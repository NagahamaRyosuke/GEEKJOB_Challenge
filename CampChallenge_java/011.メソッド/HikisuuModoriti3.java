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

/**
 *
 * @author Ryosuke
 */
public class HikisuuModoriti extends HttpServlet {

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
            out.println("<title>引数と戻り値</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>引数と戻り値</h1>");
            
            Integer limit = 2;
            String[][] data = prof();
            
            for(int i=0; i<data.length; i++){
                for(int j=0; j<data[i].length ; j++){
                    if(data[i][j] ==null){
                        continue;
                    }
                    out.print(data[i][j]+"<br>");
                }
                if((i+1) == limit){
                    break;
                }
            }
                        
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    String[][] prof(){
        String[][] id = new String[3][4];
        
        id[0][0] = "001";
        id[0][1] = "スズキ　イチ";
        id[0][2] = "2000/01/01";
        id[0][3] = "日本";
        
        id[1][0] = "002";
        id[1][1] = "スズキ　ニ";
        id[1][2] = "2000/01/02";
        id[1][3] = null;
        
        id[2][0] = "003";
        id[2][1] = "スズキ　サン";
        id[2][2] = "2000/01/03";
        id[2][3] = "日本";
        
        return id;

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
