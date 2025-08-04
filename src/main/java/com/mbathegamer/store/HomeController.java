package com.mbathegamer.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  @GetMapping("/")
  public String index() {
    // String viewName = getViewName();
    // we have error here because we don't have "index" as view page
    // return viewName;

    return "index.html";
  }

  private String getViewName() {
    return "index";
  }
}
