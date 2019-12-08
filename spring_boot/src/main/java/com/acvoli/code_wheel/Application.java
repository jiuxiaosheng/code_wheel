package com.acvoli.code_wheel;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Application {
  public static void main(String[] args) {
    List list = new ArrayList();
    Set<String> set = new LinkedHashSet<>();
    SpringApplication.run(Application.class, args);
  }
}
