$(function(){
	$("span[id^=showBtn-]").each(function(){
		$(this).on("click",function(){
			tid = this.id.split("-")[1] ;
			console.log("差旅编号：" + tid) ;
			$.post("pages/back/admin/travel/list_emp_travel.action", {tid:tid}, function(data) {
				$("#travel_emp").empty();
				for(i = 0; i < data.allEmps.length; i++) {
					var info = 
						"							<tr>" + 
						"								<td class='text-center'>" + 
						"									<img src='upload/member/" + data.allEmps[i].a.photo + "' style='width:20px;'/> " + 
						"								</td>" + 
						"								<td class='text-center'><span id='eid-" + data.allEmps[i].a.eid + "' style='cursor:pointer;'>" + data.allEmps[i].a.ename +"</span></td>" + 
						"								<td class='text-center'>" + data.allEmps[i].a.phone + "</td>" + 
						"								<td class='text-center'>" + data.allEmps[i].b +"</td>" + 
						"								<td class='text-center'>" + data.allEmps[i].c + "</td>" + 
						"							</tr> ";
					$("#travel_emp").append(info);
				}
			}, "json")
			$("#travelEmpInfo").modal("toggle") ;
		}) ;
	}) ;
})