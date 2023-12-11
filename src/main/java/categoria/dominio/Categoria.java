package categoria.dominio;



import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {
	
	@Id
	@Column(name="id_categoria", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre", nullable = true, unique = false)
	private String nombre;
	
	@Column(name="descripcion", nullable = true, unique = false)
	private String descripcion;

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
