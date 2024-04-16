package com.larseckart.spring.async.spring;

import static org.assertj.core.api.Assertions.assertThat;

import com.larseckart.spring.async.AnyCollaborator;
import com.larseckart.spring.async.AnySpringService;
import org.junit.jupiter.api.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

class Verify01SpringCollaboratorCalledTest {

  @Test
  void calls_the_collaborator() {
    AnyCollaborator collaborator = new AnyCollaborator();
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.initialize();
    AnySpringService service = new AnySpringService(collaborator, executor);

    service.doSomething();

    assertThat(collaborator.hasBeenCalled()).isTrue();
  }
}
