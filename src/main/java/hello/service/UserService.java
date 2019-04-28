package hello.service;
/**
 * 数据业务层，下面会且切换成远程服务
 */
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.concurrent.atomic.AtomicLong;

import hello.mapper.UserMapper;
import hello.model.User;

@Service
public class UserService{

  @Autowired
  private UserMapper  userMapper;

  private String      errorMessage;

  public String getErrorString() {
    return this.errorMessage;
  }

  public boolean add(String name,String email)
  {
    User u = new User(name,email);
    userMapper.add(u);
    if(u.getId()>0){
      return true;
    }
    else{
      this.errorMessage = "插入数据库失败了";
      return false;
    }
  }

  public List<User> getList() {
    return userMapper.getAll(0);
  }
}
