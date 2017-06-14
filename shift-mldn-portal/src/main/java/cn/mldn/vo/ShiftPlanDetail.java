package cn.mldn.vo;

public class ShiftPlanDetail {
    private Long shiftPlanDetailId;

    private Long shiftPlanBaseId;

    private String detailName;

    private String startTime;

    private String endTime;

    private Integer days;

    private Integer excOrder;

    public Long getShiftPlanDetailId() {
        return shiftPlanDetailId;
    }

    public void setShiftPlanDetailId(Long shiftPlanDetailId) {
        this.shiftPlanDetailId = shiftPlanDetailId;
    }

    public Long getShiftPlanBaseId() {
        return shiftPlanBaseId;
    }

    public void setShiftPlanBaseId(Long shiftPlanBaseId) {
        this.shiftPlanBaseId = shiftPlanBaseId;
    }

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName == null ? null : detailName.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getExcOrder() {
        return excOrder;
    }

    public void setExcOrder(Integer excOrder) {
        this.excOrder = excOrder;
    }
}