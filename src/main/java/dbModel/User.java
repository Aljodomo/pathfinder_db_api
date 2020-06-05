package dbModel;

import javax.persistence.*;

@Entity 
@Table(name ="users")
public class User {
	
	@Column(name = "username", unique = true)
	@Id
	private String username;
		
	@Column(name = "password")
	private String password;

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
	
	
	
}
