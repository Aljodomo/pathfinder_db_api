package transferModel;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.mapping.Set;
import dbModel.Host;
import dbModel.Show;
import dbModel.ShowProgress;
import dbModel.User;

public class ShowData {
  public static SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  private final String username;
  private final String displayedTitle;
  private final String searchTitle;
  private final String bsURL;
  private final String ssURL;
  private final String fmURL;
  private final Timestamp URLCreationTimestamp;
  private final int season;
  private final int episode;
  private final String languageTag;
  private final Timestamp lastUseTimestamp;
  private final List<String> favoriteHosts;

  public ShowData(ShowProgress showProgress) {
    this.username = showProgress.getOwner().getUsername();
    this.displayedTitle = showProgress.getDisplayedTitle();
    this.searchTitle = showProgress.getShow().getSearchTitle();
    this.bsURL = showProgress.getShow().getBs();
    this.ssURL = showProgress.getShow().getSs();
    this.fmURL = showProgress.getShow().getFm();
    this.URLCreationTimestamp = showProgress.getShow().getTimestamp();
    this.season = showProgress.getSeason();
    this.episode = showProgress.getEpisode();
    this.languageTag = showProgress.getLanguageTag();
    this.lastUseTimestamp = showProgress.getTimestamp();
    this.favoriteHosts = new ArrayList<String>();
    if(showProgress.getHosts() != null) {
      for (Host h : showProgress.getHosts()) {
        this.favoriteHosts.add(h.getHostName());
      }
    }
  }

  public ShowData(String username, String displayedTitle, String searchTitle, String bsURL,
      String ssURL, String fmURL, Timestamp URLCreationTimestamp, int season, int episode,
      String languageTag, Timestamp lastUseTimestamp, List<String> favoriteHosts) {
    super();
    this.username = username;
    this.displayedTitle = displayedTitle;
    this.searchTitle = searchTitle;
    this.bsURL = bsURL;
    this.ssURL = ssURL;
    this.fmURL = fmURL;
    this.URLCreationTimestamp = URLCreationTimestamp;
    this.season = season;
    this.episode = episode;
    this.languageTag = languageTag;
    this.lastUseTimestamp = lastUseTimestamp;
    this.favoriteHosts = favoriteHosts;
  }

  public ShowProgress toShowProgress() {
    
    User u = new User(this.username);
    
    Show s = new Show(this.searchTitle, this.bsURL, this.ssURL, this.fmURL, this.URLCreationTimestamp);
    
    ShowProgress sp = new ShowProgress(u, this.displayedTitle, s, this.season, this.episode, this.languageTag, this.lastUseTimestamp);
    
    return sp;
  }
  
  
  public List<Host> getHosts(ShowProgress showProgress){
    ArrayList<Host> list = new ArrayList<Host>();
    for(String hostName : this.favoriteHosts) {
      if(hostName != null && !hostName.equals("")) {
        Host h = new Host(showProgress, hostName);
        list.add(h);
      }
    }
    return list;
  }

  public String getUsername() {
    return username;
  }

  public String getDisplayedTitle() {
    return displayedTitle;
  }

  public String getSearchTitle() {
    return searchTitle;
  }

  public String getBsURL() {
    return bsURL;
  }

  public String getSsURL() {
    return ssURL;
  }

  public String getFmURL() {
    return fmURL;
  }

  public Timestamp getURLCreationTimestamp() {
    return URLCreationTimestamp;
  }

  public int getSeason() {
    return season;
  }

  public int getEpisode() {
    return episode;
  }

  public String getLanguageTag() {
    return languageTag;
  }

  public Timestamp getLastUseTimestamp() {
    return lastUseTimestamp;
  }

  public List<String> getFavoriteHosts() {
    return favoriteHosts;
  }

}
