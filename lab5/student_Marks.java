/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.lab5;

/**
 *
 * @author bogda
 */
public class student_Marks {
    
    private int id;
    private int stud_Id;
    private String title;
    private String mark_let;
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

    // Геттери і сеттери тут

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return stud_Id;
    }

    public String getTitle() {
        return title;
    }

    public String getMark_let() {
        return mark_let;
    }
    
    public int getMark_num() {
        return mark_num;
    }
}
