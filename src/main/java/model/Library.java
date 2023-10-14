/**
 * @author Evan Bunnell - ebunnell
 * CIS175 12737 - Fall 2023
 * Sep 13, 2023
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Library {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="TITLE")
	private String title;
	@Column(name="TYPE")
	private String type;
	
	public Library() {
		super();
	}
	
	public Library(String title, String type) {
		super();
		this.title = title;
		this.type = type;
	}

	/**
	 * Getters
	 * @return id
	 * @return store
	 * @return item
	 */
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getType() {
		return type;
	}

	/**
	 * Setters
	 * @param id - identification number
	 * @param title - location purchased
	 * @param type - item purchased
	 */
	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String store) {
		this.title = store;
	}

	public void setType(String item) {
		this.type = item;
	}
	
	public String returnItemDetails() {
		return this.title + ": " + this.type;
	}

}
