package com.bitcamp.services;

import com.bitcamp.domains.AccountBean;
import com.bitcamp.domains.AdminBean;
import com.bitcamp.domains.MemberBean;
import com.bitcamp.domains.CustomerBean;

public interface MemberService {
	public void join(CustomerBean param);
	public void resister(AdminBean param);
	public CustomerBean[] findAllCustomers();
	public AdminBean[] findAllAdmins();
	public MemberBean[] findByName(String name);
	public MemberBean findById(String id);
	public boolean login(MemberBean param);
	public int countMembers();
	public int countAdmins();
	public boolean existId(String id);
	public void updatePass(MemberBean param);
	public void deleteMember(MemberBean param);
}
