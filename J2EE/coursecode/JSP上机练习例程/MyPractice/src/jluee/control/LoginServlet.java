package jluee.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jluee.biz.UserBiz;
import jluee.entity.User;
import jluee.util.Log;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
		System.out.println("LoginServlet构造函数");
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
		System.out.println("destroy---");
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		if (uname != null && pwd != null && !uname.equals("") && !pwd.equals("")) {
			UserBiz biz = new UserBiz();
			try {
				User user = biz.login(uname, pwd);
				if (user != null) {
					request.getSession().setAttribute("user", user);
					request.getRequestDispatcher("main").forward(request, response);
				} else {
					request.setAttribute("msg", "用户名或密码不正确");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				Log.logger.error(e.getMessage());
				request.setAttribute("errMsg", e.getMessage());
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("msg", "用户名或密码不能为空");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		super.init();
		System.out.println("init----");
	}

}
