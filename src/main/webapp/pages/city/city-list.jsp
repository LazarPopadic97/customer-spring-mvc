<%-- 
    Document   : city-add
    Created on : 06-May-2021, 11:15:59
    Author     : korisnik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>cities</title>

        <!-- reference our style sheet -->

    </head>

    <body>


        <h2>List of Cities </h2>

        ${successMessage}





        <table>
            <tr>
                <th>Code</th>
                <th>Name</th>
            </tr>

            <!-- loop over and print our customers -->
            <c:forEach var="cityDto" items="${cities}">

                <!--
                <!-- construct an "update" link with customer id -->
                <c:url var="updateLink" value="/city/showFormForUpdate">
                    <c:param name="cityCode" value="${cityDto.code}" />
                </c:url>

                <!-- construct an "delete" link with customer id -->
                <c:url var="deleteLink" value="/city/delete">
                    <c:param name="cityCode" value="${cityDto.code}" />
                </c:url>


                <tr>
                    <td> ${cityDto.code} </td>
                    <td> ${cityDto.name} </td>

                    <td>
                        <!-- display the update link -->
                        <a href="${updateLink}">Update</a>
                        |
                        <a href="${deleteLink}"
                           onclick="if (!(confirm('Are you sure you want to delete this city?')))
                                       return false">Delete</a>
                    </td>

                </tr>

            </c:forEach>

        </table>




    </body>
</html>
