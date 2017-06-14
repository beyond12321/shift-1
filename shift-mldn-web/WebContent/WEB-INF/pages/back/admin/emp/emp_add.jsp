<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp" />
<%!public static final String EMP_ADD_URL = "pages/back/admin/emp/add.action";%>
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
					<strong><span class="glyphicon glyphicon-user"></span>&nbsp;雇员入职</strong>
				</div>
				<div class="panel-body"> 
					<form class="form-horizontal" action="<%=EMP_ADD_URL%>" id="myform"
						method="post" enctype="multipart/form-data">
						<fieldset>
							<div class="form-group" id="nameDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="name">雇员姓名：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="name" name="name" class="form-control"
										placeholder="请输入雇员真实姓名">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="nameMsg">${errors['name']}</div>
							</div>
							<div class="form-group" id="sexDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="sex">性别：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									男<input name="sex" type="radio" value="1" checked> 女<input
										name="sex" type="radio" value="0">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="sexMsg">${errors['name']}</div>
							</div>
							<div class="form-group" id="phoneDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="phone">联系电话：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="phone" name="phone" class="form-control"
										placeholder="请输入雇员联系电话">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="phoneMsg">${errors['phone']}</div>
							</div>
							<div class="form-group" id="id_cardDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="id_card">身份证：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="id_card" name="id_card"
										class="form-control" placeholder="请输入雇员身份证号码">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="id_cardMsg">${errors['id_card']}</div>
							</div>
							<div class="form-group" id="birthdayDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="birthday">出生日期：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="birthday" name="birthday"
										class="form-control">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="birthdayMsg">${errors['birthday']}</div>
							</div>
							<div class="form-group" id="hire_dateDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="hire_date">入职日期：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="hire_date" name="hire_date"
										class="form-control">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="hire_dateMsg">${errors['hire_date']}</div>
							</div>
							<div class="form-group" id="education_degreeDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="education_degree">文化程度：</label>
								<div class="col-md-5">
									<select id="education_degree" name="education_degree"
										class="form-control">
										<option value="小学">小学</option>
										<option value="初中">初中</option>
										<option value="高中">高中</option>
										<option value="大学">大学</option>
										<option value="研究生">研究生</option>
										<option value="博士">博士</option>
									</select>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="education_degreeMsg"></div>
							</div>

							<div class="form-group" id="team_idDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="team_id">文化程度：</label>
								<div class="col-md-5">
									<select id="team_id" name="team_id"
										class="form-control">
										<c:forEach items="${allTeams}" var="team">
											<option value="${team.id}">${team.name}</option>
										</c:forEach>
									</select>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="team_idMsg"></div>
							</div>
							
							<div class="form-group" id="picDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="pic">雇员照片：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="file" id="pic" name="pic" class="form-control"
										placeholder="请选择雇员照片">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="picMsg">${errors['pic']}</div>
							</div>
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