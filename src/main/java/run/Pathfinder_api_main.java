package run;

import javax.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import api.RestController;

public class Pathfinder_api_main {
 
  

  public static void main(String[] args) {
    RestController.FACTORY = Persistence.createEntityManagerFactory("Pathfinder");
    RestController.ENTITY_MANAGER =  RestController.FACTORY.createEntityManager();
    
    SpringApplication.run(RestController.class, args);
  }

//  public static void tryHibernate() throws InterruptedException {
//    EntityManagerFactory fac = Persistence.createEntityManagerFactory("Pathfinder");
//    EntityManager man = fac.createEntityManager();
//
//    User aljo = man.find(User.class, "aljodomo");
//    //
//    // man.getTransaction().begin();
//    // man.persist(aljo);
//    // man.getTransaction().commit();
//
//    Scanner input = new Scanner(System.in);
//
//    System.out.println("Title of new show:");
//    String search = input.nextLine();
//
//    System.out.println("Loading...");
//    Thread.sleep(1000);
//
//    Show newShow = new Show();
//    newShow.setSearchTitle(search);
//    newShow.setBs("www.bs.to");
//
//    System.out.println("Show found and initilized....");
//
//    ShowProgress futu = new ShowProgress();
//    futu.setOwner(aljo.getUsername());
//    futu.setLanguageTag("DE");
//    futu.setSeason(1);
//    futu.setEpisode(0);
//    futu.setDisplayedTitle(search);
//    futu.setShowTitle(search);
//    futu.setTimestamp(new Timestamp(System.currentTimeMillis()));
//
//    man.getTransaction().begin();
//
//    man.persist(newShow);
//    man.persist(futu);
//
//    man.getTransaction().commit();
//
//    man.close();
//    fac.close();
//  }

}
