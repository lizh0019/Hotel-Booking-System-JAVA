package Core;
import java.util.Date;



/**
 * @author  PI KE
 */
public class SpecRoom extends Room {
	/**
	 * @uml.property  name="bookedDate"
	 */
	private Date bookedDate;
	
	/**
	 * @param date
	 * @uml.property  name="bookedDate"
	 */
	public void setBookedDate(Date date)
	{
		bookedDate=date;
	}
	
	/**
	 * @return
	 * @uml.property  name="bookedDate"
	 */
	public Date getBookedDate()
	{
		return bookedDate;
	}
	/**
	 * @uml.property  name="customer"
	 * @uml.associationEnd  
	 */
	private Customer customer ;

	/**
	 * Getter of the property <tt>customer</tt>
	 * @return  Returns the customer.
	 * @uml.property  name="customer"
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Setter of the property <tt>customer</tt>
	 * @param customer  The customer to set.
	 * @uml.property  name="customer"
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
