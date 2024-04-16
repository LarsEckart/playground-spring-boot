package com.larseckart.spring;

import com.larseckart.spring.other.Event;
import com.larseckart.spring.other.EventRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.IntStream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class TestApplication {

  public static void main(String[] args) {
    SpringApplication.from(Application::main)
        .with(TestApplication.class)
        .run(args);
  }

  @Bean
  @ServiceConnection
  PostgreSQLContainer<?> postgresContainer() {
    return new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"))
        .withUsername("postgres")
        .withPassword("postgres");
  }

  @Bean
  public CommandLineRunner demo2(EventRepository repository) {
    return (args) -> {

      LocalDate now = LocalDate.now();

      var days = IntStream.iterate(1, i -> i + 1)
          .limit(100)
          .mapToObj(i -> new Event("any", now.minusDays(i).atStartOfDay()))
          .toList();

      repository.saveAll(days);

      repository.deleteAllByCreatedTimeBefore(LocalDateTime.now());
    };
  }

}
