package com.larseckart.spring.async;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.concurrent.Executor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class Verify03CollaboratorCalledTest {

  @Mock
  Executor executor;
  @Mock
  AnyCollaborator collaborator;

  @InjectMocks
  AnyService service;
  
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
