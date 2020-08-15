package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Role role = new Role(103, "CTO");

		System.out.println(new RoleDao().addRole(role));
	}

}
