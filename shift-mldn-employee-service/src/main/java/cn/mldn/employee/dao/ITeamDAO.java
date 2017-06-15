package cn.mldn.employee.dao;

import java.util.List;

import cn.mldn.util.dao.IBaseDAO;
import cn.mldn.vo.Team;

public interface ITeamDAO extends IBaseDAO<Long, Team>{ 
	public List<Team> findAll();
	
	public Team findById(Long id);
}
