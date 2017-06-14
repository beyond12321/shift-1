package cn.mldn.vo;

public class ShiftTableDetail {
    private Long shiftTableDetailId;

    private Long shiftTableBaseId;

    private Long employeeId;

    private String employeeName;

    private Long teamId;

    private String teamName;

    private String shiftData;

    private Integer dutyDays;

    private Integer shiftOrder;

    public Long getShiftTableDetailId() {
        return shiftTableDetailId;
    }

    public void setShiftTableDetailId(Long shiftTableDetailId) {
        this.shiftTableDetailId = shiftTableDetailId;
    }

    public Long getShiftTableBaseId() {
        return shiftTableBaseId;
    }

    public void setShiftTableBaseId(Long shiftTableBaseId) {
        this.shiftTableBaseId = shiftTableBaseId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName == null ? null : teamName.trim();
    }

    public String getShiftData() {
        return shiftData;
    }

    public void setShiftData(String shiftData) {
        this.shiftData = shiftData == null ? null : shiftData.trim();
    }

    public Integer getDutyDays() {
        return dutyDays;
    }

    public void setDutyDays(Integer dutyDays) {
        this.dutyDays = dutyDays;
    }

    public Integer getShiftOrder() {
        return shiftOrder;
    }

    public void setShiftOrder(Integer shiftOrder) {
        this.shiftOrder = shiftOrder;
    }
}