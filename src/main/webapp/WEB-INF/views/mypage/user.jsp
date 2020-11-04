<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ko">
	<head>
        <meta charset="UTF-8">
        <title>트롤검색.KR</title>
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mypage/user.css" type="text/css" />
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/summoner/userinfo.css" type="text/css" />
    	<meta name="keywords" content = "마이페이지">
    	<meta name = "description" content = "현재 검토중인 게시글과 승인완료 된 게시글 확인 가능">
    </head>
    <body>
        <jsp:include page="../common/header.jsp"/>

        <div class="index-wrapper">
        	<div class="post-wrapper">
        		<div class="troll-confirm-title">검토 중인 게시글</div>
        		<div class="troll-confirm-items">
        			<div class="troll-confirm-item">
        				<c:forEach var = "noConfirm" items="${noConfirmList}">
                   			<a href="/troll/board.do?id=${noConfirm.id}">
					        	<div class="troll-post-item">
					        		<div class="troll-post-left">
			                            <div class="troll-title">${noConfirm.title}</div>
			                            <div class="troll-bottom">
			                                <div class="troll-category">${noConfirm.category}</div>
			                                <div class="troll-bottom-line"></div>
			                                <div class="troll-time">${noConfirm.insertTime}</div>
			                                <div class="troll-bottom-line"></div>
			                                <div class="troll-writer">${noConfirm.writer}</div>
			                            </div>
		                            </div>
		                            <div class="troll-post-right">
		                            	<div id="${noConfirm.id}" class="troll-post-delete">삭제</div>
		                            </div>
		                        </div>
	                        </a>
				        </c:forEach>
        			</div>	
        		</div>
        	</div>
        	<div class="post-wrapper">
        		<div class="troll-confirm-title">승인 된 게시글</div>
        		<div class="troll-confirm-items">
        			<div class="troll-confirm-item">
        				<c:forEach var = "yesConfirm" items="${yesConfirmList}">
                   			<a href="/troll/board.do?id=${yesConfirm.id}">
					        	<div class="troll-post-item">
					        		<div class="troll-post-left">
			                            <div class="troll-title">${yesConfirm.title}</div>
			                            <div class="troll-bottom">
			                                <div class="troll-category">${yesConfirm.category}</div>
			                                <div class="troll-bottom-line"></div>
			                                <div class="troll-time">${yesConfirm.insertTime}</div>
			                                <div class="troll-bottom-line"></div>
			                                <div class="troll-writer">${yesConfirm.writer}</div>
			                            </div>
		                            </div>
		                            <div class="troll-post-right">
		                            	<div id="${yesConfirm.id}" class="troll-post-delete">삭제</div>
		                            </div>
		                        </div>
	                        </a>
				        </c:forEach>
        			</div>	
        		</div>
        	</div>
        </div>
        <jsp:include page="../common/footer.jsp"/>
        <script>
    		$(".troll-post-delete").click(function(e) {
    			e.preventDefault();
    			var r = confirm("삭제하시겠습니까?");
    			
    			if(r == true) {
    				window.location.href = "/troll/delete.do?id="+e.target.id;
    			}
    		})
    	</script>
    </body>
</html>