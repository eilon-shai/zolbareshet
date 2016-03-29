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
public class date {
    
    private int Day    ;
    private int Month  ;
    private int Year   ; 
    
    public date () 
    {
        Day   = 1 ;
        Month = 1 ;
        Year  = 1900 ; 
    }
    
    
    public date (int day , int month , int year )
    {
        Day = day ; 
        Month = month ; 
        Year = year  ; 
    }
    
    public int getDay () 
    {
        return Day ; 
    }
    
    public int getMonth () 
    {
        return Month ; 
    }
    
    public int getYear () 
    {
        return Year  ; 
    }
    
    public String getDateToString () 
    {
        char tag = '-' ; 
        String BirthDate = "";
        BirthDate = "" + this.Year +  tag + this.Month + tag + this.Day ; 
        return BirthDate ; 
        
    }
    
}
