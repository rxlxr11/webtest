package yb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yb.mapper.TypeMapper;
import yb.pojo.Type;
import yb.service.ITypeService;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class TypeServiceImpl implements ITypeService {
    @Autowired
    private TypeMapper typeMapper;
    @Override
    public List<Type> queryAll() {
        return typeMapper.queryAll();
    }

    @Override
    public List<Type> queryByName(String name) {
        return typeMapper.queryByName(name);
    }

    @Override
    public int addType(Type type) {
        return typeMapper.addType(type);
    }
}
