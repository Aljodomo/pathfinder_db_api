package api;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dbModel.Host;
import dbModel.Show;
import dbModel.ShowProgress;
import dbModel.User;
import transferModel.ShowData;

@SpringBootApplication
@org.springframework.web.bind.annotation.RestController
public class RestController {
  public static EntityManagerFactory FACTORY;
  public static EntityManager ENTITY_MANAGER;

  @PreDestroy
  public void destroy() {
    FACTORY.close();
    ENTITY_MANAGER.close();
  }

  @GetMapping("/exampleShowData")
  public ShowData getExampleShowData() {
    User u = new User("TestUser");

    Show s = new Show("TestSearchTitle", "test.com", "test.com", "test.com",
        new Timestamp(System.currentTimeMillis() - 1000000));

    ShowProgress sp = new ShowProgress(u, "TestDisTitle", s, 69, 69, "DE",
        new Timestamp(System.currentTimeMillis()));

    ShowData sd = new ShowData(sp);
    return sd;
  }
  
  @GetMapping("/testDBConnection")
  public User getExampleUser(){
    User u = ENTITY_MANAGER.find(User.class, "aljodomo");
    return u;
  }
  
  /**
   * Returns a basic feature1 String
   * 
   * @return Static text
   */
  @GetMapping("/feature1")
  public String getFeature1(){
    return "Feature1";
  }

  @GetMapping("/showData")
  public ShowData getShowData(@RequestParam(value = "username") String username,
      @RequestParam(value = "displayed_title") String displayedTitle) {
    return null;
  }

  @GetMapping("/allShowData")
  public List<ShowData> getAllShowData(@RequestParam(value = "username") String username) {
    User u = ENTITY_MANAGER.find(User.class, username);
    ArrayList<ShowData> list = new ArrayList<ShowData>();
    for(ShowProgress p : u.getData()) {
      list.add(new ShowData(p));
    }
    return list;
  }

}
