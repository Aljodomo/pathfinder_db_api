import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dbModel.Show;
import dbModel.ShowProgress;
import dbModel.User;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("Pathfinder");
		EntityManager man = fac.createEntityManager();
		
		User aljo = man.find(User.class, "aljodomo");
//		
//		man.getTransaction().begin();
//		man.persist(aljo);
//		man.getTransaction().commit();
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Title of new show:");
		String search = input.nextLine();
		
		System.out.println("Loading...");
		Thread.sleep(1000);
		
		Show newShow = new Show();
		newShow.setSearchTitle(search);
		newShow.setBs("www.bs.to");
		
		System.out.println("Show found and initilized....");
		
		ShowProgress futu = new ShowProgress();
		futu.setOwner(aljo.getUsername());
		futu.setLanguageTag("DE");
		futu.setSeason(1);
		futu.setEpisode(0);
		futu.setDisplayedTitle(search);
		futu.setShowTitle(search);
		futu.setTimestamp(new Timestamp(System.currentTimeMillis()));
		
		man.getTransaction().begin();
		
		man.persist(newShow);
		man.persist(futu);
		
		man.getTransaction().commit();
		
		man.close();
		fac.close();
	}

}
