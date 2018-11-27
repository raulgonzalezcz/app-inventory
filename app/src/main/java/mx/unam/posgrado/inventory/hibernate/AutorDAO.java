package mx.unam.posgrado.inventory.hibernate;

import java.util.List;

@SuppressWarnings("unchecked")
public class AutorDAO extends BaseHibernateDAO{
	public List<Autor> getAllAutores(){
		return (List<Autor>)(List<?>)findAll(Autor.class);
	}
}