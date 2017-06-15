package cn.mldn.shift.action;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.csource.common.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.api.IEmpService;
import cn.mldn.fastdfs.FastDFSUploadFile;
import cn.mldn.util.action.abs.AbstractBaseAction;
import cn.mldn.util.web.ActionSplitPageUtil;
import cn.mldn.vo.Emp;

@Controller
@RequestMapping("/pages/back/admin/emp/*")
public class EmpAction extends AbstractBaseAction {
	@Resource
	private IEmpService empService;
	private static final String FLAG = "雇员";

	@RequestMapping("addpre")
	public ModelAndView addpre() {
		ModelAndView mav = new ModelAndView(super.getUrl("emp.addpre.page"));
		mav.addAllObjects(empService.addpre());
		return mav;
	}

	@RequestMapping("add")
	public ModelAndView add(HttpServletRequest request, Emp vo, MultipartFile pic) {
		ModelAndView mav = new ModelAndView(super.getUrl("forward.page"));
		
		try {
			String[] result = FastDFSUploadFile.fileUpload(request, pic);
			String fileName = result[0] + "/" + result[1];
			vo.setAvatar(fileName);
			System.err.println(vo);
			if (empService.add(vo, request.getParameter("flag") != null)) {
				super.setUrlAndMsg(request, "emp.add.action", "vo.add.success", FLAG);
			} else {
				super.setUrlAndMsg(request, "emp.add.action", "vo.add.failure", FLAG);
			} 
		} catch (IOException | MyException e) { 
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getUrl("emp.list.page"));
		ActionSplitPageUtil aspu = new ActionSplitPageUtil(request, "姓名:name|身份证号:id_card|手机号:phone",
				super.getUrl("emp.list.action"));
		Map<String, Object> map = empService.list(aspu.getColumn(), aspu.getKeyWord(), aspu.getCurrentPage(),
				aspu.getLineSize());
		mav.addAllObjects(map);
		return mav;
	}
}