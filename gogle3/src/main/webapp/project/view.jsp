<%@page import="net.bitacademy.java41.vo.Member"%>
<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Gogle - Project View</title>
<link rel="icon" type="image/png" href="${rootPath}/res/logo_gogle.png">

<link rel="stylesheet" type="text/css" href="${rootPath}/css/reset.css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="${rootPath}/css/text.css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="${rootPath}/css/grid.css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="${rootPath}/css/layout.css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="${rootPath}/css/nav.css"
	media="screen" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" href="${rootPath}/css/ie6.css" media="screen" /><![endif]-->
<!--[if IE 7]><link rel="stylesheet" type="text/css" href="${rootPath}/css/ie.css" media="screen" /><![endif]-->
<link href="${rootPath}/css/table/demo_page.css" rel="stylesheet"
	type="text/css" />
<!-- BEGIN: load jquery -->
<script src="${rootPath}/js/jquery-1.6.4.min.js" type="text/javascript"></script>
<script type="text/javascript"
	src="${rootPath}/js/jquery-ui/jquery.ui.core.min.js"></script>
<script src="${rootPath}/js/jquery-ui/jquery.ui.widget.min.js"
	type="text/javascript"></script>
<script src="${rootPath}/js/jquery-ui/jquery.ui.accordion.min.js"
	type="text/javascript"></script>
<script src="${rootPath}/js/jquery-ui/jquery.effects.core.min.js"
	type="text/javascript"></script>
<script src="${rootPath}/js/jquery-ui/jquery.effects.slide.min.js"
	type="text/javascript"></script>
<script src="${rootPath}/js/jquery-ui/jquery.ui.mouse.min.js"
	type="text/javascript"></script>
<script src="${rootPath}/js/jquery-ui/jquery.ui.sortable.min.js"
	type="text/javascript"></script>
<script src="${rootPath}/js/table/jquery.dataTables.min.js"
	type="text/javascript"></script>
<!-- END: load jquery -->
<script type="text/javascript" src="${rootPath}/js/table/table.js"></script>
<script src="${rootPath}/js/setup.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		setupLeftMenu();

		$('.datatable').dataTable();
		setSidebarHeight();

	});
</script>



<!-- 추가  CSS-->
<link rel="stylesheet" type="text/css" href="${rootPath}/css/header.css" />
<link rel="stylesheet" type="text/css"
	href="${rootPath}/css/sidebar.css" />
<link rel="stylesheet" type="text/css"
	href="${rootPath}/css/content.css" />

<!-- //추가 CSs-->

</head>
<body>
	<div class="container_12">
		<!-- Header -->
		<jsp:include page="/header.do"></jsp:include>

		<!-- Sidebar -->
		<jsp:include page="/sidebar.do"></jsp:include>

		<!-- Content -->

		<div class="grid_10">
			<div class="box round first grid">

				<div class="block ">

					<div>
						<div id="submenu">
							<input type="submit" value="기본정보"
								class="btn btn-yellow btn-small"
								onclick="document.location.href='${rootPath}/project/view.do?no=${project.no}'">
							<input type="submit" value="작업들" class="btn btn-yellow btn-small"
								onclick="document.location.href='${rootPath}/task/list.do?projectNo=${project.no}'">
							<input type="submit" value="게시판" class="btn btn-yellow btn-small"
								onclick="document.location.href='${rootPath}/feed/list.do?projectNo=${project.no}'">
						</div>


						<table class="form">
							<tr>
								<td><label>프로젝트 명</label></td>
								<td><input type="text" class="mini"
									value="${project.title}" disabled /></td>
							</tr>
							<tr>
								<td><label>번호</label></td>
								<td><input type="text" class="mini" value="${project.no}"
									disabled /></td>
							</tr>
							<tr>
								<td><label>PL</label></td>
								<td><input type="text" class="mini"
									value="${project.leader}" disabled /></td>
							</tr>
							<tr>
								<td><label>내용</label></td>
								<td><input type="text" class="mini"
									value="${project.content}" disabled /></td>

							</tr>
							<tr>
								<td><label>시작일</label></td>
								<td><input type="text" class="mini"
									value="${project.startDate}" disabled /></td>
							</tr>
							<tr>
								<td><label>종료일</label></td>
								<td><input type="text" class="mini"
									value="${project.endDate}" disabled /></td>
							</tr>

						</table>

						<div class="form_submit_div">
							<input type="submit" value="목록" class="btn btn-orange"
								onclick="document.location.href='${rootPath}/project/list.do';">
							<input type="submit" value="변경" class="btn btn-blue submit"
								onclick="document.location.href='${rootPath}/project/update.do?no=${project.no}';">
							<input type="reset" value="삭제" class="btn btn-grey"
								onclick="document.location.href='${rootPath}/project/delete.do?no=${project.no}';">
						</div>
					</div>
				</div>
			</div>


			<div class="box round">
				<h2>프로젝트 멤버</h2>
				<div class="block">
					<table class="data display datatable" id="example">
						<thead>
							<tr>
								<th>이름</th>
								<th>이메일</th>
								<th>전화</th>
								<th>블로그</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach var="memberByProject" items="${memberByProject}">
								<tr class="odd gradeX" style='cursor: pointer;' align="center">
									<td>${memberByProject.name}</td>
									<td>${memberByProject.email}</td>
									<td>${memberByProject.tel}</td>
									<td>${memberByProject.blog}</td>

								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- //Content -->


		<div class="clear"></div>
	</div>
	<!-- Tail -->
	<jsp:include page="/Tail.jsp"></jsp:include>
</body>
</html>