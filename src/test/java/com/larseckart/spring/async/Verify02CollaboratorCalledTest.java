package com.larseckart.spring.async;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.concurrent.Executor;
import org.junit.jupiter.api.Test;

class Verify02CollaboratorCalledTest {

  @Test
  void calls_the_collaborator() {
    AnyCollaborator collaborator = mock(AnyCollaborator.class);
    Executor executor = mock(Executor.class);
    AnyService service = new AnyService(collaborator, executor);

    doAnswer(invocation -> {
      Runnable task = invocation.getArgument(0);
      task.run();
      return null;
    }).when(executor).execute(any(Runnable.class));

    service.doSomething();

    verify(collaborator).doSomething();
  }

}
