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
            
            String id = "001";
            String[] data = prof(id);
            for(int i=1; i<data.length; i++){
                if(data[i] ==null){
                    continue;
                }
                out.print(data[i]+"<br>");
            }
            
            out.println("<br>");
            id = "002";
            data = prof(id);
            for(int i=1; i<data.length; i++){
                if(data[i] ==null){
                    continue;
                }
                out.print(data[i]+"<br>");
            }
            
            out.println("<br>");
            id = "003";
            data = prof(id);
            for(int i=1; i<data.length; i++){
                if(data[i] ==null){
                    continue;
                }
                out.print(data[i]+"<br>");
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    String[] prof(String data){
        String[] id1 = new String[4];
        String[] id2 = new String[4];
        String[] id3 = new String[4];
        
        id1[0] = "001";
        id1[1] = "スズキ　イチ";
        id1[2] = "2000/01/01";
        id1[3] = "日本";
        
        id2[0] = "002";
        id2[1] = "スズキ　ニ";
        id2[2] = "2000/01/02";
        id2[3] = null;
        
        id3[0] = "003";
        id3[1] = "スズキ　サン";
        id3[2] = "2000/01/03";
        id3[3] = "日本";
        
        if(id1[0].equals(data)){
            return id1;
        } else if(id2[0].equals(data)){
            return id2;
        } else {
            return id3;
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
