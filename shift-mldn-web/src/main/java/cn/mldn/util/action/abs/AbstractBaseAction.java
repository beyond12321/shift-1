package cn.mldn.util.action.abs;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public abstract class AbstractBaseAction {
	@Resource
	private MessageSource messageSource;

	public void setUrlAndMsg(HttpServletRequest request, String urlKey, String msgKey, Object... arg) {
		request.setAttribute("msg", this.getMsg(msgKey, arg));
		request.setAttribute("url", this.getMsg(urlKey));
	}
	
	public void setUrlAndMsg(HttpServletRequest request, String urlKey, Exception e) {
		request.setAttribute("msg", e.getMessage());
		request.setAttribute("url", this.getMsg(urlKey));
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(java.util.Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	public void print(HttpServletResponse response, Object val) {
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().print(val);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getUrl(String key) {
		return this.getMsg(key);
	}

	public String getMsg(String key, Object... args) {
		try {
			return this.messageSource.getMessage(key, args, null);
		} catch (Exception e) {
			return null;
		}
	} 
	
	public String getEid(HttpServletRequest request) {
		return (String)request.getSession().getAttribute("ineid");
	}
}
