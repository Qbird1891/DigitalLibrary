package helpers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import models.Library;

/**
 * @author Itsal - Quinn Birdsley
 * @author Evan Burnell CIS175 - Fall 2023 Oct 11, 2023
 */
public class LibraryHelper {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("DigitalLibrary");

	public void insertTitle(Library model) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(model);
		manager.getTransaction().commit();
		manager.close();
	}

	// deleting title
	public void deleteTitle(Library model) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.remove(manager.find(Library.class, model.getId()));
		manager.getTransaction().commit();
		manager.close();
	}

	// updating an entry
	public void update(Library model) {
		EntityManager manager = factory.createEntityManager();
		Library dbEntity = manager.find(Library.class, model.getId());
		dbEntity.setId(model.getId());
		dbEntity.setTitle(model.getTitle());
		dbEntity.setType(model.getType());
		manager.getTransaction().commit();
		manager.close();
	}

	// returns all titles
	public List<Library> showAllTitles() {
		EntityManager manager = factory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Library> allTitles = manager.createQuery("SELECT i FROM DigitalLibrary i").getResultList();
		manager.close();
		return allTitles;
	}

	// search by id number
	public Library searchForItemById(int id) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Library> query = manager.createQuery("SELECT i FROM DigitalLibrary AS i WHERE i.id = :id",
				Library.class);
		query.setParameter("id", id);
		Library dbEntity = query.getSingleResult();
		return dbEntity;
	}

	// search by title
	public Library searchForItemByTitle(String title) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Library> query = manager.createQuery("SELECT i FROM DigitalLibrary AS i WHERE i.title = :title",
				Library.class);
		query.setParameter("title", title);
		Library dbEntity = query.getSingleResult();
		return dbEntity;
	}

	// search by type
	public Library searchForItemByType(String type) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Library> query = manager.createQuery("SELECT i FROM DigitalLibrary AS i WHERE i.type = :type",
				Library.class);
		query.setParameter("type", type);
		Library dbEntity = query.getSingleResult();
		return dbEntity;
	}
}
