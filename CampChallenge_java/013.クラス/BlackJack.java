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

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Ryosuke
 */
public class BlackJack extends HttpServlet {

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
            out.println("<title>BlackJack</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>BlackJack</h1>");
            
            Dealer dealer = new Dealer();
            User user = new User();
            ArrayList<Integer> dealerNum = new ArrayList<>();
            ArrayList<Integer> userNum = new ArrayList<>();
            int dealerResult = 0;
            int userResult = 0; 
            int number = 2;
            int flag = 0;
            
            //user
            userNum = dealer.deal();    //2枚配る
            user.setCard(userNum);    //myCardsに登録
            out.print("<p>User</p>");
            out.println("1枚目:"+user.myCards.get(0)+"<br>2枚目:"+user.myCards.get(1)+"<br>");
            
            while(true){
                if(user.checkSum()){  //hitか勝負か
                    userResult = user.open();
                    out.print("<b>結果：</b>"+userResult);
                    break;
                } else {
                    userNum = dealer.hit();
                    user.setCard(userNum);
                    out.print("1枚追加："+user.myCards.get(number)+"<br>");
                }
                number++;
            }
            number = 2; //初期化
            
            //dealer
            dealerNum = dealer.deal();    //2枚配る
            dealer.setCard(dealerNum);    //myCardsに登録
            out.print("<p>Dealer</p>");
            out.println("1枚目:"+dealer.myCards.get(0)+"<br>2枚目:"+dealer.myCards.get(1)+"<br>");
            
            while(true){
                if(dealer.checkSum()){  //hitか勝負か
                    dealerResult = dealer.open();
                    out.print("<b>結果：</b>"+dealerResult+"<br><br>");
                    break;
                } else {
                    dealerNum = dealer.hit();
                    dealer.setCard(dealerNum);
                    out.print("1枚追加："+dealer.myCards.get(number)+"<br>");
                }
                number++;
            }
            
            if(userResult > 21){
                flag = 1;       //Userがバストしました Dealerの勝利
            }
            if(dealerResult > 21){
                if(flag == 1){
                    flag = 5;       //引き分け
                } else {
                    flag = 2;       //Dealerがバストしました Userの勝利
                }
            }
            if(flag == 0){
                if(dealerResult > userResult){
                    flag = 3;       //Dealerの勝利
                } else if(dealerResult < userResult){
                    flag = 4;       //Userの勝利
                } else {
                    flag = 5;       //引き分け
                }
            }
            
            switch(flag){
                case 1:
                    out.print("Userがバストしました<br>Dealerの勝利");
                    break;
                case 2:
                    out.print("Dealerがバストしました<br>Userの勝利");
                    break;
                case 3:
                    out.print("Dealerの勝利");
                    break;
                case 4:
                    out.print("Userの勝利");
                    break;
                case 5:
                    out.print("引き分け");
                    break;
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

//抽象クラス
abstract class Human{
    public abstract int open();
    public abstract void setCard(ArrayList<Integer> a);
    public abstract boolean checkSum();
    ArrayList<Integer> myCards = new ArrayList<>();
}

class Dealer extends Human {
    ArrayList<Integer> cards = new ArrayList<>();
    int i;

    //コンストラクタに入れる、クラスには処理が書けない
    Dealer(){
        int num = 1;
        for(i=0; i<52; i++){  
            if(num == 14){
                num = 1;
            }
            this.cards.add(num);
            num++; 
        }
    }
    
    //ランダムで2枚返す
    ArrayList<Integer> deal(){
        ArrayList<Integer> card = new ArrayList<>();
        Random rand = new Random();
        
        for(i=0; i<2; i++){
            Integer index = rand.nextInt(this.cards.size());    //乱数取得
            card.add(this.cards.get(index));
        }
        return card;
    }
    
    //ランダムで1枚返す
    ArrayList<Integer> hit(){
        ArrayList<Integer> card = new ArrayList<>();
        Random rand = new Random();
        
        Integer index = rand.nextInt(this.cards.size());    //乱数取得
        card.add(this.cards.get(index));
        
        return card;
    }

    @Override
    public int open(){
        int sum = 0;
        for(i=0; i<myCards.size(); i++){
            sum = sum + myCards.get(i);
        }
        return sum;
    }
    @Override
    public void setCard(ArrayList<Integer> a){
        for(i=0; i<a.size(); i++){
            myCards.add(a.get(i));
        }
    }
    @Override
    public boolean checkSum(){
        int sum = 0;
        for(i=0; i<myCards.size(); i++){
            sum = sum + myCards.get(i);
        }
        return sum >= 17;
    }
}

class User extends Human {
    int i;
    
    @Override
    public int open(){
        int sum = 0;
        for(i=0; i<myCards.size(); i++){
            sum = sum + myCards.get(i);
        }
        return sum;
    }
    @Override
    public void setCard(ArrayList<Integer> a){
        for(i=0; i<a.size(); i++){
            myCards.add(a.get(i));
        }
    }
    @Override
    public boolean checkSum(){
        int sum = 0;
        for(i=0; i<myCards.size(); i++){
            sum = sum + myCards.get(i);
        }
        return sum >= 17;
    }
}
