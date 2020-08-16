package kr.or.connect.Todo.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.Todo.dao.TodoDao;
import kr.or.connect.Todo.dto.TodoDto;

/**
 * Servlet implementation class TodoAddServlet
 */
@WebServlet("/TodoAddServlet")
public class TodoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");    //한글 깨짐 문제 해결
		TodoDto dto = new TodoDto();
		TodoDao dao = new TodoDao();
		
		dto.setTitle(request.getParameter("title"));
		dto.setName(request.getParameter("name"));
		dto.setSequence(Integer.parseInt(request.getParameter("sequenceRadio")));
		
		dao.addTodo(dto);
		
		response.sendRedirect("/Todo/MainServlet");
	}

}
