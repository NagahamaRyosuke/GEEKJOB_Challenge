/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ryosuke
 */
public class InventoryControl extends HttpServlet {

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
            out.println("<title>Servlet InventoryControl</title>");            
            out.println("</head>");
            out.println("<body>");
            
            request.setCharacterEncoding("UTF-8");
            String url = "jdbc:mysql://localhost/Inventory_Control";
            String user = "GEEKJOB";
            String pass = "geekjob";
            String sql;
            
            ArrayList<InventoryControlScope> check = new ArrayList<>();
            
            String product_name = getParaSt(request.getParameter("product_name"));
            String code = getParaSt(request.getParameter("code"));
            String price = getParaSt(request.getParameter("price"));
            
            Connection conn = null;
            HttpSession session = request.getSession();                  
            
            //登録
            if(request.getParameter("entry") != null){
                try{
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    conn = DriverManager.getConnection(url, user, pass);

                    PreparedStatement db_st = null;
                    sql = "insert into product values(?, ?, ?)";

                    db_st = conn.prepareStatement(sql);
                    db_st.setString(1, code);
                    db_st.setString(2, product_name);
                    db_st.setString(3, price);
                    int num = db_st.executeUpdate();
                    
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
            }
            //検索
            if(request.getParameter("search") != null){
                 try{
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    conn = DriverManager.getConnection(url, user, pass);

                    PreparedStatement db_st = null;
                    ResultSet rs = null;
                    sql = "select * from product where (code =? and product_name =? and price =?) is not false";

                    db_st = conn.prepareStatement(sql);
                    db_st.setString(1, code);
                    db_st.setString(2, product_name);
                    db_st.setString(3, price);
                    rs = db_st.executeQuery();

                    while(rs.next()){
                        InventoryControlScope ics = new InventoryControlScope();
                        code = rs.getString("code");
                        product_name = rs.getString("product_name");
                        price = rs.getString("price");
                        ics.setCode(code);
                        ics.setProduct_name(product_name);
                        ics.setPrice(price);
                        check.add(ics);
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
            }

            request.setAttribute("check",check);
            RequestDispatcher rd = request.getRequestDispatcher("InventoryControlResult.jsp");
            rd.forward(request, response);
            
//            response.sendRedirect("InventoryControlResult.jsp");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    String getParaSt(String word){
        String xxx = null;
        if(word != null && word != ""){
                xxx = word;
            }
        return xxx;
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
