/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author Ryosuke
 */
public class DbTask1 extends HttpServlet {

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
            out.println("<title>Servlet DbTask1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DbTask1 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            Connection conn = null;
            String url = "jdbc:mysql://localhost/challenge_db";
            String user = "GEEKJOB";
            String password = "geekjob";
            
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                out.print("ドライバのロードに成功しました<br>");
                  
                conn = DriverManager.getConnection(url, user, password);
                out.print("データベース接続に成功しました<br>");
                
            }catch (ClassNotFoundException e){
                out.print("ClassNotFoundException:"+e.getMessage());
            }catch (SQLException e){
                out.print("SQLException:"+e.getMessage());
            }catch (Exception e){
                out.print("Exception:"+e.getMessage());
            }finally{
                try{
                    if(conn != null){
                          conn.close();
                          out.print("データべース切断に成功しました");
                    } else {
                        out.print("コネクションがありません");
                    }
                }catch(SQLException e){
                    out.print("SQLException:"+e.getMessage());
                }
            }
            
            
            
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
