package sap.crun.performance.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import sap.crun.performance.api.controller.TestController;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TestController.class)
@ContextConfiguration(classes = TestController.class)
public class TestsUnitTestController {

  @Autowired
  private MockMvc restTemplate;

  @Test
  public void exampleTest() throws Exception {
//    MvcResult result = this.restTemplate.perform(get("/")).andReturn();
//    String content = result.getResponse().getContentAsString();
//    assertThat(content).startsWith("Hello World");
  }
}