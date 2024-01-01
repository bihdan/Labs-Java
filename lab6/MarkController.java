/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.lab6_1;


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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sumdu.lab6_1.ST.Student;
import sumdu.lab6_1.SM.student_Marks;
/**
 *
 * @author bogda
 */

@Controller
public class MarkController {
    ApplicationContext factory;
    Student st;
    List<student_Marks> marks;
    student_Marks mark;
    
    String url = "jdbc:mysql://localhost:3311/jdbc"; 
    String user = "root"; 
    String password = "123"; 
    
    @RequestMapping(value = "UserMarks", method=RequestMethod.GET)
    public ModelAndView formMarks(@RequestParam("stId") String studentId, Model m, HttpServletRequest request,HttpServletResponse response) 
            throws IOException, SQLException{ 

        ModelAndView modelNview = new ModelAndView();
        modelNview.setViewName("Mark");
        factory = new ClassPathXmlApplicationContext("WEB-INF/spring.xml");

        st = (Student) factory.getBean("Student");
//            Student student = new Student();

        PrintWriter pw = null;
        try{
            pw=response.getWriter();
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException ex){
            ex.printStackTrace(pw);
            pw.print(ex.getMessage());
        }

        

        Connection con = DriverManager.getConnection(url, user, password);

        String query = "SELECT * FROM `student` WHERE id = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, studentId);
        ResultSet rs = preparedStatement.executeQuery();


        if(rs.next()){

            st.setId(rs.getInt(1));
            st.setName(rs.getString(2));       
            st.setSurname(rs.getString(3));
            st.setAge(rs.getInt(4));
            st.setEmail(rs.getString(5));
            st.setGroup(rs.getString(6));
            st.setFaculty(rs.getString(7));
//                students.add(student);
        }
        modelNview.addObject("user",st);

        query = "SELECT * FROM `student-mark` WHERE stud_id = ?;";
        preparedStatement = (PreparedStatement) con.prepareStatement(query);
        preparedStatement.setString(1, studentId);
        rs = preparedStatement.executeQuery();

        marks = new ArrayList<>();

        while(rs.next()){
            mark = (student_Marks) factory.getBean("student_Marks");
            mark.setId(rs.getInt(1));
            mark.setStudentId(rs.getInt(2));       
            mark.setTitle(rs.getString(3));
            mark.setMark_let(rs.getString(4));
            mark.setMark_num(rs.getInt(5));
            marks.add(mark);
            modelNview.addObject("marks",marks);

        }
        rs.close();
        preparedStatement.close();
        return modelNview;
    }
}
