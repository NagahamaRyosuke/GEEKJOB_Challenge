/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ryosuke
 */
public class InventoryControlLogin extends HttpServlet {

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
            out.println("<title>Servlet InventoryControlLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InventoryControlLogin at " + request.getContextPath() + "</h1>");
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
//        processRequest(request, response);
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        
        String name = request.getParameter("Name");
        String password = request.getParameter("Password");
        
        String url = "jdbc:mysql://localhost/Inventory_Control";
        String user = "GEEKJOB";
        String pass = "geekjob";
        String sql,user_name,user_pass;
        int flag = 0;
            
        Connection conn = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, user, pass);

            PreparedStatement db_st = null;
            ResultSet rs = null;
            sql = "select * from user where name =? and password =?";

            db_st = conn.prepareStatement(sql);
            db_st.setString(1, name);
            db_st.setString(2, password);
            rs = db_st.executeQuery();

            while(rs.next()){
                user_name = rs.getString("name");
                user_pass = rs.getString("password");
                
                if(name.equals(user_name) && password.equals(user_pass)){
                    flag = 1;
                }
            }
            rs.close();
            db_st.close();
            } catch(ClassNotFoundException e){
                out.println("ClassNotFoundException:"+e.getMessage());
            } catch(SQLException e){
                out.println("SQLException:"+e.getMessage());
            } catch(Exception e){
                out.println("Exception:"+e.getMessage());
            } finally {
                try{
                    conn.close();
                } catch(SQLException e){
                    out.println("Exception:"+e.getMessage());
                }
            }
        
        if(flag == 1){
            response.sendRedirect("InventoryControl.jsp");
        }else{
            response.sendRedirect("InventoryControlLogin.jsp");
        }
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
