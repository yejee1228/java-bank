package com.bitcamp.domains;

public class CustomerBean extends MemberBean {
	private int credit;

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return String.format("%s님의 신용등급은 %d등급 입니다", super.getName(), credit);
	}
}
