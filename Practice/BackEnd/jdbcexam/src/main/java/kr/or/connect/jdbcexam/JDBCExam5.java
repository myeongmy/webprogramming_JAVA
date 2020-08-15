package kr.or.connect.jdbcexam;

import java.util.List;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Role> list = new RoleDao().getRoles();

		for (Role r : list) {
			System.out.println(r.getDescription() + " " + r.getRoleId());
		}
	}

}
