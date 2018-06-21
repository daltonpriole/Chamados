package model;

public class User {
	private String nome;
	private String email;
	private String user;
	private String password;
	private String status;
	
	public User(String nome, String email, String user, String password, String status) {
		this.setNome(nome);
		this.setUser(email);
		this.setUser(user);
		this.setPassword(password);
		this.setStatus(status);
	}
	
	public User(String user, String email, String password) {
		this.setUser(user);
		this.setUser(email);
		this.setPassword(password);
	}

	public User(String user, String password) {
		this.setUser(user);
		this.setPassword(password);
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

}
