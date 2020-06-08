package dbModel;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

  @Column(name = "username", unique = true)
  @Id
  private String username;

  @Column(name = "password")
  private String password;
  
  @OneToMany(mappedBy = "owner")
  private Set<ShowProgress> data;
  
  public User(String username) {
    super();
    this.username = username;
    this.password = null;
  }

  public User(String username, String password) {
    super();
    this.username = username;
    this.password = password;
  }
  
  public User() {
    super();
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
  public Set<ShowProgress> getData() {
    return data;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((password == null) ? 0 : password.hashCode());
    result = prime * result + ((username == null) ? 0 : username.hashCode());
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
    User other = (User) obj;
    if (username == null) {
      if (other.username != null)
        return false;
    } else if (!username.equals(other.username))
      return false;
    return true;
  }

}
