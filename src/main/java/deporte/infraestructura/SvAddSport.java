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

@WebServlet(name = "SvAddSport", urlPatterns= {"/SvAddSport"})
public class SvAddSport extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SportService sportService;
    
    public SvAddSport() {
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Oli");
        SportRepository deporteRepository = new SportRepositoryImpl(emf);
        this.sportService = new SportServiceImpl(deporteRepository);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        
        
        if (nombre != null && descripcion != null) {

            sportService.save(nombre, descripcion);
           
            response.sendRedirect("./deportes");
        } else {
            
            response.getWriter().println("Error: Falta nombre o descripción");
        }
    }

    
}
