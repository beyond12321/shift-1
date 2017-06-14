$(function(){
	$("button[id^=edit-]").each(function(){
		$(this).on("click",function(){
			did = this.id.split("-")[1] ;
			console.log("部门编号：" +  did) ;
			dname = $("#dname-" + did).val() ;
			console.log("部门名称: "  + dname);
			if (dname == "") { 
				operateAlert(false,"","部门名称不允许为空，请确认后再提交更新！") ;
			} else {
				$.post("pages/back/admin/dept/edit.action", {"did" : did, "dname" : dname}, function(data) {
					operateAlert("true" == data.trim(), "部门信息修改成功", "部门信息修改失败");
				}, "text");
			}
		}) ;
	}) ;
	$("span[id^=eid-]").each(function(){
		$(this).on("click",function(){
			eid = this.id.split("-")[1] + "-" +  this.id.split("-")[2];
			console.log("雇员编号：" + eid) ;
			$.post("pages/back/admin/dept/get.action", {"eid" : eid}, function(data) {
				console.log(data);
				$("#ename").text(data.empDatail.a.ename);
				$("#level").text(data.empDatail.b);
				$("#dname").text(data.empDatail.c);
				$("#phone").text(data.empDatail.a.phone);
				$("#hiredate").text(new Date(data.empDatail.a.hiredate.time).format("yyyy-MM-dd"));
				$("#note").text(data.empDatail.a.note);
			}, "json"); 
			$("#userInfo").modal("toggle") ;
		}) ;
	}) ;
}) ;