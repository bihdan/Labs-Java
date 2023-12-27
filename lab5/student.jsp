

<%@page import="sumdu.lab5.Student"%>
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
            width: 50%;
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
        input[type=number],
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

        
       </style>
    </head>

<body>
    <div id="page">
        <h1>Student Form</h1>
        <div class="boxs">
            <div class="top">
                <form method="post" action="Servlet_addStudent">
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
                                <td><label for="age">Age</td>
                                <td><input id="age" type="number" name="age"></td>
                            </tr>
                            <tr>
                                <td><label for="email">Email</td>
                                <td><input id="email" type="email" name="email"></td>
                            </tr>
                            <tr>
                                <td><label for="group">Group</label></td>
                                <td><input id="group" type="text" name="group"></td>
                            </tr>
                            <tr>
                                <td><label for="faculty">Faculty</label></td>
                                <td><input id="faculty" type="text" name="faculty"></td>
                            </tr>
                        </tbody>
                    </table>
                    <input type="submit" name="send" value="Send">
                </form>
            </div>

            <div class="bot">
                
                
                <c:if test="${not empty students}">
                    <table class="list">
                        <tr>
                            <th>Name</th>
                            <th>Surname</th>
                            <th>Age</th>
                            <th>Email</th>
                            <th>Group</th>
                            <th>Faculty</th>
                        </tr>
                        <c:forEach items="${students}" var="s">
                            <tr>
                                <td><c:out value="${s.name}" /></td>
                                <td><c:out value="${s.surname}" /></td>
                                <td><c:out value="${s.age}" /></td> 
                                <td><c:out value="${s.email}" /></td>
                                <td><c:out value="${s.group}" /></td>
                                <td><c:out value="${s.faculty}" /></td>
                                <td><a href="GradesServlet?id=${s.id}">Grades</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
                
            </div>
            
        </div>
    </div>
</body>
</html>
