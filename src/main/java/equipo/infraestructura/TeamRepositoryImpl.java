package equipo.infraestructura;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import equipo.dominio.Equipo;
import equipo.dominio.TeamRepository;

public class TeamRepositoryImpl implements TeamRepository{
	private EntityManagerFactory emf;

	public TeamRepositoryImpl(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	@Override
	public Equipo obtener(int id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Equipo.class, id);
	}

	@Override
	public void guardar(Equipo equipo) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(equipo);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void actualizar(Equipo equipo) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(equipo);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void eliminar(Equipo equipo) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		equipo = em.merge(equipo);
		em.remove(equipo);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Equipo> obtenerTodos() {
		EntityManager em = emf.createEntityManager();
		
		try {
			List<Equipo> listaEquipos = em.createQuery("SELECT e FROM Equipo e", Equipo.class).getResultList();
			return listaEquipos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}
}
