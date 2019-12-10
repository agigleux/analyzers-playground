package RIPS_Calendar_2019;

import java.io.*;
import java.nio.file.*;
import javax.servlet.http.*;

public class Day06_Yule_ReadFile extends HttpServlet {
  protected void doPost(HttpServletRequest request,
                        HttpServletResponse response) throws IOException{
    try{
      String url = request.getParameter("url");
      String data = new String(Files.readAllBytes(Paths.get(url))); // TP S2083
    }
    catch (IOException e){
      PrintWriter out = response.getWriter();
      out.print("File not found");
      out.flush();
    }
    //proceed with code
  }
}