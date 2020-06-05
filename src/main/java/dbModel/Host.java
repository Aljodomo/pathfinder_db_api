package dbModel;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "hosts")
@IdClass(Host.IDClass.class)
public class Host {

	@Column(name = "users_username")
	@Id
	private String username;

	@Column(name = "displayed_title")
	@Id
	private String displayedTitle;

	@Column(name = "host")
	@Id
	private String hostName;

	static class IDClass implements Serializable {
		private static final long serialVersionUID = 1L;
		private String username;
		private String displayedTitle;
		private String hostName;

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
			if (hostName == null) {
				if (other.hostName != null)
					return false;
			} else if (!hostName.equals(other.hostName))
				return false;
			if (username == null) {
				if (other.username != null)
					return false;
			} else if (!username.equals(other.username))
				return false;
			return true;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((displayedTitle == null) ? 0 : displayedTitle.hashCode());
			result = prime * result + ((hostName == null) ? 0 : hostName.hashCode());
			result = prime * result + ((username == null) ? 0 : username.hashCode());
			return result;
		}
	}

	
	public Host(String username, String displayedTitle, String hostName) {
		super();
		this.username = username;
		this.displayedTitle = displayedTitle;
		this.hostName = hostName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDisplayedTitle() {
		return displayedTitle;
	}

	public void setDisplayedTitle(String displayedTitle) {
		this.displayedTitle = displayedTitle;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public boolean exactEqual(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Host other = (Host) obj;
		if (displayedTitle == null) {
			if (other.displayedTitle != null)
				return false;
		} else if (!displayedTitle.equals(other.displayedTitle))
			return false;
		if (hostName == null) {
			if (other.hostName != null)
				return false;
		} else if (!hostName.equals(other.hostName))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	
	
}
