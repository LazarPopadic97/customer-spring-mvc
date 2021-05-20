<%-- 
    Document   : city-add
    Created on : 06-May-2021, 11:15:59
    Author     : korisnik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>City add-model</title>
    </head>
    <body>
        <h1>This page is: city-add-model!</h1>
        <form action="/customer-spring-mvc/city/save-object" method="post">
            <form:hidden path="cityCode" />
            <div>
                ${errorMessage}
            </div>

            <table>
                <tbody>
                    <tr>
                        <td>City code:</td>
                        <td>
                            <input type="text" name="code" value=${cityDto.code}>
                        </td>
                    </tr>
                    <tr>
                        <td>City name:</td>
                        <td>
                            <input type="text" name="name" value=${cityDto.name}>
                        </td>
                    </tr>   
                    <tr>
                        <td colspan="2"> 
                            <input type="submit" value="Save">
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
