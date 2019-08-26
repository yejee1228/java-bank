package com.bitcamp.controllers;

import javax.swing.JOptionPane;

import com.bitcamp.domains.MemberBean;
import com.bitcamp.services.MemberService;
import com.bitcamp.services.MemberServiceImpl;

public class userController {
	public static void main(String[] args) {
		MemberBean member = null;
		MemberService mService = new MemberServiceImpl();
		while (true) {
			switch (JOptionPane.showInputDialog("은행고객시스템 \n 0.종료, 1.회원가입")) {
			case "0":
				JOptionPane.showMessageDialog(null, "0.종료");
				return;
			case "1":
				String[] arr = JOptionPane.showInputDialog("회원가입\n 아이디, 비밀번호, 이름, 주민번호 입력").split(",");
				member = new MemberBean();
				member.setId(arr[0]);
				member.setPw(arr[1]);
				member.setName(arr[2]);
				member.setSsn(arr[3]);
				JOptionPane.showMessageDialog(null, "회원가입 완료");
				break;
			case "2":
				JOptionPane.showMessageDialog(null, mService.findAllCustomers());
				break;
			case "3":
				break;
			case "4":
				break;
			}
		}
	}
}
