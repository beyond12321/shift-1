package cn.mldn.shift.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.api.ITeamService;
import cn.mldn.util.action.abs.AbstractBaseAction;
import cn.mldn.vo.Team;
@Controller
@RequestMapping("/pages/back/admin/team/*")
public class TeamAction extends AbstractBaseAction{
	@Resource
	private ITeamService teamService;
	
	@RequestMapping("add") 
	public ModelAndView add(HttpServletRequest request,Team vo){
		ModelAndView mav = new ModelAndView(super.getUrl("team.add.page"));
		if(this.teamService.add(vo)){
			super.setUrlAndMsg(request, "team.add.action", "vo.add.success","小组");
		}else {
			super.setUrlAndMsg(request, "team.add.action", "vo.add.failure","小组");
		}
		return mav; 
	}
}
