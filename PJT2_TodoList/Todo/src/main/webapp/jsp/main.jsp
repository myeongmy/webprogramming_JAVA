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
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
	<section>
		<ul class="header">
			<li id="title">나의 해야할 일들</li>
			<li id="new-button" onclick="location.href='/Todo/TodoFormServlet' ">새로운 TODO 등록</li>
		</ul>
		<ul class="container">
			<li class="todo"><div id="todo-title">TODO</div>
			<%
				for(int i=0;i<todoList.size();i++){
					String [] arg = todoList.get(i).getRegDate().split(" ");
			%>
					<div class="box"><span><%= todoList.get(i).getTitle() %></span><br>등록날짜:<%= arg[0] %>, <%= todoList.get(i).getName() %>, 우선순위 <%= todoList.get(i).getSequence() %>
					<button id = "<%= todoList.get(i).getType() %>#<%= todoList.get(i).getId() %>" >-></button>
					</div>
			<% 
				}
			%>
			</li>
			
			<li class="doing"><div id="doing-title">DOING</div>
			<%
				for(int i=0;i<doingList.size();i++){
					String [] arg = doingList.get(i).getRegDate().split(" ");
			%>
					<div class="box"><span><%= doingList.get(i).getTitle() %></span><br>등록날짜:<%= arg[0] %>, <%= doingList.get(i).getName() %>, 우선순위 <%= doingList.get(i).getSequence() %>
					<button id = "<%= doingList.get(i).getType() %>#<%= doingList.get(i).getId() %>" >-></button>
					</div>
			<% 
				}
			%>
			</li>
			<li class="done"><div id="done-title">DONE</div>
			<%
				for(int i=0;i<doneList.size();i++){
					String [] arg = doneList.get(i).getRegDate().split(" ");
			%>
					<div class="box"><span><%= doneList.get(i).getTitle() %></span><br>등록날짜:<%= arg[0] %>, <%= doneList.get(i).getName() %>, 우선순위 <%= doneList.get(i).getSequence() %>
	
					</div>
			<% 
				}
			%>
			</li>
		</ul>
	</section>
</body>
<script>
	var buttons = document.querySelectorAll("button");
	
	for(var i=0;i<buttons.length;i++){
		buttons[i].addEventListener("click", remove);
	}
	
	function remove(){
		var buttonInfo = this.id.split("#");
		var type = buttonInfo[0];
		var id = buttonInfo[1];
		
		var removeTarget = this;
		removeTarget.parentNode.remove(removeTarget);
		
		ajax(type, id);
	}
	
	function ajax(type, id){
		var xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function(){
			//서버에서 응답이 완료되면 실행되는 함수
			if(xhr.readyState === XMLHttpRequest.DONE){   //꼭 추가해주어야함
				if(xhr.status === 200){
					console.log("success");
					var json = this.responseText;
					json = JSON.parse(json);   //json 문자열을 json으로 파싱
					
					var type = json['type'];
					var title = json['title'];
					var sequence = json['sequence'];
					var regDate = json['regDate'].split(" ");
					var name = json['name'];
					var id = json['id'];
		
				
					if(type === 'DOING'){
						var newElement = document.createElement('div');
						newElement.innerHTML = '<div class="box"><span>'+title+'</span><br>등록날짜:'+regDate[0]+', '+name+', 우선순위 '+sequence+'<button id="DOING#'+id+'">-></button>';
						newElement.children[0].children[2].addEventListener("click", remove);     // event listener 등록해주어야함
						console.log(newElement.children[0]);
						var parent = document.querySelector('.doing');
						parent.appendChild(newElement);
						
					}else if(type === 'DONE'){
						var newElement = document.createElement('div');
						newElement.innerHTML = '<div class="box"><span>'+title+'</span><br>등록날짜:'+regDate[0]+', '+name+', 우선순위 '+sequence;
						
						var parent = document.querySelector('.done');
						parent.appendChild(newElement);
					}
				}
			}
		};
		
		xhr.open("POST", "http://localhost:8080/Todo/TodoTypeServlet", true);
		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');   //post 방식으로 데이터를 전송할 때 이용하는 형태
		xhr.send('type='+type+'&id='+id);
	}
</script>
</html>