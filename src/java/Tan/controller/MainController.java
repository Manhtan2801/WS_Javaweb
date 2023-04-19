/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 *
 * @author Acer
 */
public class MainController extends HttpServlet {

    private final String LOGINPAGE = "login.html";
    private final String LOGINCONTROLLER = "LoginController";
    private final String SEARCHCONTROLLER = "SearchController";
    private final String DELETECONTROLLER = "DeleteController";
    private final String UPDATECONTROLLER = "UpdateController";
    private final String NULLCONTROLLER = "NullController";
    private final String ADDITEMSSCONTROLLER = "AdditemsController";
    private final String VIEWCARTPAGE = "viewcart.jsp";
    private final String REMOVEITEMSCONTROLLER = "RemoveItemsController";
    private final String CREATENEWACCOUNTCONTROLLER = "CreateNewAccountController";

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

            String url = LOGINPAGE;
            String button = request.getParameter("btAction");
            if (button == null) {
                url = NULLCONTROLLER;
            } else if (button.equals("Login")) {
                url = LOGINCONTROLLER;
            } else if (button.equals("search")) {
                url = SEARCHCONTROLLER;
            } else if (button.equals("del")) {
                url = DELETECONTROLLER;
            } else if (button.equals("Update")) {
                url = UPDATECONTROLLER;
            } else if (button.equals("Add book to cart")) {
                url = ADDITEMSSCONTROLLER;
            } else if (button.equals("View your cart")) {
                url = VIEWCARTPAGE;
            } else if (button.equals("Remove Selected Items")) {
                url = REMOVEITEMSCONTROLLER;
            } else if (button.equals("Sign up")) {
                url = CREATENEWACCOUNTCONTROLLER;
                
            }

            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);

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
