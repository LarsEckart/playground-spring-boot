package com.larseckart.spring.async;

import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;

public class AnyCollaborator {

  private static final Logger log = getLogger(AnyCollaborator.class);

  private boolean hasBeenCalled = false;

  public void doSomething() {
    log.info("Doing something");
    hasBeenCalled = true;
  }

  public boolean hasBeenCalled() {
    return hasBeenCalled;
  }

}
