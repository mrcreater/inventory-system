/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.database;

import inventory.model.InventoryList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PARIN
 */
public class DBinventory {
    
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url;
    private static String databaseName;
    private static String username;
    private static String password;
    
    // private member variable to hold the connection
    private static Connection conn = null;

    
    public DBinventory(String url, String databaseName, 
                    String username, String password) {
        this.url = url;
        this.databaseName = databaseName;
        this.username = username;
        this.password = password;
    }
    
    /**
     * A method that will connect to the specified JDBC driver
     *
     * @param driver driver to connect to, 
     *              typically com.mysql.jdbc.Driver
     * @param url url pointing to your database server; 
     *              i.e. jdbc:mysql://localhost:3306/
     * @param databaseName the database you want to connect to
     * @param username the db username to connect with
     * @param password password correspond to db username
     */
    public static void createConnection() {
        try {
            Class.forName(driver);
            // get the connection from the DriverManager
            conn = DriverManager.getConnection(DBinventory.url + DBinventory.databaseName, 
                                DBinventory.username, DBinventory.password);
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException: " + 
                    e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getSQLState());
            System.err.println("SQLException: " + e.getErrorCode());
            System.err.println("SQLException: " + e.getMessage());
        }
    }

 

    public static int insert(InventoryList inventory_db) {
        
        DBinventory.createConnection();
        Connection connection = DBinventory.conn;
        PreparedStatement ps = null;

        String query
                = "INSERT INTO inventory_list (product_id, product_category, product_name, product_qty, manufacturer, mf_date, purchase_date, purchase_price, total_price) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
                    
            ps.setString(2, inventory_db.getProductcategory());
            ps.setInt(1, inventory_db.getProductid());
            ps.setString(3, inventory_db.getProductname());
            ps.setInt(4, inventory_db.getProductqty());
            ps.setString(5, inventory_db.getManufacturer());
            ps.setDate(6, new java.sql.Date (inventory_db.getMfd().getTime()));
            ps.setDate(7, new java.sql.Date (inventory_db.getPurchasedate().getTime()));
            ps.setDouble(8, inventory_db.getPprice());
            ps.setDouble(9, inventory_db.getTprice());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBconn.closeConnection(connection);
            DBconn.closePreparedStatement(ps);
          }
    }

    public static int update(InventoryList inventory_db) {
        DBinventory.createConnection();
        Connection connection = DBinventory.conn;
        PreparedStatement ps = null;

        String query = "UPDATE inventory_list SET "
                + "product_category = ?, "
                + "product_name = ? "
                + "product_qty = ? "
                + "manufacturer = ? "
                + "mf_date = ? "
                + "purchase_date = ? "
                + "purchase_price = ? "
                + "WHERE product_id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, inventory_db.getProductid());
            ps.setString(2, inventory_db.getProductcategory());
            ps.setString(3, inventory_db.getProductname());
            ps.setInt(4, inventory_db.getProductqty());
            ps.setString(5, inventory_db.getManufacturer());
            ps.setDate(6, new java.sql.Date (inventory_db.getMfd().getTime()));
            ps.setDate(7, new java.sql.Date (inventory_db.getPurchasedate().getTime()));
            ps.setDouble(8, inventory_db.getPprice());
            

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBconn.closeConnection(connection);
            DBconn.closePreparedStatement(ps);
          }
    }

    public static int delete(InventoryList inventory_db) {
        DBinventory.createConnection();
        Connection connection = DBinventory.conn;
        PreparedStatement ps = null;

        String query = "DELETE FROM inventory_list "
                + "WHERE product_id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, inventory_db.getProductid());

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBconn.closeConnection(connection);
            DBconn.closePreparedStatement(ps);
        }
    }

    public static boolean emailExists(int product_id) {
        DBinventory.createConnection();
        Connection connection = DBinventory.conn;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int em = product_id;
        boolean exists = false;

        String query = "SELECT product_id FROM inventory_list "
                + "WHERE product_id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, product_id);
            rs = ps.executeQuery();
            em = (Integer)rs.getObject(3);
            exists = (em == product_id);
            
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DBconn.closeConnection(connection);
            DBconn.closeResultSet(rs);
            DBconn.closePreparedStatement(ps);
         }
        return exists;
    }

    public static InventoryList selectInventoryList(int product_id) {
        DBinventory.createConnection();
        Connection connection = DBinventory.conn;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM inventory_list "
                + "WHERE product_id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, product_id);
            rs = ps.executeQuery();
            InventoryList inventory_db = null;
            if (rs.next()) {
                inventory_db = new InventoryList();
                inventory_db.setProductid(rs.getInt("product_id"));
                inventory_db.setProductcategory(rs.getString("product_category"));
                inventory_db.setProductname(rs.getString("product_name"));
                inventory_db.setProductqty(rs.getInt("product_qty"));
                inventory_db.setManufacturer(rs.getString("manufacturer"));
                inventory_db.setMfd(rs.getDate("mf_date"));
                inventory_db.setPurchasedate(rs.getDate("purchase_date"));
                inventory_db.setPprice(rs.getDouble("purhcase_price"));
                inventory_db.setTprice(rs.getDouble("total_price"));
            }
            return inventory_db;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBconn.closeConnection(connection);
            DBconn.closeResultSet(rs);
            DBconn.closePreparedStatement(ps);
        }
    }
}
