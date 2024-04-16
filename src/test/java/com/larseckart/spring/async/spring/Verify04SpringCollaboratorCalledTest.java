package com.larseckart.spring.async.spring;

import static org.assertj.core.api.Assertions.assertThat;

import com.larseckart.spring.async.AnyCollaborator;
import com.larseckart.spring.async.AnySpringService;
import org.junit.jupiter.api.Test;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

class Verify04SpringCollaboratorCalledTest {

  @Test
  void calls_the_collaborator() {
    AnyCollaborator collaborator = new AnyCollaborator();
    TaskExecutor executor = new SyncTaskExecutor();
    AnySpringService service = new AnySpringService(collaborator, executor);

    service.doSomething();

    assertThat(collaborator.hasBeenCalled()).isTrue();
  }
}
