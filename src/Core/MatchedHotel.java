package Core;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import DataModel.DataConnection;

/**
 * @author  PI KE
 */
public class MatchedHotel extends Hotel {
	/**
	 * @uml.property  name="matchedRooms"
	 */
	public Vector<Room> matchedRooms;
	public Vector<Room> selectedRooms=new Vector<Room>();
	public int numOfMatchedRooms=0;
	/**
	 * @uml.property  name="roomPriceRange"
	 */
	private double[] roomPriceRange;
	
	public MatchedHotel()
	{
		super();
		matchedRooms=new Vector<Room>();
	}
	
	public MatchedHotel(Vector<Room> matchedRooms)
	{
		super();
		this.matchedRooms=matchedRooms;
	}
	
	/**
	 * @return
	 * @uml.property  name="matchedRooms"
	 */
	public Vector<Room> getMatchedRooms()
	{
		return matchedRooms;
	}
	
	/**
	 * @param matchedRooms
	 * @uml.property  name="matchedRooms"
	 */
	public void setMatchedRooms(Vector<Room> matchedRooms)
	{
		this.matchedRooms=matchedRooms;
		numOfMatchedRooms=matchedRooms.size();
	}
	
	public void setMacthedRoomNum(int numOfMatchedRooms)
	{
		this.numOfMatchedRooms=numOfMatchedRooms;
	}
	
	public int getMacthedRoomNum()
	{
		return numOfMatchedRooms;
	}
	
	public void searchMatchedRoom(int hotel_id,double[] price,String capacity)
	{
		matchedRooms=new Vector<Room>();
		DataConnection conn=new DataConnection();
		String selectSql="select * from Room where hotel_id="+hotel_id+" and price>="+price[0]+" and price<"+price[1];
		if(!capacity.equals("All"))
		{
			if(capacity.equals(">4"))
				selectSql+=" and capacity>4";
			else
				selectSql+=" and capacity="+Integer.parseInt(capacity);	
		}
		selectSql+=" and is_available=1 order by room_id asc";
		ResultSet rs=conn.getResultSet(selectSql);
		
		try {
			while(rs.next())
			{
				Room room=new Room();
				room.setRoomId(rs.getInt("room_id"));
				room.setType(rs.getString("capacity"));
				room.setLevel(rs.getInt("level"));
				room.setRoomNo(rs.getString("room_no"));
				room.setTel(rs.getString("tel"));
				room.setAvailable(rs.getBoolean("is_available"));
				room.setPrice(rs.getDouble("price"));
				room.setHotelId(rs.getInt("hotel_id"));
				room.setHotel(this);
				room.setDescription(rs.getString("description"));
				matchedRooms.addElement(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param roomPriceRange
	 * @uml.property  name="roomPriceRange"
	 */
	public void setRoomPriceRange(double[] roomPriceRange)
	{
		this.roomPriceRange=roomPriceRange;
	}
	
	/**
	 * @return
	 * @uml.property  name="roomPriceRange"
	 */
	public double[] getRoomPriceRange()
	{
		return roomPriceRange;
	}
	
	/*
	public void addSelecteddRoom(int room_id)
	{
		for(int i=0;i<getMacthedRoomNum();i++)
		{
			if(matchedRooms.get(i).getRoomId()==room_id)
			{
				selectedRooms.addElement(matchedRooms.get(i));
				break;
			}
		}
	}
	
	public void removeSelectedRoom(int room_id)
	{
		for(int i=0;i<getMacthedRoomNum();i++)
		{
			if(matchedRooms.get(i).getRoomId()==room_id)
			{
				selectedRooms.removeElement(matchedRooms.get(i));
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
	*/
}
