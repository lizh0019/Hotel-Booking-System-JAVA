package Core;

/**
 */
public class Address {
	/**
	 * @uml.property  name="country"
	 */
	public String country="";
	/**
	 * @uml.property  name="street"
	 */
	public String street="";
	/**
	 * @uml.property  name="postCode"
	 */
	public String postCode="";
	
	/**
	 * @param street
	 * @param country
	 * @param postCode
	 */
	public Address(String street,String country,String postCode)
	{
		this.street=street;
		this.country=country;
		this.postCode=postCode;
	}
	
	/**
	 * @return
	 * @uml.property  name="country"
	 */
	public String getCountry()
	{
		return country;
	}
	
	/**
	 * @param country
	 * @uml.property  name="country"
	 */
	public void setCountry(String country)
	{
		this.country=country;
	}
	
	/**
	 * @return
	 * @uml.property  name="street"
	 */
	public String getStreet()
	{
		return street;
	}
	
	/**
	 * @param street
	 * @uml.property  name="street"
	 */
	public void setStreet(String street)
	{
		this.street=street;
	}
	
	/**
	 * @return
	 * @uml.property  name="postCode"
	 */
	public String getPostCode()
	{
		return postCode;
	}
	
	/**
	 * @param postCode
	 * @uml.property  name="postCode"
	 */
	public void setPostCode(String postCode)
	{
		this.postCode=postCode;
	}
	
	/**
	 * @return
	 */
	public String getAddress()
	{
		return street+" "+country+" "+postCode;
	}
	
	public String toString()
	{
		return street+" "+country+","+postCode;
	}


}
