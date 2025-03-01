package yb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yb.mapper.UserMapper;
import yb.pojo.User;
import yb.service.IUserService;

import java.util.Collections;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> queryByNameAndPwd(User user) {
        return userMapper.queryByNameAndPwd(user);
    }
}
