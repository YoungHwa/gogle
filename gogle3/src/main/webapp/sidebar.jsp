<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Side Menu Start -->
<div class="grid_2">
	<div class="box sidemenu">
		<div class="block" id="section-menu">
			<ul class="section menu">
				<c:choose>
					<c:when test="${member.level == 1}">
						<!-- 관리프로젝트 -->
						<li><a class="menuitem">메뉴</a>
							<ul class="submenu">
								<li><a href="${rootPath}/member/list.do">멤버 관리</a></li>
								<li><a href="${rootPath}/project/list.do">프로젝트 관리</a></li>
							</ul></li>
					</c:when>
					<c:otherwise>
						<!-- 참여프로젝트 -->
						<li><a class="menuitem">참여 프로젝트</a>
							<ul class="submenu">
								<li class="sidebar_total"><a
									href="${rootPath}/project/list.do"><span>전체보기</span></a></li>
								<c:forEach var="myProject" items="${myprojects}">
									<li><a
										href="${rootPath}/project/view.do?no=${myProject.no}">${myProject.title}<c:if
												test="${myProject.level == 1}">&nbsp;&nbsp;★</c:if></a></li>
								</c:forEach>
							</ul></li>
					</c:otherwise>
				</c:choose>

			</ul>
		</div>
	</div>
</div>





