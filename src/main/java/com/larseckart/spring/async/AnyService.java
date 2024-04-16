package com.larseckart.spring.async;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.concurrent.Executor;
import org.slf4j.Logger;

public class AnyService {

  private static final Logger log = getLogger(AnyService.class);

  private final AnyCollaborator collaborator;
  private final Executor executor;

  public AnyService(AnyCollaborator collaborator, Executor executor) {
    this.collaborator = collaborator;
    this.executor = executor;
  }

  public void doSomething() {
    log.info("Doing something");
    executor.execute(collaborator::doSomething);
  }
}
