<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'showfile.jsp' starting page</title>
        
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
            <style type="text/css" media="screen">
			html, body	{ height:100%; }
			body { margin:0; padding:0; overflow:auto; }  
			#flashContent { display:none; }
        </style>
		
		<link rel="stylesheet" type="text/css" href="css/flexpaper.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.extensions.min.js"></script>
		<script type="text/javascript" src="js/flexpaper.js"></script>
		
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
    
    
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
  	
  <div id="documentViewer" class="flexpaper_viewer" style="position:absolute;left:10px;top:10px;width:770px;height:500px"></div>
  	<script type="text/javascript">

        var startDocument = "Paper";

        $('#documentViewer').FlexPaperViewer(
                { config : {

                    SWFFile : '${pageContext.request.contextPath}/document/swf/${document.swfname }',

                    Scale : 0.6,
                    ZoomTransition : 'easeOut',
                    ZoomTime : 0.5,
                    ZoomInterval : 0.2,
                    FitPageOnLoad : true,
                    FitWidthOnLoad : false,
                    FullScreenAsMaxWindow : false,
                    ProgressiveLoading : false,
                    MinZoomSize : 0.2,
                    MaxZoomSize : 5,
                    SearchMatchAll : false,

                    RenderingOrder : 'flash',

                    ViewModeToolsVisible : true,
                    ZoomToolsVisible : true,
                    NavToolsVisible : true,
                    CursorToolsVisible : true,
                    SearchToolsVisible : true,
                    WMode : 'window',
                    localeChain: 'en_US'
                }}
        );
        </script>
  
  <div style="padding-left: 900px">
  <c:choose>
	<c:when test="${empty commentList }">
	  	暂时无评论！
  	</c:when>
  	<c:otherwise>
  		<table border="1">
  		<tr><td>评论内容</td><td>评论时间</td><td>评论人</td></tr><br/>
	    <c:forEach var="comment" items="${commentList }">
	    	<tr>
	    		<td>${comment.content }</td>
	    		<td>${comment.comtime }</td>
	    		<td>${comment.user.username }</td>
	    	</tr>
	    </c:forEach>
	    </table>
  	</c:otherwise>
  </c:choose>
  
  </div>
  
  <div id="form" style="padding-top: 550px;padding-left: 200px;">
  	<c:choose>
	<c:when test="${empty biaoqianList }">
	  	没设置标签
  	</c:when>
  	<c:otherwise>
  	标签：&nbsp;&nbsp;	
	    <c:forEach var="biaoqian" items="${biaoqianList }">	    	
	    		<a href="${pageContext.request.contextPath}/biaoqian.action?id=${biaoqian.bid }">
	    		${biaoqian.bname }&nbsp;&nbsp;</a>	
	    </c:forEach>
  	</c:otherwise>
  </c:choose>
  	<br/>
  	<br/>
    
    <c:choose>
	<c:when test="${empty like }">
		<input type="button" id="dianzan" value="已点赞"  onclick="javascript:butOnclick();"/>	  	
  	</c:when>
  	<c:otherwise>
    <input type="button" id="dianzan" value="点赞"  onclick="javascript:butOnclick();"/>
  	</c:otherwise>
  	</c:choose>
               
    <br/>
    <br/>
    <form action="/library/addComment.action" method="post">
    <input name="id" value="${document.did }" type="hidden"/>
             评论：<input name="comm" type="text"><br>
    <input type="submit" value="评论">
    </form><br>
    下载需要${document.dnum }积分 &nbsp;&nbsp;您有${userInfo.usernum }积分<br/>
    <c:choose>
	<c:when test="${empty jifen }">
		<a href="${pageContext.request.contextPath}/fileDownload.action?id=${document.did }">点击下载</a>	  	
  	</c:when>
  	<c:otherwise>
  		您的积分不够
  	</c:otherwise>
  </c:choose>
    <br/>
    <br/>
  </div>
  
  <script>
 	function butOnclick()
 	{//按钮点击事件
 		var Item = document.getElementById("dianzan");
    	if(Item.value == "点赞"){
    		Item.value = "已点赞";}
    	else{
    		Item.value = "点赞";
    	}
    	jQuery.ajax({
    		  url: "${pageContext.request.contextPath}/addLike.action",
    		  cache: false,
    		  data:"id="+${document.did },
    		  /*success: function(data){
    		    createSelectObj(data,toSelId);
    		  }*/
    		});
 	}
  </script> 
   
   
   
  </body>
</html>
