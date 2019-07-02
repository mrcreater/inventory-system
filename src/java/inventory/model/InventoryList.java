/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author PARIN
 */
public class InventoryList implements Serializable {
    
    private String productcategory;
    private int productid ;
    private String productname;
    private int productqty;
    private String manufacturer;
    private Date mfd;
    private Date purchasedate;
    private Double pprice;
    private Double tprice;
    
    public InventoryList()
    {
        this.productcategory = "";
        this.productid = 0;
        this.productname = "";
        this.productqty = 0;
        this.manufacturer = "";
        this.mfd = null;
        this.purchasedate = null;
        this.pprice = 0.0;
        this.tprice = 0.0;
    }

    public InventoryList(String productcategory, int productid, String productname, 
                        int productqty, String manufacturer, Date mfd, Date purchasedate,
                        Double pprice, Double tprice) {
        this.productcategory = productcategory;
        this.productid = productid;
        this.productname = productname;
        this.productqty = productqty;
        this.manufacturer = manufacturer;
        this.mfd = mfd;
        this.purchasedate = purchasedate;
        this.pprice = pprice;
        this.tprice = tprice;
    }

    public InventoryList(String category, int productid, String productname, int productqty, String Manufacturer, long mfd, long purchasedate, Double pprice, Double tprice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getProductcategory() {
        return productcategory;
    }

    public void setProductcategory(String productcategory) {
        this.productcategory = productcategory;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getProductqty() {
        return productqty;
    }

    public void setProductqty(int productqty) {
        this.productqty = productqty;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getMfd() {
        return mfd;
    }

    public void setMfd(Date mfd) {
        this.mfd = mfd;
    }

    public Date getPurchasedate() {
        return purchasedate;
    }

    public void setPurchasedate(Date purchasedate) {
        this.purchasedate = purchasedate;
    }

    public Double getPprice() {
        return pprice;
    }

    public void setPprice(Double pprice) {
        this.pprice = pprice;
    }

    public Double getTprice() {
        return tprice;
    }

    public void setTprice(Double tprice) {
        this.tprice = tprice;
    }
    
    
    
}
