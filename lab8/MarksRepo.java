/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sumdu.model.student_Marks;
import sumdu.model.Student;
/**
 *
 * @author bogda
 */
@Repository
public interface MarksRepo extends JpaRepository<Student, Integer>{
    @Query("from student_Marks where stud_id= :id")
    List<student_Marks> getScoresByStId(@Param("id") int id);
}
