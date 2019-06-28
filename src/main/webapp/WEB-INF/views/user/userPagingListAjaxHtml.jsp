<%@page import="kr.or.ddit.paging.model.PageVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

				
				<!--향상된 포문 -->
				<c:forEach items="${data.userList }" var="user" varStatus="status">
					<tr class="userTr" data-userid="${user.userId }" data-name="${user.name }">
						<td class="userId">${user.userId }</td>
						<td>${user.name }</td>
						<td>${user.alias }</td>
						<td></td>
					</tr>
				</c:forEach>
SEPERATORSEPERATOR
		<!-- 사용자수 : 105건
			 페이지네이션 : 11건
		 -->
			
				<c:choose>
					<c:when test="${pageVo.page == 1 }">
						<li class="disabled"><span>«</span></li>
					</c:when>
					<c:otherwise>
						<li>
						<a href="javascript:userPagingListAjaxHtml(${pageVo.page -1},${pageVo.pageSize});">«</a>
						</li>
					</c:otherwise>
				</c:choose>
				<c:forEach begin="1" end="${data.paginationSize }" step="1" var="i">
					<c:choose>
						<c:when test="${pageVo.page == i }">
							<li class="active"><span>${i }</span></li>
						</c:when>
					<c:otherwise>
						<li>
							<a href="javascript:userPagingListAjaxHtml(${i },${pageVo.pageSize});">${i }</a>
						</li>
					</c:otherwise>
					</c:choose>
				</c:forEach>
						<c:choose>
					<c:when test="${pageVo.page == data.paginationSize }">
						<li class="disabled"><span>»</span></li>
					</c:when>
					<c:otherwise>
						<li>
						<a href="javascript:userPagingListAjaxHtml(${pageVo.page +1},${pageVo.pageSize});">»</a>
						</li>
					</c:otherwise>
				</c:choose>
