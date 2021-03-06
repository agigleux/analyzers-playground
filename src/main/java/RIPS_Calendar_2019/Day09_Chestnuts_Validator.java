package RIPS_Calendar_2019;

import java.io.*;
import java.util.regex.*;
import javax.servlet.http.*;

// Expected Issue: ReDoS
public class Day09_Chestnuts_Validator extends HttpServlet {

  protected void doPost(HttpServletRequest request,
                        HttpServletResponse response) throws IOException {
    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");
 
    PrintWriter out = response.getWriter();
    if(isInWhiteList(request.getParameter("whitelist"),request.getParameter("value"))){
      out.print("Value is in whitelist.");
    }
    else{
      out.print("Value is not in whitelist.");
    }
    out.flush();
  }

  public static boolean isInWhiteList(String whitelist, String value){
    Pattern pattern = Pattern.compile("^["+whitelist+"]+"); // TP S2631
    Matcher matcher = pattern.matcher(value);
    return matcher.matches();
  }
}