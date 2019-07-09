<%-- 
    Document   : AddInventory
    Created on : May 24, 2019, 3:22:25 PM
    Author     : PARIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Inventory</title>
        <link rel="stylesheet" href="CSS/AddInventory.css" type="text/css"/>

    </head>
    <body>
    <div class="container">
  <form action="InventoryManagementApp" method="POST">
      <center><h1>Electronic Inventory</h1></center>
    <div class="row">
      <div class="col-25">
        <label for="pcategory">Product Category</label>
      </div>
      <div class="col-75">
        <select name="electronics" style="width:350px">
        <option value="Laptops">Laptops</option>
        <option value="Mobile Phones">Mobile Phones</option>
        <option value="Headphones">HeadPhones</option>
        <option value="Fridge">Fridge</option>
        <option value="Air Conditioner">Air Conditioner</option>
        </select>
      </div>
    </div>  
    
      <div class="row">
      <div class="col-25">
        <label for="pid">Product ID :</label>
      </div>
      <div class="col-75">
        <input type="number" id="pid" name="pid" required="required" min="0" step="any">
      </div>
    </div>
      <div class="row">
      <div class="col-25">
        <label for="pname">Product Name :</label>
      </div>
      <div class="col-75">      
        <input type="text" id = 'pname' name="pname" style="width:350px">
      </div>
    </div>
      <div class="row">
      <div class="col-25">
        <label for="pqty">Product Qty. :</label>
      </div>
      <div class="col-75">
        <input type="number" id="pqty" name="pqty" min="1" step="any">
      </div>
    </div>
      <div class="row">
      <div class="col-25">
        <label for="mf">Manufacturer :</label>
      </div>
      <div class="col-75">
        <input type="text" id="mf" name="mf" style="width:350px" required="required">
      </div>
    </div>
      <div class="row">
      <div class="col-25">
        <label for="mfd">Manufacturing Date :</label>
      </div>
      <div class="col-75">
        <input type="date" id="mfd" name="mfd">
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="pdate">Purchase Date :</label>
      </div>
      <div class="col-75">
        <input type="date" id="pdate" name="pdate">
      </div>        
    </div>
      
      <div class="row">
      <div class="col-25">
        <label for="pprice">Product Price Per Qty. :</label>
      </div>
      <div class="col-75">
        <span>$</span>  
        <input type="number" id="pprice" name="pprice" min="0" step="any">
      </div>        
    </div>
    
    <div class="row" style="text-align: center">
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
        
        
    </div>
      
  </form>
     <a href='/PatelParinkumar_Assign2'><button id="button">Go Back</button></a>   
</div>

    </body>
</html>
