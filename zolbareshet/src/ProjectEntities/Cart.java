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
public class Cart {
    private String UserName ; 
    private long PartNumber ; 
    private int Quantity ; 
    
    public Cart (String user , long partNumber  , int quntity )
    {
        UserName   =  user       ; 
        PartNumber =  partNumber ;
        Quantity   =  quntity    ; 
    }
    
    //User Name 
    public String getUserName ()
    {
        return this.UserName ; 
    }
    
    public void setUserName (String userName)
    {
        this.UserName = userName  ; 
    }
    
    //Part Number 
    public long getPartNumber () 
    {
        return this.PartNumber ; 
    }
    
    public void setPartNumber (long partNumber ) 
    {
        this.PartNumber =partNumber ;
    }
    
    //Quantity 
    public int getQuantity () 
    {
        return this.Quantity ;
    }
    public void setQuantity (int qty )
    {
        this.Quantity = qty ; 
    }
}
