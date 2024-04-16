package com.larseckart.spring.async;

import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;
import org.springframework.core.task.TaskExecutor;

public class AnySpringService {

  private static final Logger log = getLogger(AnySpringService.class);

  private final AnyCollaborator collaborator;
  private final TaskExecutor taskExecutor;

  public AnySpringService(AnyCollaborator collaborator, TaskExecutor taskExecutor) {
    this.collaborator = collaborator;
    this.taskExecutor = taskExecutor;
  }

  public void doSomething() {
    log.info("Doing something");
    taskExecutor.execute(collaborator::doSomething);
  }
}
