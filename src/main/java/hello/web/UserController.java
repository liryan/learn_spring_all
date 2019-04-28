package hello.web;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpServletRequest;

import hello.mapper.UserMapper;
import hello.model.User;
import hello.model.JsonRe;

@RestController
@RequestMapping("/user")
public class UserController{
  private final AtomicLong counter = new AtomicLong();
  @Autowired
  private UserMapper userMapper;

  @RequestMapping("/")
  public List<User> getUsers() {
    List<User> users = userMapper.getAll(0);
    return users;
  }
  @RequestMapping("/add")
  public JsonRe addUser(HttpServletRequest request) {
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    User u = new User(name,email);
    int newId = userMapper.add(u);
    return new JsonRe(u.getId(),"");
  }
}
