<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="ko">
	<head>
        <meta charset="UTF-8">
        <title>트롤검색.KR</title>
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/troll/board.css" type="text/css" />
    	<meta name="keywords" content = "트롤 신고 게시글">
    	<meta name = "description" content = "트롤 신고 게시글 상세내용 보기">
    	<script>
    		function commentPost() {
    			var frm = document.trollComment;
    			frm.action = "/troll/insertComment.do";
    			frm.id.value = "${id}";
    			frm.submit();
    		}
    		function timeForToday(value) {
    	        const today = new Date();
    	        const timeValue = new Date(value);

    	        const betweenTime = Math.floor((today.getTime() - timeValue.getTime()) / 1000 / 60);
    	        if (betweenTime < 1) return '방금전';
    	        if (betweenTime < 60) {
    	            return `${betweenTime}분전`;
    	        }

    	        const betweenTimeHour = Math.floor(betweenTime / 60);
    	        if (betweenTimeHour < 24) {
    	            return `${betweenTimeHour}시간전`;
    	        }

    	        const betweenTimeDay = Math.floor(betweenTime / 60 / 24);
    	        if (betweenTimeDay < 365) {
    	            return `${betweenTimeDay}일전`;
    	        }

    	        return `${Math.floor(betweenTimeDay / 365)}년전`;
    	 }
    	</script>
    </head>
    <body>
        <jsp:include page="../common/header.jsp"/>
        <div class="troll-post">
            <div class="troll-post-wrapper">
                <div class="troll-post-top">
                	<div class="troll-post-sub-top">
                        <div class="troll-post-title">${title}</div>
	                    <div class="troll-post-title-line"></div>
	                    <div onClick="location.href = '/summoner/info.do?username=${name}&page=1'" style="cursor:pointer;" class="troll-post-title">${name}</div>
                    </div>
                    <div class="troll-post-sub-top">
                        <!--<div class="troll-post-category-line"></div>-->
                        <div class="troll-post-category">${category}</div>
                        <div class="troll-post-category-line"></div>
                        <div class="troll-post-category">${writer} 님 작성</div>
                    </div>
                </div>
                <div class="troll-post-line"></div>
                <div id="troll-post-content" class="troll-post-content">${content}</div>
                <div class="troll-post-like">
                	<a href="/troll/increaseLike.do?id=${id}">
	                	<div class="like-button">
		                	<div class="like-emoji">&#128077;</div>
		                	<div class="like-count">${likeCount}</div>
	                	</div>
                	</a>
                	<a href="/troll/decreaseLike.do?id=${id}">
	                	<div class="like-button">
	                		<div class="like-emoji">&#128078;</div>
	                		<div class="like-count">${unlikeCount}</div>
	                	</div>
                	</a>
                </div>
                <form class="troll-post-comment-form" onsubmit="return false" name="trollComment">
                	<input type="hidden" name="id">
                	<input name="content" class="troll-comment" type="text" placeholder="댓글입력">
                	<button class="comment-post" onClick="commentPost();" type="button">입력</button>
            	</form>
            	<div class="troll-post-comment-list">
            		<c:forEach varStatus="status" var = "comment" items="${commentList}">
			        	<div class="troll-post-comment">
			        		<div class="troll-post-comment-name">${comment.uname}</div>
			        		<div class="troll-post-comment-content">${comment.content}</div>
							<div class="troll-post-comment-date"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${comment.insertTime}" /></div>
                        </div>
			        </c:forEach>
            	</div>
            </div>
        </div>
        <jsp:include page="../common/footer.jsp"/>
    </body>
</html>