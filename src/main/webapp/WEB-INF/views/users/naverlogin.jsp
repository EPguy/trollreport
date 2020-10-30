<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ko">
	<head>
        <meta charset="UTF-8">
        <title>TROLLREPORT.GG</title>
    	<script>
    		window.self.location = "${url}";
    	</script>
    </head>
    <body>
        <jsp:include page="../common/header.jsp"/>
        <jsp:include page="../common/footer.jsp"/>
    </body>
</html>