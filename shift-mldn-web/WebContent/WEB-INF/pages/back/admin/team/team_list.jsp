<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/emp/emp_list.js"></script>
<%!
	public static final String EMP_DELETE_URL = "pages/back/admin/emp/delete.action" ;
%>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="1"/>
			<jsp:param name="msi" value="13"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-success">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;员工列表</strong>
			</div>
			<div class="panel-body">
				<div>
					<jsp:include page="/WEB-INF/pages/plugins/split_plugin_search_bar.jsp"/>
				</div>
				${errors}
				<table class="table table-condensed">
					<thead>
						<tr>
							<th class="text-center">姓名</th>
							<th class="text-center">身份证号</th>
							<th class="text-center">手机号码</th>
							<th class="text-center">小组</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${allEmps}" var="emp">
						<tr>
							<td class="text-center">${emp.name}</td> 
							<td class="text-center">${emp.idCard}</td>
							<td class="text-center">${emp.phone}</td>
							<td class="text-center">${allTeams[emp.teamId]}</td>
							<td class="text-center">
								<a type="button" class="btn btn-warning btn-xs" href="<%=EMP_DELETE_URL%>?eid=${emp.id}">
										<span class="glyphicon glyphicon-edit"></span>&nbsp;删除</a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<div id="splitBarDiv" style="float:right">
					<jsp:include page="/WEB-INF/pages/plugins/split_plugin_page_bar.jsp"/>
				</div>
			</div>
			<div class="panel-footer">
				<jsp:include page="/WEB-INF/pages/plugins/include_alert.jsp"/>
			</div>
		</div>
		</div>
		<!-- 导入公司尾部认证信息 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_foot.jsp" />
		<!-- 导入右边工具设置栏 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_sidebar.jsp" />
		<div class="control-sidebar-bg"></div>
	</div>
	<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
