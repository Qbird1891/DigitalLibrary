/**
 * @author Evan Bunnell - ebunnell
 * CIS175 12737 - Fall 2023
 * Sep 13, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Library;

public class LibraryHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("DigitalLibrary");
	
	public void insertItem(Library li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Library> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Library> allItems = em.createQuery("SELECT i FROM ListItem i").getResultList();
		return allItems;
	}
	
	public void deleteItem(Library toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Library> typedQuery = em.createQuery("select li from ListItem li where li.title = :selectedTitle and li.item = :selectedItem", Library.class);

		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedTitle", toDelete.getTitle());
		typedQuery.setParameter("selectedItem", toDelete.getType());
		
		//one result
		typedQuery.setMaxResults(1);
		
		//get result and save into a new list item
		Library result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * @param idToEdit
	 * @return
	 */
	public Library searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Library found = em.find(Library.class,	idToEdit);
		em.close();
		return found;
	}

	/**
	 * @param toEdit
	 */
	public void updateItem(Library toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();		
	}

	/**
	 * @param titleName
	 * @return
	 */
	public List<Library> searchForItemByTitle(String titleName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Library> typedQuery = em.createQuery("select li from ListItem li where li.title = :selectedTitle", Library.class);
		typedQuery.setParameter("selectedTitle", titleName);
		List<Library> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	/**
	 * @param itemName
	 * @return
	 */
	public List<Library> searchForItemByType(String typeName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Library> typedQuery = em.createQuery("select li from ListItem li where li.item = :selectedItem", Library.class);
		typedQuery.setParameter("selectedItem", typeName);
		List<Library> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
