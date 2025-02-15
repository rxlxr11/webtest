package yb.jsptest1.dao;

import yb.jsptest1.pojo.BookManage;

import java.util.ArrayList;

public interface IBookManageDao extends IBaseDao{
    ArrayList<BookManage> queryAll();
    Integer deleteById(Integer id);
    Integer addOne(BookManage bookManage);

}
