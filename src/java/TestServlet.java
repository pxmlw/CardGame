/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import java.io.IOException;
//import java.io.PrintWriter;
//import java.math.BigDecimal;
//import javax.json.Json;
//import javax.json.JsonObject;
//import javax.json.JsonObjectBuilder;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import static javax.ws.rs.client.Entity.json;
//
///**
// *
// * @author pradeepganesan
// */
//@WebServlet(urlPatterns = {"/test/PersonSubmit"})
//public class TestServlet extends HttpServlet {
//    public boolean isset(Card a,Card b,Card c){
//        if (!((a.getNumber() == b.getNumber()) && (b.getNumber() == c.getNumber()) ||
//                (a.getNumber() != b.getNumber()) && (a.getNumber() != c.getNumber()) && (b.getNumber() != c.getNumber()))) {
//            return false;
//        }
//        if (!((a.getShape() == b.getShape()) && (b.getShape() == c.getShape()) ||
//                (a.getShape() != b.getShape()) && (a.getShape() != c.getShape()) && (b.getShape() != c.getShape()))) {
//            return false;
//        }
//        if (!((a.getColor() == b.getColor()) && (b.getColor() == c.getColor()) ||
//                (a.getColor() != b.getColor()) && (a.getColor() != c.getColor()) && (b.getColor() != c.getColor()))) {
//            return false;
//        }
//        if (!((a.getSq() == b.getSq()) && (b.getSq() == c.getSq()) ||
//                (a.getSq() != b.getSq()) && (a.getSq() != c.getSq()) && (b.getSq() != c.getSq()))) {
//            return false;
//        }
//        return true;
//    }
//    
//    
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        
//        int img1= Integer.parseInt(request.getParameter("img1"));
//        int img2= Integer.parseInt(request.getParameter("img2"));
//        int img3= Integer.parseInt(request.getParameter("img3"));
//        
//        Cardlist ca=new Cardlist();
//        Card a=ca.getcard(img1);
//        Card b=ca.getcard(img2);
//        Card c=ca.getcard(img3);
//        boolean k=(isset(a,b,c));
//        if (k) {
//            ca.tocardlist().remove(a);
//            ca.tocardlist().remove(b);
//            ca.tocardlist().remove(c);
//                    
//        } 
//        
//      
//        
//        
//        
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println(img1 + " " + img2 + " " + img3);
//           
//            
//            
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
