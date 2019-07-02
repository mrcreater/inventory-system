<%-- 
    Document   : WelcomePage
    Created on : May 24, 2019, 3:22:00 PM
    Author     : PARIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory Management System</title>
    
  <style>


button {
  background-color: black;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: none;
  
}

button1 {
  background-color: white;
  color: black;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: none;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
  
</style>
    </head>
    <body>
        <div class="container">
    <center>
        
        <h1>Welcome To Inventory Management System</h1>
        
    <p>
    <a>
        This is an Inventory Management System used for managing the list of multiple electronics
        products stored in a warehouse or any store.By this inventory system you can easily record 
        the data of a particular item of your store like its prize, quantity,
        stock management, Manufacturing date, Purchase date, Product name and much more related to a 
        product. It's an very handy application for any person who is running a store or an
        organization and want to keep records for its products this application will help them and
        will reduce their half work load by managing their product.
    </a>
    </p> 
    </br>
    <a href='AddInventory.jsp'><button id="button" style="width:200px">Add Inventory</button></a>
    
    </center>
    
        </div>         
    </body>
</html>
