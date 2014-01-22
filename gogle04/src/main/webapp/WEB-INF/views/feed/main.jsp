<%@page import="net.bitacademy.java41.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Gogle - Project List</title>
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

        $(document).ready(function () {
            setupLeftMenu();

            $('.datatable').dataTable();
			setSidebarHeight();


        });
    </script>






<script src="${rootPath}/js/setup.js" type="text/javascript"></script>
<script type="text/javascript">

        $(document).ready(function () {
            setupDashboardChart('chart1');
            setupLeftMenu();
			setSidebarHeight();


        });
    </script>

<link rel="stylesheet" type="text/css" href="${rootPath}/css/style.css"
	media="screen">





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
				<h2>${param.projectNo}번프로젝트 피드목록</h2>
				<jsp:include page="/feed/addForm.do"></jsp:include>
				<jsp:include page="/feed/list.do"></jsp:include>

			</div>
		</div>
		<!-- //Content -->


		<div class="clear"></div>
	</div>
	<!-- Tail -->
	<jsp:include page="/Tail.do"></jsp:include>

</body>
</html>


