/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contacto;

import Task.email.email;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Darlin
 */
@WebServlet(name = "contacto", urlPatterns = {"/mail"})
public class contacto extends HttpServlet {

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
            String nombre = request.getParameter("nombre");
            String mensaje = request.getParameter("mensaje");
            String correo = request.getParameter("correo");
            String telefono = request.getParameter("telefono");
            
            String mensajeAdmin = "La persona <strong>"+nombre+"</strong>, te envio una solicitud de contacto y su correo es "+correo+" su numero es "+telefono+"<br> su mensaje fue "+mensaje;
            String mensajerespuesta = "Gracias por contactarme "+nombre+",<br/> recibi tu mensaje "+mensaje+" en breve me contactare con tigo";
            
            email mailEnvio = new email();
            
            if(mailEnvio.send("aprendefacil1020@gmail.com","jdbr10122000",correo,mensajerespuesta, "Contacto de ByteCode y Codytron")&&mailEnvio.send("aprendefacil1020@gmail.com","jdbr10122000","davidbriones1020@gmail.com",mensajeAdmin, "Te estan contactando")){
                out.println("En breve me pondre al contacto con tigo");
            }else{
                out.println("Hubo un error verifica los campos");
            }
            
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
