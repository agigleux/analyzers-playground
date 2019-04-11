package S4719;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class S4719_ExpectedIssue {

  public void issue() {
    String string = "ExpectedIssue";
    try {
      byte[] bytes = string.getBytes("UTF-8"); // Noncompliant; use a String instead of StandardCharsets.UTF_8
    } catch (UnsupportedEncodingException e) {
      throw new AssertionError(e);
    }
  }

  public void noIssue() {
    String string = "ExpectedIssue";
    string.getBytes(StandardCharsets.UTF_8); // Compliant
  }

}
