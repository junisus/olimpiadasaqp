package usuario.infraestructura;

import javax.persistence.*;

import usuario.dominio.UserRepository;
import usuario.dominio.Usuario;

public class UserRepositoryImpl implements UserRepository{
	private EntityManagerFactory emf;

	public UserRepositoryImpl(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	@Override
	public Usuario encontrarPorEmail(String email) {
		EntityManager em = emf.createEntityManager();
		
		try {
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class);
			query.setParameter("email", email);
	        return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public void guardar(Usuario usuario) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();
	}
	
	
}
