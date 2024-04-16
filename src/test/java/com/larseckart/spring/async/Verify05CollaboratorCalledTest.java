package com.larseckart.spring.async;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;
import org.junit.jupiter.api.Test;

class Verify05CollaboratorCalledTest {

  @Test
  void calls_the_collaborator() {
    AnyCollaborator collaborator = new AnyCollaborator();
    Executor executor = Runnable::run;
    AnyService service = new AnyService(collaborator, executor);

    service.doSomething();

    assertThat(collaborator.hasBeenCalled()).isTrue();
  }
}
