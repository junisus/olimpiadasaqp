package encuentros.infraestructura;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import encuentros.dominio.Encuentro;
import encuentros.dominio.MatchRepository;

public class MatchRepositoryImpl implements MatchRepository{
	private EntityManagerFactory emf;

	public MatchRepositoryImpl(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	@Override
	public Encuentro obtener(int id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Encuentro.class, id);
	}

	@Override
	public void guardar(Encuentro encuentro) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(encuentro);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void actualizar(Encuentro encuentro) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(encuentro);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void eliminar(Encuentro encuentro) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		encuentro = em.merge(encuentro);
		em.remove(encuentro);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Encuentro> obtenerTodos() {
		EntityManager em = emf.createEntityManager();

		try {
			List<Encuentro> listaEncuentros = em.createQuery("SELECT e FROM Encuentro e", Encuentro.class).getResultList();
			return listaEncuentros;
		} catch (Exception e) {
			return null;
		} finally {
			em.close();
		}
	}
}
