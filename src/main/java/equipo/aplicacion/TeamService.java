package equipo.aplicacion;

import java.util.List;

import equipo.dominio.Equipo;

public interface TeamService {
	void save(int idCategoria, String nombre);
    Equipo getTeam(int id);
    void update(int id, int idCategoria, String nombre);
    void delete(int id);
	List<Equipo> getAllTeams();
}
