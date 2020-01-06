package RIPS_Calendar_2019;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Day16_Candle_FindController {
  public String escapeQuotes(String in) {
    return in.replaceAll("'", "''");
  }

  @RequestMapping("/findUsers")
  public void findUsers(@RequestParam(name = "name") String name, HttpServletResponse res) throws IOException {
    Configuration config = new Configuration();
    // Create SessionFactory with MySQL driver
    SessionFactory sessionFactory = config.configure().buildSessionFactory();
    Session session = sessionFactory.openSession();
    List<Day16_Candle_UserEntity> users = session
        .createQuery("from Day16_Candle_UserEntity where FIRST_NAME ='" + escapeQuotes(name) + "'")
        .list();
    res.getWriter().println("Found " + users.size() + " Users with that name");
  }
}