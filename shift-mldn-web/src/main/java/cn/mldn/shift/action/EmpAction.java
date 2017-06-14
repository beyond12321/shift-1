package cn.mldn.shift.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.api.IEmpService;
import cn.mldn.util.action.abs.AbstractBaseAction;
import cn.mldn.util.web.ActionSplitPageUtil;

@Controller
@RequestMapping("/pages/back/admin/emp/*")
public class EmpAction extends AbstractBaseAction {
	@Resource
	private IEmpService empService;

	@RequestMapping("addpre") 
	private ModelAndView addpre() {
		ModelAndView mav = new ModelAndView(super.getUrl("emp.addpre.page"));
		mav.addAllObjects(empService.addpre());
		return mav;
	}
	
	@RequestMapping("list")
	private ModelAndView list(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getUrl("emp.list.page")); 
		ActionSplitPageUtil aspu = new ActionSplitPageUtil(request, "姓名:name|身份证号:idCard|手机号:phone", super.getUrl("emp.list.action"));
		Map<String, Object> map = empService.list(aspu.getColumn(), aspu.getKeyWord(), aspu.getCurrentPage(), aspu.getLineSize());
		mav.addAllObjects(map);
		return mav;
	}
}