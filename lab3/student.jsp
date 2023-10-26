<%-- 
    Document   : student
    Created on : 24 окт. 2023 г., 10:05:38
    Author     : bogda
--%>

<%@page import="sumdu.lab3.Student"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student</title>
       <style>
        body {
            background-color: #151F42;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;

        }
        #page{
            width: 40%;
            margin: auto;
            margin-top: 100px;
            background-color: #142F42;
            padding: 30px;
            border-radius: 10px;
            /*box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);*/
            
        }
        .bows{
            display: inline;
            display: flex;
            float: left;
        }

        
        h1{
            color: #4C68D9;
            text-align: center;
        }

        table {
            color: #4C68D9;
            border-collapse: collapse;
            width: 100%;
            margin-top: 10px;
        }
        th,
        td {
            text-align: center;
        }
        input[type=text],
        input[type=email] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            margin-top: 5px;
            margin-bottom: 10px;
        }

        input[type=submit] {
            width: 370px;
            background-color: #4C68D9;
            color: white;
            margin-left: 50px;
            padding: 10px;
            border: none;
            border-radius: 5px;
            
            
        }
        input[type=submit]:hover {
            background-color: #151F42;
        }
        
        
        .bot table {
            width: 100%;
            margin-top: 10px;
            border-collapse: collapse;
        }
        .bot table,
        .bot   th,
        .bot   td {
            border: 1px solid black;
        }
        .bot th,
        .bot td {
            padding: 10px;
            text-align: left;
        }

        /*#page {
            width: 800px;
            margin: auto;
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 50px;
        }
        h1 {
            text-align: center;
        }
        form {
            width: 100%;
            max-width: 400px;
            margin: 20px auto;
        }
        table {
            width: 100%;
            margin-top: 10px;
            border-collapse: collapse;
        }
        table,
           th,
           td {
            border: 1px solid black;
        }
        th,
        td {
            padding: 10px;
            text-align: left;
        }*/
        
       </style>
    </head>

<body>
    <div id="page">
        <h1>Student Form</h1>
        <div class="boxs">
            <div class="top">
                <form>
                    <table>
                        <tbody>
                            <tr>
                                <td><label for="name">Name</td>
                                <td><input id="name" type="text" name="name"></td>
                            </tr>
                            <tr>
                                <td><label for="surname">Surname</td>
                                <td><input id="surname" type="text" name="surname"></td>
                            </tr>
                            <tr>
                                <td><label for="email">Email</td>
                                <td><input id="email" type="email" name="email"></td>
                            </tr>
                        </tbody>
                    </table>
                    <input type="submit" name="send" value="Send">
                </form>
            </div>

            <div class="bot">
                <% List<Student> students= (List<Student>)application.getAttribute("students"); %>
                <c:if test="${not empty param.send }">
                <%
                if(students ==null){
                    students= new LinkedList<Student>();
                    application.setAttribute("students",students);
                }
                if(request.getParameter("name")!=""||request.getParameter("surname")!=""){
                    Student student = new Student();
                    student.setName(request.getParameter("name"));
                    student.setSurname(request.getParameter("surname"));
                    student.setEmail(request.getParameter("email"));
                    students.add(student);
                }
                response.sendRedirect("student.jsp");
                %>

                </c:if>

                <%
                if(students != null){
                    out.println("<table class=\"list\"><tr><th>Name</th><th>Surname</th><th>Email</th></tr>");
                    for(Student s:students){
                        out.println("<tr><td>"+s.getName()+"</td><td>"+s.getSurname()+"</td><td>"+s.getEmail()+"</td></tr>");
                    }
                    out.println("</table>");
                }
                %>
            </div>
            
        </div>
    </div>
    
        

    </>
</body>
</html>
