/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEntities;

import java.sql.Date;

/**
 *
 * @author peretzs
 */
public class OrderPayment {
    private String UserName ; 
    private long UserID ; 
    private long CardNumber ; 
    private String CardType ; 
    private Date ExDate ; 
    
    public OrderPayment (String username , long id , long cardnumber , String cardType , Date exdate )
    {
        UserName   = username    ; 
        UserID     = id          ; 
        CardNumber = cardnumber  ; 
        CardType   = cardType    ; 
        ExDate     = exdate      ; 
    }
    
    //user name 
    public String getUserName ()
    {
        return this.UserName ; 
    }
    public void setUserName (String userName ) 
    {
        this.UserName = userName ;
    }
    
    // User ID 
    public long getUserID () 
    {
     return this.UserID ;    
    }
    public void setUserID (long userid)  
    {
        this.UserID = userid ; 
    }
    
    //card number 
    public long getCardNumber () 
    {
        return this.CardNumber ; 
    }
    public void setCardNumber(long cardNumber )
    {
        this.CardNumber = cardNumber ;
    }
    
    //Card Type 
    public String getCardType()
    {
        return this.CardType ; 
    }
    public void setCardType (String cardType )
    {
        this.CardType = cardType  ; 
    }
    
    //Ex Date 
    public Date getExDate ()
    {
        return this.ExDate ; 
    }
    public void setExDate (Date exDate )
    {
        this.ExDate = exDate ; 
    }
}
