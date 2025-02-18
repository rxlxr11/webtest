package yb.jsptest6.pojo;

import java.util.Objects;

public class MembersInfo {
    private Integer id;
    private String mName;
    private String mGender;
    private Integer mAge;
    private String mAddress;
    private String mEmail;

    public MembersInfo() {
    }

    public MembersInfo(Integer id, String mName, String mGender, Integer mAge, String mAddress, String mEmail) {
        this.id = id;
        this.mName = mName;
        this.mGender = mGender;
        this.mAge = mAge;
        this.mAddress = mAddress;
        this.mEmail = mEmail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmGender() {
        return mGender;
    }

    public void setmGender(String mGender) {
        this.mGender = mGender;
    }

    public Integer getmAge() {
        return mAge;
    }

    public void setmAge(Integer mAge) {
        this.mAge = mAge;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MembersInfo that = (MembersInfo) o;
        return Objects.equals(id, that.id) && Objects.equals(mName, that.mName) && Objects.equals(mGender, that.mGender) && Objects.equals(mAge, that.mAge) && Objects.equals(mAddress, that.mAddress) && Objects.equals(mEmail, that.mEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mName, mGender, mAge, mAddress, mEmail);
    }

    @Override
    public String toString() {
        return "MembersInfo{" +
                "id=" + id +
                ", mName='" + mName + '\'' +
                ", mGender='" + mGender + '\'' +
                ", mAge=" + mAge +
                ", mAddress='" + mAddress + '\'' +
                ", mEmail='" + mEmail + '\'' +
                '}';
    }
}
