package com.bitcamp.controllers;

import javax.swing.JOptionPane;

import com.bitcamp.domains.AccountBean;
import com.bitcamp.domains.MemberBean;
import com.bitcamp.services.AccountService;
import com.bitcamp.services.MemberService;
import com.bitcamp.servicesImpl.AccountServiceImpl;
import com.bitcamp.servicesImpl.MemberServiceImpl;

public class AdminController {

	public static void main(String[] args) {
		AccountBean account = null;
		MemberBean member = new MemberBean();
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
					+ "9. 비밀번호 변경"
					+ "10. 회원탈퇴"
					+ "11. 계좌생성"
					+ "12. 모든 계좌 검색"
					+ "13. 계좌로 검색"
					+ "14. 입금"
					+ "15. 출금"
					+ "16. 계좌삭제")){
			case "0" : 
				JOptionPane.showMessageDialog(null, "종료"); 
				return;
			case "1" : 
				JOptionPane.showMessageDialog(null,mService.findAllCustomers());
				break;
			case "2" : 
				JOptionPane.showMessageDialog(null,mService.findAllAdmins());
				break;
			case "3" : 
				String spec = JOptionPane.showInputDialog("이름 입력");
				JOptionPane.showMessageDialog(null, mService.findByName(spec));
				break;
			case "4" : 
				spec = JOptionPane.showInputDialog("아이디 입력");
				JOptionPane.showMessageDialog(null, mService.findById(spec));
				break;
			case "5" :
				spec = JOptionPane.showInputDialog("id, pw 입력");
				String[] arr = spec.split(",");
				String loginId = arr[0];
				String loginPw = arr[1];
				member.setId(loginId);
				member.setPw(loginPw);
				JOptionPane.showMessageDialog(null, mService.login(member));
				break;
			case "6" : 
				JOptionPane.showMessageDialog(null, mService.countMembers());
				break;
			case "7" : 
				JOptionPane.showMessageDialog(null, mService.countAdmins());
				break;
			case "8" : 
				spec = JOptionPane.showInputDialog("id 입력");
				JOptionPane.showMessageDialog(null, mService.existId(spec));
				break;
			case "9" :
				spec = JOptionPane.showInputDialog("id, 현재 pw, 변경할pw");
				arr = spec.split(",");
				loginId = arr[0];
				loginPw = arr[1];
				String oldPw = arr[2];
				member.setId(loginId);
				member.setPw(loginPw+","+oldPw);
				JOptionPane.showMessageDialog(null, "비밀번호 변경 완료");
				break;
			case "10" : break;
			}
		}
			
		
	}

}
