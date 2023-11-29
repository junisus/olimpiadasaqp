package evento.infraestructura;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import evento.dominio.EventRepository;
import evento.dominio.Evento;

public class EventRepositoryImpl implements EventRepository {
	private EntityManagerFactory emf;

	public EventRepositoryImpl(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	@Override
	public Evento obtener(int id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Evento.class, id);
	}

	@Override
	public void guardar(Evento evento) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(evento);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void actualizar(Evento evento) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(evento);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void eliminar(Evento evento) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		evento = em.merge(evento);
		em.remove(evento);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Evento> obtenerTodos() {
		EntityManager em = emf.createEntityManager();
		
		try {
			List<Evento> listaEventos = em.createQuery("SELECT e FROM Evento e", Evento.class).getResultList();
			return listaEventos;
		} catch (Exception e) {
			return null;
		} finally {
			em.close();
		}
	}
}
