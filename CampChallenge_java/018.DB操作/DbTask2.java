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
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Ryosuke
 */
public class DbTask2 extends HttpServlet {

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
            out.println("<title>Servlet DbTask2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DbTask2 at " + request.getContextPath() + "</h1>");
            
            
            Connection conn = null;
            String url = "jdbc:mysql://localhost/challenge_db";
            String user = "GEEKJOB";
            String password = "geekjob";
            
            try{
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                date = sdf.parse("2000-12-24");
                java.sql.Date date2 = new java.sql.Date(date.getTime());
                
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection(url, user, password);
                
                PreparedStatement db_st = null;
                String sql = "insert into profiles values(?, ?, ?, ?, ?);";
                
                db_st = conn.prepareStatement(sql);
                db_st.setInt(1, 3);
                db_st.setString(2, "鈴木 実");
                db_st.setString(3, "080-5566-7788");
                db_st.setInt(4, 24);
                db_st.setDate(5, date2);
                
                int num = db_st.executeUpdate();
                
                db_st.close();
                                          
            } catch (ClassNotFoundException e){
                out.print("ClassNotFoundException:"+e.getMessage());
            } catch (SQLException e){
                out.print("SQLExcepiton:"+e.getMessage());
            } catch (Exception e){
                out.print("Exception:"+e.getMessage());
            } finally {
                try{
                    if(conn != null){
                        conn.close();
                    }
                } catch(SQLException e){
                    out.print("SQLException:"+e.getMessage());
                }
            }
            
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
