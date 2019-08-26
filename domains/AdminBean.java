package com.bitcamp.domains;

public class AdminBean extends MemberBean{
	private int sabun;

	public int getSabun() {
		return sabun;
	}

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	
	@Override
	public String toString() {
		return String.format("%s 직원의 사원번호는 %d 입니다", super.getName(), sabun);
	}
}
