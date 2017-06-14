package cn.mldn.util.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

public class ActionSplitPageUtil {
	@Resource
	private HttpServletRequest request;
	private long currentPage = 1 ; 
	private int lineSize = 5 ;  
	private String column ;
	private String keyWord ; 
	public ActionSplitPageUtil(HttpServletRequest request, String columnData,String url) {
		this.request = request; 
		request.setAttribute("columnData", columnData);
		request.setAttribute("url", url);
		this.handleParameter(); 
	}
	private void handleParameter() {	// 针对于所有的分页参数进行处理
		try {
			this.currentPage = Integer.parseInt(request.getParameter("cp")) ;
		} catch (Exception e) {}	// 分页的参数不正确，就出错
		try {
			this.lineSize = Integer.parseInt(request.getParameter("ls")) ;
		} catch (Exception e) {}
		this.column = request.getParameter("col") ;
		this.keyWord = request.getParameter("kw") ;
		request.setAttribute("currentPage", this.currentPage); 
		request.setAttribute("lineSize", this.lineSize);
		request.setAttribute("column", this.column);
		request.setAttribute("keyWord", this.keyWord);
	}
	public long getCurrentPage() {
		return currentPage;
	}
	public String getColumn() {
		return column;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public int getLineSize() {
		return lineSize;
	}
}
