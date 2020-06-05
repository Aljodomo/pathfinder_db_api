package pathfinder2;

import static org.junit.Assert.*;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import dbModel.Show;

public class TestHibernateConnection {

	@Test
	public void testIni() {
		try {
			EntityManagerFactory fac = Persistence.createEntityManagerFactory("Pathfinder");
			EntityManager man = fac.createEntityManager();
			man.close();
			fac.close();
		}catch(Exception e) {
			e.printStackTrace();
			fail("Hibernate");
		}
	}
	
	@Test
	public void testAddShow() {
		try {
			EntityManagerFactory fac = Persistence.createEntityManagerFactory("Pathfinder");
			EntityManager man = fac.createEntityManager();
			
			Show s = new Show();
			s.setSearchTitle("TestCaseHibernateAddShow");
			s.setBs("TEST");
			s.setFm("TEST");
			s.setSs("TEST");
			s.setTimestamp(new Timestamp(System.currentTimeMillis()));
			
			man.getTransaction().begin();
			man.persist(s);
			
			Show sn = man.find(Show.class, "TestCaseHibernateAddShow");
			if(sn == null) {
				fail("HibernateAddShow");
			}
			
			man.getTransaction().rollback();
			man.close();
			fac.close();
		}catch(Exception e) {
			e.printStackTrace();
			fail("HibernateAddShow");
		}
	}
	
}
