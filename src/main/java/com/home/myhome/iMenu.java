package com.home.myhome;

import java.util.ArrayList;

public interface iMenu {
	ArrayList<menuDTO> listMenu();
	void insert(String name, int price);
	void delete(int seqno);
}
