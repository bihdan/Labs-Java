/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sumdu.lab4_jdbc;

import com.mysql.jdbc.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bogda
 */
@WebServlet(name = "Servlet_addStudent", urlPatterns = {"/Servlet_addStudent"})
public class Servlet_addStudent extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{ 
            HttpSession session = request.getSession(); 
            List<Student> students = (List<Student>) getServletContext().getAttribute("students"); 

            PrintWriter pw=null; 
            try{ 
                pw=response.getWriter(); 
                Class.forName("com.mysql.jdbc.Driver"); 
            } 
            catch(ClassNotFoundException ex){ 
                ex.printStackTrace(pw); 
                pw.print(ex.getMessage()); 
            } 
         
         
            String url = "jdbc:mysql://localhost:3311/jdbc"; 

            String user = "root"; 
            String password = "123"; 


            Connection conn;  
         
            conn = DriverManager.getConnection(url, user, password); 
         
            if (request.getParameter("name") != null && request.getParameter("surname") != null) { 
                PreparedStatement ps = conn.prepareStatement("INSERT INTO student (Name_, Surname, age, email, group_, faculty) VALUES (?, ?, ?, ?, ?, ?)"); 
                    ps.setString(1, request.getParameter("name"));
                    ps.setString(2, request.getParameter("surname"));
                    ps.setInt(3, Integer.parseInt(request.getParameter("age")));
                    ps.setString(4, request.getParameter("email"));
                    ps.setString(5, request.getParameter("group"));
                    ps.setString(6, request.getParameter("faculty"));
                    ps.executeUpdate();
                 
            } 
 
            Statement s = (Statement) conn.createStatement(); 
            ResultSet rs = s.executeQuery("SELECT * FROM student;"); 
            students = new LinkedList<>(); 
            while (rs.next()) { 
                Student student = new Student(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7)); 
                students.add(student); 
            } 
            session.setAttribute("students",students); 
            response.sendRedirect("student.jsp"); 
         
         
        } catch(SQLException ex){ 
        }
 
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

