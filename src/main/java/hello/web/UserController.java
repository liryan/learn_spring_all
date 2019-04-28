package hello.web;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpServletRequest;

import hello.model.JsonRe;
import hello.model.User;
import hello.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController{

  @Autowired
  private UserService userSrv;  //may be call by gRPC

  @RequestMapping("/")
  public List<User> getUsers() {
    return this.userSrv.getList();
  }

  @RequestMapping("/add")
  public JsonRe addUser(HttpServletRequest request) {
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    if(this.userSrv.add(name,email)){
      return new JsonRe(200,"");
    }
    return new JsonRe(500,this.userSrv.getErrorString());
  }
}
