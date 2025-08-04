package com.mbathegamer.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  @Value("${spring.application.name}")
  private String appName;

  @Value("${app.page-size}")
  private int pageSize;

  @GetMapping("/")
  public String index() {
    // String viewName = getViewName();
    // we have error here because we don't have "index" as view page
    // return viewName;

    return "index.html";
  }

  // private String getViewName() {
  // return "index";
  // }
}
