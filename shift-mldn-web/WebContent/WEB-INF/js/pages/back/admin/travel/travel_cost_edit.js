var myform ;
function clearCostModal() {
	$(title).val("") ;
	$(price).val("") ;
	$("#tpid option").each(function(){
		$(this).prop("selected",false) ; 
	}) ;
	myform.resetForm() ; 
}
$(function(){
	var allPrice = 0.0;
	$("span[id^=price-]").each(function(){
		allPrice += parseFloat($(this).text());
	})
	$("#allPrice").text(allPrice);
	$(addBtn).on("click",function(){
		clearCostModal() ;
		// Ajax异步读取用户信息
		// 将异步加载信息填充到模态窗口的组件之中
		$("#costInfo").modal("toggle") ;	// 显示模态窗口
	}) ;
	$("button[id^=remove-]").each(function() {
		$(this).on("click",function(){
			var tcid = this.id.split("-")[1]; 
			var tid = $("#tid").val();
			var price = $("#price-" + tcid).text(); 
			console.log(tcid);
			console.log(tid);
			console.log(price);
			if(window.confirm("确定要删除吗?")) {
				$.post("pages/back/admin/travel/deleteCost.action", {tcid : tcid, tid : tid, price : price}, function (data) {
					operateAlert(data.trim() == "true", "支出项删除成功!", "支出项删除失败!");
					if(data.trim() == "true") {
						$("#travel-" + tcid).remove();
						var oldAllPrice = parseFloat($("#allPrice").text());
						$("#allPrice").text(oldAllPrice - parseFloat(price));
					}
				}) 
			}
		}) ;
	});
	myform = $("#myform").validate({
		debug : true, // 取消表单的提交操作
		submitHandler : function(form) {
			// form.submit(); // 提交表单
			var tpid = $("#tpid").val();
			var tid = $("#tid").val();
			var title = $("#title").val();
			var price = $("#price").val();
			$.post("pages/back/admin/travel/cost_add.action", {tpid:tpid, tid:tid, title:title, price:price}, function(data) {
				var tcid = data.trim();
				operateAlert(tcid != "-1", "支出项追加成功!", "支出项追加失败!") ;
				if(tcid != "-1") {
					var info = 
						"							<tr id='travel-" + tcid + "'>" + 
						"								<td class='text-center'>" + $("#tpid option[value=" + tpid + "]").text() + "</td>" + 
						"								<td class='text-center'>￥<span id='price-" + tcid + "'>" + price + "</span></td>" + 
						"								<td class='text-center'>" + title + "</td>" + 
						"								<td class='text-center'>" + 
						"									<button class='btn btn-danger btn-xs' id='remove-" + tcid + "'>" + 
						"										<span class='glyphicon glyphicon-remove'></span>&nbsp;移除</button>" + 
						"								</td>" + 
						"							</tr>";
					$("tbody").append(info);
					var oldAllPrice = parseFloat($("#allPrice").text());
					$("#allPrice").text(oldAllPrice + parseFloat(price));
				}
			}, "text");
			$("#costInfo").modal("toggle") ;	// 显示模态窗口
		},
		errorPlacement : function(error, element) {
			$("#" + $(element).attr("id").replace(".", "\\.") + "Msg").append(error);
		},
		highlight : function(element, errorClass) {
			$(element).fadeOut(1,function() {
				$(element).fadeIn(1, function() {
					$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-error");
				});

			})
		},
		unhighlight : function(element, errorClass) {
			$(element).fadeOut(1,function() {
				$(element).fadeIn(1,function() {
						$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-success");
				});
			})
		},
		errorClass : "text-danger",
		rules : {
			"title" : {
				required : true,
				//remote : {
//									url : "check.jsp", // 后台处理程序
//									type : "post", // 数据发送方式
//									dataType : "html", // 接受数据格式
//									data : { // 要传递的数据
//										code : function() {
//											return $("#code").val();
//										}
//									},
//									dataFilter : function(data, type) {
//										if (data.trim() == "true")
//											return true;
//										else
//											return false;
//									}
				//}
			},
			"tpid" : {
				required : true
			} ,
			"price" : {
				required : true ,
				number : true
			}
		}
	});
})