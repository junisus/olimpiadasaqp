package categoria.infraestructura;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import categoria.aplicacion.CategoryService;
import categoria.aplicacion.CategoryServiceImpl;
import categoria.dominio.CategoryRepository;

@WebServlet(name = "SvDeleteCategory", urlPatterns= {"/SvDeleteCategory"})
public class SvDeleteCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryService categoryService;
       
    public SvDeleteCategory() {
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Oli");
        CategoryRepository categoryRepository = new CategoryRepositoryImpl(emf);
        this.categoryService = new CategoryServiceImpl(categoryRepository);	
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id-categoria"));
		
		categoryService.delete(id);
		response.sendRedirect("./categorias");
	}

}
