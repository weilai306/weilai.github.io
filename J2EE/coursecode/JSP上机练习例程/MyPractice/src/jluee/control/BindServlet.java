package jluee.control;

import java.io.IOException;

import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BindServlet
 */
@WebServlet("/bind")
public class BindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * jboss/exported/Myschool
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public BindServlet() {
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

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Context ctx = null;
		try {
			ctx = new InitialContext();
			System.out.println("ini1");
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Context ctx=(Context)session.getAttribute("context");

		String bind_name = (String) request.getParameter("bind_name");
		String bind_value = (String) request.getParameter("bind_value");
		String msg = "";

		try {
			ctx.bind(bind_name, bind_value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			msg = "²Ù×÷Ê§°Ü£¬JNDIÒì³£";
			e.printStackTrace();
		}

		String find_name = bind_name;
		String find_value = bind_value;

		request.setAttribute("find_name", find_name);
		request.setAttribute("find_value", find_value);
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/JNDIOP.jsp").forward(request, response);
	}

}
