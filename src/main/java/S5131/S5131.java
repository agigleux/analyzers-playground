package S5131;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class S5131 {

    public void doGetNotSafeToXSS(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String out = request.getParameter("out");

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();

        pw.println("<html>");
        pw.println("<head><title>Hello World</title></title>");
        pw.println("<body>");
        pw.println("<h1>" + out + "</h1>");
        pw.println("</body></html>");
    }

    public void doGetSafeJSON(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String out = request.getParameter("out");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");        
        PrintWriter pw = response.getWriter();

        pw.println("{ 'data' : " + out + "}");
    }

    public void doGetSafeXML(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String out = request.getParameter("out");

        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();

        pw.println("<data>" + out + "</data>");
    }

}
