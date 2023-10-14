package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LibraryDetails;
import model.Library;
import model.LibraryOwner;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewLibraryServlet")
public class CreateNewLibraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateNewLibraryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		LibraryHelper lih = new LibraryHelper();
		String libraryName = request.getParameter("libraryName");
		System.out.println("Library Name: " + libraryName);
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String libraryOwnerName = request.getParameter("libraryOwnerName");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		String[] selectedItems = request.getParameterValues("allItemsToAdd");
		List<Library> selectedItemsInLibrary = new ArrayList<Library>();
		// make sure something was selected – otherwise we get a null pointer exception
		if (selectedItems != null && selectedItems.length > 0) {
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				Library c = lih.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedItemsInLibrary.add(c);
			}
		}
		LibraryOwner owner = new LibraryOwner(libraryOwnerName);
		LibraryDetails sld = new LibraryDetails(libraryName, ld, owner);
		sld.setListOfItems(selectedItemsInLibrary);
		LibraryDetailsHelper slh = new LibraryDetailsHelper();
		slh.insertNewLibraryDetails(sld);
		System.out.println("Success!");
		System.out.println(sld.toString());
		getServletContext().getRequestDispatcher("/viewAllLibrariesServlet").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
