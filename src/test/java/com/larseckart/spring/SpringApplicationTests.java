package com.larseckart.spring;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.core.env.Environment;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class SpringApplicationTests {

  @ServiceConnection
  static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
      DockerImageName.parse("postgres:latest"))
      .withUsername("postgres")
      .withPassword("postgres");

  @Autowired
  private Environment env;

  @BeforeAll
  static void setup() {
    postgres.start();
  }

  @Test
  void contextLoads() {
  }

  @Test
  void exposes_health_endpoint_due_to_micronaut_management_dependency() {
    int port = Integer.parseInt(env.getProperty("local.server.port"));

    given()
        .port(port)
        .when()
        .get("/actuator/health")
        .then()
        .statusCode(200);
  }
}
