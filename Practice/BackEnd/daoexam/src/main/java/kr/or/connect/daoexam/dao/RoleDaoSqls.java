package kr.or.connect.daoexam.dao;

public class RoleDaoSqls {
	public static final String SELECT_ALL = "select role_id, description from role order by role_id";
	public static final String UPDATE = "update role set description = :description where role_id = :roleId";   //동적으로 데이터가 변환되는 부분은 java의 camel 표기법을 이용!
	public static final String SELECT_BY_ROLE_ID = "select role_id, description from role where role_id = :roleId";
	public static final String DELETE_BY_ROLE_ID = "delete from role where role_id = :roleId";
	
}
