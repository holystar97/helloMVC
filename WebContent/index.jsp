<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>helloMVC Web Application</title>
</head>
<body>

	This is the home page for shopping
	
	<!--JSP 페이지에서 servlet으로 전달하기 위해서 url를 전달하는 부분을 a href 태그에 적어서 보냄. 
	이때 경로명은 현재 디렉토리(루트?)를 기준으로 하여 프로젝트명/서블릿 명 /? 뒤에 get 방식으로 action 속성과 값을 전달한다.  -->
	
	<p> <a href="/hw1-helloMVC/home?action=login"> go to login page </a> </p> 
	<p> <a href="/hw1-helloMVC/home?action=register"> go to register page </a> </p>
	
</body>
</html>