package com.larseckart.spring.other;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

  @Autowired
  private EventRepository repository;

  public void saveEvent() {
    repository.save(new Event("Hello World!", LocalDateTime.now()));
  }

  public void deleteAllOldEvents() {
    repository.deleteAllByCreatedTimeBefore(LocalDateTime.now());
  }

}
