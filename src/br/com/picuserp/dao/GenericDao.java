/**
 * 
 */
package br.com.picuserp.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 * @author Victor Sampaio
 *
 */
public class GenericDao <T, ID extends Serializable>{
	

	protected static EntityManagerFactory factory = Persistence
	.createEntityManagerFactory("picusErp");
	
	private final Class<T> persistenceClass;
	
	@SuppressWarnings("unchecked")
	public GenericDao(){
		this.persistenceClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public Class<T> getPersistenceClass(){
		return persistenceClass;
	}
	
	protected final Criteria createCreteriaMethod() {
		EntityManager entityManager = factory.createEntityManager();
		Session session = (Session) entityManager.getDelegate();
		return session.createCriteria(getPersistenceClass());
	}
	
	public Class<T> getObjectClass(){
		return this.persistenceClass;
	}
	
	/**
	 * This method (Include) is a inclusion the new object into DataBase.
	 * Uses 'EntityManager' and 'EntityTransaction' for the interaction with database.  
	 **/
	public T include(T object){
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction includeTransaction = entityManager.getTransaction();
		includeTransaction.begin();
		entityManager.persist(object);
		includeTransaction.commit();
		entityManager.close();
		return object;
	}
	
	public List<T> all(String order){
		EntityManager entityManager = factory.createEntityManager();
		StringBuffer querys = new StringBuffer("SELECT obj FROM" + persistenceClass.getSimpleName()+ "obj");
		if (order != null){
			querys.append("order by" + order);
		}
		Query query = entityManager.createQuery(querys.toString());
		return  query.getResultList();
	}
	
	public T update (T object){
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction updateTransaction = entityManager.getTransaction();
		updateTransaction.begin();
		entityManager.merge(object);
		updateTransaction.commit();
		entityManager.close();
		return null;
	}
	
	public void delete(T object) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction deleteTransaction = entityManager.getTransaction();
		deleteTransaction.begin();
		entityManager.find(getPersistenceClass(), object);
		entityManager.remove(object);
		deleteTransaction.commit();
		entityManager.close();
	}
	
	public void delete(ID id) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction deleteIdTRansaction = entityManager.getTransaction();
		deleteIdTRansaction.begin();
		T object = entityManager.find(getPersistenceClass(), id);; 
		entityManager.remove(object);
		deleteIdTRansaction.commit();
		entityManager.close();
	}
	
	public T searchToId (ID id){
		EntityManager entityManager = factory.createEntityManager();
		return entityManager.find(getPersistenceClass(), id);
		
	}

}
