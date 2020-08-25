package kr.or.connect.guestbook.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.guestbook.dto.Guestbook;
import kr.or.connect.guestbook.service.GuestbookService;

@Controller
public class GuestbookController {
	@Autowired
	GuestbookService guestbookService;
	
	@GetMapping(path = "/list")
	public String list(@RequestParam(name="start", required=false, defaultValue="0") int start,
			ModelMap model) {
		List<Guestbook> list = guestbookService.getGuestbooks(start);
		
		int count = guestbookService.getCount();
		int pageCount = count / GuestbookService.LIMIT;
		if(count % GuestbookService.LIMIT != 0)
			pageCount++;
		
		List<Integer> pageStartList = new ArrayList<>();
		for(int i=0;i<pageCount;i++)
			pageStartList.add(i * GuestbookService.LIMIT);
		
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("pageStartList", pageStartList);
		
		return "list";     //jsp view name
	}
	
	@PostMapping(path = "/write")
	public String write(Guestbook guestbook, HttpServletRequest request) {
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		guestbook.setName(name);
		guestbook.setContent(content);
		guestbook.setRegdate(new Date());
		
		guestbookService.addGuestbook(guestbook, "127.0.0.1");
		
		return "index";
	}
}
