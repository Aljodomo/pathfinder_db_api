package dbModel;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "showProgress")
@IdClass(ShowProgress.IDClass.class)
public class ShowProgress {

  @ManyToOne
  @JoinColumn(name = "owner")
  @Id
  private User owner;

  @Column(name = "displayed_title")
  @Id
  private String displayedTitle;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "show_title", referencedColumnName = "title")
  private Show show;

  @Column(name = "season")
  private int season;

  @Column(name = "episode")
  private int episode;

  @Column(name = "languageTag")
  private String languageTag;

  @Column(name = "timestamp")
  private Timestamp timestamp;
  
  @OneToMany(mappedBy = "showProgress") // Name of the attribute in the Host class
  private Set<Host> hosts;

  

  public ShowProgress(User owner, String displayedTitle, Show show, int season, int episode,
      String languageTag, Timestamp timestamp) {
    super();
    this.owner = owner;
    this.displayedTitle = displayedTitle;
    this.show = show;
    this.season = season;
    this.episode = episode;
    this.languageTag = languageTag;
    this.timestamp = timestamp;
  }
  
  public ShowProgress() {
    super();
  }
  
  

  public User getOwner() {
    return owner;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }

  public String getDisplayedTitle() {
    return displayedTitle;
  }

  public void setDisplayedTitle(String displayedTitle) {
    this.displayedTitle = displayedTitle;
  }

  public Show getShow() {
    return show;
  }

  public void setShow(Show show) {
    this.show = show;
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

  public Set<Host> getHosts() {
    return hosts;
  }


  public static class IDClass implements Serializable {
    private static final long serialVersionUID = 1L;
    protected User owner;
    protected String displayedTitle;

    public IDClass(User owner, String displayedTitle) {
      super();
      this.owner = owner;
      this.displayedTitle = displayedTitle;
    }
    
    public IDClass() {
      super();
    }

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


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((displayedTitle == null) ? 0 : displayedTitle.hashCode());
    result = prime * result + episode;
    result = prime * result + ((hosts == null) ? 0 : hosts.hashCode());
    result = prime * result + ((languageTag == null) ? 0 : languageTag.hashCode());
    result = prime * result + ((owner == null) ? 0 : owner.hashCode());
    result = prime * result + season;
    result = prime * result + ((show == null) ? 0 : show.hashCode());
    result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
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
    ShowProgress other = (ShowProgress) obj;
    if (displayedTitle == null) {
      if (other.displayedTitle != null)
        return false;
    } else if (!displayedTitle.equals(other.displayedTitle))
      return false;
    if (episode != other.episode)
      return false;
    if (hosts == null) {
      if (other.hosts != null)
        return false;
    } else if (!hosts.equals(other.hosts))
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
    if (show == null) {
      if (other.show != null)
        return false;
    } else if (!show.equals(other.show))
      return false;
    if (timestamp == null) {
      if (other.timestamp != null)
        return false;
    } else if (!timestamp.equals(other.timestamp))
      return false;
    return true;
  }

}
