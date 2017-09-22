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
public class DbTask11 extends HttpServlet {

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
            out.println("<title>Servlet DbTask11</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DbTask11 at " + request.getContextPath() + "</h1>");
            
            request.setCharacterEncoding("UTF-8");
            
            int id = Integer.parseInt(request.getParameter("Id"));
            String name = request.getParameter("Name");
            String tel = request.getParameter("Tel");
            int age = Integer.parseInt(request.getParameter("Age"));

            Connection conn = null;
            String url = "jdbc:mysql://localhost/challenge_db";
            String user = "GEEKJOB";
            String password = "geekjob";
            
            try{
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                date = sdf.parse(request.getParameter("Birthday"));
                java.sql.Date date2 = new java.sql.Date(date.getTime());
                
                out.print("ID:"+id+", name:"+name+", tel:"+tel+", age:"+age+", birthday:"+date2+"<br>");
                
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection(url, user, password);
                
                PreparedStatement db_st = null;
                String sql = "update profiles set name=?, tel=?, age=?, birthday=? where profilesID=?;";
                
                db_st = conn.prepareStatement(sql);
                db_st.setString(1, name);
                db_st.setString(2, tel);
                db_st.setInt(3, age);
                db_st.setDate(4, date2);
                db_st.setInt(5, id);
                
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
            
            out.println("<a href=DbTask11.jsp>戻る</a>");
            
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
