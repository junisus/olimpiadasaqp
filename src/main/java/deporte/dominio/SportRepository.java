package deporte.dominio;

import java.util.List;

public interface SportRepository {
	Deporte obtener (int id);
	void guardar (Deporte deporte);
	void actualizar (Deporte deporte);
	void eliminar (Deporte deporte);
	List<Deporte> obtenerTodos();
}