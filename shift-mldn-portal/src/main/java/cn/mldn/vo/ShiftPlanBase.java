package cn.mldn.vo;

import java.util.Date;

public class ShiftPlanBase {
    private Long shiftPlanBaseId;

    private String planName;

    private String planDescription;

    private Long createId;

    private Date createTime;

    private Long lastUpdateUserId;

    private Date updateTime;

    private Integer lastUpdateNo;

    private String serverStationCode;

    private String bizZhyCode;

    private Byte state;

    public Long getShiftPlanBaseId() {
        return shiftPlanBaseId;
    }

    public void setShiftPlanBaseId(Long shiftPlanBaseId) {
        this.shiftPlanBaseId = shiftPlanBaseId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription == null ? null : planDescription.trim();
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(Long lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getLastUpdateNo() {
        return lastUpdateNo;
    }

    public void setLastUpdateNo(Integer lastUpdateNo) {
        this.lastUpdateNo = lastUpdateNo;
    }

    public String getServerStationCode() {
        return serverStationCode;
    }

    public void setServerStationCode(String serverStationCode) {
        this.serverStationCode = serverStationCode == null ? null : serverStationCode.trim();
    }

    public String getBizZhyCode() {
        return bizZhyCode;
    }

    public void setBizZhyCode(String bizZhyCode) {
        this.bizZhyCode = bizZhyCode == null ? null : bizZhyCode.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}