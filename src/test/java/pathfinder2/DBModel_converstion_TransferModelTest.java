package pathfinder2;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.Test;

import dbModel.Host;
import dbModel.Show;
import dbModel.ShowProgress;
import transferModel.ShowData;

public class DBModel_converstion_TransferModelTest {

	@Test
	public void test() {
		try {
			ShowProgress sp = new ShowProgress("TESTUSER", "TESTSHOW", "TESTSEARCH", 69, 69, "DE",
					new Timestamp(System.currentTimeMillis()));
			Show s = new Show("TESTSEARCH", "bs.to", "ss.to", "fm.to", new Timestamp(System.currentTimeMillis()));
			Host h = new Host("TESTUSER", "TESTSHOW", "TESTHOST");
			ArrayList<Host> list = new ArrayList<Host>();
			list.add(h);
			
			ShowData sd = new ShowData(sp, s, list);
			
			if(!sp.exactEqual(sd.toShowProgress())) {
				fail();
			}
			if(!s.exactEqual(sd.toShow())) {
				fail();
			}
			if(!h.exactEqual(sd.toHosts().get(0))) {
				fail();
			}
			

		} catch (Exception e) {
			fail();
		}
	}

}
