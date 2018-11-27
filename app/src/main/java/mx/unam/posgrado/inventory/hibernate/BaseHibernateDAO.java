package mx.unam.posgrado.inventory.hibernate;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Clase DAO para definir las funciones genéricas de acceso a los 
 * datos almacenados en la base de datos
 * @author Gabriel Gonzalez
 *
 */
@SuppressWarnings("unchecked")
public abstract class BaseHibernateDAO implements IBaseHibernateDAO{
	private static final Logger logger = Logger.getLogger(BaseHibernateDAO.class);
	private Session session;
	private Transaction tx;

	/**
	 * Constructor por defecto
	 */
	public BaseHibernateDAO() {
		session = getSession();
	}

	/**
	 * Recuperación del objeto {@link Session} que mantiene la
	 * sesión con la base de datos
	 */
	public Session getSession(){
		return HibernateSessionFactory.getSession();
	}
	
	/**
	 * Búsqueda por un criterio específico
	 * @param criteria
	 * @return
	 */
	protected List<Object> findByCriteria(Criteria criteria){
		logger.debug("findByCriteria()");
		
		logger.debug("Criterio de búsqueda: " + criteria.toString());
		
		return criteria.list();
	}
	
	/**
	 * Búsqueda de un registro en la tabla empleando su identificador 
	 * (llave primaria)
	 * @param clazz
	 * @param id
	 * @return
	 */
	protected Object findById(Class<?> clazz, Object id){
		logger.debug("findById()");
		Object obj = null;
		startOperation();
		obj = session.load(clazz, (Serializable) id);
		tx.commit();
		return obj;
	}
	
	/**
	 * Recuperación de todos los registros contenidos en la tabla. 
	 * Equivalente a <code>SELECT * FROM tabla</code>
	 * @param clazz
	 * @return
	 */
	protected List<Object> findAll(Class<?> clazz) {
		logger.debug("findAll()");
		Criteria criteria = getSession().createCriteria(clazz);
		return criteria.list();
	}
	
	/**
	 * Guardar el registro representado por el parámetro <code>obj</code> 
	 * en la tabla
	 * @param obj
	 * @throws RuntimeException
	 */
	protected void save(Object obj) throws RuntimeException {
		logger.debug("save()");
		try {
			startOperation();
			session.save(obj);
			tx.commit();
		} catch (HibernateException e) {
			logger.error( e );
			tx.rollback();
			throw new RuntimeException(e);
		} finally {
			logger.debug("Cerrando la conexión");
			session.clear();
			session.close();
		}
	}
	
	/**
	 * Eliminar el registro representado por el parámetro <code>obj</code> 
	 * en la tabla
	 * @param obj
	 * @throws RuntimeException
	 */
	protected void delete(Object obj) throws RuntimeException {
		logger.debug("delete()");
		try {
			startOperation();
			session.delete(obj);
			tx.commit();
		} catch (HibernateException e) {
			logger.error( e );
			tx.rollback();
			throw new RuntimeException(e);
		} finally {
			logger.debug("Cerrando la conexión");
			session.clear();
			session.close();
		}
	}
	
	/**
	 * Actualzación del registro representado por el parámetro 
	 * <code>obj</code>
	 * @param obj
	 * @throws RuntimeException
	 */
	protected void saveOrUpdate(Object obj) throws RuntimeException {
		logger.debug("saveOrUpdate()");
		try {
			startOperation();
			session.saveOrUpdate(obj);
			tx.commit();
		} catch (HibernateException e) {
			logger.error( e );
			tx.rollback();
			throw new RuntimeException(e);
		} finally {
			logger.debug("Cerrando la conexión");
			session.clear();
			session.close();
		}
	}
	
	/**
	 * Guardar el registro representado por el parámetro <code>obj</code> 
	 * en la tabla
	 * @param obj
	 * @throws RuntimeException
	 */
	protected void deleteById(Object obj) throws RuntimeException {
		logger.debug("delete()");
		try {
			startOperation();
			session.delete(obj);
			tx.commit();
		} catch (HibernateException e) {
			logger.error( e );
			tx.rollback();
			throw new RuntimeException(e);
		} finally {
			logger.debug("Cerrando la conexión");
			session.clear();
			session.close();
		}
	}
	
	/**
	 * Ver https://docs.jboss.org/hibernate/orm/3.5/api/org/hibernate/Session.html
	 * @throws HibernateException
	 */
	protected void startOperation() throws HibernateException {
		logger.debug("startOperation()");
        
        tx = session.beginTransaction();
    }

}
