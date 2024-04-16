package com.larseckart.spring.async;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.Test;

class Verify04CollaboratorCalledTest {

  @Test
  void calls_the_collaborator() {
    AnyCollaborator collaborator = new AnyCollaborator();
    Executor executor = MoreExecutors.directExecutor();
    AnyService service = new AnyService(collaborator, executor);

    service.doSomething();

    assertThat(collaborator.hasBeenCalled()).isTrue();
  }
}
