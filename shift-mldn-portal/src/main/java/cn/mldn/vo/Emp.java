package cn.mldn.vo;

import java.io.Serializable;
import java.util.Date;

public class Emp implements Serializable{
    private Long id;

    private String name;

    private String avatar;

    private Boolean sex;

    private String phone;

    private String idCard;

    private Date birthday;

    private Date hireDate;

    private Date dimissionDate;

    private String educationDegree;

    private Long createId;

    private String lastUpdateUserId;

    private Date createTime;

    private Date updateTime;

    private Long teamId;

    private Integer lastUpdateNo;

    private Boolean state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getDimissionDate() {
        return dimissionDate;
    }

    public void setDimissionDate(Date dimissionDate) {
        this.dimissionDate = dimissionDate;
    }

    public String getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(String educationDegree) {
        this.educationDegree = educationDegree == null ? null : educationDegree.trim();
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public String getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(String lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId == null ? null : lastUpdateUserId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Integer getLastUpdateNo() {
        return lastUpdateNo;
    }

    public void setLastUpdateNo(Integer lastUpdateNo) {
        this.lastUpdateNo = lastUpdateNo;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", avatar=" + avatar + ", sex=" + sex + ", phone=" + phone
				+ ", idCard=" + idCard + ", birthday=" + birthday + ", hireDate=" + hireDate + ", dimissionDate="
				+ dimissionDate + ", educationDegree=" + educationDegree + ", createId=" + createId
				+ ", lastUpdateUserId=" + lastUpdateUserId + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", teamId=" + teamId + ", lastUpdateNo=" + lastUpdateNo + ", state=" + state + "]";
	}
}