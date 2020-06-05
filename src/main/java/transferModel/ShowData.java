package transferModel;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dbModel.Host;
import dbModel.Show;
import dbModel.ShowProgress;

public class ShowData {
	public static SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private final String username;
	private final String displayedTitle;
	private final String searchTitle;
	private final String bsURL;
	private final String ssURL;
	private final String fmURL;
	private final String URLCreationTimestamp;
	private final int season;
	private final int episode;
	private final String languageTag;
	private final String lastUseTimestamp;
	private final List<String> favoriteHosts;

	public ShowData(ShowProgress showProgress, Show show, List<Host> hosts) {
		this.username = showProgress.getOwner();
		this.displayedTitle = showProgress.getDisplayedTitle();
		this.searchTitle = show.getSearchTitle();
		this.bsURL = show.getBs();
		this.ssURL = show.getSs();
		this.fmURL = show.getFm();
		this.URLCreationTimestamp = ShowData.TIMESTAMP_FORMAT.format(show.getTimestamp());
		this.season = showProgress.getSeason();
		this.episode = showProgress.getEpisode();
		this.languageTag = showProgress.getLanguageTag();
		this.lastUseTimestamp = ShowData.TIMESTAMP_FORMAT.format(showProgress.getTimestamp());
		this.favoriteHosts = new ArrayList<String>();
		for (Host h : hosts) {
			this.favoriteHosts.add(h.getHostName());
		}
	}

	public ShowData(String username, String displayedTitle, String searchTitle, String bsURL, String ssURL,
			String fmURL, String uRLCreationTimestamp, int season, int episode, String languageTag,
			String lastUseTimestamp, List<String> favoriteHosts) {
		super();
		this.username = username;
		this.displayedTitle = displayedTitle;
		this.searchTitle = searchTitle;
		this.bsURL = bsURL;
		this.ssURL = ssURL;
		this.fmURL = fmURL;
		URLCreationTimestamp = uRLCreationTimestamp;
		this.season = season;
		this.episode = episode;
		this.languageTag = languageTag;
		this.lastUseTimestamp = lastUseTimestamp;
		this.favoriteHosts = favoriteHosts;
	}
	
	public ShowProgress toShowProgress() {
		ShowProgress sp = null;
		try {
			sp = new ShowProgress(this.username, this.displayedTitle, this.searchTitle, this.season, this.episode,
					this.languageTag, new Timestamp(TIMESTAMP_FORMAT.parse(this.lastUseTimestamp).getTime()));
		} catch (ParseException e) {
			System.err
					.println("Timestamp parsing error while converting ShowData to ShowProgress. Now is set to null.");
			sp = new ShowProgress(this.username, this.displayedTitle, this.searchTitle, this.season, this.episode,
					this.languageTag, null);
		}

		return sp;
	}

	public Show toShow() {
		Show s = null;
		try {
			s = new Show(this.searchTitle, this.bsURL, this.ssURL, this.fmURL,
					new Timestamp(TIMESTAMP_FORMAT.parse(this.URLCreationTimestamp).getTime()));
		} catch (ParseException e) {
			System.err.println("Timestamp parsing error while converting ShowData to Show. Now is set to null.");
			s = new Show(this.searchTitle, this.bsURL, this.ssURL, this.fmURL, null);

		}
		return s;
	}

	public List<Host> toHosts() {
		ArrayList<Host> list = new ArrayList<Host>();
		if (this.favoriteHosts != null && this.favoriteHosts.size() > 0) {
			for (String host : this.favoriteHosts) {
				Host h = new Host(this.username, this.displayedTitle, host);
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

	public String getURLCreationTimestamp() {
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

	public String getLastUseTimestamp() {
		return lastUseTimestamp;
	}

	public List<String> getFavoriteHosts() {
		return favoriteHosts;
	}

}
