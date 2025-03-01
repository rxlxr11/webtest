package yb.service;

import yb.pojo.User;

import java.util.List;

public interface IUserService {
    List<User> queryByNameAndPwd(User user);
}
