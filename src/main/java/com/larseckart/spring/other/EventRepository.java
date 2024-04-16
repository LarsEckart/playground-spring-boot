package com.larseckart.spring.other;

import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

  List<Event> findByEventName(String eventName);

  @Modifying
  @Transactional
  void deleteAllByCreatedTimeBefore(LocalDateTime dateTime);

}
