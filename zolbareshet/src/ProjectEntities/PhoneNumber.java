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
public class PhoneNumber {
    
    private long PhoneNumber1 ; 
    private long PhoneNumber2 ;
    private long PhoneNumber3 ; 
    private long PhoneNumber4 ; 
    private final int MAX_NUMBERS = 4 ; 
    private final int  NA = -1 ; 
   
      
    public PhoneNumber( ) 
    {
        PhoneNumber1 = NA ; 
        PhoneNumber2 = NA ;
        PhoneNumber3 = NA ;
        PhoneNumber4 = NA ;
    }
    
    public PhoneNumber(long number1 , long number2 , long number3 , long number4 ) 
    {
        PhoneNumber1 = number1;
        PhoneNumber2 = number2;
        PhoneNumber3 = number3;
        PhoneNumber4 = number4;
    }
    
    public PhoneNumber(String number1 , String number2 , String number3 , String number4 ) 
    {
        if (number1 != null )
                PhoneNumber1 = Long.parseLong(number1) ;
            else PhoneNumber1 = -1 ;
        if (number2 != null )
                 PhoneNumber2 = Long.parseLong(number2);
            else PhoneNumber2 = -1 ;
        if (number3 != null )
                PhoneNumber3 = Long.parseLong(number3);
            else PhoneNumber3 = -1 ;
        if (number4 != null )
                PhoneNumber4 = Long.parseLong(number4);
            else PhoneNumber4 = -1 ;
    }
    
    public long[] getPhoneNumbers ()
    {
       long [] PhoneList  = new long [MAX_NUMBERS] ;
       PhoneList[0] = this.PhoneNumber1 ; 
       PhoneList[1] = this.PhoneNumber2 ; 
       PhoneList[2] = this.PhoneNumber3 ; 
       PhoneList[3] = this.PhoneNumber4 ; 
        return PhoneList ;
    }

    public long getPhoneNumber_1 ()
    {

        return this.PhoneNumber1 ;
    }
    
    public long getPhoneNumber_2 ()
    {

        return this.PhoneNumber2 ;
    }
        
    public long getPhoneNumber_3 ()
    {

        return this.PhoneNumber3 ;
    }
            
    public long getPhoneNumber_4 ()
    {

        return this.PhoneNumber4 ;
    }
    
    
    
    
    public void setPhoneNumbers (long [] NewPhoneNumbers ) 
    {
         
       this.PhoneNumber1 = NewPhoneNumbers[0];
       this.PhoneNumber2 = NewPhoneNumbers[1];
       this.PhoneNumber3 = NewPhoneNumbers[2]; 
       this.PhoneNumber4 = NewPhoneNumbers[3]; 
    }
    
    public String toString ()
    {
        String phones = "Number 1 : " + this.PhoneNumber1 + "\tNumber 2 :" + this.PhoneNumber2 + "\tNumber 3 : " + this.PhoneNumber3 + "\tNumber 4: " + this.PhoneNumber4 + "\n" ;
        return  phones ; 
        
    }
    
}
