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

/**
 *
 * @author PATILOX
 */
public class RegisterServlet extends HttpServlet {

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
            out.println("<br/>");
            
            out.println("<h2>Client Address & Ports Information</h2>");
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<td>");
            out.println("Remote Address");
            out.println("</td>");
            
            out.println("<td>");
            out.println(request.getRemoteAddr());
            out.println("</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td>");
            out.println("Remote Host");
            out.println("</td>");
            out.println("<td>");
            out.println(request.getRemoteHost());
            out.println("</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td>");
            out.println("Server Port");

            out.println("</td>");
            out.println("<td>");
            out.println(request.getServerPort());

            out.println("</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>");
            out.println("Local Port");
            
            out.println("</td>");
            out.println("<td>");
            out.println(request.getLocalPort());
            
            out.println("</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>");
            out.println("Remote Port");
            out.println("</td>");
            out.println("<td>");
            out.println(request.getRemotePort());

            out.println("</td>");
            out.println("</tr>");

            out.println("</table>");

            

            
//Reading the name of the HTTP method used to submit the request
            out.println("<h2>Request Type </h2>");
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<td>");
            out.println("Request Type");
            out.println("</td>");
            out.println("<td>");
            out.println(request.getMethod());
            out.println("</td>");
            out.println("</tr>");
            out.println("</table>");

//Reading Application Context Path
            out.println("<h2>Context Path</h2>");
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<td>");
            out.println("Application Context Path");
            out.println("</td>");
            out.println("<td>");
            out.println(request.getContextPath());
            out.println("</td>");
            out.println("</tr>");
            out.println("</table>");
                        
            

            
            
            
//Reading HTTP Header
            out.println("<h2>HTTP Header Details</h2>");
            out.println("<table border=\"1\">");
            java.util.Enumeration e = request.getHeaderNames();
            String headerName="";
            while(e.hasMoreElements())
            {
                out.println("<tr>");

                headerName=(String)e.nextElement();
                out.println("<td>");
                out.print(headerName);
                out.println("</td>");
                out.println("<td>");
                out.print(request.getHeader(headerName));
                out.println("</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            
            
//Reading QueryString
            
            out.println("<h2>Query String</h2>");
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<td>");
            out.println("Query String Information");
            out.println("</td>");
            out.println("<td>");
            out.println(request.getQueryString());
            out.println("</td>");
            out.println("</tr>");
            out.println("</table>");

//Reading Parameters            
            java.util.Enumeration reqParams=request.getParameterNames();
            out.println("<h2>Request Parameters</h2>");
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<td>");
            out.println("<b>Parameter Name</b>");
            out.println("</td>");
            out.println("<td>");
            out.println("<b>Parameter Value</b>");
            out.println("</td>");
            out.println("</tr>");

            while(reqParams.hasMoreElements())
            {
		String param=(String)reqParams.nextElement();
		String value=request.getParameter(param);
                out.println("<tr>");
                out.println("<td>");
                out.println(param);
                out.println("</td>");
                out.println("<td>");
                out.println(value);
                out.println("</td>");
                out.println("</tr>");	
            }
            out.println("</table>");
            
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
