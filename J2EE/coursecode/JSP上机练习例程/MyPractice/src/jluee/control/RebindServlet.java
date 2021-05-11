package jluee.control;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RebindServlet
 */
@WebServlet("/rebind")
public class RebindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RebindServlet() {
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
		// doGet(request, response);
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

		String bind_name = (String) request.getParameter("bind_name");
		String bind_value = (String) request.getParameter("bind_value");
		String msg = "操作成功";

		try {
			ctx.rebind(bind_name, bind_value);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			msg = "操作失败，JNDI异常";
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
