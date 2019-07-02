/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.controller;

import inventory.database.DBinventory;
import inventory.model.InventoryList;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PARIN
 */
public class InventoryManagementApp extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //retrieve context params (db credentials) from DD
        String connUrl = getServletContext().
                    getInitParameter("connUrl");
        String database = getServletContext().
                    getInitParameter("database");
        String user = getServletContext().
                    getInitParameter("user");
        String password = getServletContext().
                    getInitParameter("pass"); 
            
        String url = "";
        String message = "";
        
        //declare an object for date format
        
        SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-mm-dd");
        
        
        // Get Input from the Jsp
        
        String category = request.getParameter("electronics");
        int productid = Integer.parseInt(request.getParameter("pid"));
        String productname = request.getParameter("pname");
        int productqty = Integer.parseInt(request.getParameter("pqty"));
        String Manufacturer = request.getParameter("mf");
        Double pprice = Double.parseDouble(request.getParameter("pprice"));
        Double tprice = pprice * productqty;
        
        //Setting date format
        
        Date mfd = null;
        Date purchasedate=null;
        try
        {
            mfd =dateformat.parse(request.getParameter("mfd"));        
            purchasedate = dateformat.parse(request.getParameter("pdate")); 
        }
        catch(ParseException e){}
        
       
        // User object for the input data
        
        InventoryList inventory = new InventoryList(category, productid, productname,productqty,
                                Manufacturer,mfd,purchasedate,pprice,tprice);
        
        // Create a data access object for database interactions
        DBinventory userDB = new DBinventory(connUrl, database, user, password);
        
       
               
        
        String cat = inventory.getProductcategory();
        int pid = inventory.getProductid();
        String pn = inventory.getProductname();
        int pq = inventory.getProductqty();
        String mf = inventory.getManufacturer();
        Date md = inventory.getMfd();
        Date pd = inventory.getPurchasedate();
        Double pp = inventory.getPprice();
        Double tp = inventory.getTprice();
        
         // setting the input data
         
        request.setAttribute("pcategory", cat);
        request.setAttribute("pid", pid);
        request.setAttribute("pname", pn);
        request.setAttribute("pqty", pq);
        request.setAttribute("mf", mf);
        request.setAttribute("mfd", md.toString());
        request.setAttribute("pdate", pd.toString());
        request.setAttribute("pprice", pp);
        request.setAttribute("tprice", tp);
       
        // checking the existence of the inventory record in the database
        boolean exists = DBinventory.emailExists(inventory.getProductid());
        if (exists){
            message ="Product already there. Inventory record is:";
            InventoryList inventory1 = DBinventory.selectInventoryList(inventory.getProductid());
            request.setAttribute("user", inventory1);
            request.setAttribute("message", message);
            url = "/StoredInventory.jsp";
        }
        else {
            // insert user data to the database
            int in = DBinventory.insert(inventory);
            if (in != 0) {
               InventoryList inventory2 = DBinventory.selectInventoryList(productid);
               message = "Inventory inserted into the Database";
               request.setAttribute("user", inventory2);
               request.setAttribute("message", message);
                url = "/StoredInventory.jsp";
                } 
            else {
                message = "Product was not inserted into the database. Inventory was:";
                request.setAttribute("user", inventory);
                request.setAttribute("message", message);
                url = "/StoredInventory.jsp"; 
            } 
        }
        
        RequestDispatcher view = request.getRequestDispatcher("StoredInventory.jsp");
        view.forward(request, response);
        
        }
    }

    


