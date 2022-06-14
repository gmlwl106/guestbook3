package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestbookDao gbDao;

	public List<GuestbookVo> getGuestList() {
		return gbDao.getGuestList();
	}
	
	public int guestInsert(GuestbookVo gbVo) {
		return gbDao.guestInsert(gbVo);
	}
	
	public GuestbookVo getGuest(int no) {
		return gbDao.getGuest(no);
	}

	public int guestDelete(int no, String pw) {
		return gbDao.guestDelete(no, pw);
	}

	

	



}
