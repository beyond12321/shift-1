package cn.mldn.employee.dao;

import java.util.List;
import java.util.Map;

import cn.mldn.vo.Emp; 

public interface IEmpDAO { 
	public boolean doCreate(Emp vo);
	
	public Emp findById(Long id);
	
	public List<Emp> findAllSplit(Map<String, Object> params);
	
	public Long getAllCount(Map<String, Object> params);
	
	public boolean doUpdateByDelete(Long id);
}
