<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ko">
	<head>
        <meta charset="UTF-8">
        <title>TROLLREPORT.GG</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/basic.css" type="text/css" />
    	<link rel="stylesheet" type="text/css" href="https://cdn.rawgit.com/moonspam/NanumSquare/master/nanumsquare.css">
    	<style>
    		.user-info {
    			margin-left: auto;
    			display:flex;
    			justify-content: center;
    			align-items: center;
    			flex-direction: row
    		}
    	</style>
    </head>
    <body>
        <nav class="Navigation">
            <div class="container" style="justify-content: flex-start">
                <a href="/" class="Menus__link Gilroy brand">트롤검색.KR</a>
                <div class="link-items">
                    <a href="/troll/report.do" class="Menus__link">트롤 등록</a>
                </div>
                <c:choose>
                	<c:when test="${sessionScope.userInfo == null}">
                		<a href="/users/naverlogin" id="login-button" class="Menus__login float-right" style="margin-left: auto"><span>로그인</span></a>
                	</c:when>
                	<c:when test="${sessionScope.userInfo != null}">
                		<div class="user-info">
	                		<div><a href="/mypage/user.do">${userInfo.name} 님</a></div>
	                		<a style="margin-left: 15px;" href="/users/logout.do" id="login-button" class="Menus__login float-right" ><span>로그아웃</span></a>
                		</div>
                	</c:when>
                </c:choose>
            </div>
        </nav>
    </body>
</html>