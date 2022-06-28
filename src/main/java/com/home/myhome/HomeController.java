package com.home.myhome;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private SqlSession sqlSession;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping("/list")
	public String dolist(Model model) {
		iEmployees emp = sqlSession.getMapper(iEmployees.class);
		emp.listEmployees();
		ArrayList<empDTO> emplist = emp.listEmployees();
		model.addAttribute("list", emplist);
		return "list";
	}
	
	@RequestMapping("/find/{eid}")
	public String doFind(@PathVariable int eid, Model model) {
		iEmployees emp = sqlSession.getMapper(iEmployees.class);
		emp.getMember(eid);
		memberDTO memDTO = emp.getMember(eid);
		model.addAttribute("member",memDTO);
		ArrayList<empDTO> emplist = emp.listEmployees();
		model.addAttribute("list", emplist);
		int n = emp.countMember(eid);
		model.addAttribute("cnt", n);
		return "find";
	}
	
//	@RequestMapping("/find/{eid}")
//	public String doFind(@PathVariable int eid, Model model) {
//		iEmployees emp = sqlSession.getMapper(iEmployees.class);
//		empDAO minfo = new empDAO(emp);
//		MemberInfo mi = minfo.getMemberInfo(eid);
//		model.addAttribute("mi",mi);
//		System.out.println(mi.m.employee_id);
//		return "find";
//	}
	
	@RequestMapping("/mlist")
	public String doMenuList(Model model) {
		iMenu menu = sqlSession.getMapper(iMenu.class);
		menu.listMenu();
		ArrayList<menuDTO> menulist = menu.listMenu();
		model.addAttribute("mlist", menulist);
		return "listmenu";
	}
	
	@RequestMapping("/addnew")
	public String doAddNew(Model model) {
		iMenu menu = sqlSession.getMapper(iMenu.class);
		ArrayList<menuDTO> menulist = menu.listMenu();
		model.addAttribute("mlist", menulist);
		return "addnew";
	}
	
	@RequestMapping(value="/addMenu", method=RequestMethod.POST)
	public String doAddMenu(@RequestParam("mname") String mname, 
			@RequestParam("price") int price) {
		iMenu menu = sqlSession.getMapper(iMenu.class);
		menu.insert(mname, price);
		return "redirect:/addnew";
	}
	
//	@RequestMapping(value="/delete")
//	public String doDelete(HttpServletRequest req) {
//		String seqno = req.getParameter("seqno");
//		iMenu menu = sqlSession.getMapper(iMenu.class);
//		menu.delete(Integer.parseInt(seqno));
//		return "redirect:/addnew";
//	}
	
	@RequestMapping(value="/delete/{seqno}")
	public String doDelete(@PathVariable String seqno) {
		iMenu menu = sqlSession.getMapper(iMenu.class);
		menu.delete(Integer.parseInt(seqno));
		return "redirect:/addnew";
	}
	
	@RequestMapping
	public String doView(@RequestParam int seqno, Model model) {
		iMenu menu = sqlSession.getMapper(iMenu.class);
		menuDTO mDto = menu.viewMenu(seqno);
		model.addAttribute("mDto",mDto);
		return "view";
	}
	
	@RequestMapping("/update")
	public String doUpdate(HttpServletRequest req, Model model) {
		iMenu menu = sqlSession.getMapper(iMenu.class);
		String name = req.getParameter("name");
		int price = Integer.parseInt(req.getParameter("price"));
		int seqno = Integer.parseInt(req.getParameter("seqno"));
		menu.updateMenu(name, price, seqno);
		return "redirect:/addnew";
	}
	
	@RequestMapping(value="/name",method=RequestMethod.GET)
	public String showMyName(HttpServletRequest request, Model model) {
		String str1 = request.getParameter("mobile");
		String myName="Kwon Bokyung";
		model.addAttribute("name",myName);
		model.addAttribute("phone",str1);
		return "showName";
	}
	
	@RequestMapping(value="/nick", method = RequestMethod.GET)
	public String showNick(HttpServletRequest req, Model model) {
		String uid = req.getParameter("userid");
		String passcode = req.getParameter("password");
		String region = req.getParameter("city");
		model.addAttribute("nick", uid);
		model.addAttribute("pwd",passcode);
		model.addAttribute("area",region);
		return "Nick";
	}
	
	@RequestMapping(value="/dan", method=RequestMethod.GET)
	public String gugudan(HttpServletRequest req, Model model) {
		int dan = Integer.parseInt(req.getParameter("dan"));
		String danString = "";
		for(int i=1; i<10; i++) {
			danString += dan + "x" + i + "=" + dan*i + "<br>";
		}
		model.addAttribute("dan", dan);
		model.addAttribute("gugu", danString);
		return "Gugudan";
		
	}
	
	@RequestMapping(value="/plus", method = RequestMethod.GET)
	public String plus(HttpServletRequest req, Model model) {
		String str1 = req.getParameter("x");
		String str2 = req.getParameter("y");
		if(str1==null||str1.equals("")||str2==null||str2.equals("")) {
			model.addAttribute("plus","x값이나 y값이 주어지지 않았습니다.");
		} else {
			int x = Integer.parseInt(str1);
			int y = Integer.parseInt(str2);
			model.addAttribute("plus", x+y);
		}
		return "Gugudan";
	}
	
//	//~/calc?op=plus/minus&x=99&y=99
//	@RequestMapping(value = "/calc", method = RequestMethod.GET)
//	public String doCalc(HttpServletRequest req, Model model) {
//		String strOP = req.getParameter("op");
//		String str1 = req.getParameter("x");
//		String str2 = req.getParameter("y");
//		if(strOP==null||strOP.equals("")||str1==null||str1.equals("")||str2==null||str2.equals("")) {
//			model.addAttribute("오류 상황");
//			model.addAttribute("result","유효한 값이 주어지지 않았습니다.");
//		}else if(strOP.equals("plus")) {
//			model.addAttribute("title","더하기");
//			model.addAttribute("result",Integer.parseInt(str1)+Integer.parseInt(str2));
//		}else if(strOP.equals("minus")) {
//			model.addAttribute("title","빼기");
//			model.addAttribute("result",Integer.parseInt(str1)-Integer.parseInt(str2));
//		}
//		return "Gugudan";
//	}
	
	@RequestMapping(value = "/calc/{op}/{x}/{y}", method = RequestMethod.GET)
	public String doCalc(@PathVariable("op") String strOP, 
			@PathVariable("x") String str1, @PathVariable("y") String str2, 
			Model model) {
		if(strOP==null||strOP.equals("")||str1==null||str1.equals("")||str2==null||str2.equals("")) {
			model.addAttribute("오류 상황");
			model.addAttribute("result","유효한 값이 주어지지 않았습니다.");
		}else if(strOP.equals("plus")) {
			model.addAttribute("title","더하기");
			model.addAttribute("result",Integer.parseInt(str1)+Integer.parseInt(str2));
		}else if(strOP.equals("minus")) {
			model.addAttribute("title","빼기");
			model.addAttribute("result",Integer.parseInt(str1)-Integer.parseInt(str2));
		}
		return "Gugudan";
	}
	
	//~/compute?x=99&y=99
	@RequestMapping(value = "/compute", method = RequestMethod.GET)
	public String doCompute(HttpServletRequest req, Model model) {
		String call = "";
		String x = req.getParameter("x");
		String y = req.getParameter("y");
		int xNum = Integer.parseInt(x);
		int yNum = Integer.parseInt(y);
		int result = xNum - yNum;
		model.addAttribute("x", xNum);
		model.addAttribute("y", yNum);
		model.addAttribute("result", result);
		if(xNum - yNum < 0) {
			call = "On";
		} else {
			call = "Off";
		}
		return call;
	}
}
