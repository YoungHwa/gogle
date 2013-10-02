<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<body>
<c:forEach var="feed" items="${list}">
			<aside>
<%-- 			<img src="${rootPath}/img/cross.png" align="right"> --%>
				<div class="post-meta2">
				<input type="hidden" name="projectNo" value="${param.projectNo}">
					<h4 class="user">피드번호: ${feed.fno}</h4>
					<ul>
						<li class="time">이메일: ${feed.email }</li>
						<li class="permalink">등록일: ${feed.regDate }</li>
				<li><input type="submit" value="삭제" class="btn btn-yellow btn-small"  align="right"
							onclick="document.location.href='${rootPath}/feed/delete.do?fno=${feed.fno}&projectNo=${param.projectNo}&email=${feed.email}'">
				</li>	
					</ul>
				</div>
			</aside>

				<div id="demo1" class="jMax2">
					<div class="jMax-submit" style="float: right;">
						<textarea disabled="disabled">${feed.content}</textarea>
					</div>
				</div>
</c:forEach>
</body>
</html>