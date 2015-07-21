<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'downfile.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <c:choose>
	<c:when test="${empty documentList }">
	  	没找到文件<a href="${pageContext.request.contextPath}/index.jsp">返回主页</a>
  	</c:when>
  	<c:otherwise>
  		<table border="1">
  		<tr><td>文件</td><td>上传者</td><td>上传时间</td><td>下载</td></tr><br/>
	    <c:forEach var="document" items="${documentList }">
	    	<tr>
	    		<td><a href="${pageContext.request.contextPath}/detailfile.action?id=${document.did }">${document.oldname }</a></td>
	    		<td>${document.user.username }</td>
	    		<td>${document.dtime }</td>
	    		<td><a href="${pageContext.request.contextPath}/fileDownload.action?id=${document.did }">点击下载</a></td>
	    	</tr>
	    </c:forEach>
  	</c:otherwise>
  </c:choose>
  </body>
</html>
