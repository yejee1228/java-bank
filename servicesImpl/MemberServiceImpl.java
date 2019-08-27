package com.bitcamp.servicesImpl;

import com.bitcamp.domains.AdminBean;
import com.bitcamp.domains.MemberBean;
import com.bitcamp.services.MemberService;
import com.bitcamp.domains.CustomerBean;

public class MemberServiceImpl implements MemberService {
	private AdminBean admin = new AdminBean();
	private CustomerBean customer = new CustomerBean();
	private CustomerBean[] customers;
	private AdminBean[] admins;
	private int cCount;
	private int aCount;

	public MemberServiceImpl() {
		customers = new CustomerBean[10];
		admins = new AdminBean[10];
		cCount = 0;
		aCount = 0;
	}

	@Override
	public void join(CustomerBean param) {
		if(existId(param.getId()) == true) {
			customers[cCount] = param;
			cCount++;
		}
	}

	@Override
	public void resister(AdminBean param) {
		admins[aCount] = param;
		aCount++;
	}

	@Override
	public CustomerBean[] findAllCustomers() {
		return customers;
	}

	@Override
	public AdminBean[] findAllAdmins() {
		return admins;
	}

	@Override
	public MemberBean[] findByName(String name) {
		int j = 0;
		for(int i = 0; i<cCount; i++) {
			if(name.equals(customers[i].getName())) {
				j++;
				break;
			}
		}
		int k = 0;
		for(int i = 0; i<aCount; i++) {
			if(name.equals(admins[i].getName())) {
				k++;
				break;
			}
		}
		int count1 = 0, count2 = 0;
		MemberBean[] members = new MemberBean[j+k];
		for(int i = 0; i<cCount; i++) {
			if(name.equals(customers[i].getName())) {
				members[i] = customers[i];
				count1++;
				if (count1 == j) {
					break;
				}
			}
		}
		for(int i = 0; i<aCount; i++) {
			if(name.equals(admins[i].getName())) {
				members[j+i] = admins[i];
				count2++;
				if(count2 == k) {
					break;
				}
			}
		}
		return members;
	}

	@Override
	public MemberBean findById(String id) {
		MemberBean members = new MemberBean();
		for(int i = 0; i<cCount; i++) {
			if(id.equals(customers[i].getId())) {
				members = customers[i];
				break;
			}
		}
		for(int i = 0; i<aCount; i++) {
			if(id.equals(admins[i].getId())) {
				members = admins[i];
				break;
			}
		}
		return members;
	}

	@Override
	public boolean login(MemberBean param) {
		return findById(param.getId()).getPw().equals(param.getPw());
	}

	@Override
	public int countMembers() {
		return cCount;
	}

	@Override
	public int countAdmins() {
		return aCount;
	}

	@Override
	public boolean existId(String id) {
		boolean flag = true;
		for(int i = 0; i<cCount; i++) {
			if(id.equals(customers[i].getId())){
				flag = false;
			}
		}
		return flag;
	}

	@Override
	public void updatePass(MemberBean param) {
		String loginId = param.getId();
		String loginPw = param.getPw();
		String[] arr = loginPw.split(",");
		String oldPw = arr[0];
		String newPw = arr[1];
		if (login(param)) {
			for (int i = 0; i < cCount; i++) {
				if (loginId.equals(customers[i].getId())) {
					customers[i].setPw(newPw);
					break;
				}
			}
			for (int i = 0; i < aCount; i++) {
				if (loginId.equals(admins[i].getId())) {
					admins[i].setPw(newPw);
					break;
				}
			}
		}
	}

	@Override
	public void deleteMember(MemberBean param) {
				
	}

	
}