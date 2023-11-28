package evento.dominio;

import java.util.List;

public interface EventRepository {
	Evento obtener (int id);
	void guardar (Evento evento);
	void actualizar (Evento evento);
	void eliminar (Evento evento);
	List<Evento> obtenerTodos();
}
