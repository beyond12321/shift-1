package cn.mldn.api;

import java.util.Map;

import cn.mldn.vo.Emp;

public interface IEmpService {
	/**
	 * 获得小组信息
	 * @return 所有小组信息
	 */
	public Map<String, Object> addpre(); 
	
	/**
	 * 增加雇员
	 * @param vo 雇员VO类
	 * @param flag 是否将其设为组长
	 * @return 增加成功返回true，否则返回false
	 */
	public boolean add(Emp vo, boolean flag); 
	
	/**
	 * 取得一个雇员的信息
	 * @param id 雇员ID
	 * @return Emp传输对象
 	 */ 
	public Emp get(Long id); 
	
	/**
	 * 分页
	 * @param column 模糊查询列
	 * @param keyWord 模糊查询关键字 
	 * @param currentPage 当前页
	 * @param lineSize 每页显示的行数
	 * @return 返回map
	 */
	public Map<String, Object> list(String column, String keyWord, Long currentPage, Integer lineSize);

	/**
	 * 雇员的逻辑删除
	 * @param id 雇员id
	 * @return 删除成功返回true，否则返回false
	 */
	public boolean delete(Long id);
}
