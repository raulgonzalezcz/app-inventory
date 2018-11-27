package mx.unam.posgrado.inventory.hibernate;

import java.util.List;
import org.apache.log4j.Logger;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import mx.unam.posgrado.inventory.actions.RegistroAction;

/**
 * Objeto DAO para manipular la información de objetos tipo {@link Libro}
 * @author Gabriel Gonzalez
 *
 */
@SuppressWarnings("unchecked")
public class LibroDAO extends BaseHibernateDAO{
	/**
	 * Query by Example (QBE)
	 * @param libro
	 * @return
	 */
	private static final Logger logger = Logger.getLogger(LibroDAO.class);
	
	public List<Object> getLibrosByExample(Libro libro){
		Example ejemploLibro = Example.create(libro).enableLike();
		Criteria criteriaByExample = getSession().createCriteria(Libro.class).add(ejemploLibro);
		return findByCriteria(criteriaByExample);
	}
	
	public Libro getLibroById(String isbn){
		return (Libro) findById(Libro.class, isbn);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Libro> getAllLibros(){
		return (List<Libro>)(List<?>)findAll(Libro.class);
	}
	
	/**
	 * 
	 * @param titulo
	 * @return
	 */
	public List<Libro> getByTituloExacto(String titulo){
		Criteria criteria = getSession().createCriteria(Libro.class)
				.add( Restrictions.eq("titulo", titulo) );
		
		return (List<Libro>)(List<?>)findByCriteria(criteria);		
	}
	
	public List<Libro> getByTituloAprox(String titulo){
		Criteria criteria = getSession().createCriteria(Libro.class)
				.add( Restrictions.ilike("titulo", titulo, MatchMode.ANYWHERE) );
		
		return (List<Libro>)(List<?>)findByCriteria(criteria);		
	}
	
	public List<Libro> getByTituloLocochon(String titulo, String isbn){
		Criteria criteria = getSession().createCriteria(Libro.class)
				.add( Restrictions.ilike("titulo", titulo, MatchMode.START) )
				.add( Restrictions.ilike("isbn", isbn, MatchMode.ANYWHERE) )
				.setMaxResults(5)
				.addOrder( Order.asc("titulo") );
		return (List<Libro>)(List<?>)findByCriteria(criteria);		
	}
	
	public void saveLibro(Libro libro) {
		logger.info(libro.toString());
		super.save(libro);
	}
}