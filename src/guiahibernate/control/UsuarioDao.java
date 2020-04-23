package guiahibernate.control;

import antlr.collections.List;
import guiahibernate.modelo.Usuario;

public interface UsuarioDao {

	public Usuario selectById(String Usuario);
	
	public List selectAll();
	
	public void insert(Usuario usuario);
	
	public void update(Usuario usuario);
	
	public void delete(Usuario usuario);
}
