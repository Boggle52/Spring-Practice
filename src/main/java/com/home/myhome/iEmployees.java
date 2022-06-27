package com.home.myhome;

import java.util.ArrayList;

public interface iEmployees {
	ArrayList<empDTO> listEmployees();
	memberDTO getMember(int id);
	int countMember(int id);
}
