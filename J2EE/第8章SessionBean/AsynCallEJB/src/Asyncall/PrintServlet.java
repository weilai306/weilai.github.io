package Asyncall;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ejbdemo.asyncall.PrintBean;

public class PrintServlet extends HttpServlet {
   
    @EJB
    PrintBean printBean;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
          
            printBean.printAndForget();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PrintServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>printAndForget executed</h3>");
            Future<String> futureResult = printBean.printAndCheckLater();
            request.getSession().setAttribute("ResultFuture", futureResult);
            String result = "";
            try {
            	if(futureResult.isDone() && !futureResult.isCancelled())
            		result = futureResult.get();           		
            	else
            		result = "Print is not complete!";            			
            } catch (InterruptedException ex) {
                Logger.getLogger(PrintServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(PrintServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("<h3>printAndCheckLater executed - Result: " + result + "</h3>");
            out.println("</body>");
            out.println("</html>");
            
        } finally { 
            out.close();
        }
    } 

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
