package org.samples.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.samples.controller.UserRoleFacadeLocal;
import org.samples.entities.UserRole;


@WebServlet(name = "AddUserRole", urlPatterns = {"/AddUserRole"})
public class AddUserRole extends HttpServlet {

   @EJB
    private UserRoleFacadeLocal facadeLocal;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            UserRole o = new UserRole();
            String _user = request.getParameter("user");
            String _role = request.getParameter("role");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();                     
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListUser</title>");            
            out.println("</head>");
            out.println("<body>");
            if (_user == null || _role == null){
                out.println("<h1>Adicione um usuário para uma regra. Ex: ?user=1&role=2</h1>");
            }else{
                o.setRoleId(Long.parseLong(_role));
                o.setUserId(Long.parseLong(_user));
                out.println("<h1>Adicionando regra " + o.getRoleId() + " para o usuário " + o.getUserId()+ "</h1>");
                facadeLocal.salvar(o);            
            }            
            out.println("</body>");
            out.println("</html>");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
