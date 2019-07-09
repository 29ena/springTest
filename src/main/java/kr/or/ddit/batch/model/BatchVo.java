package kr.or.ddit.batch.model;

import java.util.Date;

public class BatchVo {
	private int bid;		// 배치 번호(sequence)
	private String bcd;		// 배치코드 (01 : 실적, 02 : 월실적, 03: url통계)
	private String st;		// 배치 실행상태(01: 진행중, 02 : 정상완료, 03 : 비정상완료)
	private Date st_dt;		// 배치 시작일자
	private Date de_dt;		// 시작 종료일자
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBcd() {
		return bcd;
	}
	public void setBcd(String bcd) {
		this.bcd = bcd;
	}
	public String getSt() {
		return st;
	}
	public void setSt(String st) {
		this.st = st;
	}
	public Date getSt_dt() {
		return st_dt;
	}
	public void setSt_dt(Date st_dt) {
		this.st_dt = st_dt;
	}
	public Date getDe_dt() {
		return de_dt;
	}
	public void setDe_dt(Date de_dt) {
		this.de_dt = de_dt;
	}
	
	@Override
	public String toString() {
		return "BatchVo [bid=" + bid + ", bcd=" + bcd + ", st=" + st + ", st_dt=" + st_dt + ", de_dt=" + de_dt + "]";
	}
	
	
}
