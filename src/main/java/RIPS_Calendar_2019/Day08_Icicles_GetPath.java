package RIPS_Calendar_2019;

import java.io.File;

import javax.servlet.http.*;
import java.io.*;

public class Day08_Icicles_GetPath extends HttpServlet {
 
  protected void doGet(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {
    try{
      String icons = request.getParameter("icons");
      String filename = request.getParameter("filename");
 
      File f_icons = new File(icons);
      File f_filename = new File(filename);
 
      if(!icons.equals(f_icons.getName())){
        throw new Exception("File not within target directory!");
      }

      if(!filename.equals(f_filename.getName())){
        throw new Exception("File not within target directory!");
      }

      String toDir = "/var/myapp/data/"+f_icons.getName()+"/";
      File file = new File(toDir, filename);
      file.setExecutable(true); // TP SS2083

      FileReader reader = new FileReader(file);
      reader.read(); // TP SS2083
      reader.close();
    }
    catch(Exception e){
      response.sendRedirect("/");
    }
  }
}