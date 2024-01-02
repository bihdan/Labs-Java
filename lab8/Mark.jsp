<%-- 
    Document   : Mark
    Created on : 27 дек. 2023 г., 18:46:22
    Author     : bogda
--%>

<%@page import="java.util.List"%>
<%@page import="sumdu.model.Student"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mark</title>
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
            <div class="boxs">
                <div class="bot">
                    
                    <h1>Scores of <c:out value ="${user.getId()}"/> <c:out value ="${user.getName()}"/> <c:out value ="${user.getSurname()}"/></h1>
                    
                        <table class = "list">
                            <tr>
                                <th>Discipline</th>
                                <th>Mark</th>
                                <th>ECTS</th>
                            </tr>
                            <c:forEach items="${marks}" var="m">
                                <tr>
                                    <td><c:out value ="${m.getTitle()}"/></td>
                                    <td><c:out value ="${m.getMark_num()}"/></td>
                                    <td><c:out value ="${m.getMark_let()}"/></td>
                                </tr>
                            </c:forEach>
                        </table>

                </div>
            </div>
        </div>
      
        
    </body>
</html>
