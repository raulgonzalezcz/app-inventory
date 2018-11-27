package mx.unam.posgrado.inventory.hibernate;

import java.util.List;

@SuppressWarnings("unchecked")
public class PublicacionDAO extends BaseHibernateDAO{
	public List<Publicacion> getAllPublicaciones(){
		return (List<Publicacion>)(List<?>)findAll(Publicacion.class);
	}	
}