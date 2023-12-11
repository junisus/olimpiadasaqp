package deporte.infraestructura;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import deporte.aplicacion.SportService;
import deporte.aplicacion.SportServiceImpl;
import deporte.dominio.SportRepository;

@WebServlet(name = "SvDeleteSport", urlPatterns= {"/SvDeleteSport"})
public class SvDeleteSport extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SportService sportService;
       
    public SvDeleteSport() {
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Oli");
        SportRepository sportRepository = new SportRepositoryImpl(emf);
        this.sportService = new SportServiceImpl(sportRepository);    
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id-deporte"));
        
        sportService.delete(id);
        response.sendRedirect("./deportes");
    }
}
