package equipo.dominio;

import java.util.List;

public interface TeamRepository {
	Equipo obtener (int id);
	void guardar (Equipo equipo);
	void actualizar (Equipo equipo);
	void eliminar (Equipo equipo);
	List<Equipo> obtenerTodos();
}
