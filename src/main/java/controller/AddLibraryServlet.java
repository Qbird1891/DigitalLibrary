package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Library;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/addLibraryServlet")
public class AddLibraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLibraryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String type = request.getParameter("type");
		
		Library li = new Library(title, type);
		LibraryHelper dao = new LibraryHelper();
		dao.insertItem(li);

		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
