package pathfinder2;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.Test;

import dbModel.Host;
import dbModel.Show;
import dbModel.ShowProgress;
import dbModel.User;
import transferModel.ShowData;

public class DBModel_converstion_TransferModelTest {

  @Test
  public void test() {
    try {
      User u = new User("TestUser");

      Show s = new Show("TestSearchTitle", "test.com", "test.com", "test.com",
          new Timestamp(System.currentTimeMillis() - 1000000));

      ShowProgress sp = new ShowProgress(u, "TestDisTitle", s, 69, 69, "DE",
          new Timestamp(System.currentTimeMillis()));

      ShowData sd = new ShowData(sp);
      ShowProgress spn = sd.toShowProgress();

      assertEquals(sp, spn);

      assertEquals((sp.getHosts() == null) ? 0 : sp.getHosts().size(), sd.getHosts(sp).size());

    } catch (Exception e) {
      e.printStackTrace();
      fail();
    }
  }

}
