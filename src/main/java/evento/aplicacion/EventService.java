package evento.aplicacion;

import java.sql.Date;
import java.util.List;

import evento.dominio.Evento;

public interface EventService {
	void save(String nombre, String organizador, Date inicio, Date fin, String lugar);
    Evento getEvent(int id);
    void update(int id, String nombre, String organizador, Date inicio, Date fin, String lugar);
    void delete(int id);
	List<Evento> getAllEvents();
}
