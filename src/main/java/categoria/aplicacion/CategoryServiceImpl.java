package categoria.aplicacion;

import java.util.List;

import categoria.dominio.CategoryRepository;
import categoria.dominio.Categoria;

public class CategoryServiceImpl implements CategoryService{
	private CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void save(String nombre, String descripcion) {
		Categoria categoria = new Categoria();
		categoria.setNombre(nombre);
		categoria.setDescripcion(descripcion);
		
		
		categoryRepository.guardar(categoria);
	}

	@Override
	public Categoria getCategory(int id) {
		return categoryRepository.obtener(id);
	}

	@Override
	public void update(int id, String nombre, String descripcion) {
		Categoria categoria = new Categoria();
		categoria.setId(id);
		categoria.setNombre(nombre);		
		categoria.setDescripcion(descripcion);
		
		categoryRepository.actualizar(categoria);
	}

	@Override
	public void delete(int id) {
		Categoria categoria = getCategory(id);
		categoryRepository.eliminar(categoria);
	}

	@Override
	public List<Categoria> getAllCategorys() {
		return categoryRepository.obtenerTodos();
	}

	
}
