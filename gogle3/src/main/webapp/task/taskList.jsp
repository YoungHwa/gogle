<%@page import="net.bitacademy.java41.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Gogle - Project Task List</title>
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



		<!-- Container Start -->



		<div class="grid_10">
			<div class="box round first grid">

				<h2>작업 목록</h2>

				<div class="block ">

					<div id="submenu">
						<input type="submit" value="기본정보" class="btn btn-yellow btn-small"
							onclick="document.location.href='${rootPath}/project/view.do?no=${project.no}'">
						<input type="submit" value="작업들" class="btn btn-yellow btn-small"
							onclick="document.location.href='${rootPath}/task/list.do?projectNo=${project.no}'">
						<input type="submit" value="게시판" class="btn btn-yellow btn-small"
							onclick="document.location.href='${rootPath}/feed/list.do?projectNo=${project.no}'">
					</div>
					<br>

					<table class="form">
						<tr>
							<td><label><h5>프로젝트 명: ${project.title}</h5></label></td>
						</tr>
					</table>

					<table class="data display datatable" id="example">
						<thead>
							<tr>
								<th class="sorting_asc" rowspan="1" colspan="1"
									style="width: 253px;">작업명</th>
								<th class="sorting" rowspan="1" colspan="1"
									style="width: 313px;">시작일</th>
								<th class="sorting" rowspan="1" colspan="1"
									style="width: 294px;">종료일</th>
								<th class="sorting" rowspan="1" colspan="1"
									style="width: 212px;">상태</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="task" items="${taskList}">
								<tr
									onclick="document.location.href='view.do?projectNo=${task.projectNo}&taskNo=${task.taskNo}'"
									style='cursor: pointer;'>
									<td>${task.title}</td>
									<td>${task.startDate}</td>
									<td>${task.endDate}</td>
									<td><c:choose>
											<c:when test="${task.status == 0}">등록</c:when>
											<c:when test="${task.status == 1}">진행</c:when>
											<c:when test="${task.status == 2}">완료</c:when>
											<c:when test="${task.status == 3}">지연</c:when>
										</c:choose></td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="table_bottom_btns_div">
						<button class="btn-icon btn-blue btn-person"
							onclick="document.location.href='${rootPath}/task/addForm.do?projectNo=${project.no}';">
							<span></span>새 작업 등록
						</button>
					</div>
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

