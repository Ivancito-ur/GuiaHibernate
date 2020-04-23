package guiahibernate.servelets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guiahibernate.control.HibernateUsuarioDao;
import guiahibernate.control.UsuarioDao;
import guiahibernate.modelo.Usuario;


@WebServlet("/RegistroServelet")
public class RegistroServelet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		
		String usuarioTxt = request.getParameter("usuario");
		String claveTxt = request.getParameter("clave");
		String nombreTxt = request.getParameter("nombre");
		String direccionTxt = request.getParameter("direccion");
		String telefonoTxt = request.getParameter("telefono");
		String correoTxt = request.getParameter("email");
		
		Usuario usuario = new Usuario();
		
		usuario.setUsuario(usuarioTxt);
		usuario.setClave(claveTxt);
		usuario.setNombre(nombreTxt);
		usuario.setDireccion(direccionTxt);
		usuario.setTelefono(telefonoTxt);
		usuario.setCorreo(correoTxt);
		
		System.out.println("Acasito la pruebita");
		
		UsuarioDao usuarioDao = new HibernateUsuarioDao();
		usuarioDao.insert(usuario);
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
	}
	
	

}
