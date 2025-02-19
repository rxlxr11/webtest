package yb.jsptest8.pojo;

import java.util.Objects;

public class Person {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private String rank;
    private String department;

    public Person() {
    }

    public Person(Integer id, String name, String sex, Integer age, String rank, String department) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.rank = rank;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(sex, person.sex) && Objects.equals(age, person.age) && Objects.equals(rank, person.rank) && Objects.equals(department, person.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex, age, rank, department);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", rank='" + rank + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
