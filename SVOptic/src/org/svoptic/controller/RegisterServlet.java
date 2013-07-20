package org.svoptic.controller;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.svoptic.dto.UserDetail;
import org.svoptic.service.RegisterService;



/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String company = request.getParameter("company");
        String firstAddr = request.getParameter("firstAddr");
        String secondAddr = request.getParameter("secondAddr");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String province = request.getParameter("province");
        String postalCode = request.getParameter("postalCode");
        String phone = request.getParameter("phone");
        String FAX = request.getParameter("FAX");
        String Email = request.getParameter("Email");
        String rank = request.getParameter("rank");
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        String confirmPassword = request.getParameter("confirmPassword");
        
        
        
        UserDetail userDetail = new UserDetail( firstName, lastName, company, firstAddr, secondAddr, city, country, province, postalCode, phone, FAX, Email, rank, userName, passWord, null);
                
       try {        
            RegisterService registerService = new RegisterService();
            boolean result = registerService.register(userDetail , confirmPassword);
            HttpSession session = request.getSession();
            session.setAttribute("registerService", registerService);
            session.setAttribute("userDetail", userDetail);
            String address = null;
            out.println("<html>");
            out.println("<head>");            
            out.println("<title>Registration Successful</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            if(result){
                out.println("<h1>Registration Successful</h1>");
                out.println("To login with new UserId and Password<a href=login.jsp>Click here</a>");
                address = "success.jsp";
            }else{
                out.println("<h1>Registration Unsuccessful</h1>");
                out.println("To try again<a href=Register.jsp>Click here</a>");
                address = "retry.jsp" ;
                RequestDispatcher dispathcer = request.getRequestDispatcher(address);
                dispathcer.forward(request, response);
            }
            out.println("</center>");
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


}
