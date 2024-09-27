package Dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Util.Utils;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class GenericDao<T, ID extends Serializable> implements IGenericDao<T, ID> {

	SessionFactory sessionFactory;

	public GenericDao() {
		this.sessionFactory = Utils.getSessionFactory();
	}

	public void Insert(T entity) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();
			session.persist(entity);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			if (session != null && session.getTransaction() != null) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				session.getTransaction().rollback();
			}
			e.printStackTrace();

		}
	}

	public T get(ID id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();
			T entity = (T) session.get(getEntityClass(), id);
			session.getTransaction().commit();
			return entity;
		} catch (HibernateException e) {
			e.printStackTrace();
			if (session != null && session.getTransaction() != null) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				session.getTransaction().rollback();
			}
			e.printStackTrace();

		}
		return null;
	}

	public void delete(ID id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			T entity = (T) session.get(getEntityClass(), id);
			session.remove(entity);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (session != null && session.getTransaction() != null) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				session.getTransaction().rollback();
			}
			e.printStackTrace();

		}
	}

	List<T> findAll() {
		Session session = sessionFactory.getCurrentSession();

		try {
			// TODO Auto-generated method stub
			// session.beginTransaction();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<T> cr = cb.createQuery(getEntityClass());
			Root<T> root = cr.from(getEntityClass());
			cr.select(root);

			TypedQuery<T> query = session.createQuery(cr);
			List<T> entities = query.getResultList();

			// session.getTransaction().commit();
			return entities;
		} catch (HibernateException e) {
			e.printStackTrace();
			if (session != null && session.getTransaction() != null) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Class<T> getEntityClass() {
		// TODO Auto-generated method stub
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void Update(T entity) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();
			// session.saveOrUpdate(entity);
			session.merge(entity);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			if (session != null && session.getTransaction() != null) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				session.getTransaction().rollback();
			}
			e.printStackTrace();

		}
	}

	public List<T> listar() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();

		List<T> entities;

		try {
			session.beginTransaction();
			entities = this.findAll();
			session.getTransaction().commit();

			return entities;
		} catch (HibernateException e) {
			e.printStackTrace();
			if (session != null && session.getTransaction() != null) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				session.getTransaction().rollback();
			}
			e.printStackTrace();

		}

		return null;

	}

}
