/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEntities;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author peretzs
 */
public class Order {
    private long  orderID ; 
    private Date OrderDate ; 
    private Time OrderTime ;
    private float totalPay ; 
    
    public Order (long id , Date date  , Time time , float totpay)
    {
        orderID    = id     ; 
        OrderDate  = date   ; 
        OrderTime  = time   ; 
        totalPay   = totpay ; 
    }
    
    //order id 
    public long getOrderId()
    {
        return this.orderID ;
    }
    
    public void setOrderID (long orderid)
    {
        this.orderID = orderid ; 
    }
    
    //Order Date 
    
    public Date getDateOrder()
    {
        return this.OrderDate;
    }
    
    public void setOrderDate (Date orderDate )
    {
        this.OrderDate = orderDate ; 
    }
    
    // Order Time 
    
    public Time getOrderTime () 
    {
        return this.OrderTime ; 
    }
    
    public void setOrderTime (Time orderTIme)
    {
        this.OrderTime = orderTIme ; 
    }
    
    // total pay
    
    public float getTotalPay()
    {
        return this.totalPay ; 
    }
    
    public void setTotalPay (float totpay )
    {
        this.totalPay = totpay ; 
    }
}
