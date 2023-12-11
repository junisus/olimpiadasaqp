package categoria.infraestructura;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import categoria.dominio.CategoryRepository;
import categoria.dominio.Categoria;

public class CategoryRepositoryImpl implements CategoryRepository {
	private EntityManagerFactory emf;

	public CategoryRepositoryImpl(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	@Override
	public Categoria obtener(int id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Categoria.class, id);
	}

	@Override
	public void guardar(Categoria categoria) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(categoria);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void actualizar(Categoria categoria) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(categoria);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void eliminar(Categoria categoria) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		categoria = em.merge(categoria);
		em.remove(categoria);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Categoria> obtenerTodos() {
		EntityManager em = emf.createEntityManager();
		
		try {
			List<Categoria> listaCategorias = em.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
			return listaCategorias;
		} catch (Exception e) {
			return null;
		} finally {
			em.close();
		}
	}
}
