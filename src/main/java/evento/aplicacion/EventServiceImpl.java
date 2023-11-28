package evento.aplicacion;

import java.sql.Date;
import java.util.List;

import evento.dominio.EventRepository;
import evento.dominio.Evento;

public class EventServiceImpl implements EventService{
	private EventRepository eventRepository;

	public EventServiceImpl(EventRepository eventRepository) {
		super();
		this.eventRepository = eventRepository;
	}

	@Override
	public void save(String nombre, String organizador, Date inicio, Date fin, String lugar) {
		Evento evento = new Evento();
		evento.setNombre(nombre);
		evento.setOrganizador(organizador);
		evento.setFechaInicio(inicio);
		evento.setFechaFin(fin);
		evento.setLugar(lugar);
		eventRepository.guardar(evento);
	}

	@Override
	public Evento getEvent(int id) {
		return eventRepository.obtener(id);
	}

	@Override
	public void update(int id, String nombre, String organizador, Date inicio, Date fin, String lugar) {
		Evento evento = new Evento();
		evento.setId(id);
		evento.setNombre(nombre);		
		evento.setOrganizador(organizador);
		evento.setFechaInicio(inicio);
		evento.setFechaFin(fin);
		evento.setLugar(lugar);
		eventRepository.actualizar(evento);
	}

	@Override
	public void delete(int id) {
		Evento evento = getEvent(id);
		eventRepository.eliminar(evento);
	}

	@Override
	public List<Evento> getAllEvents() {
		return eventRepository.obtenerTodos();
	}

	
}
