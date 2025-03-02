package yb.mapper;

import yb.pojo.Type;

import java.util.List;

public interface TypeMapper {
    List<Type> queryAll();
    List<Type> queryByName(String name);
    int addType(Type type);
}
