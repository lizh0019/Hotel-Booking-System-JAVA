package Core;


import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * @author  PI KE
 */
public class Hotel {
	/**
	 * @uml.property  name="isFull"
	 */
	public boolean isFull=false;
	public int hotel_id;
	/**
	 * @uml.property  name="type"
	 */
	public String type;
	/**
	 * @uml.property  name="description"
	 */
	public String description;
	public static final Map<String,String> typeHash=new HashMap<String,String>(){{
													put("0","Budget hotel");
													put("1","One start");
													put("2","Two star");
													put("3","Three star");
													put("4","Four star");
													put("5","Five star");
													put("6","Six star");
													put("7","Seven star");
	}};
	
	public void setHotelId(int hotel_id)
	{
		this.hotel_id=hotel_id;
	}
	
	public int getHotelId()
	{
		return hotel_id;
	}
	
	/**
	 * @return
	 * @uml.property  name="type"
	 */
	public String getType()
	{
		return type;
	}
	
	/**
	 * @param type
	 * @uml.property  name="type"
	 */
	public void setType(String type)
	{
		this.type=type;
	}
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
	 * @uml.property  name="tel"
	 */
	private String tel;

	/**
	 * Getter of the property <tt>tel</tt>
	 * @return  Returns the tel.
	 * @uml.property  name="tel"
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * Setter of the property <tt>tel</tt>
	 * @param tel  The tel to set.
	 * @uml.property  name="tel"
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @uml.property  name="address"
	 * @uml.associationEnd  
	 */
	private Address address = null;

	/**
	 * Getter of the property <tt>address</tt>
	 * @return  Returns the address.
	 * @uml.property  name="address"
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Setter of the property <tt>address</tt>
	 * @param address  The address to set.
	 * @uml.property  name="address"
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	public String getHotelAddressString()
	{
		return (address.street+" "+address.country+","+address.postCode);
	}

	/**
	 * @uml.property  name="room"
	 * @uml.associationEnd  multiplicity="(1 -1)" inverse="hotel:Room"
	 */
	protected Collection<Room> room = new java.util.ArrayList<Room>();

	/**
	 * Returns an iterator over the elements in this collection. 
	 * @return  an <tt>Iterator</tt> over the elements in this collection
	 * @see java.util.Collection#iterator()
	 * @uml.property  name="room"
	 */
	public Iterator<Room> roomIterator() {
		return room.iterator();
	}

	/**
	 * Returns <tt>true</tt> if this collection contains no elements.
	 * @return  <tt>true</tt> if this collection contains no elements
	 * @see java.util.Collection#isEmpty()
	 * @uml.property  name="room"
	 */
	public boolean isRoomEmpty() {
		return room.isEmpty();
	}

	/**
	 * Returns <tt>true</tt> if this collection contains the specified element. 
	 * @param element  whose presence in this collection is to be tested.
	 * @see java.util.Collection#contains(Object)
	 * @uml.property  name="room"
	 */
	public boolean containsRoom(Room room) {
		return this.room.contains(room);
	}

	/**
	 * Returns <tt>true</tt> if this collection contains all of the elements in the specified collection.
	 * @param elements  collection to be checked for containment in this collection.
	 * @see java.util.Collection#containsAll(Collection)
	 * @uml.property  name="room"
	 */
	public boolean containsAllRoom(Collection room) {
		return this.room.containsAll(room);
	}

	/**
	 * Returns the number of elements in this collection.
	 * @return  the number of elements in this collection
	 * @see java.util.Collection#size()
	 * @uml.property  name="room"
	 */
	public int roomSize() {
		return room.size();
	}

	/**
	 * Returns all elements of this collection in an array.
	 * @return  an array containing all of the elements in this collection
	 * @see java.util.Collection#toArray()
	 * @uml.property  name="room"
	 */
	public Room[] roomToArray() {
		return room.toArray(new Room[room.size()]);
	}

	/**
	 * Returns an array containing all of the elements in this collection;  the runtime type of the returned array is that of the specified array.
	 * @param a  the array into which the elements of this collection are to be stored.
	 * @return  an array containing all of the elements in this collection
	 * @see java.util.Collection#toArray(Object[])
	 * @uml.property  name="room"
	 */
	public Room[] roomToArray(Room[] room) {
		return this.room.toArray(room);
	}

	/**
	 * Ensures that this collection contains the specified element (optional operation). 
	 * @param element  whose presence in this collection is to be ensured.
	 * @see java.util.Collection#add(Object)
	 * @uml.property  name="room"
	 */
	public boolean addRoom(Room room) {
		return this.room.add(room);
	}

	/**
	 * Removes a single instance of the specified element from this collection, if it is present (optional operation).
	 * @param element  to be removed from this collection, if present.
	 * @see java.util.Collection#add(Object)
	 * @uml.property  name="room"
	 */
	public boolean removeRoom(Room room) {
		return this.room.remove(room);
	}

	/**
	 * Removes all of the elements from this collection (optional operation).
	 * @see java.util.Collection#clear()
	 * @uml.property  name="room"
	 */
	public void clearRoom() {
		this.room.clear();
	}

	/** 
	 * Getter of the property <tt>room</tt>
	 * @return  Returns the room.
	 * @uml.property  name="room"
	 */
	public Collection<Room> getRoom() {
		return room;
	}

	/** 
	 * Setter of the property <tt>room</tt>
	 * @param room  the room to set.
	 * @uml.property  name="room"
	 */
	public void setRoom(Collection<Room> room) {
		this.room = room;
	}
	
	/**
	 * @return
	 * @uml.property  name="isFull"
	 */
	public boolean isFull()
	{
		return isFull;
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
	 * @return
	 * @uml.property  name="description"
	 */
	public String getDescription()
	{
		return description;
	}
}
