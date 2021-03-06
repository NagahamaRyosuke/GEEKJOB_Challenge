package jums;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * insertresultと対応するサーブレット
 * フォームから入力された値をセッション経由で受け取り、データベースにinsertする
 * 直接アクセスした場合はerror.jspに振り分け
 * @author hayashi-s
 */
public class InsertResult extends HttpServlet {

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
        
        try{
            HttpSession session = request.getSession();
            request.setCharacterEncoding("UTF-8");//セッションに格納する文字コードをUTF-8に変更
            String accesschk = request.getParameter("ac");
            if(accesschk ==null || (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }        
            try{
                //ユーザー情報に対応したJavaBeansオブジェクトに格納していく
                UserDataBeans userbeans =  (UserDataBeans)session.getAttribute("userbeans");
                UserDataDTO userdata = new UserDataDTO();
                userdata.setName((String)userbeans.getName());
                userdata.setType(Integer.parseInt((String)userbeans.getType()));
                userdata.setTell((String)userbeans.getTell());
                userdata.setComment((String)userbeans.getComment());
                
                //生年月日の格納
                java.util.Date date = new java.util.Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String newdate = userbeans.getYear()+"-"+userbeans.getMonth()+"-"+userbeans.getDay();
                date = sdf.parse(newdate);
                java.sql.Date birthday = new java.sql.Date(date.getTime());
                userdata.setBirthday(birthday);
                
                //requestをsetする
                request.setAttribute("name", userbeans.getName());
                request.setAttribute("year", userbeans.getYear());
                request.setAttribute("month", userbeans.getMonth());
                request.setAttribute("day", userbeans.getDay());
                request.setAttribute("type", userbeans.getType());
                request.setAttribute("tell", userbeans.getTell());
                request.setAttribute("comment", userbeans.getComment());
                
                //DBへデータの挿入
                UserDataDAO .getInstance().insert(userdata); 
                
                //sessionを破棄
                session.invalidate();
                
                request.getRequestDispatcher("/insertresult.jsp").forward(request, response);
            }catch(Exception e){
                //データ挿入に失敗したらエラーページにエラー文を渡して表示
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
        }catch(Exception e){
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
