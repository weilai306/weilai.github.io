package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TestEJBServlet extends HttpServlet {

//引用EJB
	@EJB 
	private ejbdemo.nointerface.NoInterfaceHelloBean hello;
	
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {

		this.doPost(arg0,arg1); 
                                                                                            
	}

    public void doPost(HttpServletRequest request, HttpServletResponse response){
    	 PrintWriter out=null;
         try{
//         	开始打印        	
         	response.setContentType("text/html;charset=UTF-8");
            out = response.getWriter();
           
              
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet call nointerfaceEJB</title>");  
                out.println("</head>");
                out.println("<body>");           
                String result = "";
                result = hello.sayHello("Jilin University");
                              
                out.println("<h3>nointerface executed - Result: " + result + "</h3>");
                out.println("</body>");
                out.println("</html>");             
             
			

		} catch(Exception e){

			e.printStackTrace();

		}

         finally { 
             out.close();
         }


          }

}
