package yb.ajaxtest2.pojo;

import java.util.Objects;

public class StudentInfo {
    private Integer sId;
    private String sName;
    private String sGender;
    private Integer sAge;
    private String sAddress;
    private String sEmail;

    public StudentInfo() {
    }

    public StudentInfo(Integer sId, String sName, String sGender, Integer sAge, String sAddress, String sEmail) {
        this.sId = sId;
        this.sName = sName;
        this.sGender = sGender;
        this.sAge = sAge;
        this.sAddress = sAddress;
        this.sEmail = sEmail;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsGender() {
        return sGender;
    }

    public void setsGender(String sGender) {
        this.sGender = sGender;
    }

    public Integer getsAge() {
        return sAge;
    }

    public void setsAge(Integer sAge) {
        this.sAge = sAge;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentInfo that = (StudentInfo) o;
        return Objects.equals(sId, that.sId) && Objects.equals(sName, that.sName) && Objects.equals(sGender, that.sGender) && Objects.equals(sAge, that.sAge) && Objects.equals(sAddress, that.sAddress) && Objects.equals(sEmail, that.sEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sId, sName, sGender, sAge, sAddress, sEmail);
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", sGender='" + sGender + '\'' +
                ", sAge=" + sAge +
                ", sAddress='" + sAddress + '\'' +
                ", sEmail='" + sEmail + '\'' +
                '}';
    }
}
