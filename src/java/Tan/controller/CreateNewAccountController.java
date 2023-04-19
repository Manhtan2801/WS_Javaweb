/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tan.controller;

import Tan.registration.RegistrationDAO;
import Tan.registration.RegistrationInsertError;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Acer
 */
public class CreateNewAccountController extends HttpServlet {

    //private final String CREATENEWACCOUNT = "createnewaccount.html";
    private final String LOGINPAGE = "login.html";
    private final String CREATENEWACCOUNTJSP = "createnewaccount.jsp";

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
        PrintWriter out = response.getWriter();

        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");
        String fullname = request.getParameter("txtFullname");

        boolean bErr = false;
        RegistrationInsertError err = new RegistrationInsertError();
        String url = CREATENEWACCOUNTJSP;

        try {
            if (username.trim().length() < 3 || username.trim().length() > 12) {
                bErr = true;
                err.setUsernameLengthErr("Username phai co kich thuoc thu 3 den 12 ky tu");
            }
            if (password.trim().length() < 3 || password.trim().length() > 12) {
                bErr = true;
                err.setPasswordLengthErr("Password  phai co kich thuoc thu 3 den 12 ky tu");
            } else if (!confirm.trim().equals(password.trim())) {
                bErr = true;
                err.setconfirmNotMatch("confirm phai giong password ");
            }
            if (fullname.trim().length() < 2 || fullname.trim().length() > 40) {
                bErr = true;
                err.setFullnameLengthErr("Fullname phai co kich thuoc thu 2 den 40 ky tu");
            }
            if (bErr) {
                request.setAttribute("INSERTERRS", err);
            } else {
                RegistrationDAO dao = new RegistrationDAO();
                boolean result = dao.insertrecord(username, password, fullname, false);

                if (result) {
                    url = LOGINPAGE;
                }
            }

        } catch (SQLException ex) {
            log(("CreateNewAccountController_SQL" + ex.getMessage()));
            err.setUsernameisExisted(username + " da ton tai");
            request.setAttribute("INSERTERRS", err);
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
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
