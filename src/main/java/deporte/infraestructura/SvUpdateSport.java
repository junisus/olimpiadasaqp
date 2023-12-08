package deporte.infraestructura;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

@WebServlet(name = "SvUpdateSport", urlPatterns= {"/SvUpdateSport"})
public class SvUpdateSport extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SportService sportService;

    public SvUpdateSport() {
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Oli");
        SportRepository sportRepository = new SportRepositoryImpl(emf);
        this.sportService = new SportServiceImpl(sportRepository);    
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id-edit"));
        String nombre = request.getParameter("nombre-edit");
        String descripcion = request.getParameter("descripcion-edit");
        
        try {
            sportService.update(id, nombre, descripcion);
            response.sendRedirect("./eventos");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
