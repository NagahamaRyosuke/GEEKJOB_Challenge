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
import java.text.SimpleDateFormat;

/**
 *
 * @author Ryosuke
 */
public class DbTask7 extends HttpServlet {

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
            out.println("<title>Servlet DbTask7</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DbTask7 at " + request.getContextPath() + "</h1>");
            
            Connection conn = null;
            String url = "jdbc:mysql://localhost/challenge_db";
            String user = "GEEKJOB";
            String pass = "geekjob";
            
            try{
                java.util.Date date = new java.util.Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                date = sdf.parse("1967-11-06");
                java.sql.Date date2 = new java.sql.Date(date.getTime());
                
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection(url, user, pass);
                
                PreparedStatement db_st = null;
                ResultSet rs = null;
                
                String sql = "update profiles set name=?, age=?, birthday=? where profilesID=?";
                String sql2 = "select * from profiles";
                
                db_st = conn.prepareStatement(sql);
                db_st.setString(1, "松岡 修造");
                db_st.setInt(2, 48);
                db_st.setDate(3, date2);
                db_st.setInt(4, 1);
                int num = db_st.executeUpdate();
                
                db_st = conn.prepareStatement(sql2);
                rs = db_st.executeQuery();
                
                while(rs.next()){
                    int id = rs.getInt("profilesID");
                    String name = rs.getString("name");
                    String tel = rs.getString("tel");
                    int age = rs.getInt("age");
                    java.util.Date date3 = (java.sql.Date) rs.getDate("birthday");
                    out.print("ID:"+id+", name:"+name+", tel:"+tel+", age:"+age+", birthday:"+date3+"<br>");
                }
                
                db_st.close();
                rs.close();
            } catch(ClassNotFoundException e){
                out.print("ClassNotFoundException:"+e.getMessage());
            } catch(SQLException e){
                out.print("SQLException:"+e.getMessage());
            } catch(Exception e){
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
