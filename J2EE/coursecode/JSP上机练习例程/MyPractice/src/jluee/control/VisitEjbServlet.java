package jluee.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jee.ejb.singleton.remote.*;
import jee.ejb.stateful.remote.*;
import jee.ejb.stateless.local.*;
/**
 * Servlet implementation class VisitEjbServlet
 */
@WebServlet("/VisitEjbServlet")
public class VisitEjbServlet extends HttpServlet {
	@EJB private SimpleSingletonBeanRemote singletonBeanRemote;
	@EJB private MulBy2Remote mulBt2Remote;
	@EJB private CallerBeanRemote callerBeanRemote;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitEjbServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer=response.getWriter();
		//writer.append("µ¥Àý:\n");
		writer.append(Integer.toString(singletonBeanRemote.getValue())+" ");
		singletonBeanRemote.change01();
		writer.append(Integer.toString(singletonBeanRemote.getValue())+" ");
		
		//writer.append("ÓÐ×´Ì¬:\n");
		writer.append(Integer.toString(mulBt2Remote.mul())+" ");
		writer.append(Integer.toString(mulBt2Remote.mul())+" ");
		
		//writer.append("ÎÞ×´Ì¬:\n");
		writer.append(callerBeanRemote.callEJBOne(1000, 2000));
	}

}
