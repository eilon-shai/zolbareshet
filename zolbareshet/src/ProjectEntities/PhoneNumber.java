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
    
    private int PhoneNumber1 ; 
    private int PhoneNumber2 ;
    private int PhoneNumber3 ; 
    private int PhoneNumber4 ; 
    private final int MAX_NUMBERS = 4 ; 
   
        
    public PhoneNumber(int number1 , int number2 , int number3 , int number4 ) 
    {
        PhoneNumber1 = number1;
        PhoneNumber2 = number2;
        PhoneNumber3 = number3;
        PhoneNumber4 = number4;
    }
    
    public int[] getPhoneNumbers ()
    {
       int [] PhoneList  = new int [MAX_NUMBERS] ;
       PhoneList[0] = this.PhoneNumber1 ; 
       PhoneList[1] = this.PhoneNumber2 ; 
       PhoneList[2] = this.PhoneNumber3 ; 
       PhoneList[3] = this.PhoneNumber4 ; 
        return PhoneList ;
    }

    public int getPhoneNumber_1 ()
    {

        return this.PhoneNumber1 ;
    }
    
    
    
    
    public void setPhoneNumbers (int [] NewPhoneNumbers ) 
    {
         
       this.PhoneNumber1 = NewPhoneNumbers[0];
       this.PhoneNumber2 = NewPhoneNumbers[1];
       this.PhoneNumber3 = NewPhoneNumbers[2]; 
       this.PhoneNumber4 = NewPhoneNumbers[3]; 
    }
    
}
