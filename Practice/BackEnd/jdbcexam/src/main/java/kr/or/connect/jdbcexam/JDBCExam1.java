package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Role role = new RoleDao().getRole(100);

		System.out.println(role.getRoleId() + " " + role.getDescription());

	}

}
