/**
 * @author Evan Bunnell - ebunnell
 * CIS175 12737 - Fall 2023
 * Oct 4, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.LibraryDetails;

public class LibraryDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("DigitalLibrary");

	public void insertNewLibraryDetails(LibraryDetails l) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.close();
	}

	public List<LibraryDetails> getLists() {
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<LibraryDetails> allDetails = em.createQuery("SELECT d FROM LibraryDetails d").getResultList();
		return allDetails;
	}

	public void deleteList(LibraryDetails toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<LibraryDetails> typedQuery = em
				.createQuery("select detail from LibraryDetails detail where detail.id = :selectedId", LibraryDetails.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", toDelete.getId());
		// we only want one result
		typedQuery.setMaxResults(1);
		// get the result and save it into a new list item
		LibraryDetails result = typedQuery.getSingleResult();
		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public LibraryDetails searchForListDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		LibraryDetails found = em.find(LibraryDetails.class, tempId);
		em.close();
		return found;
	}

	public void updateList(LibraryDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
