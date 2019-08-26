package com.bitcamp.controllers;

import javax.swing.JOptionPane;

import com.bitcamp.domains.AccountBean;
import com.bitcamp.services.AccountService;
import com.bitcamp.services.AccountServiceImpl;
import com.bitcamp.services.MemberService;
import com.bitcamp.services.MemberServiceImpl;

public class AdminController {

	public static void main(String[] args) {
		AccountBean account = null;
		AccountService aService = new AccountServiceImpl();
		MemberService mService = new MemberServiceImpl();
		while(true) {
			switch(JOptionPane.showInputDialog("은행관리자 시스템 \n"
					+ "0. 종료"
					+ "1. 모든 고객 정보"
					+ "2. 모든 관리자 정보"
					+ "3. 이름찾기"
					+ "4. id 찾기"
					+ "5. 로그인"
					+ "6. 고객 수"
					+ "7. 사원 수"
					+ "8. id 중복체크"
					+ "9. 비밀번호 변경"
					+ "10. 회원탈퇴")){
			case "0" : 
				JOptionPane.showMessageDialog(null, "종료"); 
				return;
			case "1" : 
				JOptionPane.showMessageDialog(null,mService.findAllCustomers());
				break;
			case "2" : 
				JOptionPane.showMessageDialog(null,mService.findAllAdmins());
				break;
			case "3" : break;
			case "4" : break;
			}
		}
			
		
	}

}
