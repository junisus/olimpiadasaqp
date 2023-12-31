package evento.infraestructura;

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

import evento.aplicacion.EventService;
import evento.aplicacion.EventServiceImpl;
import evento.dominio.EventRepository;

@WebServlet(name = "SvAddEvent", urlPatterns= {"/SvAddEvent"})
public class SvAddEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EventService eventService;
	
    public SvAddEvent() {
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Oli");
        EventRepository eventRepository = new EventRepositoryImpl(emf);
        this.eventService = new EventServiceImpl(eventRepository);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String organizador = request.getParameter("organizador");
		String fechaInicio = request.getParameter("inicio");
		String fechaFin = request.getParameter("fin");
		String lugar = request.getParameter("lugar");
		
	    SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
	    
	    try {
	        Date fechaInicioConvertida = new Date(formatoEntrada.parse(fechaInicio).getTime());
	        Date fechaFinConvertida = new Date(formatoEntrada.parse(fechaFin).getTime());

	        eventService.save(nombre, organizador, fechaInicioConvertida, fechaFinConvertida, lugar);
	        response.sendRedirect("./eventos");
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	}
}
