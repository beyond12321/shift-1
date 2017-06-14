package cn.mldn.employee.dao;

import java.util.List;

import cn.mldn.vo.Team;

public interface ITeamDAO { 
	public List<Team> findAll();
	
	public Team findById(Long id);
}
