package com.larseckart.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.larseckart.spring.other.EventService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@WebMvcTest
@DisabledInAotMode // because https://stackoverflow.com/questions/77586355/after-upgrade-to-spring-boot-3-2-aot-failure-code-generation-does-not-support
public class ControllerTests {

  @MockBean
  EventService eventService;

  @Autowired MockMvc mockMvc;

  @Test
  void home() throws Exception {
    MvcResult result =
        this.mockMvc
            .perform(get("/"))
            //            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();

    String content = result.getResponse().getContentAsString();
    assertThat(content).isEqualTo("Hello Lars!");
  }
}
