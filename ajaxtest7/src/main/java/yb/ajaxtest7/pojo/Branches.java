package yb.ajaxtest7.pojo;

import java.util.Objects;

public class Branches {
    private Integer id;
    private String businessNo;
    private String name;
    private String cityArea;
    private String address;
    private String branchTelephone;
    private String branchSummary;

    public Branches() {
    }


    public Branches(Integer id, String businessNo, String name, String cityArea, String address, String branchTelephone, String branchSummary) {
        this.id = id;
        this.businessNo = businessNo;
        this.name = name;
        this.cityArea = cityArea;
        this.address = address;
        this.branchTelephone = branchTelephone;
        this.branchSummary = branchSummary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityArea() {
        return cityArea;
    }

    public void setCityArea(String cityArea) {
        this.cityArea = cityArea;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBranchTelephone() {
        return branchTelephone;
    }

    public void setBranchTelephone(String branchTelephone) {
        this.branchTelephone = branchTelephone;
    }

    public String getBranchSummary() {
        return branchSummary;
    }

    public void setBranchSummary(String branchSummary) {
        this.branchSummary = branchSummary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Branches branches = (Branches) o;
        return Objects.equals(id, branches.id) && Objects.equals(businessNo, branches.businessNo) && Objects.equals(name, branches.name) && Objects.equals(cityArea, branches.cityArea) && Objects.equals(address, branches.address) && Objects.equals(branchTelephone, branches.branchTelephone) && Objects.equals(branchSummary, branches.branchSummary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, businessNo, name, cityArea, address, branchTelephone, branchSummary);
    }

    @Override
    public String toString() {
        return "Branches{" +
                "id=" + id +
                ", businessNo='" + businessNo + '\'' +
                ", name='" + name + '\'' +
                ", cityArea='" + cityArea + '\'' +
                ", address='" + address + '\'' +
                ", branchTelephone='" + branchTelephone + '\'' +
                ", branchSummary='" + branchSummary + '\'' +
                '}';
    }
}
