package dbModel;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "showProgress")
@IdClass(ShowProgress.IDClass.class)
public class ShowProgress {

	@Column(name = "owner")
	@Id
	private String owner;

	@Column(name = "displayed_title")
	@Id
	private String displayedTitle;

	static class IDClass implements Serializable {
		private static final long serialVersionUID = 1L;
		protected String owner;
		protected String displayedTitle;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((displayedTitle == null) ? 0 : displayedTitle.hashCode());
			result = prime * result + ((owner == null) ? 0 : owner.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			IDClass other = (IDClass) obj;
			if (displayedTitle == null) {
				if (other.displayedTitle != null)
					return false;
			} else if (!displayedTitle.equals(other.displayedTitle))
				return false;
			if (owner == null) {
				if (other.owner != null)
					return false;
			} else if (!owner.equals(other.owner))
				return false;
			return true;
		}

	}

	@Column(name = "show_title")
	private String showTitle;

	@Column(name = "season")
	private int season;

	@Column(name = "episode")
	private int episode;

	@Column(name = "languageTag")
	private String languageTag;

	@Column(name = "timestamp")
	private Timestamp timestamp;
	
	

	public ShowProgress(String owner, String displayedTitle, String showTitle, int season, int episode,
			String languageTag, Timestamp timestamp) {
		super();
		this.owner = owner;
		this.displayedTitle = displayedTitle;
		this.showTitle = showTitle;
		this.season = season;
		this.episode = episode;
		this.languageTag = languageTag;
		this.timestamp = timestamp;
	}

	public ShowProgress() {
		// TODO Auto-generated constructor stub
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getDisplayedTitle() {
		return displayedTitle;
	}

	public void setDisplayedTitle(String displayedTitle) {
		this.displayedTitle = displayedTitle;
	}

	public String getShowTitle() {
		return showTitle;
	}

	public void setShowTitle(String showTitle) {
		this.showTitle = showTitle;
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public int getEpisode() {
		return episode;
	}

	public void setEpisode(int episode) {
		this.episode = episode;
	}

	public String getLanguageTag() {
		return languageTag;
	}

	public void setLanguageTag(String languageTag) {
		this.languageTag = languageTag;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public boolean exactEqual(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShowProgress other = (ShowProgress) obj;
		if (displayedTitle == null) {
			if (other.displayedTitle != null)
				return false;
		} else if (!displayedTitle.equals(other.displayedTitle))
			return false;
		if (episode != other.episode)
			return false;
		if (languageTag == null) {
			if (other.languageTag != null)
				return false;
		} else if (!languageTag.equals(other.languageTag))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (season != other.season)
			return false;
		if (showTitle == null) {
			if (other.showTitle != null)
				return false;
		} else if (!showTitle.equals(other.showTitle))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		}
		System.out.println(this.timestamp + " : " + other.getTimestamp());
		return true;
	}
	
	

}
