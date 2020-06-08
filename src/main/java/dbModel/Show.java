package dbModel;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "shows")
public class Show {

  @Column(name = "title", unique = true)
  @Id
  private String searchTitle;

  @Column(name = "bs")
  private String bs;

  @Column(name = "serienstream")
  private String ss;

  @Column(name = "fmovies")
  private String fm;

  @Column(name = "timestamp")
  private Timestamp timestamp;


  public Show(String searchTitle, String bs, String ss, String fm, Timestamp timestamp) {
    super();
    this.searchTitle = searchTitle;
    this.bs = bs;
    this.ss = ss;
    this.fm = fm;
    this.timestamp = timestamp;
  }

  public Show() {
    // TODO Auto-generated constructor stub
  }

  public String getSearchTitle() {
    return searchTitle;
  }

  public void setSearchTitle(String searchTitle) {
    this.searchTitle = searchTitle;
  }

  public String getBs() {
    return bs;
  }

  public void setBs(String bs) {
    this.bs = bs;
  }

  public String getSs() {
    return ss;
  }

  public void setSs(String ss) {
    this.ss = ss;
  }

  public String getFm() {
    return fm;
  }

  public void setFm(String fm) {
    this.fm = fm;
  }

  public Timestamp getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Timestamp timestamp) {
    this.timestamp = timestamp;
  }

  

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((bs == null) ? 0 : bs.hashCode());
    result = prime * result + ((fm == null) ? 0 : fm.hashCode());
    result = prime * result + ((searchTitle == null) ? 0 : searchTitle.hashCode());
    result = prime * result + ((ss == null) ? 0 : ss.hashCode());
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
    Show other = (Show) obj;
    if (bs == null) {
      if (other.bs != null)
        return false;
    } else if (!bs.equals(other.bs))
      return false;
    if (fm == null) {
      if (other.fm != null)
        return false;
    } else if (!fm.equals(other.fm))
      return false;
    if (searchTitle == null) {
      if (other.searchTitle != null)
        return false;
    } else if (!searchTitle.equals(other.searchTitle))
      return false;
    if (ss == null) {
      if (other.ss != null)
        return false;
    } else if (!ss.equals(other.ss))
      return false;
    if (timestamp == null) {
      if (other.timestamp != null)
        return false;
    } else if (!timestamp.equals(other.timestamp))
      return false;
    return true;
  }

}
