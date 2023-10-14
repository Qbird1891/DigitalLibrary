/**
 * @author Evan Bunnell - ebunnell
 * CIS175 12737 - Fall 2023
 * Oct 4, 2023
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shopper")
public class LibraryOwner {
	@Id
	@GeneratedValue
	private int id;
	private String ownerName;

	public LibraryOwner() {
		super();
		//TODO Auto-generated constructor stub
	}

	public LibraryOwner(int id, String ownerName) {
		super();
		this.id = id;
		this.ownerName = ownerName;
	}

	public LibraryOwner(String ownerName) {
		super();
		this.ownerName = ownerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	@Override
	public String toString() {
		return "Shopper [id=" + id + ", ownerName=" + ownerName + "]";
	}
}