package mx.unam.posgrado.inventory.hibernate;


import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import mx.unam.posgrado.inventory.pojo.FrmLogin;
import java.util.List;

/**
 * 
 * @author Andric Valdez Valenzuela
 * @version 1.0  
 * @since 22/11/2018
 *
 */
public class UsuarioDAO extends BaseHibernateDAO{
	
	public Usuario login(FrmLogin login) {
		Criteria criteria = getSession().createCriteria(Usuario.class)
				.add( Restrictions.eq("correo", login.getCorreo()) )
				.add( Restrictions.eq("contrasena", login.getContrasena()) );
		return (Usuario) criteria.uniqueResult();
	}

	/**
	 * Query all producto objects
	 * @return List<Usuario> object
	 */
	public List<Usuario> getAllUsuarios(){
		return (List<Usuario>)(List<?>)findAll(Usuario.class);
	}
	
	public void saveUsuario(Usuario usuario) {
		super.save(usuario);
	}
	
	public void updateUsuario(Usuario usuario) {
		super.saveOrUpdate(usuario);
	}
}