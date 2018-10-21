package controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegistrationDAO;
import model.User;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /*@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("Checking for name in db");
		String name = request.getParameter("first_name");
		RegistrationDAO.instance.checkFirstName(name);
		request.getRequestDispatcher("Index.jsp").forward(request, response);
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//PrintWriter p = response.getWriter();
		//String name = request.getParameter("name");
		//normally output will be in views
		//p.println("<h3>Hello  " + name + "</h3>");
		//p.close();
			
		//doGet(request, response);
		User user=new User();
		user.setFirstName(request.getParameter("first_name"));
		user.setLastName(request.getParameter("last_name"));
		user.setUsername(request.getParameter("user_name"));
		user.setPassword(request.getParameter("password"));
		user.setMobile_no(request.getParameter("mobile_no"));
		
		RegistrationDAO registrationdao=new RegistrationDAO();
		User username=registrationdao.getUserByUserName(request.getParameter("user_name"));
		if(username==null) {
			
		registrationdao.saveUser(user);
		
		request.getRequestDispatcher("Success.jsp").forward(request, response);
	}else {
		request.getRequestDispatcher("failure.jsp").forward(request, response);
	}

}}



