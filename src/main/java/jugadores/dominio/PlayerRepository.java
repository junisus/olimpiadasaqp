package jugadores.dominio;

import java.util.List;

public interface PlayerRepository {
	Jugador obtener (int id);
	void guardar (Jugador jugador);
	void actualizar (Jugador jugador);
	void eliminar (Jugador jugador);
	List<Jugador> obtenerTodos();
}
