package kr.or.connect.Todo.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.Todo.dto.TodoDto;

public class TodoDao {
	private static String url = "jdbc:mysql://localhost:3306/connectdb";
	private static String user = "connectuser";
	private static String password = "connect123!@#";
	
	public int addTodo(TodoDto dto) {
		int insertCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			String sql = "insert into Todo (title, name, sequence) values (?, ?, ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getName());
			ps.setInt(3, dto.getSequence());
			
			insertCount = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return insertCount;
	}
	
	public List<TodoDto> getTodos(String type){
		List<TodoDto> todoList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			String sql = "select id, title, name, sequence, type, regdate from todo where type = ? order by regdate";		
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, type);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Long id = rs.getLong(1);
				String title = rs.getString(2);
				String name = rs.getString(3);
				Integer sequence = rs.getInt(4);
				String type1 = rs.getString(5);
				String regDate = rs.getTimestamp(6).toString();
				
				todoList.add(new TodoDto(id, name, regDate, sequence, title, type1));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			if(ps != null) {
				try {
					ps.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return todoList;
	} 
	
	public int updateTodo(TodoDto dto) {
		int updateCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			String sql = "update todo set type = ? where id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setLong(2, dto.getId());
			if(dto.getType().equals("TODO"))
				ps.setString(1, "DOING");
			else if(dto.getType().equals("DOING"))
				ps.setString(1, "DONE");
			
			updateCount = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return updateCount;
		
	}
}
