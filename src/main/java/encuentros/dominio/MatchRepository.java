package encuentros.dominio;

import java.util.List;

public interface MatchRepository {
	Encuentro obtener (int id);
	void guardar (Encuentro encuentro);
	void actualizar (Encuentro encuentro);
	void eliminar (Encuentro encuentro);
	List<Encuentro> obtenerTodos();
}
