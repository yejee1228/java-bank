package com.bitcamp.controllers;

import javax.swing.JOptionPane;

import com.bitcamp.domains.AccountBean;
import com.bitcamp.domains.CustomerBean;
import com.bitcamp.services.AccountService;
import com.bitcamp.services.MemberService;
import com.bitcamp.servicesImpl.AccountServiceImpl;
import com.bitcamp.servicesImpl.MemberServiceImpl;

public class userController {
	public static void main(String[] args) {
		CustomerBean member = null;
		AccountBean account = null;
		AccountService as = new AccountServiceImpl();
		MemberService service = new MemberServiceImpl();
		while (true) {
			switch (JOptionPane.showInputDialog("은행고객시스템 \n 0.종료, 1.회원가입\n "
												+ "2.로그인, 3.비밀번호 변경, 4.회원탈퇴\n " 
												+ "5.계좌생성, 6.입금, 7.출금, 8.계좌삭제")) {
			case "0":
				JOptionPane.showMessageDialog(null, "0.종료");
				return;
			case "1":
				String[] arr = JOptionPane.showInputDialog("회원가입\n 아이디, 비밀번호, 이름, 주민번호, 신용도 입력").split(",");
				member = new CustomerBean();
				member.setId(arr[0]);
				member.setPw(arr[1]);
				member.setName(arr[2]);
				member.setSsn(arr[3]);
				member.setCredit(arr[4]);
				if (service.existId(arr[0]) == true) {
					service.join(member);
					JOptionPane.showMessageDialog(null, "회원가입 완료");
					break;
				} else {
					JOptionPane.showMessageDialog(null, "회원가입실패");
					break;
				}
				
			case "2":
				String spec = JOptionPane.showInputDialog("id, pw 입력");
				arr = spec.split(",");
				String loginId = arr[0];
				String loginPw = arr[1];
				member.setId(loginId);
				member.setPw(loginPw);
				JOptionPane.showMessageDialog(null, service.login(member));
				break;
			case "3":
				spec = JOptionPane.showInputDialog("id, 현재 pw, 변경할pw");
				arr = spec.split(",");
				loginId = arr[0];
				loginPw = arr[1];
				String newPw = arr[2];
				member.setId(loginId);
				member.setPw(loginPw + "," + newPw);
				service.updatePass(member);
				JOptionPane.showMessageDialog(null, "비밀번호 변경 완료");
				break;// 비밀번호 변경
			case "4":
				spec = JOptionPane.showInputDialog("id, pw 입력");
				member = new CustomerBean();
				arr = spec.split(",");
				member.setId(arr[0]);
				member.setPw(arr[1]);
				service.deleteMember(member);
				JOptionPane.showMessageDialog(null, "탈퇴 완료");
				break;
			case "5":
				spec = JOptionPane.showInputDialog("계좌생성\n 입금액 입력");
				account = new AccountBean();
				account.setMoney(spec);
				as.createAccount(Integer.parseInt(spec));
				JOptionPane.showMessageDialog(null, as.createAccountNum());
				break;
			case "6":
				spec = JOptionPane.showInputDialog("입금액 입력");
				account.setMoney(spec);
				as.depositMoney(account);
				JOptionPane.showMessageDialog(null, "입금 완료");
				break;// 입금
			case "7":
				spec = JOptionPane.showInputDialog("출금액 입력");
				account.setMoney(spec);
				as.withdrawMoney(account);
				JOptionPane.showMessageDialog(null, "출금 완료");
				break;// 출금
			case "8" :
				spec = JOptionPane.showInputDialog("삭제할 계좌 입력");
				account.setAccountNum(spec);
				as.deleteAccountNum(spec);
				JOptionPane.showMessageDialog(null, "계좌삭제 완료");
				break;// 계좌삭제
			}
		}
	}
}
