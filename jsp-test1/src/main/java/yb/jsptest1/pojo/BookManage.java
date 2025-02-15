package yb.jsptest1.pojo;

import yb.jsptest1.utils.DateFormatUtil;

import java.util.Date;
import java.util.Objects;

public class BookManage {
    private Integer id;
    private String name;
    private String author;
    private Date time;
    private Integer type;

    public BookManage() {
    }

    public BookManage(Integer id, String name, String author, Date time, Integer type) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.time = time;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookManage that = (BookManage) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(author, that.author) && Objects.equals(time, that.time) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, time, type);
    }

    @Override
    public String toString() {
        return "BookManage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", time=" + time +
                ", type=" + type +
                '}';
    }
}
