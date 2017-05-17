<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
      <meta http-equiv="Content-Type"content="text/html charset=UTF-8">
  </head>
  
  <body>
  	<form action="<c:url value='/servlet/AdminServlet'/>" method="post">
  		<p align="center">登录界面</p><br/>
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名:<input type="text" name="snumber"/><br/><br/>
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码:<input type="password" name="spass"/><br/><br/>
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="登录"/>
  	</form>
  </body>
</html>
