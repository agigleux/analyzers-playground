package findsecbugs.SPRING_ENDPOINT;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringEndPoint {

  @RequestMapping(path = "/profile", method = RequestMethod.GET) // Noncompliant
  public void getUserProfile(String name) {
  }

}
