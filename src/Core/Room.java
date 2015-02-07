package Core;


/**
 * @author  PI KE
 */
public class Room {
	private int room_id=0;
	
	public void setRoomId(int room_id)
	{
		this.room_id=room_id;
	}
	
	public int getRoomId()
	{
		return room_id;
	}
	
	private boolean isAvailable=false;
	
	/**
	 * @param isAvailable
	 * @uml.property  name="isAvailable"
	 */
	public void setAvailable(boolean isAvailable)
	{
		this.isAvailable=isAvailable;
	}
	
	public boolean getAailable()
	{
		return isAvailable;
	}
	
	private int hotel_id=0;
	
	public void setHotelId(int hotel_id)
	{
		this.hotel_id=hotel_id;
	}
	
	public int getHotelId()
	{
		return hotel_id;
	}
	/**
	 * @uml.property  name="hotel"
	 * @uml.associationEnd  
	 */
	private Hotel hotel = new Hotel();
	
	/** 
	 * Getter of the property <tt>hotel</tt>
	 * @return  Returns the hotel.
	 * @uml.property  name="hotel"
	 */
	public Hotel getHotel() {
		return hotel;
	}

	/** 
	 * Setter of the property <tt>hotel</tt>
	 * @param hotel  The hotel to set.
	 * @uml.property  name="hotel"
	 */
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	/**
	 * @uml.property  name="price"
	 */
	private Double price = 0.0;

	/**
	 * Getter of the property <tt>price</tt>
	 * @return  Returns the price.
	 * @uml.property  name="price"
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * Setter of the property <tt>price</tt>
	 * @param price  The price to set.
	 * @uml.property  name="price"
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @uml.property  name="type"
	 */
	private String type = "";

	/**
	 * Getter of the property <tt>type</tt>
	 * @return  Returns the type.
	 * @uml.property  name="type"
	 */
	public String getType() {
		return type;
	}

	/**
	 * Setter of the property <tt>type</tt>
	 * @param type  The type to set.
	 * @uml.property  name="type"
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @uml.property  name="availDate"
	 */
	private String availDate;

	/**
	 * Getter of the property <tt>availDate</tt>
	 * @return  Returns the availDate.
	 * @uml.property  name="availDate"
	 */
	public String getAvailDate() {
		return availDate;
	}

	/**
	 * Setter of the property <tt>availDate</tt>
	 * @param availDate  The availDate to set.
	 * @uml.property  name="availDate"
	 */
	public void setAvailDate(String availDate) {
		this.availDate = availDate;
	}
	
	/**
	 * @uml.property  name="level"
	 */
	public int level;
	
	/**
	 * @return
	 * @uml.property  name="level"
	 */
	public int getLevel()
	{
		return level;
	}
	
    /**
	 * @param level
	 * @uml.property  name="level"
	 */
    public void setLevel(int level)
    {
    	this.level=level;
    }
    
	private String room_no="";
	
	public String getRoomNo()
	{
		return room_no;
	}
	
    public void setRoomNo(String room_no)
    {
    	this.room_no=room_no;
    }
    
    /**
	 * @uml.property  name="description"
	 */
    public String description;
    
	/**
	 * @return
	 * @uml.property  name="description"
	 */
	public String getDescription()
	{
		return description;
	}
	
    /**
	 * @param description
	 * @uml.property  name="description"
	 */
    public void setDescription(String description)
    {
    	this.description=description;
    }
    
    /**
	 * @uml.property  name="tel"
	 */
    private String tel="";
    
    /**
	 * @param tel
	 * @uml.property  name="tel"
	 */
    public void setTel(String tel)
    {
    	this.tel=tel;
    }
    
    /**
	 * @return
	 * @uml.property  name="tel"
	 */
    public String getTel()
    {
    	return tel;
    }
}