package cn.mldn.vo;

import java.util.Date;

public class ShiftTableBase {
    private Long shiftTableBaseId;

    private String tableName;

    private Long shiftPlanBaseId;

    private Date startDate;

    private Date endDate;

    private Long createId;

    private Date createTime;

    private Long lastUpdateUserId;

    private Date updateTime;

    private Integer lastUpdateNo;

    private String serverStationCode;

    private String bizZhyCode;

    private Byte shiftType;

    private Byte state;

    public Long getShiftTableBaseId() {
        return shiftTableBaseId;
    }

    public void setShiftTableBaseId(Long shiftTableBaseId) {
        this.shiftTableBaseId = shiftTableBaseId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public Long getShiftPlanBaseId() {
        return shiftPlanBaseId;
    }

    public void setShiftPlanBaseId(Long shiftPlanBaseId) {
        this.shiftPlanBaseId = shiftPlanBaseId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public Byte getShiftType() {
        return shiftType;
    }

    public void setShiftType(Byte shiftType) {
        this.shiftType = shiftType;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}