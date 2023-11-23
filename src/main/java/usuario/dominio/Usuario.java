package usuario.dominio;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@Column(name="id_usuario", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="id_rol", nullable = true, unique = false)
	private int idRol;
	
	@Column(name="email", nullable = true, unique = true)
	private String email;
	
	@Column(name="password", nullable = true, unique = false)
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
