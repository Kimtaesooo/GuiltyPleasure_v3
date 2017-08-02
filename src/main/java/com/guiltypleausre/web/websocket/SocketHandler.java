package com.guiltypleausre.web.websocket;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.guiltypleausre.web.domain.Battle_Play;
import com.guiltypleausre.web.domain.Battle_Room;
import com.guiltypleausre.web.repository.battlequizmodule.BattleQuizPlay;
import com.guiltypleausre.web.repository.battlequizmodule.BattleQuizPlayImpl;
import com.guiltypleausre.web.repository.battlequizmodule.GetBattleQuiz;

public class SocketHandler extends TextWebSocketHandler implements InitializingBean {

	private final Logger logger = LogManager.getLogger(getClass());
	static HashMap<String, WebSocketSession> map = new HashMap<String, WebSocketSession>(); // 세션과
																							// 아이디
																							// 맵핑할려고
																							// 했지만
																							// 안씀
	private static Set<WebSocketSession> clients = Collections.synchronizedSet(new HashSet<WebSocketSession>());

	String me = ""; // 정보를 보내는 유저
	String br_num = ""; // 게임방 번호
	String user01 = ""; // 게임방 유저1
	String user02 = ""; // 게임장 유저2
	Boolean startFlag = false; // 게임방이 시작되었는지 안되었는지 확인하는 변수
	String msg = "";

	public SocketHandler() {
	}

	// 클라이언트로부터 메시지가 도착했을 때 호출
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		this.logger.info("receive message:" + message.getPayload());
		System.out.println(message);
		// 받아온 문자열을 ':' 구분자를 통하여 배열로 저장
		String strArray[] = ((String) message.getPayload()).split(":");

		// 메시지 전송
		if (strArray[0].equals("messageSend")) {
			synchronized (clients) {
				for (WebSocketSession client : clients) {
					if (!client.equals(session)) {
						client.sendMessage(message);
					}
				}
			}
		}

		// 세션 값 매핑
		// "sessionValue:" + br_num + ":" + me
		if (strArray[0].equals("sessionValue")) {
			// 0-sessionValue, 1-방번호, 2-u_id
			me = strArray[2];
			map.put(me, session);
			WebSocketSession usersession = map.get(me);
			msg = "checkPeople:" + br_num + ":" + me;
			// message = "checkPeople:" + br_num + ":" + me;
			for (WebSocketSession client : clients) {
				client.sendMessage(new TextMessage(msg));
			}
		}

		// 방장이 게임시작 버튼을 눌렀을 때
		if (strArray[0].equals("gameStart")) {
			// message = "gameStart:" + br_num + ":" + me + ":" + q_type;
			br_num = strArray[1];
			me = strArray[2];
			String q_type = strArray[3];

			BattleQuizPlay battlequizplay = new BattleQuizPlayImpl();
			Battle_Room room = battlequizplay.idRoomInfo(me);
			int people_cnt = room.getBr_people();
			// 게임방 인원이 2명 이하일떄 (즉, 나 혼자일때)
			if (people_cnt < 2) {
				msg = "people_cnt_check:" + br_num + ":인원이 부족합니다.:";
				synchronized (clients) {
					for (WebSocketSession client : clients) {
						if (client.equals(session)) {
							client.sendMessage(new TextMessage(msg));
						}
					}
				}
				return;
			}

			// DB로 부터 게임방이 시작되었는지 안되었는지 확인하기 위해 값을 꺼내 온다. Y는 실행중, N는 대기중
			String startFlag = battlequizplay.selectBattleRoomState(br_num);

			// 게임방이 시작하고 있지 않은 상태
			if (startFlag.equals("N")) {
				String question = "";
				String answer = "";
				String wa1 = "";
				String wa2 = "";
				String wa3 = "";
				String code = "";

				// 퀴즈유형을 변수로 넘겨주고 퀴즈 유형에 따른 퀴즈를 랜덤적으로 얻어온다.
				GetBattleQuiz getBattleQuiz = new GetBattleQuiz();
				String quiz = getBattleQuiz.getQuiz(q_type);

				String quizinfo[] = quiz.split(":");
				// Q0012:C:가장 쓸모없는 구리는?:멍텅구리:구리:딱다구리:너구리:
				// 0.코드 1.유형 2.문제 3.정답 4.오답 5.오답 6.오답
				code = quizinfo[0];
				question = quizinfo[2];
				answer = quizinfo[3];
				wa1 = quizinfo[4];
				wa2 = quizinfo[5];
				wa3 = quizinfo[6];
				msg = "getget:" + br_num + ":" + code + ":" + question + ":" + answer + ":" + wa1 + ":" + wa2 + ":"
						+ wa3 + ":";
				synchronized (clients) {
					for (WebSocketSession client : clients) {
						client.sendMessage(new TextMessage(msg));
					}
				}
			}
		}

		// 다음 문제로 넘기기
		if (strArray[0].equals("nextSend")) {
			// message = "nextSend:" + br_num + ":" + me + ":" + q_type);
			br_num = strArray[1];
			me = strArray[2];
			String q_type = strArray[3];

			String question = "";
			String answer = "";
			String wa1 = "";
			String wa2 = "";
			String wa3 = "";
			String code = "";

			GetBattleQuiz getBattleQuiz = new GetBattleQuiz();
			String quiz = getBattleQuiz.getQuiz(q_type);

			String quizinfo[] = quiz.split(":");
			// Q0012:C:가장 쓸모없는 구리는?:멍텅구리:구리:딱다구리:너구리:
			// 0.코드 1.유형 2.문제 3.정답 4.오답 5.오답 6.오답
			code = quizinfo[0];
			question = quizinfo[2];
			answer = quizinfo[3];
			wa1 = quizinfo[4];
			wa2 = quizinfo[5];
			wa3 = quizinfo[6];
			msg = "getget:" + br_num + ":" + code + ":" + question + ":" + answer + ":" + wa1 + ":" + wa2 + ":"
					+ wa3 + ":";
			synchronized (clients) {
				for (WebSocketSession client : clients) {
					session.sendMessage(new TextMessage(msg));
				}
			}
		}

		// 유저가 누른 답을 받아온다.
		if (strArray[0].equals("button")) {
			// message = button:"+ br_num+":"+me+":"+code+":"+button4.value
			br_num = strArray[1];
			me = strArray[2];
			String q_code = strArray[3];
			String value = strArray[4];

			// 초기 버튼 누를때 아무 동작 하지 않게 막아버린다.
			if (value.equals("키패드1") || value.equals("키패드2") || value.equals("키패드3") || value.equals("키패드4")
					|| value.equals("undefined")) {
				return;
			}

			BattleQuizPlay battlequizplay = new BattleQuizPlayImpl();
			Battle_Play roomdto = new Battle_Play();
			// 둘 다 틀린 경우 확인 하는 것 Bp_state
			roomdto = battlequizplay.numPlayInfo(br_num);
			int bp_state = roomdto.getBp_state();

			// 정답 값 가져오기
			String checkFlag = battlequizplay.checkanswer(q_code);

			if (bp_state < 1) {
				// 정답을 틀린 경우
				if (!value.equals(checkFlag)) {
					// bp_state 카운팅 +1 한다.
					if (!value.equals("ㅋㅋㅋㅋㅋ")) {
						battlequizplay.updatePlayRoomState(br_num);
					}
					msg = "wrong:" + br_num + ":틀렸습니다. 상대방이 문제를 풀 동안 기다려 주세요:ㅋㅋㅋㅋㅋ";
					synchronized (clients) {
						for (WebSocketSession client : clients) {
							if (client.equals(session)) {
								session.sendMessage(new TextMessage(msg));
							}
						}
					}
					return;
				} else {
					// 정답을 맞춘 경우
					// bp_01cnt, bp_02cnt 카운팅한다.
					battlequizplay.updatePlayCnt(br_num, me);
					// 정답 개수 가지고 온다.
					roomdto = battlequizplay.numPlayInfo(br_num);
					int bp_01cnt = roomdto.getBp_01cnt();
					int bp_02cnt = roomdto.getBp_02cnt();
					int bp_count = roomdto.getBp_count();

					if (bp_01cnt == bp_count || bp_02cnt == bp_count) {
						msg = "exit:" + br_num + ":";
						synchronized (clients) {
							for (WebSocketSession client : clients) {
								session.sendMessage(new TextMessage(msg));
							}
						}
						return;
					}

					msg = "next:" + br_num + ":";
					synchronized (clients) {
						for (WebSocketSession client : clients) {
							session.sendMessage(new TextMessage(msg));
						}
					}
					return;
				}
			}
			// 문제를 늦게 푼 경우
			else {
				// 먼저 푼 유저가 문제 푸는거 방지
				if (!value.equals("ㅋㅋㅋㅋㅋ")) {
					// 정답일 때
					if (value.equals(checkFlag)) {
						battlequizplay.updatePlayCnt(br_num, me);

						// 정답 개수 가지고 온다.
						roomdto = battlequizplay.numPlayInfo(br_num);
						int bp_01cnt = roomdto.getBp_01cnt();
						int bp_02cnt = roomdto.getBp_02cnt();
						int bp_count = roomdto.getBp_count();

						if (bp_01cnt == bp_count || bp_02cnt == bp_count) {
							msg = "exit:" + br_num + ":";
							synchronized (clients) {
								for (WebSocketSession client : clients) {
									session.sendMessage(new TextMessage(msg));
								}
							}
							return;
						}
						msg = "next:" + br_num + ":";
						synchronized (clients) {
							for (WebSocketSession client : clients) {
								session.sendMessage(new TextMessage(msg));
							}
						}
						return;
					}
					// 오답일 때
					else {
						battlequizplay.updatePlayCnt(br_num);
						msg = "next:" + br_num + ":";
						synchronized (clients) {
							for (WebSocketSession client : clients) {
								session.sendMessage(new TextMessage(msg));
							}
						}
						return;
					}
				}
			}
		}

		// 유저가 포기하기를 눌렀을 때 해당 번호를 가진 방 사람들에게 메시지를 전달한다.
		if (strArray[0].equals("giveup")) {
			// message : "giveup:" + br_num + ":" + me
			br_num = strArray[1];
			me = strArray[2];
			msg = "giveup:" + br_num + ":" + me + "";

			synchronized (clients) {
				for (WebSocketSession client : clients) {
					session.sendMessage(new TextMessage(msg));
				}
			}
		}
	}

	// WebSocket 연결이 닫혔을 때 호출
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		clients.remove(session);
		this.logger.info("remove session!");
	}

	// WebSocket 연결이 열리고 사용이 준비될 때 호출
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		clients.add(session);
		this.logger.info("add session!");
	}

	// 전송 에러 발생할 때 호출
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		this.logger.error("web socket error!", exception);
	}

	// WebSocketHandler가 부분 메시지를 처리할 때 호출
	@Override
	public boolean supportsPartialMessages() {
		this.logger.info("call method!");
		return super.supportsPartialMessages();
	}

	public void sendMessage(String message) {
		for (WebSocketSession session : this.clients) {
			if (session.isOpen()) {
				try {
					session.sendMessage(new TextMessage(message));
				} catch (Exception ignored) {
					this.logger.error("fail to send message!", ignored);
				}
			}
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
	}

}
