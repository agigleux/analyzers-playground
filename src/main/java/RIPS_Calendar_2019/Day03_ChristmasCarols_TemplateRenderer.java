package RIPS_Calendar_2019;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.VelocityContext;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.StringWriter;

// Modified from the original one to be able to compile.
// SonarSecurity doesn't support Veloticy Template Engine
public class Day03_ChristmasCarols_TemplateRenderer {
  private final VelocityEngine velocity = new VelocityEngine();

  public String renderFragment(String fragment, Map<String, Object> contextParameters) {
    velocity.init();
    VelocityContext context = new VelocityContext(contextParameters);
    StringWriter tempWriter = new StringWriter(fragment.length());
    velocity.evaluate(context, tempWriter, "renderFragment", fragment);
    return tempWriter.toString();
  }

  public String render(HttpServletRequest req, HttpServletResponse res) throws IOException {
    Map<String, Object> hm = new HashMap<String, Object>();
    hm.put("user", req.getParameter("user"));
    String template = req.getParameter("temp");
    String rendered = renderFragment(template,hm);
    res.getWriter().println(rendered);
    return rendered;
  }
}