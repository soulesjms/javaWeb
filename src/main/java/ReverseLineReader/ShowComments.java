/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jonny
 */
@WebServlet(urlPatterns = {"/ShowComments"})
public class ShowComments extends HttpServlet {

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
        String comment = request.getParameter("comment");
        String fileName = "C:\\Users\\Jonny\\Documents\\NetBeansProjects\\CS313\\mavenproject1\\src\\main\\java\\comment.txt";
        
        List<String> comments = new ArrayList<>();
        readTextFile(fileName, comments);   //possible problem? don't know if its affecting comments list?
        
        comments.add("hey look at my awesome comment!");
        comments.add("this is the next awesome comment!");
        
        request.setAttribute("comments", comments);
        
        writeToText(fileName, comment);
        
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
    
    public void readTextFile(String fileName, List<String> comments) throws IOException {
        FileReader FR = new FileReader(fileName);
        try (BufferedReader BR = new BufferedReader(FR)) {
            String line = BR.readLine();
            
            while (line != null) {
                comments.add(line);
                line = BR.readLine();
            }
        }
    }
    
    public void writeToText(String fileName, String comment) throws IOException {
        BufferedWriter BW;
        File fout = new File(fileName);
        BW = new BufferedWriter(new FileWriter(fout, true));
        
        System.out.println("Writing comment to text file: " + fileName);
        
        BW.write(comment + "\n");
        
        System.out.println("File written");
        BW.close();
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
