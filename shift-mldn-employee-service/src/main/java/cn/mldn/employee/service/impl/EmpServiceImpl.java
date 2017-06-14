package cn.mldn.employee.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.api.IEmpService;
import cn.mldn.employee.dao.IEmpDAO;
import cn.mldn.employee.dao.ITeamDAO;
import cn.mldn.employee.service.abs.AbstractService;
import cn.mldn.vo.Emp;
import cn.mldn.vo.Team;

@Service(value="empServiceAPI") 
public class EmpServiceImpl extends AbstractService implements IEmpService {
	@Resource
	private ITeamDAO teamDAO;
	@Resource
	private IEmpDAO empDAO;

	@Override
	public Map<String, Object> addpre() {
		Map<String, Object> map = new HashMap<>();
		map.put("allTeams", teamDAO.findAll()); 
		return map; 
	}

	@Override
	public Emp get(Long id) {
		return empDAO.findById(id); 
	}

	@Override
	public boolean add(Emp vo, boolean flag) {
		if(flag) {
			if(teamDAO.findById(vo.getTeamId()).getLeaderId() != null) {
				return false;
			}
		}
		return empDAO.doCreate(vo);
	}

	@Override
	public Map<String, Object> list(String column, String keyWord, Long currentPage, Integer lineSize) {
		Map<String, Object> params = new HashMap<>();
		params.put("column", "".equals(column)? null: column);
		params.put("keyWord", "".equals(keyWord)? null: "%" + keyWord + "%");
		params.put("start", (currentPage - 1) * lineSize);
		params.put("lineSize", lineSize);
		
		Map<Long, String> teams = new HashMap<>();
		for(Team team : teamDAO.findAll()) {
			teams.put(team.getTeamId(), team.getName());
		}
		
		Map<String, Object> result = new HashMap<>();
		result.put("allRecorders", empDAO.getAllCount(params));
		result.put("allEmps", empDAO.findAllSplit(params));
		result.put("allTeams", teams); 
		return result;
	}

	@Override
	public boolean delete(Long id) {
		return empDAO.doUpdateByDelete(id);
	}
}
