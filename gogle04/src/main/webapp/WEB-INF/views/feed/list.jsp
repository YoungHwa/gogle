<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<c:forEach var="feed" items="${list}">			
				        ${feed.fno}
						${feed.content}
						${feed.regDate}
						${feed.email}
						${feed.pno}
<div class="grid_10">

<div class="demo">

	<div id="demo1" class="jMax">
			<input type="hidden" name="projectNo" value="${param.projectNo}">
			<div class="jMax-text" style="float: left;">
				<span>109</span> <span> characters left</span>
			</div>
			<textarea disabled="disabled">${feed.content}</textarea>
			<div class="jMax-submit" style="float: right;">
				<input type="submit" value="등록"
					onclick="document.location.href='${rootPath}/feed/add.do';"
					class="btn btn-blue submit">
					</c:forEach>
			</div>
		</form>
	</div>
</div>
</div>				
				




 </html>