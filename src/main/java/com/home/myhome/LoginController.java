package com.home.myhome;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		if(session.getAttribute("userid") == null) {
			model.addAttribute("statusLine","<a href='login'>�α���</a>&nbsp<a href='user_signin'>ȸ������</a>");
			model.addAttribute("newbutton", "<input type=button value='���� ����' disabled>");
		} else {
			model.addAttribute("statusLine",session.getAttribute("realname")+"&nbsp<a href='logout'>�α׾ƿ�</a>");
			model.addAttribute("newbutton","<input type=button value='���� ����'>");
		}
		return "members/home";
	}
	
	//~/login
	@RequestMapping("/login")
	public String doLogin() {
		return "members/login";
	}
	
	@RequestMapping("/user_check")
	public String doUserCheck(HttpServletRequest req, Model model) {
//		System.out.println("doUserCheck called");
		String user_id = req.getParameter("userid");
		String password = req.getParameter("pwd");
		model.addAttribute("user_id",user_id);
		model.addAttribute("password",password);
		HttpSession session = req.getSession();
		if(user_id.equals("human") && password.equals("human123")) {
			session.setAttribute("userid", user_id);
			session.setAttribute("realname", "Park");
//			return "members/userinfo";
//		} else {
//			return "members/signin";
		}
		return "redirect:/";
	}
	
	@RequestMapping("/user_signin")
	public String doSignin(HttpServletRequest req, Model model) {
		String uid = req.getParameter("userid");
		String pwd = req.getParameter("pwd");
		String pwd1 = req.getParameter("pwd1");
//		if(!pwd.equals(pwd1)) {
//			model.addAttribute("uid",uid);
//			return "signin";
//		} else {
	//		return "login";(JSP ȣ��)
			return "members/signin";//�޼ҵ� ȣ��
//		}
	}
	
	@RequestMapping("/logout")
	public String doLogout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		return "redirect:/";
	}
}
