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
 * Servlet implementation class LookUpServlet
 */
@WebServlet("/lookup")
public class LookUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LookUpServlet() {
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

		String rst = "";
		try {
			rst = (String) ctx.lookup(bind_name);
		} catch (javax.naming.NameNotFoundException e) {
			// TODO Auto-generated catch block
			msg = "未找到bind_name";
			e.printStackTrace();
		} catch (NamingException e) {
			msg = "JNDI异常";
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String find_name = bind_name;
		request.setAttribute("find_name", find_name);
		request.setAttribute("find_value", rst);
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/JNDIOP.jsp").forward(request, response);

	}

}
