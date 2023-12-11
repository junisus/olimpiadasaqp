package deporte.aplicacion;

import java.util.List;

import deporte.dominio.Deporte;
import deporte.dominio.SportRepository;


public class SportServiceImpl implements SportService {
    private SportRepository sportRepository;

    public SportServiceImpl(SportRepository sportRepository) {
        super();
        this.sportRepository = sportRepository;
    }

    @Override
    public void save(String nombre, String descripcion) {
        Deporte deporte = new Deporte();
        deporte.setNombre(nombre);
        deporte.setDescripcion(descripcion);
        sportRepository.guardar(deporte);
    }

    @Override
    public Deporte getSport(int id) {
        return sportRepository.obtener(id);
    }

    @Override
    public void update(int id, String nombre, String descripcion) {
        Deporte deporte = new Deporte();
        deporte.setId(id);
        deporte.setNombre(nombre);       
        deporte.setDescripcion(descripcion);
        sportRepository.actualizar(deporte);
    }

    @Override
    public void delete(int id) {
        Deporte deporte = getSport(id);
        sportRepository.eliminar(deporte);
    }

    @Override
    public List<Deporte> getAllSports() {
        return sportRepository.obtenerTodos();
    }
}
