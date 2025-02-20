package yb.ajaxtest9.pojo;

import java.util.Date;
import java.util.Objects;

public class ProjectInfo {
    private Integer id;
    private String projectName;
    private Date startDate;
    private Date endDate;
    private Integer status;

    public ProjectInfo() {
    }

    public ProjectInfo(Integer id, String projectName, Date endDate, Date startDate, Integer status) {
        this.id = id;
        this.projectName = projectName;
        this.endDate = endDate;
        this.startDate = startDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectInfo that = (ProjectInfo) o;
        return Objects.equals(id, that.id) && Objects.equals(projectName, that.projectName) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectName, startDate, endDate, status);
    }

    @Override
    public String toString() {
        return "ProjectInfo{" +
                "id=" + id +
                ", prjectName='" + projectName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                '}';
    }
}
