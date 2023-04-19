<%-- 
    Document   : newjspcreatenewaccount
    Created on : Mar 4, 2023, 4:38:22 PM
    Author     : Acer
--%>

<%@page import="Tan.registration.RegistrationInsertError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register Page</h1>
        <form action="MainController">
            Username*: <input type="text" name="txtUsername" 
                              value="<%= request.getParameter("txtUsername") %>" /> (3-12 chars)</br>
            <font color="red">
            <%
                RegistrationInsertError err = 
                        (RegistrationInsertError)request.getAttribute("INSERTERRS");
                if (err != null) {
                    if (err.getUsernameLengthErr() != null) {
                        %> 
                        <%= err.getUsernameLengthErr() %><br/>            
            <%
                        }
                        
                    }//end if err
            %>
            </font>
            Password*: <input type="password" name="txtPassword" value="" /> (3-12 chars)</br>
            <font color="red">
            <%
                if (err != null) {
                    if (err.getPasswordLengthErr()!= null) {
                        %> 
                        <%= err.getPasswordLengthErr()%><br/>            
            <%
                        }
                        
                    }//end if err
            %>
            </font>
            Confirm*: <input type="password" name="txtConfirm" value="" /></br>
            <font color="red">
            <%
                if (err != null) {
                    if (err.getconfirmNotMatch()!= null) {
                        %> 
                        <%= err.getconfirmNotMatch()%><br/>            
            <%
                        }
                        
                    }//end if err
            %>
            </font>
            Full name*: <input type="text" name="txtFullname" 
                               value="<%= request.getParameter("txtFullname") %>" /> (2-40 chars)</br>
            <font color="red">
            <%
                if (err != null) {
                    if (err.getFullnameLengthErr()!= null) {
                        %> 
                        <%= err.getFullnameLengthErr()%><br/>            
            <%
                        }
                        
                    }//end if err
            %>
            </font>
            <input type="submit" value="Sign up" name="btAction" />
            <input type="reset" value="Reset" />
        </form></br>
        <font style="color: red">
        <%
                if (err != null) {
                    if (err.getUsernameisExisted()!= null) {
                        %> 
                        <%= err.getUsernameisExisted()%><br/>            
            <%
                        }
                        
                    }//end if err
            %>
            </font>
    </body>
</html>
