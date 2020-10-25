<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ko">
	<head>
        <meta charset="UTF-8">
        <title>TROLLREPORT.GG</title>
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/troll/report.css" type="text/css" />
    	<script src="${pageContext.request.contextPath}/resources/js/ckeditor/ckeditor.js"></script>
    </head>
    <body>
        <jsp:include page="../common/header.jsp"/>
		<div class="report">
            <div class="report-wrapper">
                <img src="${pageContext.request.contextPath}/resources/image/troll/reportLogo.png">
                <div class="post-wrapper">
                    <div class="editor-tools">
                        <select id="custom-select" class="custom-select">
                            <option value="default" selected>신고 사유</option>
                            <option value="욕설/패드립">욕설/패드립</option>
                            <option value="탈주/자리비움">탈주/자리비움</option>
                            <option value="쓰로잉">쓰로잉</option>
                        </select>
                    </div>
                    <div class="editor-title">
                        <input type="text" id="report-user" class="form-control" placeholder="신고할 소환사명을 입력하세요.">
                        <input type="text" id="report-title" class="form-control" placeholder="제목을 입력하세요.">
                    </div>
                    <div class="editor-wrapper">
                        <textarea name="editor-content" id="editor-content"></textarea>
                        <script>
							 ClassicEditor.create(document.querySelector('#editor-content'));
						</script>
                    </div>
                    <div id="btn-report" class="comment-post">등록</div>
                </div>
            </div>
        </div>
        <jsp:include page="../common/footer.jsp"/>
    </body>
</html>