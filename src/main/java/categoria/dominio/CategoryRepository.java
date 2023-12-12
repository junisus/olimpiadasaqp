package categoria.dominio;

import java.util.List;

public interface CategoryRepository {
	Categoria obtener (int id);
	void guardar (Categoria categoria);
	void actualizar (Categoria categoria);
	void eliminar (Categoria categoria);
	List<Categoria> obtenerTodos();
}
