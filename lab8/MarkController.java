/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.controllers;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import sumdu.repo.MarksRepo;
import sumdu.repo.StudentRepo;


import sumdu.model.Student;
import sumdu.model.student_Marks;

/**
 *
 * @author bogda
 */

@Controller
public class MarkController {
    List<student_Marks> marks;
    ApplicationContext factory = new ClassPathXmlApplicationContext("WEB-INF/spring.xml"); 
     
    @Autowired
    StudentRepo strepo;
    
    @Autowired
    MarksRepo smrepo;
    
        @RequestMapping(value = "UserContent", method=RequestMethod.GET)
        public ModelAndView formContent(@RequestParam("stId") String studentId, HttpServletRequest request,HttpServletResponse response) throws IOException, SQLException{ 
            ModelAndView modelNview = new ModelAndView();
            modelNview.setViewName("marks");
            
            Student st = strepo.getOne(Integer.parseInt(studentId));
            modelNview.addObject("user",st);
            
            marks=smrepo.getScoresByStId(st.getId());
            modelNview.addObject("scores",marks);
            
            return modelNview;
        }
       
}

