<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<script type="text/javascript" src="${rootPath}/js/jquery-1.3.2.js"></script>
<script src="${rootPath}/js/jquery.MaxInput.js" type="text/javascript"></script>
<script type="text/javascript">
		$(function() {
			$("#demo1").maxinput({
				position	: 'topleft',
				showtext 	: true,
				limit		: 130
			});
			
			
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



<div class="grid_10">

<div class="demo">

	<div id="demo1" class="jMax">
		<form action="add.do" method="post">
			<input type="hidden" name="projectNo" value="${param.projectNo}">
			<div class="jMax-text" style="float: left;">
				<span>109</span> <span> characters left</span>
			</div>
			<textarea name="content"></textarea>
			<div class="jMax-submit" style="float: right;">
				<input type="submit" value="등록"
					onclick="document.location.href='${rootPath}/feed/add.do';"
					class="btn btn-blue submit">
			</div>
		</form>
	</div>
</div>
</div>