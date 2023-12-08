package deporte.infraestructura;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import deporte.dominio.SportRepository;
import deporte.dominio.Deporte;

public class SportRepositoryImpl implements SportRepository {
    private EntityManagerFactory emf;

    public SportRepositoryImpl(EntityManagerFactory emf) {
        super();
        this.emf = emf;
    }

    @Override
    public Deporte obtener(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Deporte.class, id);
    }

    @Override
    public void guardar(Deporte deporte) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(deporte);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void actualizar(Deporte deporte) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(deporte);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void eliminar(Deporte deporte) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        deporte = em.merge(deporte);
        em.remove(deporte);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Deporte> obtenerTodos() {
        EntityManager em = emf.createEntityManager();
        
        try {
            List<Deporte> listaDeportes = em.createQuery("SELECT d FROM Deporte d", Deporte.class).getResultList();
            return listaDeportes;
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }
}
