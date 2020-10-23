<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ko">
	<head>
        <meta charset="UTF-8">
        <title>TROLLREPORT.GG</title>
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/summoner/userinfo.css" type="text/css" />
    </head>
    <body>
        <jsp:include page="../common/header.jsp"/>

        <div class="user-wrapper">
            <div class="Summoner_Header">
                <div class="Summoner_Header_Wrapper">
                    <div class="Summoner_Info">
                        <div class="Summoner_Header_Style">
                            <div class="Summoner_Header_img">
                                <img class="profile" src="<c:url value="${icon}"/>"/>
                            </div>
                        </div>
                        <div class="Summoner_Header_Userinfo">
                            <div class="Summoner_name">${name}</div>
                        </div>
                    </div>
                </div>
                <div class="oneline-form">
                    <input id="oneline-input" placeholder="한줄평을 입력하세요." class="comment-textarea">
                    <div id="oneline-post" class="comment-post">등록</div>
                </div>
                <div class="post-wrapper">
                        <div class="post-wrapper-count">
                        <span>총 </span><span>${troll_post_count}</span><span>개</span>
                    </div>
                    <c:choose>
                    	<c:when test = "${troll_post_count==0}">
                    		<div class="no-troll">
		                        트롤 기록이 없는 유저입니다.
		                    </div>
                    	</c:when>
                    </c:choose>
                </div>
            </div>
        </div>
        <jsp:include page="../common/footer.jsp"/>
        <script src="${pageContext.request.contextPath}/resources/js/user.js"></script>
    </body>
</html>