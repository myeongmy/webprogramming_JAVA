package kr.or.connect.daoexam.dao;

import static kr.or.connect.daoexam.dao.RoleDaoSqls.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.daoexam.dto.Role;

@Repository
public class RoleDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);
	
	public RoleDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("role"); //어떤 table에 insert 할지 정해줌
	}
	
	public List<Role> selectAll(){
		
		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
	}
	
	public int insert(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);   //알아서 role 객체를 db에 넣을 객체로 매핑해준다. (예를 들면, role_id로 컬럼명 변경)
		
		return insertAction.execute(params);
	}
	
	public int update(Role role) {
SqlParameterSource params = new BeanPropertySqlParameterSource(role);   //알아서 role 객체를 db에 넣을 객체로 매핑해준다. (예를 들면, role_id로 컬럼명 변경)
		
		return jdbc.update(UPDATE, params);   //update 쿼리문에 데이터를 바인딩 해주어야 하는 데 sqlparametersource 객체가 알아서 맵 객체로 변환해준다.
	}
	
	public int deleteById(Integer id) {
		Map<String, ?> params = Collections.singletonMap("roleId", id);
		
		return jdbc.update(DELETE_BY_ROLE_ID, params);
	}
	
	public Role selectById(Integer id) {
		try {
			Map<String, ?> params = Collections.singletonMap("roleId", id);
			
			return jdbc.queryForObject(SELECT_BY_ROLE_ID, params, rowMapper);
		}catch(EmptyResultDataAccessException e) {   //해당 데이터가 조회되지 않는 경우 null 반환
			return null;
		}
	}
}
