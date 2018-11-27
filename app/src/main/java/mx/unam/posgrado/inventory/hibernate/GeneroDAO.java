package mx.unam.posgrado.inventory.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 * Objeto DAO para manipular la información de objetos tipo {@link Genero}
 * @author Gabriel Gonzalez
 *
 */
@SuppressWarnings("unchecked")
public class GeneroDAO extends BaseHibernateDAO{
	/**
	 * Búsqueda de generos por la llave primaria
	 * @param id
	 * @return
	 */
	public Genero findById(short id) {
		return (Genero) findById(Genero.class, id);
	}
	
	/**
	 * Listado de todos los generos almacenados en la tabla
	 * @return
	 */
	public List<Genero> getAllGeneros(){
		return (List<Genero>)(List<?>)findAll(Genero.class);
	}
	
	/**
	 * 
	 * @param nombre
	 * @return
	 */
	public List<Genero> getIdGeneroPorNombre(String nombre){
		Criteria criteria = getSession().createCriteria(Genero.class)
				.add( Restrictions.ilike("nombre", nombre, MatchMode.ANYWHERE) )
				.setProjection( Projections.property("id") );
		return (List<Genero>)(List<?>)findByCriteria(criteria);
	}
}