package yb.jsptest8.dao;

import yb.jsptest8.pojo.Person;

import java.util.ArrayList;

public interface IPersonDao extends IBaseDao {
    ArrayList<Person> queryAll();
    Integer addOne(Person person);
    Integer deleteById(Integer id);


}
