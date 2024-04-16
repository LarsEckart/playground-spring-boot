package com.larseckart.spring.async;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class Verify01CollaboratorCalledTest {

  @Disabled
  @Test
  void calls_the_collaborator() {
    AnyCollaborator collaborator = new AnyCollaborator();
    Executor executor = Executors.newFixedThreadPool(5);
    AnyService service = new AnyService(collaborator, executor);

    service.doSomething();

    assertTrue(collaborator.hasBeenCalled());
  }

}
