package Core;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;

import DataModel.DataConnection;

/**
 * @author  PI KE
 */
public class Customer {
	/**
	 * @uml.property  name="name"
	 */
	private String name = "";

	/**
	 * Getter of the property <tt>name</tt>
	 * @return  Returns the name.
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter of the property <tt>name</tt>
	 * @param name  The name to set.
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @uml.property  name="custID"
	 */
	private long custID;

	/**
	 * Getter of the property <tt>custID</tt>
	 * @return  Returns the custID.
	 * @uml.property  name="custID"
	 */
	public long getCustID() {
		return custID;
	}

	/**
	 * Setter of the property <tt>custID</tt>
	 * @param custID  The custID to set.
	 * @uml.property  name="custID"
	 */
	public void setCustID(long custID) {
		this.custID = custID;
	}

	/**
	 * @uml.property  name="gender"
	 */
	private String gender;

	/**
	 * Getter of the property <tt>gender</tt>
	 * @return  Returns the gender.
	 * @uml.property  name="gender"
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Setter of the property <tt>gender</tt>
	 * @param gender  The gender to set.
	 * @uml.property  name="gender"
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @uml.property  name="contactNo"
	 */
	private String contactNo="";
	
	/**
	 * @param contactNo
	 * @uml.property  name="contactNo"
	 */
	public void setContactNo(String contactNo)
	{
		this.contactNo=contactNo;
	}
	
	/**
	 * @return
	 * @uml.property  name="contactNo"
	 */
	public String getContactNo()
	{
		return contactNo;
	}
	
	/**
	 * @uml.property  name="email"
	 */
	private String email="";
	
	/**
	 * @param email
	 * @uml.property  name="email"
	 */
	public void setEmail(String email)
	{
		this.email=email;
	}
	
	/**
	 * @return
	 * @uml.property  name="email"
	 */
	public String getEmail()
	{
		return email;
	}
	
	/**
	 * @uml.property  name="country"
	 */
	private String country="";
	
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
	 * @uml.property  name="country"
	 */
	public String getCountry()
	{
		return country;
	}
	
	private String street="";
	
	/**
	 * @param street
	 * @uml.property  name="street"
	 */
	public void setStreet(String street)
	{
		this.street=street;
	}
	
	public String getSStreet()
	{
		return street;
	}
	
	/**
	 * @uml.property  name="postCode"
	 */
	private String postCode="";
	
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
	 * @uml.property  name="postCode"
	 */
	public String getPostCode()
	{
		return postCode;
	}
	/**
	 * @uml.property  name="identity"
	 */
	private String identity = "";

	/**
	 * Getter of the property <tt>identity</tt>
	 * @return  Returns the identity.
	 * @uml.property  name="identity"
	 */
	public String getIdentity() {
		return identity;
	}

	/**
	 * Setter of the property <tt>identity</tt>
	 * @param identity  The identity to set.
	 * @uml.property  name="identity"
	 */
	public void setIdentity(String identity) {
		this.identity = identity;
	}

	/**
	 * @uml.property  name="specRoom"
	 * @uml.associationEnd  multiplicity="(0 -1)" inverse="customer:SpecRoom"
	 */
	private Collection<SpecRoom> specRoom = new java.util.ArrayList<SpecRoom>();

	/**
	 * Getter of the property <tt>specRoom</tt>
	 * @return  Returns the specRoom.
	 * @uml.property  name="specRoom"
	 */
	public Collection<SpecRoom> getSpecRoom() {
		return specRoom;
	}

	/**
	 * Returns an iterator over the elements in this collection. 
	 * @return  an <tt>Iterator</tt> over the elements in this collection
	 * @see java.util.Collection#iterator()
	 * @uml.property  name="specRoom"
	 */
	public Iterator<SpecRoom> specRoomIterator() {
		return specRoom.iterator();
	}

	/**
	 * Returns <tt>true</tt> if this collection contains no elements.
	 * @return  <tt>true</tt> if this collection contains no elements
	 * @see java.util.Collection#isEmpty()
	 * @uml.property  name="specRoom"
	 */
	public boolean isSpecRoomEmpty() {
		return specRoom.isEmpty();
	}

	/**
	 * Returns <tt>true</tt> if this collection contains the specified element. 
	 * @param element  whose presence in this collection is to be tested.
	 * @see java.util.Collection#contains(Object)
	 * @uml.property  name="specRoom"
	 */
	public boolean containsSpecRoom(SpecRoom specRoom) {
		return this.specRoom.contains(specRoom);
	}

	/**
	 * Returns <tt>true</tt> if this collection contains all of the elements in the specified collection.
	 * @param elements  collection to be checked for containment in this collection.
	 * @see java.util.Collection#containsAll(Collection)
	 * @uml.property  name="specRoom"
	 */
	public boolean containsAllSpecRoom(Collection specRoom) {
		return this.specRoom.containsAll(specRoom);
	}

	/**
	 * Returns the number of elements in this collection.
	 * @return  the number of elements in this collection
	 * @see java.util.Collection#size()
	 * @uml.property  name="specRoom"
	 */
	public int specRoomSize() {
		return specRoom.size();
	}

	/**
	 * Returns all elements of this collection in an array.
	 * @return  an array containing all of the elements in this collection
	 * @see java.util.Collection#toArray()
	 * @uml.property  name="specRoom"
	 */
	public SpecRoom[] specRoomToArray() {
		return specRoom.toArray(new SpecRoom[specRoom.size()]);
	}

	/**
	 * Returns an array containing all of the elements in this collection;  the runtime type of the returned array is that of the specified array.
	 * @param a  the array into which the elements of this collection are to be stored.
	 * @return  an array containing all of the elements in this collection
	 * @see java.util.Collection#toArray(Object[])
	 * @uml.property  name="specRoom"
	 */
	public SpecRoom[] specRoomToArray(SpecRoom[] specRoom) {
		return this.specRoom.toArray(specRoom);
	}

	/**
	 * Ensures that this collection contains the specified element (optional operation). 
	 * @param element  whose presence in this collection is to be ensured.
	 * @see java.util.Collection#add(Object)
	 * @uml.property  name="specRoom"
	 */
	public boolean addSpecRoom(SpecRoom specRoom) {
		
		return this.specRoom.add(specRoom);
	}

	/**
	 * Setter of the property <tt>specRoom</tt>
	 * @param specRoom  the specRoom to set.
	 * @uml.property  name="specRoom"
	 */
	public void setSpecRoom(Collection<SpecRoom> specRoom) {
		this.specRoom = specRoom;
	}

	/**
	 * Removes a single instance of the specified element from this collection, if it is present (optional operation).
	 * @param element  to be removed from this collection, if present.
	 * @see java.util.Collection#add(Object)
	 * @uml.property  name="specRoom"
	 */
	public boolean removeSpecRoom(SpecRoom specRoom) {
		return this.specRoom.remove(specRoom);
	}

	/**
	 * Removes all of the elements from this collection (optional operation).
	 * @see java.util.Collection#clear()
	 * @uml.property  name="specRoom"
	 */
	public void clearSpecRoom() {
		this.specRoom.clear();
	}

	private Vector<Room> selectedRooms=new Vector<Room>();
	
	public void addSelecteddRoom(Room room)
	{
		int i=0;
		for(;i<selectedRooms.size();i++)
		{
			if(selectedRooms.get(i).getRoomId()==room.getRoomId())
				break;
		}
		if(i==selectedRooms.size())
			selectedRooms.addElement(room);
	}
	
	public void removeSelectedRoom(Room room)
	{
		int total_number=selectedRooms.size();
		for(int i=0;i<total_number;i++)
		{
			if(selectedRooms.get(i).getRoomId()==room.getRoomId())
			{
				System.out.println("Room "+getSelectedRoom().size()+" is left before");
				selectedRooms.removeElement(selectedRooms.get(i));
				System.out.println("Room "+getSelectedRoom().size()+" is left after");
				break;
			}
		}
	}
	
	public void clearSelectedRoom()
	{
		selectedRooms=new Vector<Room>();
	}
	
	public Vector<Room> getSelectedRoom()
	{
		return selectedRooms;
	}
	
	public boolean isBookingCanceled=true;
	
	public boolean pay()
	{
		DataConnection conn=new DataConnection();
		String insertSql="insert into customer (customer_id,name,gender,contact_no,email,country,street,postcode,update_time,end_time) values ("+custID+",'"+name+"','"+gender+"','"+contactNo+"','"+email+"','"+country+"','"+street+"','"+postCode+"',null,null)";
		//Check whether the customer id is existed in the database of not
		String selectSql="select * from customer where customer_id="+custID;
		ResultSet sRs=conn.getResultSet(selectSql);
		int row_count=0;
		try {
			while(sRs.next())
				row_count++;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//Insert customer information into database
		if(row_count<=0&&conn.setUpdateStatement(insertSql)<1)
		{
			JOptionPane.showMessageDialog(null,"Cannot insert customer information into database","Database error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		//Update room table to set the available date of the room to unavailable
		Iterator<SpecRoom> it=specRoom.iterator();
		int count=0;
		while(it.hasNext())
		{
			SpecRoom sr=it.next();
			String updateSql="update Room set is_available=0 where room_id="+sr.getRoomId();
			if(conn.setUpdateStatement(updateSql)<1)
			{
				JOptionPane.showMessageDialog(null,"Cannot update room information into database","Database error",JOptionPane.ERROR_MESSAGE);
				return false;
			}
				
			String insertSql1="insert into BookedRoom (room_id,customer_id,update_time,end_time) values ("+sr.getRoomId()+","+custID+",null,null)";
			if(conn.setUpdateStatement(insertSql1)<1)
			{
				JOptionPane.showMessageDialog(null,"Cannot insert booked room information into database","Database error",JOptionPane.ERROR_MESSAGE);
				return false;
			}
			this.removeSelectedRoom(sr);
			count++;
		}
		conn.CloseConn();
		isBookingCanceled=false;
		return true;
	}
	
	public boolean cancelBooking()
	{
		DataConnection conn=new DataConnection();
		String deleteSql="delete from Customer where customer_id="+custID;
		
		if(conn.setUpdateStatement(deleteSql)<1)
		{
			JOptionPane.showMessageDialog(null,"Cannot delete customer information from database","Database error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		Iterator<SpecRoom> it=specRoom.iterator();
		while(it.hasNext())
		{
			SpecRoom sr=it.next();
			String updateSql="update Room set is_available=1 where room_id="+sr.getRoomId();
			if(conn.setUpdateStatement(updateSql)<1)
			{
				JOptionPane.showMessageDialog(null,"Cannot update room information into database","Database error",JOptionPane.ERROR_MESSAGE);
				return false;
			}
				
			String deleteSql1="delete from BookedRoom where room_id="+sr.getRoomId()+" and customer_id="+custID;
			if(conn.setUpdateStatement(deleteSql1)<1)
			{
				JOptionPane.showMessageDialog(null,"Cannot delete booked room information from database","Database error",JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		this.clearSpecRoom();
		conn.CloseConn();
		isBookingCanceled=true;
		JOptionPane.showMessageDialog(null,"Your booking is cancelled","Booking cancelled",JOptionPane.INFORMATION_MESSAGE);
		return true;
	}
	
	public String displayCustomerInfo()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("<html>");
		//sb.append("<html><p><center>"+getName()+"</center></p>");
		sb.append("<p>ID : "+getCustID()+"</p>");
		sb.append("<p>&nbsp;</p>");
		sb.append("<p>Name : "+getName()+"</p>");
		sb.append("<p>&nbsp;</p>");
		sb.append("<p>Gender : "+getGender()+"</p>");
		sb.append("<p>&nbsp;</p>");
		sb.append("<p>Email : "+getEmail()+"</p>"); 
		sb.append("<p>&nbsp;</p>");
		sb.append("<p>Conatct No. : "+getContactNo()+"</p>"); 
		sb.append("<p>&nbsp;</p>");
		sb.append("<p>Country : "+getCountry()+"</p>"); 
		sb.append("<p>&nbsp;</p>");
		sb.append("<p>Street : "+getSStreet()+"</p>"); 
		sb.append("<p>&nbsp;</p>");
		sb.append("<p>Post code : "+getPostCode()+"</p>"); 
		sb.append("<p>&nbsp;</p>");
		sb.append("</html>");
		return sb.toString();
	}
	
	public String displayBookingInfo()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("<html><p><center>"+getName()+"</center></p>");
		sb.append("<p>ID : "+getCustID()+"</p>");
		sb.append("<p>&nbsp;</p>");
		sb.append("<p>Name : "+getName()+"</p>");
		sb.append("<p>&nbsp;</p>");
		sb.append("<p>Gender : "+getGender()+"</p>");
		sb.append("<p>&nbsp;</p>");
		sb.append("<p>Email : "+getEmail()+"</p>"); 
		sb.append("<p>&nbsp;</p>");
		sb.append("<p>Conatct No. : "+getContactNo()+"</p>"); 
		sb.append("<p>&nbsp;</p>");
		sb.append("<p>-------------------------------Booked Room Information--------------------------------</p>"); 
		Iterator<SpecRoom> ir=specRoom.iterator();
		while(ir.hasNext())
		{
			SpecRoom room=ir.next();
			sb.append("<p>Hotel : "+room.getHotel().getName()+"</p>");
			sb.append("<p>Room ID : "+room.getRoomId()+"</p>");
			sb.append("<p>Room Price : "+room.getPrice()+"</p>");
			sb.append("<p>Room Address : Level "+room.getLevel()+"</p>");
			sb.append("<p>&nbsp;</p>");
		}
		sb.append("</html>");
		return sb.toString();
	}
}
