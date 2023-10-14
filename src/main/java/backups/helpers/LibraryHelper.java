package helpers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import models.Library;

/**
 * @author Itsal - Quinn Birdsley
 * @author Evan Bunnell - ebunnell
 * CIS175 - Fall 2023 
 * Oct 11, 2023
 */
public class LibraryHelper {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("DigitalLibrary");

	public void insertTitle(LibraryOwner model) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(model);
		manager.getTransaction().commit();
		manager.close();
	}

	// deleting title
	public void deleteTitle(LibraryOwner model) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.remove(manager.find(LibraryOwner.class, model.getId()));
		manager.getTransaction().commit();
		manager.close();
	}

	// updating an entry
	public void update(LibraryOwner model) {
		EntityManager manager = factory.createEntityManager();
		LibraryOwner dbEntity = manager.find(LibraryOwner.class, model.getId());
		dbEntity.setId(model.getId());
		dbEntity.setTitle(model.getTitle());
		dbEntity.setType(model.getType());
		manager.getTransaction().commit();
		manager.close();
	}

	// returns all titles
	public List<LibraryOwner> showAllTitles() {
		EntityManager manager = factory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<LibraryOwner> allTitles = manager.createQuery("SELECT i FROM DigitalLibrary i").getResultList();
		manager.close();
		return allTitles;
	}

	// search by id number
	public LibraryOwner searchForItemById(int id) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<LibraryOwner> query = manager.createQuery("SELECT i FROM DigitalLibrary AS i WHERE i.id = :id",
				LibraryOwner.class);
		query.setParameter("id", id);
		LibraryOwner dbEntity = query.getSingleResult();
		return dbEntity;
	}

	// search by title
	public LibraryOwner searchForItemByTitle(String title) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<LibraryOwner> query = manager.createQuery("SELECT i FROM DigitalLibrary AS i WHERE i.title = :title",
				LibraryOwner.class);
		query.setParameter("title", title);
		LibraryOwner dbEntity = query.getSingleResult();
		return dbEntity;
	}

	// search by type
	public LibraryOwner searchForItemByType(String type) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<LibraryOwner> query = manager.createQuery("SELECT i FROM DigitalLibrary AS i WHERE i.type = :type",
				LibraryOwner.class);
		query.setParameter("type", type);
		LibraryOwner dbEntity = query.getSingleResult();
		return dbEntity;
	}
}
