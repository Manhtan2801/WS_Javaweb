<%-- 
    Document   : viewcart
    Created on : Mar 1, 2023, 3:46:46 PM
    Author     : Acer
--%>

<%@page import="javax.print.DocFlavor.STRING"%>
<%@page import="java.util.Map"%>
<%@page import="Tan.object.CartObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Your Shopping Cart</h1>
        <%
            if (session != null) {
                CartObject cart = (CartObject) session.getAttribute("CART");
                if (cart != null) {
                    if (cart.getItems() != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Book Title</th>
                    <th>Quantity</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
            <form action="MainController">
                <%
                    Map<String, Integer> items = cart.getItems();
                    int count = 0;
                    for (Map.Entry item : items.entrySet()) {
                %> 
                <tr>
                    <td>
                        <%= ++count%>
                    </td>
                    <td>
                        <%= item.getKey()%>
                    </td>
                    <td>
                        <%= item.getValue()%>
                    </td>
                    <td>
                        <input type="checkbox" name="chkItem" value="<%= item.getKey()%>" /> 
                    </td>
                </tr>   
                <%
                    }// end for
                %>
                <tr>
                    <td colspan="3">
                        <a href="shoppingcart.html">Add more books</a> 
                    </td>
                    <td>
                        <input type="submit" value="Remove Selected Items" name="btAction" />
                    </td>

                </tr>

            </form>

        </tbody>
    </table>



    <%
                    return;
                } //end cart.getitem
            } // end cart 

        }// end if session

    %>

    <a href="shoppingcart.html">CLick here to buy books</a>
</body>
</html>
