package com.guiltypleausre.web.domain;

public class Quiz {
	String q_code;
	String q_type;
	String q_question;
	String q_answer;
	int q_ca_cnt;
	int q_wa_cnt;
	String u_id;
	String q_wa_a;
	String q_wa_b;
	String q_wa_c;
	public String getQ_code() {
		return q_code;
	}
	public void setQ_code(String q_code) {
		this.q_code = q_code;
	}
	public String getQ_type() {
		return q_type;
	}
	public void setQ_type(String q_type) {
		this.q_type = q_type;
	}
	public String getQ_question() {
		return q_question;
	}
	public void setQ_question(String q_question) {
		this.q_question = q_question;
	}
	public String getQ_answer() {
		return q_answer;
	}
	public void setQ_answer(String q_answer) {
		this.q_answer = q_answer;
	}
	public int getQ_ca_cnt() {
		return q_ca_cnt;
	}
	public void setQ_ca_cnt(int q_ca_cnt) {
		this.q_ca_cnt = q_ca_cnt;
	}
	public int getQ_wa_cnt() {
		return q_wa_cnt;
	}
	public void setQ_wa_cnt(int q_wa_cnt) {
		this.q_wa_cnt = q_wa_cnt;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getQ_wa_a() {
		return q_wa_a;
	}
	public void setQ_wa_a(String q_wa_a) {
		this.q_wa_a = q_wa_a;
	}
	public String getQ_wa_b() {
		return q_wa_b;
	}
	public void setQ_wa_b(String q_wa_b) {
		this.q_wa_b = q_wa_b;
	}
	public String getQ_wa_c() {
		return q_wa_c;
	}
	public void setQ_wa_c(String q_wa_c) {
		this.q_wa_c = q_wa_c;
	}
	
	
	
	@Override
	public String toString() {
		return "Quiz [q_code=" + q_code + ", q_type=" + q_type + ", q_question=" + q_question + ", q_answer=" + q_answer
				+ ", q_ca_cnt=" + q_ca_cnt + ", q_wa_cnt=" + q_wa_cnt + ", u_id=" + u_id + ", q_wa_a=" + q_wa_a
				+ ", q_wa_b=" + q_wa_b + ", q_wa_c=" + q_wa_c + "]";
	}
	
	
	

	
	
}
