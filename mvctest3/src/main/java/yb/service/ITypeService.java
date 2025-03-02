package yb.service;

import yb.pojo.Type;

import java.util.List;

public interface ITypeService {
    List<Type> queryAll();
    List<Type> queryByName(String name);
    int addType(Type type);
}
