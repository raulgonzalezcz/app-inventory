package mx.unam.posgrado.inventory.hibernate;


import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import mx.unam.posgrado.inventory.pojo.FrmLogin;

/**
 * 
 * @author Andric Valdez
 *
 */
public class UsuarioDAO extends BaseHibernateDAO{
	
	public Usuario login(FrmLogin login) {
		Criteria criteria = getSession().createCriteria(Usuario.class)
				.add( Restrictions.eq("correo", login.getCorreo()) )
				.add( Restrictions.eq("contrasena", login.getContrasena()) );
		return (Usuario) criteria.uniqueResult();
	}
	
	public void saveUsuario(Usuario usuario) {
		super.save(usuario);
	}
	
	public void updateUsuario(Usuario usuario) {
		super.saveOrUpdate(usuario);
	}
}