package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.LibraryHelper;
import models.Library;

/**
 * Servlet implementation class insertTitle
 */
@WebServlet("/insertTitle")
public class insertTitle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertTitle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LibraryOwner l = new LibraryOwner();
		LibraryOwnerHelper helper = new LibraryOwnerHelper();
		l.setTitle(request.getParameter("title"));
		l.setType(request.getParameter("type"));
		helper.insertTitle(l);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
