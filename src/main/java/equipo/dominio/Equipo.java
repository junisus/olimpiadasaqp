package equipo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipos")
public class Equipo {
	@Id
	@Column(name="id_equipo", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="id_categoria", nullable = true, unique = false)
	private int idCategoria;
	
	@Column(name="nombre", nullable = true, unique = false)
	private String nombre;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
