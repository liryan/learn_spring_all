package hello;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("hello.mapper")
public class Application extends SpringBootServletInitializer {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(Application.class);
  }
}
