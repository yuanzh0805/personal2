<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
  </head>
  
  <body>
    <h1>用户注册</h1>
    <form action="${pageContext.request.contextPath}/regist.action" method="post">
    <table>
    <tr><td>name:</td><td> <input type="text" name="user.username" /></td></tr>
    <tr><td>pwd:</td><td><input type="password" name="user.userpwd"/></td></tr>
    <tr><td><input type="submit" value="注册" /></td><td><input type="reset" value="重填"/></td></tr>
    </table>
   
    <br/>
    
    </form>
  </body>
</html>
