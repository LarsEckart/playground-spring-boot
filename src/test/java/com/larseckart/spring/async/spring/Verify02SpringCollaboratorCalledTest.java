package com.larseckart.spring.async.spring;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.larseckart.spring.async.AnyCollaborator;
import com.larseckart.spring.async.AnySpringService;
import org.junit.jupiter.api.Test;
import org.springframework.core.task.TaskExecutor;

class Verify02SpringCollaboratorCalledTest {

  @Test
  void calls_the_collaborator() {
    AnyCollaborator collaborator = mock(AnyCollaborator.class);
    TaskExecutor executor = mock(TaskExecutor.class);
    AnySpringService service = new AnySpringService(collaborator, executor);

    doAnswer(invocation -> {
      Runnable task = invocation.getArgument(0);
      task.run();
      return null;
    }).when(executor).execute(any(Runnable.class));

    service.doSomething();

    verify(collaborator).doSomething();
  }

}
