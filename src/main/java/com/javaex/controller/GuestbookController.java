package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestbookController {
	
	//필드
	@Autowired
	private GuestbookService gbService;
	
	
	//Guestbook 출력
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("GuestbookController->list()");
		
		List<GuestbookVo> gbList = gbService.getGuestList();
		
		model.addAttribute("gbList", gbList);
		
		
		return "addList";
	}
	
	//Guestbook 글쓰기
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute GuestbookVo gbVo) {
		System.out.println("GuestbookController->write()");
		
		gbService.guestInsert(gbVo);
		
		return "redirect:/list";
	}
	
	//Guestbook 삭제폼
	@RequestMapping(value="/deleteForm/{no}", method= {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm(@PathVariable("no") int no, Model model) {
		System.out.println("GuestbookController->deleteForm()");
		
		model.addAttribute("no", no);
		
		return "deleteForm";
	}
	
	//Guestbook 삭제
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestbookVo gbVo) {
		System.out.println("GuestbookController->delete()");
		
		int no = gbVo.getNo();
		String pw = gbVo.getPassword();
		gbService.guestDelete(no, pw);
		
		return "redirect:/list";
	}

}
