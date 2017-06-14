package cn.mldn.vo;

public class Action {
    private String actid;

    private String rid;

    private String title;

    public String getActid() {
        return actid;
    }

    public void setActid(String actid) {
        this.actid = actid == null ? null : actid.trim();
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid == null ? null : rid.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
}