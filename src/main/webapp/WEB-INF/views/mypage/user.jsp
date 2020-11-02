<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ko">
	<head>
        <meta charset="UTF-8">
        <title>TROLLREPORT.GG</title>
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mypage/user.css" type="text/css" />
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/summoner/userinfo.css" type="text/css" />
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
		                            <div class="troll-title">${noConfirm.title}</div>
		                            <div class="troll-bottom">
		                                <div class="troll-category">${noConfirm.category}</div>
		                                <div class="troll-bottom-line"></div>
		                                <div class="troll-time">${noConfirm.insertTime}</div>
		                                <div class="troll-bottom-line"></div>
		                                <div class="troll-writer">${noConfirm.writer}</div>
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
		                            <div class="troll-title">${yesConfirm.title}</div>
		                            <div class="troll-bottom">
		                                <div class="troll-category">${yesConfirm.category}</div>
		                                <div class="troll-bottom-line"></div>
		                                <div class="troll-time">${yesConfirm.insertTime}</div>
		                                <div class="troll-bottom-line"></div>
		                                <div class="troll-writer">${yesConfirm.writer}</div>
		                            </div>
		                        </div>
	                        </a>
				        </c:forEach>
        			</div>	
        		</div>
        	</div>
        </div>
        <jsp:include page="../common/footer.jsp"/>
    </body>
</html>