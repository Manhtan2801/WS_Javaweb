<%-- 
    Document   : search
    Created on : Feb 18, 2023, 4:06:37 PM
    Author     : Acer
--%>

<%@page import="Tan.registration.RegistrationDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>   
    <body>
        <%
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                String username = " ";
                for (Cookie cookie : cookies) {
                    String temp = cookie.getName();
                    if (!temp.equals("JSESSIONID")) {
                        username = temp;
                    }
                }

        %>
        <h2 style="color: red">Welcome, <%= username%> </h2>
        <%           }
        %>
        <h1>Search</h1>
        <form action="MainController">
            Last name <input type="text" name="txtSearchvalue" value="" /> 
            <input type="submit" value="search" name="btAction" /> </br>
        </form>

        <%
            String searchvalue = request.getParameter("txtSearchvalue");
            if (searchvalue
                    != null) {
                List<RegistrationDTO> result = (List<RegistrationDTO>) request.getAttribute("SEARCHVALUE");
                if (result != null) {
        %> 

        <table border="1">
            <thead>
                <tr>
                    <th>NO</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Lastname</th>
                    <th>Role</th>
                    <th>Delete</th>
                    <th>Update</th>                    
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (RegistrationDTO dto : result) {
                %>
            <form action="MainController">
                <tr>
                    <td>
                        <%= ++count%>
                    </td>
                    <td>
                        <%= dto.getUsername()%>
                        <input type='hidden' name='txtUsername'  value= "<%= dto.getUsername()%>" />
                    </td>
                    <td>
                        <input type="text" name="txtPassword" value="<%= dto.getPassword()%>" />
                    </td>
                    <td>
                        <input type="text" name="txtLastname" value="<%= dto.getLastname()%>" />
                    </td>
                    <td>                       
                        <input type="checkbox" name="chkAdmin" value="ADMIN"
                               <%
                                   if (dto.isIsAdmin()) {
                               %> 
                               checked="checked"    
                               <%
                                   }
                               %>
                               />
                    </td>
                    <%
                        String urlRewriting = "MainController?btAction=del&pk="
                                + dto.getUsername() + "&lastSearchvalue="
                                + searchvalue;
                    %>
                    <td>
                        <a href= <%= urlRewriting%>>Delete</a>
                    </td>
                    <td>
                        <input type="submit" value="Update" name="btAction" />
                        <input type="hidden" name="lastsearchvalue" 
                               value= "<%= searchvalue%>" />

                    </td>

                </tr>
            </form>

            <%
                }

            %>


        </tbody>
    </table>

    <%                } else {
    %>
    <h1>No record is matched</h1>
    <%
            }
        }
    %>

</body>
</html>
