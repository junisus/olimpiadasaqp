package evento.infraestructura;

import java.io.IOException;
import java.util.List;

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
import evento.dominio.Evento;

@WebServlet(name = "SvListaEventos", urlPatterns= {"/eventos"})
public class SvListaEventos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EventService eventService;

    public SvListaEventos() {
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Oli");
        EventRepository eventRepository = new EventRepositoryImpl(emf);
        this.eventService = new EventServiceImpl(eventRepository);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("eventos", eventService.getAllEvents());
        request.getRequestDispatcher("pages/eventos.jsp").forward(request, response);
	}
}
