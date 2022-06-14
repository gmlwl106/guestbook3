package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestbookController {
	
	//Guestbook 삭제
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestbookVo gbVo) {
		System.out.println("GuestbookController->delete()");
		
		GuestbookDao gbDao = new GuestbookDao();
		int no = gbVo.getNo();
		String pw = gbVo.getPassword();
		gbDao.guestDelete(no, pw);
		
		return "redirect:/list";
	}
	
	//Guestbook 삭제폼
	@RequestMapping(value="/deleteForm/{no}", method= {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm(@PathVariable("no") int no, Model model) {
		System.out.println("GuestbookController->deleteForm()");
		
		GuestbookDao gbDao = new GuestbookDao();
		GuestbookVo gbVo = gbDao.getGuest(no);
		
		model.addAttribute("gbVo", gbVo);
		
		return "deleteForm";
	}
	
	//Guestbook 글쓰기
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute GuestbookVo gbVo) {
		System.out.println("GuestbookController->write()");
		
		GuestbookDao gbDao = new GuestbookDao();
		gbDao.guestInsert(gbVo);
		
		return "redirect:/list";
	}

	//Guestbook 출력
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("GuestbookController->list()");
		
		GuestbookDao gbDao = new GuestbookDao();
		List<GuestbookVo> gbList = gbDao.getGuestList();
		
		model.addAttribute("gbList", gbList);
		
		
		return "addList";
	}
}
