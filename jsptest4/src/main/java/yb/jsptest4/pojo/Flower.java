package yb.jsptest4.pojo;

import java.util.Objects;

public class Flower {
    private Integer id;
    private String name;
    private String nickName;
    private String property;
    private Float price;
    private String production;

    public Flower() {
    }

    public Flower(Integer id, String name, String nickName, String property, Float price, String production) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
        this.property = property;
        this.price = price;
        this.production = production;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return Objects.equals(id, flower.id) && Objects.equals(name, flower.name) && Objects.equals(nickName, flower.nickName) && Objects.equals(property, flower.property) && Objects.equals(price, flower.price) && Objects.equals(production, flower.production);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nickName, property, price, production);
    }

    @Override
    public String toString() {
        return "Flower{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", property='" + property + '\'' +
                ", price=" + price +
                ", production='" + production + '\'' +
                '}';
    }
}
