<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html lang="ko">
	<head>
        <meta charset="UTF-8">
        <title>TROLLREPORT.GG</title>
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/troll/report.css" type="text/css" />
    	<script src="${pageContext.request.contextPath}/resources/js/ckeditor/ckeditor.js"></script>
    	<script type="text/javascript">
    		function trollRegister() {
    			var frm = document.trollPost;
    			frm.action = "/troll/insert.do";
    			frm.writer.value = "익명";
    			frm.submit();
    		}
    	</script>
    </head>
    <body>
        <jsp:include page="../common/header.jsp"/>
		<div class="report">
            <div class="report-wrapper">
                <img src="${pageContext.request.contextPath}/resources/image/troll/reportLogo.png">
                <form name="trollPost">
                	<input type="hidden" name="writer">
	                <div class="post-wrapper">
	                    <div class="editor-tools">
	                        <select name="category" id="custom-select" class="custom-select">
	                            <option value="default" selected>신고 사유</option>
	                            <option value="욕설">욕설</option>
	                            <option value="탈주/자리비움">탈주/자리비움</option>
	                            <option value="고의트롤">고의트롤</option>
	                        </select>
	                    </div>
	                    <div class="editor-title">
	                        <input type="text" name="troller"  id="report-user" class="form-control" placeholder="신고할 소환사명을 입력하세요.">
	                        <input type="text" name="title" id="report-title" class="form-control" placeholder="제목을 입력하세요.">
	                    </div>
	                    <div class="editor-wrapper">
	                        <textarea name="content" id="editor-content"></textarea>
	                        <script>
								 ClassicEditor.create(document.querySelector('#editor-content'), {
									 ckfinder: {
										 uploadUrl: '/ck/fileUpload.do'
									 }
								 });
							</script>
	                    </div>
	                    <div id="btn-report" onClick="trollRegister();" class="comment-post">등록</div>
	                </div>
	        	</form>
            </div>
        </div>
        <jsp:include page="../common/footer.jsp"/>
    </body>
</html>