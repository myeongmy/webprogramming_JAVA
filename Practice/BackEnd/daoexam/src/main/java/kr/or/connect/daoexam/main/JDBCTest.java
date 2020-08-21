package kr.or.connect.daoexam.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexam.config.ApplicationConfig;
import kr.or.connect.daoexam.dao.RoleDao;
import kr.or.connect.daoexam.dto.Role;

public class JDBCTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		RoleDao roleDao = ac.getBean(RoleDao.class);

		Role role = new Role();
		role.setRoleId(102);
		role.setDescription("PROGRAMMER");

		/*
		 * int count = roleDao.insert(role); 
		 * System.out.println(count +"건 입력하였습니다.");
		 */

		int count = roleDao.update(role);
		System.out.println(count + "건 수정되었습니다.");
		
		Role r1 = roleDao.selectById(101);
		System.out.println(r1);
		
		int deleteCount = roleDao.deleteById(500);
		System.out.println(deleteCount+"건 삭제되었습니다.");
	}

}
