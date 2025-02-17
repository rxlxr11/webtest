package yb.ajaxtest5.pojo;

import java.util.Date;
import java.util.Objects;

public class Pet {
    private Integer petId;
    private String petName;
    private String petBreed;
    private String petSex;
    private Date birthday;
    private String desc;

    public Pet() {
    }

    public Pet(Integer petId, String petName, String petBreed, String petSex, Date birthday, String desc) {
        this.petId = petId;
        this.petName = petName;
        this.petBreed = petBreed;
        this.petSex = petSex;
        this.birthday = birthday;
        this.desc = desc;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetSex() {
        return petSex;
    }

    public void setPetSex(String petSex) {
        this.petSex = petSex;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(petId, pet.petId) && Objects.equals(petName, pet.petName) && Objects.equals(petBreed, pet.petBreed) && Objects.equals(petSex, pet.petSex) && Objects.equals(birthday, pet.birthday) && Objects.equals(desc, pet.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(petId, petName, petBreed, petSex, birthday, desc);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", petName='" + petName + '\'' +
                ", petBreed='" + petBreed + '\'' +
                ", petSex='" + petSex + '\'' +
                ", birthday=" + birthday +
                ", desc='" + desc + '\'' +
                '}';
    }
}
