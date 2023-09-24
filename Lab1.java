/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package sumdu.lab1;

/**
 *
 * @author bogda
 */
public class Lab1 {

    public static void main(String[] args) {
        
        try{
            Employee emp=new Employee("Bihdan", "D", 5);
            emp.nameYourself();
        }catch(FieldLengthLimitException ex){
            System.out.println(ex.getMessage());
        }catch(IncorrectSalaryException ex){
            System.out.println(ex.getMessage());
        }
        
        try{
            Employee emp=new Employee("BihdanBihdanBihdanBihdan", "D", 0);
            emp.nameYourself();
        }catch(FieldLengthLimitException ex){
            System.out.println(ex.getMessage());
        }catch(IncorrectSalaryException ex){
            System.out.println(ex.getMessage());
        }
        
        try{
            Employee emp=new Employee("Bihdan", "DDDDDDDDDDDDDDDDDD", 0);
            emp.nameYourself();
        }catch(FieldLengthLimitException ex){
            System.out.println(ex.getMessage());
        }catch(IncorrectSalaryException ex){
            System.out.println(ex.getMessage());
        }
        
        try{
            Employee emp=new Employee("Bihdan", "D", -10);
            emp.nameYourself();
        }catch(FieldLengthLimitException ex){
            System.out.println(ex.getMessage());
        }catch(IncorrectSalaryException ex){
            System.out.println(ex.getMessage());
        }
    }
}
