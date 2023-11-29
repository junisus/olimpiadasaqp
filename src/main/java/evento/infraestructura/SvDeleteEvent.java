package evento.infraestructura;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import evento.aplicacion.EventService;
import evento.aplicacion.EventServiceImpl;
import evento.dominio.EventRepository;

@WebServlet(name = "SvDeleteEvent", urlPatterns= {"/SvDeleteEvent"})
public class SvDeleteEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EventService eventService;
       
    public SvDeleteEvent() {
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Oli");
        EventRepository eventRepository = new EventRepositoryImpl(emf);
        this.eventService = new EventServiceImpl(eventRepository);	
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id-evento"));
		
		eventService.delete(id);
		response.sendRedirect("./eventos");
	}

}
