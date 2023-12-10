package equipo.aplicacion;

import java.util.List;

import equipo.dominio.Equipo;
import equipo.dominio.TeamRepository;

public class TeamServiceImpl implements TeamService{
	private TeamRepository teamRepository;

	public TeamServiceImpl(TeamRepository teamRepository) {
		super();
		this.teamRepository = teamRepository;
	}

	@Override
	public void save(int idCategoria, String nombre) {
		Equipo equipo = new Equipo();
		equipo.setIdCategoria(idCategoria);
		equipo.setNombre(nombre);
		teamRepository.guardar(equipo);
	}

	@Override
	public Equipo getTeam(int id) {
		return teamRepository.obtener(id);
	}

	@Override
	public void update(int id, int idCategoria, String nombre) {
		Equipo equipo = new Equipo();
		equipo.setId(id);
		equipo.setIdCategoria(idCategoria);
		equipo.setNombre(nombre);
		teamRepository.actualizar(equipo);
	}

	@Override
	public void delete(int id) {
		Equipo equipo = getTeam(id);
		teamRepository.eliminar(equipo);
	}

	@Override
	public List<Equipo> getAllTeams() {
		return teamRepository.obtenerTodos();
	}
}
