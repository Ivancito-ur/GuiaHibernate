package guiahibernate.control;

import guiahibernate.modelo.Usuario;

public class LoginDao {
	public String authenticateUser (Usuario usuario){
		UsuarioDao usuarioDao = new HibernateUsuarioDao();
		
		Usuario u = usuarioDao.selectById(usuario.getUsuario());
		
		if(u!=null){
			if(u.getClave().contentEquals(usuario.getClave())){
				return "SUCCESS-CORRECTO";
			}
		}
		return "ERROR";
	}
}
