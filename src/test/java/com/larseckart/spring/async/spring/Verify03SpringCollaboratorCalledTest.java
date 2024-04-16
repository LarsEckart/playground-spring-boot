package com.larseckart.spring.async.spring;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

import com.larseckart.spring.async.AnyCollaborator;
import com.larseckart.spring.async.AnySpringService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.task.TaskExecutor;

@ExtendWith(MockitoExtension.class)
class Verify03SpringCollaboratorCalledTest {

  @Mock
  AnyCollaborator collaborator;
  @Mock
  TaskExecutor executor;

  @InjectMocks
  AnySpringService service;

  @Test
  void calls_the_collaborator() {
    doAnswer(invocation -> {
      Runnable task = invocation.getArgument(0);
      task.run();
      return null;
    }).when(executor).execute(any(Runnable.class));

    service.doSomething();

    verify(collaborator).doSomething();
  }
}
