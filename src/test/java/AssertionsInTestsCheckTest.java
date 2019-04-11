
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AssertionsInTestsCheckTest {

  @Autowired
  WebApplicationContext wac;

  private MockMvc mockMvc;

  @Before
  public void setup() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
  }

  @Test
  public void testWithNoAssertion1() { // Noncompliant
  }
  
  @Test
  void myTest1() throws Exception { // Compliant
    mockMvc.perform(MockMvcRequestBuilders.get("/api/**"))
      .andExpect(status().isForbidden())
      .andReturn();
  }

  @Test
  void myTest2() throws Exception { // Compliant
    mockMvc.perform(MockMvcRequestBuilders.get("/api/**"))
      .andExpect(status().isOk())
      .andExpect(content().xml("foo"))
      .andExpect(content().string("foo"))
      .andExpect(forwardedUrl("/WEB-INF/layouts/main.jsp"))
      .andReturn();
  }

}
