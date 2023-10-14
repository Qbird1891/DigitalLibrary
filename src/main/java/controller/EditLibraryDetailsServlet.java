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
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editLibraryDetailsServlet")
public class EditLibraryDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditLibraryDetailsServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		LibraryDetailsHelper dao = new LibraryDetailsHelper();
		LibraryHelper lih = new LibraryHelper();
		LibraryOwnerHelper sh = new LibraryOwnerHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		LibraryDetails libraryToUpdate = dao.searchForListDetailsById(tempId);
		String newLibraryName = request.getParameter("libraryName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String libraryOwnerName = request.getParameter("libraryOwnerName");
		// find our add the new shopper
		LibraryOwner newOwner = sh.findOwner(libraryOwnerName);
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		try {
			// items are selected in list to add
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<Library> selectedItemsInLibrary = new ArrayList<Library>();
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				Library c = lih.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedItemsInLibrary.add(c);
			}
			libraryToUpdate.setListOfItems(selectedItemsInLibrary);
		} catch (NullPointerException ex) {
			// no items selected in list - set to an empty list
			List<Library> selectedItemsInLibrary = new ArrayList<Library>();
			libraryToUpdate.setListOfItems(selectedItemsInLibrary);
		}
		libraryToUpdate.setLibraryName(newLibraryName);
		libraryToUpdate.setLibraryDate(ld);
		libraryToUpdate.setOwnerName(newOwner);
		dao.updateList(libraryToUpdate);
		getServletContext().getRequestDispatcher("/viewAllLibrariesServlet").forward(request, response);
	}

}
