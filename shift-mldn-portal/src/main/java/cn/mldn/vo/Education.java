package cn.mldn.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Education implements Serializable {
	private Long eid;
	private String title;

	public Long getEid() {
		return eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
