<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KeepNote</title>
</head>
<body>
	<!-- Create a form which will have text boxes for Note ID, title, content and status along with a Send
		 button. Handle errors like empty fields -->
    <form action="add" method="post">
            <table>
                <tr>
                    <td> Title: </td>
                    <td>
                        <input type="text" name="noteTitle" required>
                    </td>
                </tr>
                <tr>
                    <td> Content: </td>
                    <td>
                        <input type="text" name="noteContent" required>
                    </td>
                </tr>
                <tr>
                    <td> Status: </td>
                    <td>
                          <input type="radio" name="noteStatus" value="Active" checked> Active
                          <input type="radio" name="noteStatus" value="Inactive"> Inactive
                    </td>
                </tr>
                <tr>
                    <td> </td>
                    <td>
                        <input type="submit" name="Add">
                    </td>
                </tr>
            </table>
        </form>
	<!-- display all existing notes in a tabular structure with Id, Title,Content,Status, Created Date and Action -->
	 <table border = "1">
           <thead>
               <td> ID </td>
               <td> Title </td>
               <td> Content </td>
               <td> Status </td>
               <td> Created Date </td>
               <td> Action </td>
           </thead>
               <c:forEach items="${list}" var="note">
                   <tr>
                       <td><c:out value ="${note.noteId}"/></td>
                       <td>${note.noteTitle}</td>
                       <td>${note.noteContent}</td>
                       <td>${note.noteStatus}</td>
                       <td>${note.createdAt}</td>
                       <td>
                           <form method="GET" action="delete">
                                 <input type="hidden" name="noteId" value="${note.noteId}" />
                                 <input type="submit" name="delete" value="Delete"/>
                           </form>

                             <form action="/updateButton" method="POST">
                                   <input type="submit" name="delete" value="Update"/>
                                   <input type="hidden" name="noteId" value="${note.noteId}" />
                             </form>

                       </td>

                   </tr>
               </c:forEach>
       </table>
</body>
</html>