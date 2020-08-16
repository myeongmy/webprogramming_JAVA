<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="kr.or.connect.Todo.dto.TodoDto" %>
<%@ page import="java.util.*" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%
	List<TodoDto> todoList = (List<TodoDto> )request.getAttribute("TODO");
	List<TodoDto> doingList = (List<TodoDto> )request.getAttribute("DOING");
	List<TodoDto> doneList = (List<TodoDto> )request.getAttribute("DONE");
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TodoList</title>
</head>
<body>
	<section>
		<ul>
			<li>나의 해야할 일들</li>
			<li onclick="location.href='/Todo/TodoFormServlet' ">새로운 TODO 등록</li>
		</ul>
		<ul>
			<li><div>TODO</div>
			<%
				for(int i=0;i<todoList.size();i++){
					String [] arg = todoList.get(i).getRegDate().split(" ");
			%>
					<div><%= todoList.get(i).getTitle() %><br>등록날짜:<%= arg[0] %>, <%= todoList.get(i).getName() %>, 우선순위 <%= todoList.get(i).getSequence() %>
					<button>-></button>
					</div>
			<% 
				}
			%>
			</li>
			
			<li><div>DOING</div>
			<%
				for(int i=0;i<doingList.size();i++){
					String [] arg = doingList.get(i).getRegDate().split(" ");
			%>
					<div><%= doingList.get(i).getTitle() %><br>등록날짜:<%= arg[0] %>, <%= doingList.get(i).getName() %>, 우선순위 <%= doingList.get(i).getSequence() %>
					<button>-></button>
					</div>
			<% 
				}
			%>
			</li>
			<li><div>DONE</div>
			<%
				for(int i=0;i<doneList.size();i++){
					String [] arg = doneList.get(i).getRegDate().split(" ");
			%>
					<div><%= doneList.get(i).getTitle() %><br>등록날짜:<%= arg[0] %>, <%= doneList.get(i).getName() %>, 우선순위 <%= doneList.get(i).getSequence() %>
					<button>-></button>
					</div>
			<% 
				}
			%>
			</li>
		</ul>
	</section>
</body>
</html>