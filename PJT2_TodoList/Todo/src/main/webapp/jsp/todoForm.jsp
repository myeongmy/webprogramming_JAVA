<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>할일 등록</title>
</head>
<body>
<section>
<h1>할일 등록</h1>
<form action="TodoAddServlet" method="POST">
<div><input type="text" name="title" placeholder="swift 공부하기(24자까지)" maxlength="24" size="40" required></div>
<div><input type="text" name="name" placeholder="홍길동" required></div>
<div>
<label><input type="radio" name="sequenceRadio" value="1" required> 1순위</label>
<label><input type="radio" name="sequenceRadio" value="2"> 2순위</label>
<label><input type="radio" name="sequenceRadio" value="3"> 3순위</label>
</div>
<div>
<ul>
<li onclick="location.href='/Todo/MainServlet' ">&lt;이전</li>
<li><input type="submit" value="제출"></li>
<li><input type="reset" value="내용지우기"></li>
</ul>
</div>
</form>
</section>
</body>
</html>