package hello.mapper;
import java.util.List;

import hello.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Options;

public interface UserMapper {
  @Select("select * from test limit #{start},20")
  @Results({
    @Result(property = "id",column = "id"),
    @Result(property = "email",column = "email" ,javaType = String.class),
    @Result(property = "name",column = "name" ,javaType = String.class)
  })
  List<User> getAll(int start);

  @Insert("insert into test(email,name) values(#{email},#{name})")
  @Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
  int add(User user);
}

