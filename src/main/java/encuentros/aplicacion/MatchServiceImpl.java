package encuentros.aplicacion;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import encuentros.dominio.Encuentro;
import encuentros.dominio.MatchRepository;

public class MatchServiceImpl implements MatchService{
	private MatchRepository matchRepository;

	public MatchServiceImpl(MatchRepository matchRepository) {
		super();
		this.matchRepository = matchRepository;
	}

	@Override
	public void save(int idEquipoA, int idEquipoB, Date fecha, Time hora, String lugar) {
		Encuentro encuentro = new Encuentro();
		encuentro.setIdEquipoA(idEquipoA);
		encuentro.setIdEquipoB(idEquipoB);
		encuentro.setFecha(fecha);
		encuentro.setHora(hora);
		encuentro.setLugar(lugar);
		matchRepository.guardar(encuentro);
	}

	@Override
	public Encuentro getMatch(int id) {
		return matchRepository.obtener(id);
	}

	@Override
	public void update(int id, int idEquipoA, int idEquipoB, Date fecha, Time hora, String lugar) {
		Encuentro encuentro = new Encuentro();
		encuentro.setId(id);
		encuentro.setIdEquipoA(idEquipoA);
		encuentro.setIdEquipoB(idEquipoB);
		encuentro.setFecha(fecha);
		encuentro.setHora(hora);
		encuentro.setLugar(lugar);
		matchRepository.actualizar(encuentro);
	}

	@Override
	public void delete(int id) {
		Encuentro encuentro = getMatch(id);
		matchRepository.eliminar(encuentro);
	}

	@Override
	public List<Encuentro> getAllMatch() {
		return matchRepository.obtenerTodos();
	}	
}
