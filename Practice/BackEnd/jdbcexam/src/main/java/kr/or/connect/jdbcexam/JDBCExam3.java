package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new RoleDao().updateRole(103));
		
		Role role = new RoleDao().getRole(103);
		System.out.println(role.getDescription());
	}

}
