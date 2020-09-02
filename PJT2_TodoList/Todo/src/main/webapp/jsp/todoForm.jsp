<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>할일 등록</title>
<link rel="stylesheet" type="text/css" href="css/todoForm.css">
</head>
<body>
<section>
<h1>할일 등록</h1>
<form action="TodoAddServlet" method="POST">
<div>어떤일인가요?<br><input type="text" name="title" placeholder="swift 공부하기(24자까지)" maxlength="24" size="40" required></div>
<div>누가 할일인가요?<br><input type="text" name="name" placeholder="홍길동" required></div>
<div>우선순위를 선택하세요<br>
<label><input type="radio" name="sequenceRadio" value="1" required> 1순위</label>
<label><input type="radio" name="sequenceRadio" value="2"> 2순위</label>
<label><input type="radio" name="sequenceRadio" value="3"> 3순위</label>
</div>
<div class="button">
<ul>
<li class="bottom-button before" onclick="location.href='/Todo/MainServlet' ">&lt;이전</li>
<li class="bottom-button submit"><input type="submit" value="제출"></li>
<li class="bottom-button back"><input type="reset" value="내용지우기"></li>
</ul>
</div>
</form>
</section>
</body>
</html>