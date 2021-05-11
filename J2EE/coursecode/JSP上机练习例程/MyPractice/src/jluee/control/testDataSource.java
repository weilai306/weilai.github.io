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

/**
 * Servlet implementation class testDataSource
 */
@WebServlet("/testDataSource")
public class testDataSource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testDataSource() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String uname = "weilai";
		String pwd = "weilai";
		if (uname != null && pwd != null && !uname.equals("") && !pwd.equals("")) {
			UserBiz biz = new UserBiz();
			try {
				User user = biz.login(uname, pwd);
				if (user != null) {
					response.getWriter().append(user.getRole());
				} else {
					response.getWriter().append("login error");
				}
			} catch (Exception e) {
				e.printStackTrace();
				Log.logger.error(e.getMessage());
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
