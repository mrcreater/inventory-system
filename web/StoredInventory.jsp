<%-- 
    Document   : StoredInventory
    Created on : May 24, 2019, 3:23:20 PM
    Author     : PARIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory List</title>
        <link rel="stylesheet" href="CSS/StoredInventory.css" type="text/css"/>
    </head>
    <body>
        <table id="inventory">
            <tr>
                <th>Product Category</th>
                <th>Product Name</th>
                <th>Product ID</th>
                <th>Product Qty.</th>
                <th>Manufacturer</th>
                <th>Manufacturing Date</th>
                <th>Purchase Date</th>
                <th>Price Per Qty.</th>
                <th>Total Price</th>
            </tr>      
    
            <tr>
                <td>
        <%
            String pcategory = (String)request.getAttribute("pcategory");
            out.print("" +pcategory);
        %>
                </td>
            
            <td>
        <%
            String pname = (String)request.getAttribute("pname");
            out.print("" +pname);
        %>
        </td>
        
            <td>
        <%
            int pid = (int)request.getAttribute("pid");
            out.print("" +pid);
        %>
        </td>
        
            <td>
        <%
            int pqty = (int)request.getAttribute("pqty");
            out.print("" +pqty);
        %>
        </td>
        
            <td>
        <%
            String mf = (String)request.getAttribute("mf");
            out.print("" +mf);
        %>
        </td>
        
            <td>
        <%
            String mfd = (String)request.getAttribute("mfd");
            out.print("" +mfd);
        %>
        </td>
        
            <td>
        <%
            String pdate = (String)request.getAttribute("pdate");
            out.print("" +pdate);
        %>
        </td>
        
            <td>
        <%
            Double pprice = (Double)request.getAttribute("pprice");
            out.print("" +pprice);
        %>
        </td>
        
            <td>
        <%
            Double tprice = (Double)request.getAttribute("tprice");
            out.print("" +tprice);
        %>
        </td>
        </tr>
        </table>
        </br> </br>
        
        <a href='/PatelParinkumar_Assign2/AddInventory.jsp'><button id="button">Go Back</button></a> 
        <a href='/PatelParinkumar_Assign2'><button id="button1">Go Home</button></a> 
    
    </body>
</html>
