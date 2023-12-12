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

@WebServlet(name = "SvListaCategorias", urlPatterns= {"/categorias"})
public class SvListaCategorias extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryService categoryService;

    public SvListaCategorias() {
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Oli");
        CategoryRepository categoryRepository = new CategoryRepositoryImpl(emf);
        this.categoryService = new CategoryServiceImpl(categoryRepository);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("categorias", categoryService.getAllCategorys());
		request.getRequestDispatcher("pages/categorias.jsp").forward(request, response);

	}


	   

		
	}

