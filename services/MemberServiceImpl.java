package com.bitcamp.services;

import com.bitcamp.domains.AdminBean;
import com.bitcamp.domains.MemberBean;
import com.bitcamp.domains.CustomerBean;

public class MemberServiceImpl implements MemberService {
	private MemberBean member = new MemberBean();
	private AdminBean admin = new AdminBean();
	private MemberBean[] members;
	private CustomerBean[] customers;
	private AdminBean[] admins;
	private int count;

	public MemberServiceImpl() {
		members = new MemberBean[10];
		customers = new CustomerBean[10];
		admins = new AdminBean[10];
		count = 0;
	}

	@Override
	public void join(MemberBean param) {
		members[count] = param;
		count++;
	}

	@Override
	public CustomerBean[] findAllCustomers() {
		customers = new CustomerBean[10];
		for(int i = 0; i<count; i++) {
			customers[i] = this.customers[i];
		}
		return customers;
	}

	@Override
	public AdminBean[] findAllAdmins() {
		admins = new AdminBean[10];
		for(int i = 0; i<count; i++) {
			admins[i] = this.admins[i];
		}
		return admins;
	}

	@Override
	public MemberBean[] findByName(String name) {
		int j = 0;
		for(int i = 0; i<count; i++) {
			if(name.equals(member.getName())) {
				j++;
			}
		}
		members = new MemberBean[j];
		j=0;
		for(int i = 0; i<count; i++) {
			if(name.equals(member.getName())) {
				members[j] = this.members[j];
				j++;
				if(members.length==j) {
					break;
				}
			}
		}
		
		return members;
	}

	@Override
	public MemberBean[] findById(String id) {
		members = new MemberBean[10];
		for(int i = 0; i<count; i++) {
			if(id.equals(member.getId())) {
				members[i] = this.members[i];
			}
		}
		return members;
	}

	@Override
	public boolean login(MemberBean param) {
		boolean msg = false;
		for(int i = 0; i<count; i++) {
			if(param.getId().equals(member.getId())
					&& param.getPw().equals(member.getPw())){
				msg = true;
			}
		}
		return msg;
	}

	@Override
	public int countMembers() {
		return count;
	}

	@Override
	public int countAdmins() {
		int j=0;
		int s = 0;
		for (int i = 0; i<count; i++) {
			s += admin.getSabun();
			j++;
		}
		return j;
	}

	@Override
	public boolean existId(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updatePass(MemberBean param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(MemberBean param) {
		// TODO Auto-generated method stub
		
	}

}
