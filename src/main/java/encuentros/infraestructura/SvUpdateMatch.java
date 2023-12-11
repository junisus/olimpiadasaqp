package encuentros.infraestructura;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import encuentros.aplicacion.MatchService;
import encuentros.aplicacion.MatchServiceImpl;
import encuentros.dominio.MatchRepository;

@WebServlet(name = "SvUpdateMatch", urlPatterns= {"/SvUpdateMatch"})
public class SvUpdateMatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MatchService matchService;
       
    public SvUpdateMatch() {
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Oli");
        MatchRepository matchRepository = new MatchRepositoryImpl(emf);
        this.matchService = new MatchServiceImpl(matchRepository);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id-encuentro-edit"));
		int idEquipoA = Integer.parseInt(request.getParameter("id-equipo-a-edit"));
		int idEquipoB = Integer.parseInt(request.getParameter("id-equipo-b-edit"));
		String fecha = request.getParameter("fecha-edit");
		String h = request.getParameter("hora-edit");
		String lugar = request.getParameter("lugar-edit");
		String ra = request.getParameter("resultado-a-edit");
		String rb = request.getParameter("resultado-b-edit");
		int resA;
		int resB;
		
	    SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
	    SimpleDateFormat formatoFecha = new SimpleDateFormat("HH:mm");
	    
	    if (ra.isEmpty()) {
	    	resA = 0;
	    } else {
	    	resA = Integer.parseInt(ra);
	    }
	    
	    if (rb.isEmpty()) {
	    	resB = 0;
	    } else {
	    	resB = Integer.parseInt(rb);
	    }
	    
	    try {
	        Date fechaConvertida = new Date(formatoEntrada.parse(fecha).getTime());
	        Time hora = new Time(formatoFecha.parse(h).getTime());
	        
	        matchService.update(id, idEquipoA, idEquipoB, fechaConvertida, hora, lugar, resA, resB);
	        response.sendRedirect("./encuentros");
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	}

}
