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
public class DbTask12 extends HttpServlet {

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
            out.println("<title>Servlet DbTask12</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DbTask12 at " + request.getContextPath() + "</h1>");
            
            request.setCharacterEncoding("UTF-8");
            String name = null;
            int age = -1;
                      
            if(request.getParameter("Name") != null && request.getParameter("Name") != ""){
                name = request.getParameter("Name");
            }
            
            if(request.getParameter("Age") != null && request.getParameter("Age") != ""){
                age = Integer.parseInt(request.getParameter("Age"));
            }
            
            Connection conn = null;
            String url = "jdbc:mysql://localhost/challenge_db";
            String user = "GEEKJOB";
            String pass = "geekjob";
            
            try{
                Date date = null;
                java.sql.Date birthday = null;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                
                if(request.getParameter("Birthday") != null && request.getParameter("Birthday") != ""){
                    date = sdf.parse(request.getParameter("Birthday"));
                    birthday = new java.sql.Date(date.getTime());
                }
                out.print("検索ワード:"+name+", "+age+", "+birthday+"<br>");
                
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection(url, user, pass);
                
                PreparedStatement db_st = null;
                ResultSet rs = null;
                String sql = "select * from profiles where (name=? and birthday=? and age=?) is not false";
                
                if(age == -1){
                    sql = "select * from profiles where (name=? and birthday=?) is not false";
                    db_st = conn.prepareStatement(sql);
                } else{
                    db_st = conn.prepareStatement(sql);
                    db_st.setInt(3, age);
                }
                db_st.setString(1, name);
                db_st.setDate(2, birthday);
                
                rs = db_st.executeQuery();
                
                while(rs.next()){
                    int id = rs.getInt("profilesID");
                    name = rs.getString("name");
                    String tel = rs.getString("tel");
                    age = rs.getInt("age");
                    birthday = (java.sql.Date) rs.getDate("birthday");
                    out.print("profilesID:"+id+", name:"+name+", tel:"+tel+", age:"+age+", birthday:"+birthday+"<br>");
                }
                
                rs.close();
                db_st.close();
                
            }catch(ClassNotFoundException e){
                out.print("ClassNotFoundException:"+e.getMessage());
                out.println("<a href=DbTask12.jsp>戻る</a>");
            }catch(SQLException e){
                out.print("SQLException:"+e.getMessage());
                out.println("<a href=DbTask12.jsp>戻る</a>");
            }catch(Exception e){
                out.print("Exception:"+e.getMessage());
                out.println("<a href=DbTask12.jsp>戻る</a>");
            }finally{
                try{
                    conn.close();
                    out.print("データベース切断<br>");
                }catch(SQLException e){
                    out.print("SQLException:"+e.getMessage());
                }
            }
            
            out.println("<a href=DbTask12.jsp>戻る</a>");
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
