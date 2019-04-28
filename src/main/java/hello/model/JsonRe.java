package hello.model;
import java.io.Serializable;

public class JsonRe implements Serializable{
  public int code;
  public String message;
  public JsonRe(int code,String msg){
    this.code = code;
    this.message = msg;
  }

  @Override
  public String toString(){
    return String.format("[%d]:%s",this.code,this.message);
  }
}
