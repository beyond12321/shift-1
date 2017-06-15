package cn.mldn.employee.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.api.ITeamService;
import cn.mldn.employee.dao.ITeamDAO;
import cn.mldn.employee.service.abs.AbstractService;
import cn.mldn.vo.Team;
@Service(value = "teamServiceAPI")
public class TeamServiceImpl extends AbstractService implements ITeamService {
	@Resource
	private ITeamDAO teamDAO;
	
	@Override
	public boolean add(Team vo) {
		return this.teamDAO.doCreate(vo);
	}

}
