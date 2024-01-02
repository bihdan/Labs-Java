/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/SimpleFormController.java to edit this template
 */
package sumdu.controllers;

import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sumdu.dao.StudentDAO;
import sumdu.model.Student;

/**
 *
 * @author bogda
 */
@Controller
public class StudentController {
    List<Student> students;
    ApplicationContext factory = new ClassPathXmlApplicationContext("WEB-INF/spring.xml"); 
    Student student;
    
    @Autowired
    private StudentDAO dao;
    
    @RequestMapping(value = "/")
    public String home(Model m) {
            students=dao.getStudents();
            m.addAttribute("students", students);
            return "student";
    }

    @RequestMapping("StudentAdd")
    public String addStudent(HttpServletRequest request,HttpServletResponse response, Model m) throws IOException, SQLException{
            
        if (request.getParameter("name") != null && request.getParameter("surname") != null) {
            student = (Student)factory.getBean("Student");
        
            student.setName(request.getParameter("name"));
            student.setSurname(request.getParameter("surname"));
            student.setAge(Integer.parseInt(request.getParameter("age")));
            student.setEmail(request.getParameter("email"));
            student.setGroup(request.getParameter("group"));
            student.setFaculty(request.getParameter("faculty"));
        
            dao.addStudent(student);       
        }
            students = dao.getStudents();

        
    
        m.addAttribute("students", students);
        return "student";
        
    }


}