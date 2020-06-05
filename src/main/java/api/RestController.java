package api;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dbModel.Host;
import dbModel.Show;
import dbModel.ShowProgress;
import transferModel.ShowData;

@SpringBootApplication
@org.springframework.web.bind.annotation.RestController
public class RestController {
  
    @GetMapping("/test")
    public ShowData getShowData() {
        ShowProgress sp = new ShowProgress("TESTUSER", "TESTSHOW", "TESTSEARCH", 69, 69, "DE",
                new Timestamp(System.currentTimeMillis()));
        Show s = new Show("TESTSEARCH", "bs.to", "ss.to", "fm.to", new Timestamp(System.currentTimeMillis()));
        Host h = new Host("TESTUSER", "TESTSHOW", "TESTHOST");
        ArrayList<Host> list = new ArrayList<Host>();
        list.add(h);
        
        ShowData sd = new ShowData(sp, s, list);
        return sd;
    }

	@GetMapping("/showData")
	public ShowData getShowData(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, @RequestParam(value = "displayed_title") String displayedTitle) {
		ShowProgress sp = new ShowProgress("TESTUSER", "TESTSHOW", "TESTSEARCH", 69, 69, "DE",
				new Timestamp(System.currentTimeMillis()));
		Show s = new Show("TESTSEARCH", "bs.to", "ss.to", "fm.to", new Timestamp(System.currentTimeMillis()));
		Host h = new Host("TESTUSER", "TESTSHOW", "TESTHOST");
		ArrayList<Host> list = new ArrayList<Host>();
		list.add(h);
		
		ShowData sd = new ShowData(sp, s, list);
		return sd;
	}

	@GetMapping("/allShowData")
	public List<ShowData> getAllShowData(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		ShowProgress sp = new ShowProgress("TESTUSER", "TESTSHOW", "TESTSEARCH", 69, 69, "DE",
				new Timestamp(System.currentTimeMillis()));
		Show s = new Show("TESTSEARCH", "bs.to", "ss.to", "fm.to", new Timestamp(System.currentTimeMillis()));
		Host h = new Host("TESTUSER", "TESTSHOW", "TESTHOST");
		ArrayList<Host> list = new ArrayList<Host>();
		list.add(h);
		
		ShowData sd1 = new ShowData(sp, s, list);
		ShowData sd2 = new ShowData(sp, s, list);
		ShowData sd3 = new ShowData(sp, s, list);
		
		ArrayList<ShowData> alist = new ArrayList<ShowData>();
		alist.add(sd1);
		alist.add(sd2);
		alist.add(sd3);
		
		return alist;
	}
	
}
