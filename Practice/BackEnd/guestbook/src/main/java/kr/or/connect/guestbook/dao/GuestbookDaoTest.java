package kr.or.connect.guestbook.dao;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.guestbook.config.ApplicationConfig;
import kr.or.connect.guestbook.dto.Guestbook;

public class GuestbookDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		GuestbookDao guestDao = ac.getBean(GuestbookDao.class);
		
		Guestbook guestBook = new Guestbook();
		guestBook.setName("mjsim");
		guestBook.setContent("안녕하세요~~~");
		guestBook.setRegdate(new Date());
		
		guestDao.insert(guestBook);
		int count = guestDao.selectCount();
		System.out.println(count);
	}

}
