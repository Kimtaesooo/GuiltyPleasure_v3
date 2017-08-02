package com.guiltypleausre.web.domain;


public class Battle_Room {
	private String br_num;
	private String br_subject;
	private int br_pw;
	private String q_type;
	private int br_cnt;
	private int br_point;
	private String u_id;
	private int br_people;
	private String br_gamestate;
	private String bangjang;
	
	public String getBr_num() {
		return br_num;
	}
	public void setBr_num(String br_num) {
		this.br_num = br_num;
	}
	public void setQ_type(String q_type) {
		this.q_type = q_type;
	}
	public String getBr_subject() {
		return br_subject;
	}
	public void setBr_subject(String br_subject) {
		this.br_subject = br_subject;
	}
	public int getBr_pw() {
		return br_pw;
	}
	public void setBr_pw(int br_pw) {
		this.br_pw = br_pw;
	}
	public String getQ_type() {
		return q_type;
	}
	public void setBr_type(String q_type) {
		this.q_type = q_type;
	}
	public int getBr_cnt() {
		return br_cnt;
	}
	public void setBr_cnt(int br_cnt) {
		this.br_cnt = br_cnt;
	}
	public int getBr_point() {
		return br_point;
	}
	public void setBr_point(int br_point) {
		this.br_point = br_point;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public int getBr_people() {
		return br_people;
	}
	public void setBr_people(int br_people) {
		this.br_people = br_people;
	}
	public String getBr_gamestate() {
		return br_gamestate;
	}
	public void setBr_gamestate(String br_gamestate) {
		this.br_gamestate = br_gamestate;
	}
	public String getBangjang() {
		return bangjang;
	}
	public void setBangjang(String bangjang) {
		this.bangjang = bangjang;
	}
	
}
