/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEntities;

/**
 *
 * @author peretzs
 */
public class OrderContent {
    private int quantity ; 
    
    public OrderContent (int qty ) 
    {
        quantity =  qty ; 
    }
    
    public int getQuantity () 
    {
        return this.quantity ; 
    }
    
    public void setQuantity  ( int qty )
    {
        this.quantity = qty ; 
    }
}
