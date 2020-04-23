package guiahibernate.control;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import antlr.collections.List;
import guiahibernate.modelo.Usuario;
import guiahibernate.utilidad.HibernateSession;

public class HibernateUsuarioDao implements UsuarioDao {

	@Override
	public Usuario selectById(String usuarioId) {
		SessionFactory sessionFactory = HibernateSession.getSessionfactory();
		Session session = sessionFactory.openSession();
		Usuario usuario = (Usuario) session.get(Usuario.class, usuarioId);
		return usuario;
	}

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateSession.getSessionfactory();
		Session session = sessionFactory.openSession();
		List usuarios = (List) session.createCriteria(Usuario.class).list();
		return usuarios;
	}

	@Override
	public void insert(Usuario usuario) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateSession.getSessionfactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String id = (String) session.save(usuario);
		usuario.setUsuario(id);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void update(Usuario usuario) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateSession.getSessionfactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(usuario);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(Usuario usuario) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateSession.getSessionfactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(usuario);
		session.getTransaction().commit();
		session.close();		
	}
}
