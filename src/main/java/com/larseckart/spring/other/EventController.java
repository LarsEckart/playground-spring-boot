package com.larseckart.spring.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EventController {

  @Value("${mandatory.config.value}")
  String name;

  @Autowired
  EventService service;

  @RequestMapping("/")
  @ResponseBody
  String home() {
    service.saveEvent();
    return "Hello World! " + name;
  }

  @RequestMapping("/delete")
  @ResponseBody
  String delete() {
    service.deleteAllOldEvents();
    return "Hello World! " + name;
  }



}
