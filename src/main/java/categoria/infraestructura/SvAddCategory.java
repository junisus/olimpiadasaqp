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

@WebServlet(name = "SvAddCategory", urlPatterns= {"/SvAddCategory"})
public class SvAddCategory extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryService categoryService;
    
    public SvAddCategory() {
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Oli");
        CategoryRepository categoryRepository = new CategoryRepositoryImpl(emf);
        this.categoryService = new CategoryServiceImpl(categoryRepository);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");

        try {
            // Aquí deberías realizar la operación con nombre y descripcion
            categoryService.save(nombre, descripcion);

            // Redirige a la misma página
            response.sendRedirect(request.getContextPath() + "/categorias");
        } catch (Exception e) {
            e.printStackTrace();
            // Manejo de excepciones
        }
    }
}
