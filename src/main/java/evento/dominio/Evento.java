package evento.dominio;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "eventos")
public class Evento {
	@Id
	@Column(name="id_evento", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre", nullable = true, unique = false)
	private String nombre;
	
	@Column(name="organizador", nullable = true, unique = false)
	private String organizador;
	
	@Column(name="fecha_inicio", nullable = true, unique = false)
	private Date fechaInicio;
	
	@Column(name="fecha_fin", nullable = true, unique = false)
	private Date fechaFin;
	
	@Column(name="lugar", nullable = true, unique = false)
	private String lugar;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getOrganizador() {
		return organizador;
	}
	public void setOrganizador(String organizador) {
		this.organizador = organizador;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
}
