package jugadores.infraestructura;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import jugadores.dominio.Jugador;
import jugadores.dominio.PlayerRepository;

public class PlayerRepositoryImpl implements PlayerRepository{
	private EntityManagerFactory emf;

	public PlayerRepositoryImpl(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	@Override
	public Jugador obtener(int id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Jugador.class, id);
	}

	@Override
	public void guardar(Jugador jugador) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(jugador);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void actualizar(Jugador jugador) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(jugador);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void eliminar(Jugador jugador) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		jugador = em.merge(jugador);
		em.remove(jugador);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Jugador> obtenerTodos() {
		EntityManager em = emf.createEntityManager();

		try {
			List<Jugador> listaJugadores = em.createQuery("SELECT j FROM Jugador j", Jugador.class).getResultList();
			return listaJugadores;
		} catch (Exception e) {
			return null;
		} finally {
			em.close();
		}
	}
	
}
