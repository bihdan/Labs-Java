/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.model;

import javax.persistence.*;
/**
 *
 * @author bogda
 */

@Entity
@Table(name="`student-mark`")
public class student_Marks {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int id;
    @Column(name="stud_id")
    private int stud_Id;
    @Column(name="Title")
    private String title;
    @Column(name="mark_let")
    private String mark_let;
    @Column(name="mark_num")
    private int mark_num;
    
    public student_Marks(){
        
    }
    
    public student_Marks(int id, int stud_Id, String title, String mark_let, int mark_num) {
        this.id = id;
        this.stud_Id = stud_Id;
        this.title = title;
        this.mark_let = mark_let;
        this.mark_num = mark_num;
    }

    public int getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    

    public int getStudentId() {
        return stud_Id;
    }
    
    public void setStudentId(Integer stud_Id) {
        this.stud_Id = stud_Id;
    }

    public String getTitle() {
        return title;
    }
    
     public void setTitle(String title) {
        this.title = title;
    }

    public String getMark_let() {
        return mark_let;
    }
    
    public void setMark_let(String mark_let) {
        this.mark_let = mark_let;
    }
    
    public int getMark_num() {
        return mark_num;
    }
    
    public void setMark_num(Integer mark_num) {
        this.mark_num = mark_num;
    }
}
