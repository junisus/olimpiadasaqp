package categoria.aplicacion;

import java.util.List;

import categoria.dominio.Categoria;

public interface CategoryService {
	void save(String nombre, String descripcion);
    Categoria getCategory(int id);
    void update(int id, String nombre, String descripcion);
    void delete(int id);
	List<Categoria> getAllCategorys();
}
