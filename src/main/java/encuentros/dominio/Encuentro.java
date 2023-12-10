package encuentros.dominio;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "encuentros")
public class Encuentro {
	@Id
	@Column(name="id_encuentro", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="id_equipo_A", nullable = true, unique = false)
	private int IdEquipoA;
	
	@Column(name="id_equipoB", nullable = true, unique = false)
	private int IdEquipoB;
	
	@Column(name="fecha", nullable = true, unique = false)
	private Date fecha;
	
	@Column(name="hora", nullable = true, unique = false)
	private Time hora;
	
	@Column(name="lugar", nullable = true, unique = false)
	private String lugar;
	
	@Column(name="resultado_A", nullable = true, unique = false)
	private int resultadoA;
	
	@Column(name="resultado_B", nullable = true, unique = false)
	private int resultadoB;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdEquipoA() {
		return IdEquipoA;
	}

	public void setIdEquipoA(int idEquipoA) {
		IdEquipoA = idEquipoA;
	}

	public int getIdEquipoB() {
		return IdEquipoB;
	}

	public void setIdEquipoB(int idEquipoB) {
		IdEquipoB = idEquipoB;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public int getResultadoA() {
		return resultadoA;
	}

	public void setResultadoA(int resultadoA) {
		this.resultadoA = resultadoA;
	}

	public int getResultadoB() {
		return resultadoB;
	}

	public void setResultadoB(int resultadoB) {
		this.resultadoB = resultadoB;
	}
}
