/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.controllers;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sumdu.model.Student;
import sumdu.model.student_Marks;
import sumdu.dao.MarkDAO;
/**
 *
 * @author bogda
 */

@Controller
public class MarkController {
    
    @Autowired
    private MarkDAO dao;
    
//    
    @RequestMapping(value = "UserMarks", method=RequestMethod.GET)
    public String formMarks(@RequestParam("stId") String studentId, Model m, HttpServletRequest request,HttpServletResponse response) 
            throws IOException, SQLException{ 


        Student st = dao.getStudent(Integer.parseInt(studentId));
        if (st != null) {

            m.addAttribute("user", st);
        }

        List<student_Marks> marks = dao.getMarks(Integer.parseInt(studentId)); 
        if (marks != null) {

            m.addAttribute("marks", marks);
        }

        return "Mark";
    }
}

