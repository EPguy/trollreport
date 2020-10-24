<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ko">
	<head>
        <meta charset="UTF-8">
        <title>TROLLREPORT.GG</title>
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/summoner/userinfo.css" type="text/css" />
    	<script type="text/javascript">
    		function trollAdd() {
    			var frm = document.trollPost;
    			frm.action = "/troll/insert.do";
    			frm.category.value = "한줄평";
    			frm.title.value = frm.onelineText.value;
    			frm.content.value = frm.onelineText.value;
    			frm.writer.value = "익명";
    			frm.troller.value = "${name}";
    			frm.submit();
    		}
    		
    		function enterKey() {
    			 if(window.event.keyCode == 13) {
                     trollAdd();
                 }
    		}
		</script>
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
                	<form name="trollPost" style="width: 100%" onsubmit="return false">
                		<input type="hidden" name="category">
                		<input type="hidden" name="title">
                		<input type="hidden" name="content">
                		<input type="hidden" name="writer">
                		<input type="hidden" name="troller">
	                    <input onkeyup="enterKey()" name="onelineText" placeholder="한줄평을 입력하세요." class="comment-textarea">
	                    <div onClick="trollAdd();" class="comment-post">등록</div>
	                </form>
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
                    	<c:otherwise>
                    		<c:forEach var = "trollPost" items="${trollPostList}">
					        	<div class="troll-post-item">
		                            <div class="troll-title">${trollPost.title}</div>
		                            <div class="troll-bottom">
		                                <div class="troll-category">${trollPost.category}</div>
		                                <div class="troll-bottom-line"></div>
		                                <div class="troll-time">${trollPost.insertTime}</div>
		                                <div class="troll-bottom-line"></div>
		                                <div class="troll-writer">${trollPost.writer}</div>
		                            </div>
		                        </div>
					        </c:forEach>
                    		
                    	</c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
        <jsp:include page="../common/footer.jsp"/>
    </body>
</html>