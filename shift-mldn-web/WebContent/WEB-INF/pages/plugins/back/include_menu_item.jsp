<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%!
	public static final String INDEX_URL = "pages/back/index.jsp";

	public static final String DEPT_LIST_URL = "pages/back/admin/dept/list.action";
	public static final String EMP_ADD_URL = "pages/back/admin/emp/addpre.action";
	public static final String EMP_LIST_URL = "pages/back/admin/emp/list.action";

	public static final String TRAVEL_ADD_URL = "pages/back/admin/travel/add_pre.action";
	public static final String TRAVEL_LIST_SELF_URL = "pages/back/admin/travel/list_self.action";
	public static final String TRAVEL_LIST_EMP_URL = "pages/back/admin/travel/list_emp.action";

	public static final String TRAVEL_AUDIT_URL = "pages/back/admin/travelaudit/prepare.action";
	public static final String TRAVEL_LIST_URL = "pages/back/admin/travelaudit/list.action";%> 
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="upload/member/nophoto.png" class="img-circle"
					alt="User Image">
			</div>
			<div class="pull-left info">
				<p>${ename}</p>
			</div>
		</div>
		<!-- /.search form -->
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header"><i class="fa fa-university"></i>排班安排系统</li>
			
			
			<li class="treeview ${param.mi == 1 ? 'active' : ''}">
				<a href="${basePath}<%=INDEX_URL%>"> <i class="fa fa-sitemap"></i>
						<span>雇员管理</span> <i class="fa fa-angle-left pull-right"></i>
				</a> 
				<ul class="treeview-menu">
					<li class="${param.msi==12 ? 'active' : ''}"><a
						href="<%=EMP_ADD_URL%>"><i class="fa fa-user-plus"></i> 增加雇员</a></li>
					<li class="${param.msi==13 ? 'active' : ''}"><a
						href="<%=EMP_LIST_URL%>"><i class="fa fa-users"></i> 雇员列表</a></li>
				</ul>
			</li>
			
			
			<li class="treeview ${param.mi==2 ? 'active' : ''}">
				<a href="${basePath}<%=INDEX_URL%>"> <i class="fa  fa-car"></i>
					<span>排班方案管理</span>
						<i class="fa fa-angle-left pull-right"></i>
				</a>
				<ul class="treeview-menu">
						<li class="${param.msi==21 ? 'active' : ''}"><a
							href="<%=TRAVEL_ADD_URL%>"><i class="fa fa-train"></i>排班方案管理</a></li>
						<li class="${param.msi==22 ? 'active' : ''}"><a
							href="<%=TRAVEL_LIST_SELF_URL%>"><i class="fa fa-history"></i>
								排班表管理</a></li>
				</ul>
			</li>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>