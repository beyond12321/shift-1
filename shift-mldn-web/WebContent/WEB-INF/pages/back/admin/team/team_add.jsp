<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp" />
<%!
	public static final String TEAM_ADD_URL = "pages/back/admin/team/add.action"; 
%>
<script type="text/javascript" src="js/pages/back/admin/emp/emp_add.js"></script>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper"> 
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="1"/>
			<jsp:param name="msi" value="12"/>
		</jsp:include>
		<div class="content-wrapper text-left">
			<div class="panel panel-success">
				<div class="panel-heading">
					<strong><span class="glyphicon glyphicon-user"></span>&nbsp;增加小组</strong>
				</div>
				<div class="panel-body"> 
					<form class="form-horizontal" action="<%=TEAM_ADD_URL%>" id="myform"
						method="post" enctype="multipart/form-data">
						<fieldset>
							<div class="form-group" id="nameDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="name">小组名称：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="name" name="name" class="form-control"
										placeholder="请输入小组姓名">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="nameMsg">${errors['name']}</div>
							</div>
							<div class="form-group" id="nameDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="name">组长：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="leader" name="leader" class="form-control"
										placeholder="请输入小组姓名">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="nameMsg">${errors['name']}</div>
							</div><div class="form-group" id="nameDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="name">创建人：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="create" name="create" class="form-control"
										placeholder="请输入小组姓名">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="nameMsg">${errors['name']}</div>
							</div>
							<div class="form-group" id="nameDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="name">最后修改人：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="update" name="update" class="form-control"
										placeholder="请输入小组姓名">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="nameMsg">${errors['name']}</div>
							</div>
							<div class="form-group" id="birthdayDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="birthday">创建日期：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="createtime" name="createtime"
										class="form-control">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="birthdayMsg">${errors['birthday']}</div>
							</div>
							<div class="form-group" id="hireDateDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="hireDate">修改日期：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="updatetime" name="updatetime"
										class="form-control">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="hireDateMsg">${errors['hireDate']}</div>
							</div>
							<div class="form-group" id="nameDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="name">最后修改次数：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="updatecount" name="updatecount" class="form-control"
										placeholder="请输入小组姓名">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="nameMsg">${errors['name']}</div>
							</div>
							<div class="form-group" id="birthdayDiv">
				
							<div class="form-group">
								<div class="col-md-5 col-md-offset-3">
									<button type="submit" class="btn btn-primary">增加</button>
									<button type="reset" class="btn btn-warning">重置</button>
								</div>
							</div>
						</fieldset>
					</form>
				</div>
				<div class="panel-footer">
					<jsp:include page="/WEB-INF/pages/plugins/include_alert.jsp" />
				</div>
			</div>
		</div>
		<!-- 导入公司尾部认证信息 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_foot.jsp" /> 
		<!-- 导入右边工具设置栏 -->
		<jsp:include
			page="/WEB-INF/pages/plugins/back/include_menu_sidebar.jsp" /> 
		<div class="control-sidebar-bg"></div>
	</div>
	<jsp:include
		page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
	<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp" />