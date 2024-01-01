/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sumdu.lab5;

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
import java.util.ArrayList;
//import java.sql.Statement;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 *
 * @author bogda
 */
public class GradesServlet extends HttpServlet {
    
    private static String url = "jdbc:mysql://localhost:3311/jdbc"; 
    private static String user = "root"; 
    private static String password = "123";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            PrintWriter pw=null;
            try{ 
                    pw =response.getWriter(); 
                    Class.forName("com.mysql.jdbc.Driver"); 
                } 
                catch(ClassNotFoundException ex){ 
                    ex.printStackTrace(pw); 
                    pw.print(ex.getMessage()); 
             } 
            int studentId = Integer.parseInt(request.getParameter("id"));
            List<Student> students = getStudent(studentId);
            List<student_Marks> marks = getstudentMark(studentId);
            request.setAttribute("students", students);
            request.setAttribute("marks", marks);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/Mark.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(GradesServlet.class.getName()).log(Level.SEVERE, null,ex);
        }
    }

    private List<student_Marks> getstudentMark(int studentId) throws SQLException, IOException {
        
        List<student_Marks> marks = new ArrayList<>();
        ApplicationContext factory = new ClassPathXmlApplicationContext("WEB-INF/spring.xml");
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            
            String query = "SELECT * FROM `student-mark` WHERE stud_id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) { 
//                student_Marks mark = new student_Marks(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5)); 
                student_Marks mark = (student_Marks) factory.getBean("student_Marks");
                mark.setId(rs.getInt(1));
                mark.setStudentId(rs.getInt(2));       
                mark.setTitle(rs.getString(3));
                mark.setMark_let(rs.getString(4));
                mark.setMark_num(rs.getInt(5));
                marks.add(mark);
            } 
        }
        return marks;
    }
    
    private List<Student> getStudent(int studentId) throws SQLException, IOException {
        List<Student> students = new ArrayList<>();
        ApplicationContext factory = new ClassPathXmlApplicationContext("WEB-INF/spring.xml");
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            
            
            String query = "SELECT * FROM `student` WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) { 

//                Student student = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7)); 
                Student student = (Student) factory.getBean("Student");
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));       
                student.setSurname(rs.getString(3));
                student.setAge(rs.getInt(4));
                student.setEmail(rs.getString(5));
                student.setGroup(rs.getString(6));
                student.setFaculty(rs.getString(7));
                students.add(student);
            } 
        }
        return students;
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
