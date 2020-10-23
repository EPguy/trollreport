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
                <div class="search-logo"><img src="${pageContext.request.contextPath}/resources/image/main/teemo.png"></div>
                <div class="main-search">
                    <input onkeyup="enterKey()" id="main-input" placeholder="누굴 박제하고 싶으십니까?">
                    <button onclick="onClick()"><i class="fas fa-search"></i></button>
                </div>
            </div>
        </div>
        <script>
            const enterKey = () => {
                if(window.event.keyCode == 13) {
                    inputValue = document.getElementById("main-input").value;
                    window.location.href = `/user/info?username=${inputValue}`;
                }
            }
            const onClick = () => {
                inputValue = document.getElementById("main-input").value;
                window.location.href = `/user/info?username=${inputValue}`;
            }
        </script>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </body>
</html>