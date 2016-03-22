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
public class Parts {
    private int PartNumber ; 
    private String PartName ; 
    private String Description ; 
    private int Price ; 
    private int AvailableQuantity ; 
    private boolean IsActive ; 
    private int discount ; 
    
    public Parts(int partnumber, String partname , String description ,int Price , int availablequantity , boolean isactive , int discount )
    {
          PartNumber =partnumber ; 
          PartName = partname ; 
          Description = description ; 
          Price = Price ; 
          AvailableQuantity = availablequantity ; 
          IsActive = isactive ; 
          discount = discount ; 
    }
    
    //Part Number 
    public int getPartNumber ()
    {
        return this.PartNumber;
    }
    
    public void setPartNumber( int newNum )
    {
        this.PartNumber = newNum ; 
    }
    
    
    //Part Name 
    
    public String getPartName ()
    {
        return this.PartName;
    }
    
    public void setPartName ( String partName )
    {
        this.PartName = partName ; 
    }
    
    
    //part description 
    
    public String getDescription ()
    {
        return this.Description ;
    }
    
    public void setDescription (String NewDescription )
    {
         this.Description = NewDescription;
    }
    
    //price 
    
    public int getPrice () 
    {
        return this.Price ; 
    }
    
    public void setPrice (int NewPrice )
    {
        this.Price =NewPrice ; 
    }
    
    //availablequantity
    
    public int getQuantity ()
    {
        return this.AvailableQuantity;
    }
    
    public void setQuantity (int NewQuantity ) 
    {
        this.AvailableQuantity = NewQuantity ; 
    }
    
    //Is Active 
    
    public boolean getIsActive ()
    {
        return this.IsActive;
    }
    
    public void setIsActive (boolean isactive )
    {
        this.IsActive = isactive ; 
    }
    
    //discount
    
    public int getDiscount ()
    {
        return this.discount;
    }
    
    public void setDiscount(int Discount)
    {
        this.discount = Discount ; 
    }
}

