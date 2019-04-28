package hello.model;
import java.io.Serializable;

public class User implements Serializable{
  private int id;
  private String email;
  private String name;

  public User(String name,String email){
    this.email=email;
    this.name=name;
  }
  public String getEmail(){
    return email;
  }

  public String getName(){
    return name;
  }
  public int getId(){
    return this.id;
  }

  @Override
  public String toString(){
    return "userName" + this.name + "'s email is "+this.email;
  }
}
