package RIPS_Calendar_2019;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

// Expected Issue: Denial of Service (DoS)
// Due to the internals of java.util.StringBuilder, this code can run in OOM
public class Day05_WinterTime_Request {
  public static String toString(HttpServletRequest req) {
    StringBuilder sb = new StringBuilder();
    String delimiter = req.getParameter("delim");
    Enumeration<String> names = req.getParameterNames();
    while (names.hasMoreElements()) {
      String name = names.nextElement();
      if (!name.equals("delim")) {
        sb.append("<b>" + name + "</b>:<br>");
        String[] values = req.getParameterValues(name);
        for (String val : values) {
          sb.append(val);
          sb.append(delimiter);
          sb.append("<br>");
        }
      }
    }

    return sb.toString();
  }
}