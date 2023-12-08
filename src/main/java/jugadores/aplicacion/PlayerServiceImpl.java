package jugadores.aplicacion;

import java.util.List;

import evento.dominio.Evento;
import jugadores.dominio.Jugador;
import jugadores.dominio.PlayerRepository;

public class PlayerServiceImpl implements PlayerService{
	private PlayerRepository playerRepository;

	public PlayerServiceImpl(PlayerRepository playerRepository) {
		super();
		this.playerRepository = playerRepository;
	}

	@Override
	public void save(String nombre, String apellido, char sexo, int edad) {
		Jugador jugador = new Jugador();
		jugador.setNombre(nombre);
		jugador.setApellido(apellido);
		jugador.setSexo(sexo);
		jugador.setEdad(edad);
		playerRepository.guardar(jugador);
	}

	@Override
	public Jugador getPlayer(int id) {
		return playerRepository.obtener(id);
	}

	@Override
	public void update(int id, String nombre, String apellido, char sexo, int edad) {
		Jugador jugador = new Jugador();
		jugador.setId(id);
		jugador.setNombre(nombre);
		jugador.setApellido(apellido);
		jugador.setSexo(sexo);
		jugador.setEdad(edad);
		playerRepository.actualizar(jugador);
	}

	@Override
	public void delete(int id) {
		Jugador jugador = getPlayer(id);
		playerRepository.eliminar(jugador);
	}

	@Override
	public List<Jugador> getAllPlayers() {
		return playerRepository.obtenerTodos();
	}
}
