package mx.unam.posgrado.inventory.hibernate;

import org.hibernate.Session;

/**
 * 
 * @author Gabriel Gonzalez
 *
 */
public interface IBaseHibernateDAO {
	public Session getSession();
}
