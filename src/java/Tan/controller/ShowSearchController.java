/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tan.controller;

import Tan.registration.RegistrationDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Acer
 */
public class ShowSearchController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShowSearchController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Seach value </h1>");

            String searchvalue = request.getParameter("txtSearchvalue");
            out.println("your search value is " + searchvalue);
            List<RegistrationDTO> result = (List<RegistrationDTO>) request.getAttribute("SEARCHVALUE");
            if (result != null) {
                out.println("<table border='1'>");
                out.println("<thead>");
                out.println("<tr>");
                out.println("<th>No.</th>");
                out.println("<th>Usename</th>");
                out.println("<th>Password</th>");
                out.println("<th>Lastname</th>");
                out.println("<th>Role</th>");
                out.println("<th>Delete</th>");
                out.println("<th>Update</th>");
                out.println("</tr>");
                out.println("</thead>");
                int count = 0;

                for (RegistrationDTO dto : result) {
                    out.println("<form action='MainController'>");
                    out.println("<tbody>");
                    out.println("<tr>");
                    out.println("<td>"
                            + ++count
                            + "</td>");
                    out.println("<td>"
                            + dto.getUsername()
                            + "<input type='hidden' name='txtUsername' value='"
                            + dto.getUsername()
                            + "' />"
                            + "</td>");
                    out.println("<td>"
                            + "<input type='text' name='txtPassword' value='"
                            + dto.getPassword()
                            + "' />"
                            + "</td>");
                    out.println("<td>"
                            + "<input type='text' name='txtLastname' value='"
                            + dto.getLastname()
                            + "' />"
                            + "</td>");
                    if (dto.isIsAdmin()) {
                        out.println("<td>"
                                + "<input type='checkbox' name='chkAdmin' value='ADMIN' checked='checked' />"
                                + "</td>");
                    } else {
                        out.println("<td>"
                                + "<input type='checkbox' name='chkAdmin' value='ADMIN' />"
                                + "</td>");
                    }

                    String urlRewriting = "MainController?btAction=del&pk="
                            + dto.getUsername() + "&lastSearchValue=" + searchvalue;
                    out.println("<td>"
                            + "<a href='"
                            + urlRewriting
                            + "'>Delete</a>\n"
                            + "</td>");
                    out.println("<td>"
                            + "<input type='submit' value='Update' name='btAction' />"
                            + "<input type='hidden' name='lastsearchvalue' value='"
                            + searchvalue
                            + "' />"
                            + "</td>");
                    out.println("</tr>");
                
                out.println("</form>");
            }

            } else {
                out.println("</br> No record is matched");
            }
            out.println("</tbody>");
            out.println("</table>");

            out.println("</body>");
            out.println("</html>");
        }
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
