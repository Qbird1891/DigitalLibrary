/**
 * @author Evan Bunnell - ebunnell
 * CIS175 12737 - Fall 2023
 * Oct 4, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.LibraryOwner;

public class LibraryOwnerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("DigitalLibrary");

	public void insertOwner(LibraryOwner s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}

	public List<LibraryOwner> showAllOwners() {
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<LibraryOwner> allOwners = em.createQuery("SELECT o FROM Owner o").getResultList();
		return allOwners;
	}

	public LibraryOwner findOwner(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<LibraryOwner> typedQuery = em
				.createQuery("select ow from Owner ow where ow.ownerName = :selectedName", LibraryOwner.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		LibraryOwner foundOwner;
		try {
			foundOwner = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundOwner = new LibraryOwner(nameToLookUp);
		}
		em.close();
		return foundOwner;
	}
}
