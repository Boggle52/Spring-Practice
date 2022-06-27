package com.home.myhome;

import java.util.ArrayList;

public class empDAO {
	
	iEmployees iemp;
	
	public empDAO(iEmployees ie) {
		this.iemp = ie;
	}
	
	public MemberInfo getMemberInfo(int eid) {
		memberDTO member = iemp.getMember(eid);
		ArrayList<empDTO> emplist = iemp.listEmployees();
		int n = iemp.countMember(eid);
		MemberInfo mi = new MemberInfo();
		mi.m = member;
		mi.memDTO = emplist;
		mi.n = n;
		return mi;
	}
}
