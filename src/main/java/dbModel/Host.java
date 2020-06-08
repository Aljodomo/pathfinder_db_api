package dbModel;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "hosts")
@IdClass(Host.IDClass.class)
public class Host {

  // @Column(name = "users_username")
  // @Id
  // private String username;
  //
  // @Column(name = "displayed_title")
  // @Id
  // private String displayedTitle;

  @ManyToOne
  @JoinColumns({@JoinColumn(name = "users_username", referencedColumnName = "owner"),
      @JoinColumn(name = "displayed_title", referencedColumnName = "displayed_title")})
  @Id
  private ShowProgress showProgress;

  @Column(name = "host_name")
  @Id
  private String hostName;
  
  
  public Host(ShowProgress showProgress, String hostName) {
    super();
    this.showProgress = showProgress;
    this.hostName = hostName;
  }
  
  public Host() {
    super();
  }

  public ShowProgress getShowProgress() {
    return showProgress;
  }

  public void setShowProgress(ShowProgress showProgress) {
    this.showProgress = showProgress;
  }

  public String getHostName() {
    return hostName;
  }

  public void setHostName(String hostName) {
    this.hostName = hostName;
  }
  

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((hostName == null) ? 0 : hostName.hashCode());
    result = prime * result + ((showProgress == null) ? 0 : showProgress.hashCode());
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
    Host other = (Host) obj;
    if (hostName == null) {
      if (other.hostName != null)
        return false;
    } else if (!hostName.equals(other.hostName))
      return false;
    if (showProgress == null) {
      if (other.showProgress != null)
        return false;
    } else if (!showProgress.equals(other.showProgress))
      return false;
    return true;
  }


  public static class IDClass implements Serializable{
    private static final long serialVersionUID = 1L;
    private ShowProgress showProgress;
    private String hostName;
    
    public IDClass(ShowProgress showProgress, String hostName) {
      super();
      this.showProgress = showProgress;
      this.hostName = hostName;
    }
    
    public IDClass() {
      super();
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((hostName == null) ? 0 : hostName.hashCode());
      result = prime * result + ((showProgress == null) ? 0 : showProgress.hashCode());
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
      if (hostName == null) {
        if (other.hostName != null)
          return false;
      } else if (!hostName.equals(other.hostName))
        return false;
      if (showProgress == null) {
        if (other.showProgress != null)
          return false;
      } else if (!showProgress.equals(other.showProgress))
        return false;
      return true;
    }
    
  }
  
}
