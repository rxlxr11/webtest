package yb.mapper;

import org.apache.ibatis.annotations.Param;
import yb.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> queryByNameAndPwd(User user);
}
