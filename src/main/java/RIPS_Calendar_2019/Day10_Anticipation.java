package RIPS_Calendar_2019;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Expected Issue: XSS
public final class Day10_Anticipation extends HttpServlet {

    @RequestMapping("/webdav")
    public void webdav(HttpServletResponse res, @RequestParam("name") String name) throws IOException {
        res.setContentType("text/xml");
        res.setCharacterEncoding("UTF-8");
        PrintWriter pw = res.getWriter();
        name = name.replace("]]", "");
        pw.print("<person>");
        pw.print("<name><![CDATA[" + name.replace(" ", "") + "]]></name>");
        pw.print("</person>");
    }

}