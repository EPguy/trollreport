<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ko">
	<head>
        <meta charset="UTF-8">
        <title>TROLLREPORT.GG</title>
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/troll/board.css" type="text/css" />
    	<script>
    		function commentPost() {
    			var frm = document.trollComment;
    			frm.action = "/troll/insertComment.do";
    			frm.id.value = "${id}";
    			frm.submit();
    		}
    	</script>
    </head>
    <body>
        <jsp:include page="../common/header.jsp"/>
        <div class="troll-post">
            <div class="troll-post-wrapper">
                <div class="troll-post-top">
                    <div class="troll-post-title">${title}</div>
                    <div class="troll-post-sub-top">
                        <!--<div class="troll-post-category-line"></div>-->
                        <div class="troll-post-category">${category}</div>
                        <div class="troll-post-category-line"></div>
                        <div class="troll-post-category">${writer}</div>
                    </div>
                </div>
                <div class="troll-post-line"></div>
                <div id="troll-post-content" class="troll-post-content">${content}</div>
                <a href="/troll/increaseLike.do?id=${id}">추천</a>
                <a href="/troll/decreaseLike.do?id=${id}">추천</a>
                <form name="trollComment">
                	<input type="hidden" name="id">
                	<input name="content" id="troll-comment" type="text" placeholder="댓글입력">
                	<button onClick="commentPost();" type="button">댓글입력</button>
            	</form>
            </div>
        </div>
        <jsp:include page="../common/footer.jsp"/>
    </body>
</html>