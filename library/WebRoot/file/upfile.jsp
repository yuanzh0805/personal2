<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'upfile.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.7.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/json/json-minified.js"></script>
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath}/upfile.action" enctype="multipart/form-data" method="post">
    	文件类型：<select name="yiji" id="yiji" onchange="onSelectChange(this,'erji');">
  				<option value="">请选择</option>
  		</select>
  		<select name="erji" id="erji">
  			<option value="">请选择</option>
 		</select><br/>
 		标签（多个标签请用英文逗号隔开）<input type="text" name="label"/><br/>
 		积分：<input type="text" name="jifen"/>
      	文件：<input type="file" name="file"/><br/>
      	<input type="submit" value="提交"/><br/> 
		${upmsg }	
    </form>
  </body>
</html>

<script type="text/javascript">
window.onload = function() {
	setSelect('0','yiji');
}


function onSelectChange(obj,toSelId){
	setSelect(obj.value,toSelId);
}


function setSelect(fromSelVal,toSelId){
	//alert(document.getElementById("province").selectedIndex);
	document.getElementById(toSelId).innerHTML="";
	jQuery.ajax({
	  url: "${pageContext.request.contextPath}/getType.action",
	  cache: false,
	  data:"parentId="+fromSelVal,
	  success: function(data){
	    createSelectObj(data,toSelId);
	  }
	});
}

function createSelectObj(data,toSelId){
	var arr = jsonParse(data);
	if(arr != null && arr.length>0){
		var obj = document.getElementById(toSelId);
		obj.innerHTML="";
		var nullOp = document.createElement("option");
		nullOp.setAttribute("value","");
		nullOp.appendChild(document.createTextNode("请选择"));
		obj.appendChild(nullOp);
		for(var o in arr){
			var op = document.createElement("option");
			op.setAttribute("value",arr[o].typeid);
			//op.text=arr[o].name;//这一句在ie下不起作用，用下面这一句或者innerHTML
			op.appendChild(document.createTextNode(arr[o].typename));
			obj.appendChild(op);
		}
		
	}
}


</script>
