<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ko">
	<head>
        <meta charset="UTF-8">
        <title>TROLLREPORT.GG</title>
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main/main.css" type="text/css" />
    </head>
    <body>
        <jsp:include page="../common/header.jsp"/>

        <div class="index-wrapper">
            <div class="search-wrapper">
                <div class="main-search">
                    <input onkeyup="enterKey()" maxlength="15" id="main-input" placeholder="누굴 박제하고 싶으십니까?">
                    <button onclick="onClick()"><i class="fas fa-search"></i></button>
                </div>
                
                <div class="troll-rank">
                	<div class="troll-top5">
                		<div class="troll-top5-title">트롤랭킹 TOP5</div>
                		<c:forEach varStatus="status" var = "trollUser" items="${trollListTop5}">
                   			<a href="/summoner/info.do?username=${trollUser.name}&page=1">
					        	<div class="troll-user-item">
					        		<div class="troll-ranking">${status.count}위</div>
		                            <div class="troll-icon"><img class="profile" src="<c:url value="http://ddragon.leagueoflegends.com/cdn/10.21.1/img/profileicon/${trollUser.profileIconId}.png"/>"/></div>
		                            <div class="troll-name">${trollUser.name}</div>
		                            <div class="troll-count">${trollUser.trollCount}개</div>
		                        </div>
	                        </a>
				        </c:forEach>
                	</div>
                </div>
            </div>
        </div>
        <script>
            const enterKey = () => {
                if(window.event.keyCode == 13) {
                    inputValue = document.getElementById("main-input").value;
                    window.location.href = "/summoner/info.do?username="+inputValue+"&page=1";
                }
            }
            const onClick = () => {
                inputValue = document.getElementById("main-input").value;
                window.location.href = "/summoner/info.do?username="+inputValue+"&page=1";
            }
        </script>
        <jsp:include page="../common/footer.jsp"/>
    </body>
</html>