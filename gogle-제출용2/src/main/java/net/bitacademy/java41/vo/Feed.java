package net.bitacademy.java41.vo;

import java.io.Serializable;
import java.sql.Date;

public class Feed implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int 		fno;
	protected String 	content;
	protected Date 		regDate;
	protected String 	email;
	protected int 		pno;
	
	
	public int getFno() {
		return fno;
	}
	public Feed setFno(int fno) {
		this.fno = fno;
		return this;
	}
	public String getContent() {
		return content;
	}
	public Feed setContent(String content) {
		this.content = content;
		return this;
	}
	public Date getRegDate() {
		return regDate;
	}
	public Feed setRegDate(Date regDate) {
		this.regDate = regDate;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Feed setEmail(String email) {
		this.email = email;
		return this;
	}
	public int getPno() {
		return pno;
	}
	public Feed setPno(int pno) {
		this.pno = pno;
		return this;
	}
	
	
	
}
