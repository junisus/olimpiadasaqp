package jugadores.aplicacion;

import java.util.List;

import jugadores.dominio.Jugador;

public interface PlayerService {
	void save(String nombre, String apellido, char sexo, int edad);
    Jugador getPlayer(int id);
    void update(int id, String nombre, String apellido, char sexo, int edad);
    void delete(int id);
	List<Jugador> getAllPlayers();
}
