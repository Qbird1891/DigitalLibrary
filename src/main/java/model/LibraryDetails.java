/**
 * @author Evan Bunnell - ebunnell
 * CIS175 12737 - Fall 2023
 * Oct 4, 2023
 */
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class LibraryDetails {
	@Id
	@GeneratedValue
	private int id;
	private String libraryName;
	private LocalDate libraryDate;
	@ManyToOne
	private LibraryOwner ownerName;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Library> listOfItems;
	
	public LibraryDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LibraryDetails(int id, String libraryName, LocalDate libraryDate, LibraryOwner ownerName, List<Library> listOfItems) {
		//omitted for space but set them in your code 
	}
	
	public LibraryDetails(String libraryName, LocalDate libraryDate, LibraryOwner ownerName, List<Library> listOfItems) {
		//omitted for space but set them in your code 
	}
	
	public LibraryDetails(String libraryName, LocalDate libraryDate,
		LibraryOwner ownerName) {
		//omitted for space but set them in your code
	}
	
	//Getters
	public int getId() {
		return id;
	}
	public String getLibraryName() {
		return libraryName;
	}
	public LocalDate getLibraryDate() {
		return libraryDate;
	}
	public LibraryOwner getOwnerName() {
		return ownerName;
	}
	public List<Library> getListOfItems() {
		return listOfItems;
	}
	
	//Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	public void setLibraryDate(LocalDate libraryDate) {
		this.libraryDate = libraryDate;
	}
	public void setOwnerName(LibraryOwner ownerName) {
		this.ownerName = ownerName;
	}
	public void setListOfItems(List<Library> listOfItems) {
		this.listOfItems = listOfItems;
	}
	
	
}