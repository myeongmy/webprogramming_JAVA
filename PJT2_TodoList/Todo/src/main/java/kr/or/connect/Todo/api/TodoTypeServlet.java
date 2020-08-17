package kr.or.connect.Todo.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.connect.Todo.dao.TodoDao;
import kr.or.connect.Todo.dto.TodoDto;

/**
 * Servlet implementation class TodoTypeServlet
 */
@WebServlet("/TodoTypeServlet")
public class TodoTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = (String) request.getParameter("id");
		String type = (String) request.getParameter("type");
		
		TodoDao dao = new TodoDao();
		TodoDto dto = new TodoDto();
		
		System.out.println(id);
		dto.setId(Long.valueOf(id));
		dto.setType(type);
		
		dao.updateTodo(dto);    //db에 업데이트
		
		//서버에 응답 결과를 보내기 위함
		List<TodoDto> list = null;
		if(type.equals("TODO"))
			list = dao.getTodos("DOING");
		else if(type.equals("DOING"))
			list = dao.getTodos("DONE");
		
		TodoDto result = null;
		
		for(TodoDto d : list) {
			if(d.getId() == Long.parseLong(id)) {
				result = d;
				break;
			}
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(result);   //json 문자열로 바꾸어줌
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("applictaion/x-www-form-urlencoded");
		PrintWriter out = response.getWriter();
		out.println(json);
		out.close();
		
		String path = request.getContextPath();  //path 정확하게 명시해주어야함
		response.sendRedirect(path + "/MainServlet");
		
	}

}
