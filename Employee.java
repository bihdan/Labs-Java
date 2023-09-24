/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.lab1;

/**
 *
 * @author bogda
 */
public class Employee {
    private int id;
    private static int nextid=1;
    private String name;
    private String surname;
    private double salary;

    public Employee(String name, String surname, double salary) throws FieldLengthLimitException, IncorrectSalaryException{
        this.id=nextid++;
        if(name.length()>15){throw new FieldLengthLimitException("Too much sumbols in name!");}
        else{this.name = name;}
        
        if(surname.length()>15){throw new FieldLengthLimitException("Too much sumbols in surname!");}
        else{this.surname = surname;}
        
        if(salary<0){throw new IncorrectSalaryException("Salary shoulbe more than 0!");}
        else{this.salary = salary;}
    }
    
    void nameYourself(){
        System.out.println("ID: "+ id + " name: " + name + " surname: " + surname + " salary: " + salary);
    }
    
    
}
