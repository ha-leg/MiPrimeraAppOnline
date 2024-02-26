package controlador;

// IMPORTANTE: un servlet es el controlador.
// Servlet, recibe los datos y los convierte en objetos que coge del modelo, y decide que harña con ellos.

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Nave;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class SVNave
 */
public class SVNave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SVNave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Esto siempre es lo mismo, es algo robótico.
		// Lo que se pone entre comillas es el name que he puesto en html, si no es asi no me lo va a recepcionar.
		
		String nombre = request.getParameter("nombre");
		String clase = request.getParameter("clase");
		String matricula = request.getParameter("matricula");
		String descripcion = request.getParameter("descripcion");
		String estado = request.getParameter("estado");
		
		// El siguiente paso es hacer el objeto nave con el nombre, la clase, la matrícula, etc.
		// Elijo el constructor que quiero usar:
		
		Nave n1 = new Nave(nombre, clase, matricula, descripcion, estado); 
		System.out.println(n1.toString());
		
		// Aquí ya tengo que gestionar los errores, no puedo lanzar el throws.
		try {   
			n1.insertar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error en base de datos");
		} 
		
		// int anosServicio = request.getParameter("anosServicio") esto no funcionaría al ser int --> lo convertimos en -->
		// int anosServicio = Integer.parseInt(request.getParameter("anosServicio"));
		// Hemos convertido el integer en un String con el parseInt, porque los datos viajan en un String aunque me pongan un numero.
		// Se llama parsearlo.
			
		
	}

}
