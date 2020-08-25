package kr.or.connect.guestbook.dao;

import static kr.or.connect.guestbook.dao.GuestbookDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.guestbook.dto.Guestbook;

@Repository
public class GuestbookDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Guestbook> rowMapper = BeanPropertyRowMapper.newInstance(Guestbook.class);
	
	public GuestbookDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("guestbook")
				.usingGeneratedKeyColumns("id");
	}
	
	public List<Guestbook> selectAll(Integer start, Integer limit){
		Map<String, Integer> params = new HashMap<String, Integer>();
		
		params.put("start", start);
		params.put("limit", limit);
		
		return jdbc.query(SELECT_PAGING, params, rowMapper);
	}
	
	public Long insert(Guestbook guestBook) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(guestBook);   //guestBook이라는 dto 객체를 db에 넣을 수 있는 형태로 자동 mapping 해준다.
		
		return insertAction.executeAndReturnKey(params).longValue();
	}
	
	public int deleteById(Long id) {
		Map<String, ?> paramMap = Collections.singletonMap("id", id);
		
		return jdbc.update(DELETE_BY_ID, paramMap);
	}
	
	public int selectCount() {
		return jdbc.queryForObject(SELECT_COUNT, Collections.emptyMap(), Integer.class);
	}
}
