/*
 * The MIT License
 *
 * Copyright 2016 Omkar Patil (omkarvpatil@gmail.com).
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.thoughtfulprogramming;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.*;
/**
 *
 * @author PATILOX
 */
public class HitsCounterServlet extends HttpServlet {

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
            out.println("<title>Code Samples - Servlets</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td>");
            out.println("<b>Servlet Context => </b>");
            out.println("</td>");
            out.println("<td>");
            out.println("<b>Web Application Name</b>");
            out.println("</td>");
            out.println("<td>");
            out.println(getServletContext().getInitParameter("AppName"));
            out.println("</td>");
            out.println("<td>");
            out.println("<b>Web Application Version</b>");
            out.println("</td>");
            out.println("<td>");
            out.println(getServletContext().getInitParameter("AppVer"));
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>");
            out.println("<b>Servlet Config => </b>");
            out.println("</td>");
            out.println("<td>");
            out.println("<b>Servlet Author</b>");
            out.println("</td>");
            out.println("<td>");
            out.println(getServletConfig().getInitParameter("Author"));
            out.println("</td>");
            out.println("<td>");
            out.println("<b>Servlet Version</b>");
            out.println("</td>");
            out.println("<td>");
            out.println(getServletConfig().getInitParameter("AppVersion"));
            out.println("</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<i>[Note: The details above are init parameters which are read from the Deployment Descriptor (web.xml)]</i> ");
            out.println("<hr/>");
            
            HttpSession session=request.getSession();
            out.println("<h2>Session Details</h2>");
out.println("<table border=\"1\">");
out.println("<tr>");
out.println("<td>");
out.println("Is Session new?");
out.println("</td>");
out.println("<td>");
out.println(session.isNew());
out.println("</td>");
out.println("</tr>");

            
            
           
            



out.println("<tr>");
out.println("<td>");
out.println("Session ID");
out.println("</td>");
out.println("<td>");
out.println(session.getId());
out.println("</td>");
out.println("</tr>");


out.println("<tr>");
out.println("<td>");
out.println("Max. Inactive Interval (in seconds)");
out.println("</td>");
out.println("<td>");
out.println(session.getMaxInactiveInterval());
out.println("</td>");
out.println("</tr>");

            java.util.Date creationDateTime=new java.util.Date(session.getCreationTime());
            java.util.Date lastAccessedDateTime=new java.util.Date(session.getLastAccessedTime());
            
out.println("<tr>");
out.println("<td>");
            out.println("Session Creation DateTime");
out.println("</td>");
out.println("<td>");
            out.println(creationDateTime);
out.println("</td>");
out.println("</tr>");


out.println("<tr>");
out.println("<td>");
out.println("Session Last Accessed DateTime");
out.println("</td>");
out.println("<td>");
out.println(lastAccessedDateTime);
out.println("</td>");
out.println("</tr>");



            int visitsCount=0;
            //session.setAttribute("NumberOfVisits", 0);
            if(session.isNew())
            {
                
                session.setAttribute("NumberOfVisits", visitsCount);
            }
            else
            {
                visitsCount=(Integer)session.getAttribute("NumberOfVisits");
                visitsCount=visitsCount+1;
                session.setAttribute("NumberOfVisits", visitsCount);
            }
            
            
            
            
out.println("<tr>");
out.println("<td>");
out.println("Visit Count");
out.println("</td>");
out.println("<td>");
out.println(visitsCount);
out.println("</td>");
out.println("</tr>");


out.println("</table>");
out.println("<br/>");
out.println("(Hit 'F5' to increament the counter)");


Cookie c1=new Cookie("User","Omkar");
            c1.setMaxAge(60*60*24);
            response.addCookie(c1);
            
            Cookie[] ck=request.getCookies();
            
            out.println("<h2>Cookies Information</h2>");

if(ck.length==0)
{
    
    out.println("No incoming cookies.");
}
else
{
    out.println("<table border=\"1\">");

            for(int i=0;i<ck.length;i++)
            {
                out.println("<tr>");
out.println("<td>");
out.println(ck[i].getName());
out.println("</td>");
out.println("<td>");
out.println(ck[i].getValue());
out.println("</td>");
out.println("</tr>");
            }
out.println("</table>");            
}

out.println("<br/>");
            out.println("<br/>");
            out.println("<a href=\"index.html\"><- Go back to the Home page</a>");
            
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
