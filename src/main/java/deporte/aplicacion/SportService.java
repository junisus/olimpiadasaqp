package deporte.aplicacion;

import java.sql.Date;
import java.util.List;

import deporte.dominio.Deporte;


public interface SportService {
	void save(String nombre, String descripcion);
    Deporte getSport(int id);
    void update(int id, String nombre, String descripcion);
    void delete(int id);
	List<Deporte> getAllSports();
}
