$(function(){
	loadEmps();
	$(addBtn).on("click",function(){
		// Ajax异步读取用户信息
		// 将异步加载信息填充到模态窗口的组件之中
		$("#did option:eq(0)").prop("selected", true);
		$("#empTable tr:gt(0)").remove() ;
		$("#pagecontrol").empty();
		$("#userInfo").modal("toggle") ;	// 显示模态窗口
	}) ;
	$(did).on("change", function() {
		var did = $(this).val();
		if(did != "") {
			$("#deptno").val(did);
			jsCommonCp  = 1;
			loadData();
		} else {
			$("#empTable tr:gt(0)").remove() ;
		}
	})
})

function loadData() {
	var did = $("#deptno").val();
	$.post("pages/back/admin/travel/user_list.action", {"did":did, "cp":jsCommonCp, "ls":jsCommonLs}, function(data) {
		$("#empTable tr:gt(0)").remove() ;
		// 填充表格数据
		for(i = 0; i < data.allEmps.length; i++) {
			addRow(data.allEmps[i].a.photo, data.allEmps[i].a.eid, data.allEmps[i].a.ename, data.allEmps[i].a.sal, data.allEmps[i].b, data.allEmps[i].c);
		}
		createSplitBar(data.allRecorders) ;	// 创建分页控制项
	}, "json")
}

function addRow(photo, eid, ename, sal, level, dname) {
	var str = 
		"							<tr id='emp-" + eid + "'>" + 
		"								<td class='text-center'>" + 
		"									<img src='upload/member/" + photo + "' style='width:20px;'/>" + 
		"								</td>" + 
		"								<td class='text-center'>" + eid + "</td>" + 
		"								<td class='text-center'>" + ename + "</td>" + 
		"								<td class='text-center'>￥" + sal + "</td>" + 
		"								<td class='text-center'>" + level + "</td>" + 
		"								<td class='text-center'>" + 
		"									<button class='btn btn-danger btn-xs' id='add-" + eid + "'>" + 
		"										<span class='glyphicon glyphicon-plus-sign'></span>&nbsp;增加" + 
		"									</button>" + 
		"								</td>" + 
		"							</tr>";
	$("#empTable tbody").append(str);
	// user_add
	$("#add-" + eid).on("click", function() {
		var tid = $("#tid").val();
		$.post("pages/back/admin/travel/user_add.action", {"tid":tid, "eid":eid}, function(data) {
			operateAlert(data.trim() == "true", "出差员工增加成功", "出差员工增加失败")
			if(data.trim() == "true") {
				var info = 
					"							<tr id='travel-" + eid +"'>" + 
					"								<td class='text-center'>" + 
					"									<img src='upload/member/" + photo + "' style='width:20px;'/> " + 
					"								</td>" + 
					"								<td class='text-center'>" + eid + "</td>" + 
					"								<td class='text-center'>" + ename + "</td>" + 
					"								<td class='text-center'>￥ " + sal + "</td>" + 
					"								<td class='text-center'>" + level + "</td>" + 
					"								<td class='text-center'>" + dname + "</td>" + 
					"								<td class='text-center'>" + 
					"									<button class='btn btn-danger btn-xs' id='remove-" + eid + "-" + tid + "'>" + 
					"										<span class='glyphicon glyphicon-remove'></span>&nbsp;移除</button>" + 
					"								</td>" + 
					"							</tr>";
				$("#emp_list_table tbody").append(info);
				bindDelete(eid, tid);
				$("#emp-" + eid).remove();
			} else {
				$("#userInfo").modal("toggle");
			}
		}, "text")
	})
}


function loadEmps() {
	var tid = $("#tid").val();
	$.post("pages/back/admin/travel/list_emp_travel.action", {"tid":tid}, function(data) {
		console.log(data);
		for(i = 0; i < data.allEmps.length; i++) {
			var info = 
				"							<tr id='travel-" + data.allEmps[i].a.eid +"'>" + 
				"								<td class='text-center'>" + 
				"									<img src='upload/member/" + data.allEmps[i].a.photo + "' style='width:20px;'/> " + 
				"								</td>" + 
				"								<td class='text-center'>" + data.allEmps[i].a.eid + "</td>" + 
				"								<td class='text-center'>" + data.allEmps[i].a.ename + "</td>" + 
				"								<td class='text-center'>￥ " + data.allEmps[i].a.sal + "</td>" + 
				"								<td class='text-center'>" + data.allEmps[i].b + "</td>" + 
				"								<td class='text-center'>" + data.allEmps[i].c + "</td>" + 
				"								<td class='text-center'>" + 
				"									<button class='btn btn-danger btn-xs' id='remove-" + data.allEmps[i].a.eid + "-" + tid + "'>" + 
				"										<span class='glyphicon glyphicon-remove'></span>&nbsp;移除</button>" + 
				"								</td>" + 
				"							</tr>";
			$("#emp_list_table tbody").append(info);
			bindDelete(data.allEmps[i].a.eid, tid);
		}
	}, "json")
}

//user_delete
function bindDelete(eid, tid) {
	$("#remove-" + eid + "-" + tid).on("click", function() {
		$.post("pages/back/admin/travel/user_delete.action", {"eid":eid, "tid":tid}, function(data) {
			console.log(data);
			operateAlert(data.trim() == "true", "出差员工删除成功！", "出差员工删除失败！");
			if(data.trim() == "true") {
				$("#travel-" + eid).remove();
			}
		}, "text")
	})
}