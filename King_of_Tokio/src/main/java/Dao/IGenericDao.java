package Dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T, ID extends Serializable> {
	void Insert(T entity);
	T get(ID id);
	void delete(ID id);
	//List<T> findAll();
	public Class<T> getEntityClass();	
	public void Update(T entity);
	public List<T> listar();
}
