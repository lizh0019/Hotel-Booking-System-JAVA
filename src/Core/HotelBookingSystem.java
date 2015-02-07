package Core;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import javax.swing.JCheckBox;

import DataModel.DataConnection;


/**
 * @author  PI KE
 */
public class HotelBookingSystem {
	/**
	 * @uml.property  name="conn"
	 * @uml.associationEnd  
	 */
	private DataConnection conn;
	private Vector<MatchedHotel> matchedHotelList;
	private Vector<MatchedHotel> selectedHotelList;
	/**
	 * @uml.property  name="customer"
	 * @uml.associationEnd  
	 */
	private Customer customer;
	
	public HotelBookingSystem()
	{
		customer=new Customer();
		customer.setCustID(new Date().getTime());
		conn=new DataConnection();
		selectedHotelList=new Vector<MatchedHotel>();
	}
	
	/**
	 * @param customer
	 * @uml.property  name="customer"
	 */
	public void setCustomer(Customer customer)
	{
		this.customer=customer;
	}
	
	/**
	 * @return
	 * @uml.property  name="customer"
	 */
	public Customer getCustomer()
	{
		return customer;
	}
	
	//Search all the rooms for the specified hotel which fulfill the search criteria and return a matched hotel list
	public Vector<Room> search(String name)
	{
		Vector<Room> matchedRoomList=new Vector<Room>();
		String selectSql="select h.hotel_id,h.name,h.type,h.tel,h.street,h.country,h.postcode,h.description,r.room_id,r.level,r.room_no,r.tel,r.capacity,r.price,r.is_available,r.description from Hotel h inner join Room r on h.hotel_id=r.hotel_id ";
		
		selectSql+=" where h.name='"+name+"' order by r.level desc";
		System.out.println("SQL : "+selectSql);
		
		ResultSet rs=conn.getResultSet(selectSql);
		try {
			while(rs.next())
			{
				Room mh=new Room();
				mh.setRoomId(rs.getInt("room_id"));
				mh.setType(rs.getString("capacity"));
				mh.setTel(rs.getString("tel"));
				mh.setLevel(rs.getInt("level"));
				mh.setRoomNo(rs.getString("room_no"));
				mh.setPrice(rs.getDouble("price"));
				mh.setAvailable(rs.getBoolean("is_available"));
				mh.setDescription(rs.getString("description"));				
				matchedRoomList.addElement(mh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return matchedRoomList;
	}
	
	//Search all the hotels which fulfill the search criteria and return a matched hotel list
	public Vector<MatchedHotel> search(String country,String type,String price,String capacity)
	{
		matchedHotelList=new Vector<MatchedHotel>();
		int AND_FLAG=0;
		String selectSql="select h.hotel_id,h.name,h.type,h.tel,h.street,h.country,h.postcode,h.description,count(r.room_id) as room_num from Hotel h inner join Room r on h.hotel_id=r.hotel_id ";
		
		if(!type.equals("All"))
		{
			if(type.equals("Budget hotel"))
				type="0";
		
			if(AND_FLAG==1)
				selectSql+=" and h.type='"+String.valueOf(Integer.parseInt(type))+"'";
			else
			{
				selectSql+=" where h.type='"+String.valueOf(Integer.parseInt(type))+"'";
				AND_FLAG=1;
			}
		}
		
		if(!price.equals("All"))
		{
			double[] prices=parsePrice(price);
			if(AND_FLAG==1)
				selectSql+=" and r.price>="+prices[0]+" and r.price<"+prices[1];
			else
			{
				selectSql+=" where r.price>="+prices[0]+" and r.price<"+prices[1];
				AND_FLAG=1;
			}
		}
		
		if(!country.equals("All"))
		{
			if(AND_FLAG==1)
				selectSql+=" and h.country='"+country+"'";
			else
			{
				selectSql+=" where h.country='"+country+"'";
				AND_FLAG=1;
			}
		}
		
		if(!capacity.equals("All"))
		{
			if(capacity.equals(">4"))
			{
				if(AND_FLAG==1)
					selectSql+=" and r.capacity>4";
				else
				{
					selectSql+=" where r.capacity>4";
					AND_FLAG=1;
				}
			}
			else
			{
				if(AND_FLAG==1)
					selectSql+=" and r.capacity="+Integer.parseInt(capacity);
				else
				{
					selectSql+=" where r.capacity="+Integer.parseInt(capacity);
					AND_FLAG=1;
				}
			}
		}
		
		if(AND_FLAG==1)
			selectSql+=" AND r.is_available=1";
		else
		{
			selectSql+=" where r.is_available=1";
			AND_FLAG=1;
		}
		
		selectSql+=" group by h.hotel_id,h.name,h.type,h.tel,h.street,h.country,h.postcode,h.description order by h.hotel_id desc";
		System.out.println("SQL : "+selectSql);
		
		ResultSet rs=conn.getResultSet(selectSql);
		try {
			while(rs.next())
			{
				MatchedHotel mh=new MatchedHotel();
				mh.hotel_id=rs.getInt("hotel_id");
				mh.setName(rs.getString("name"));
				mh.setType(rs.getString("type"));
				Address address=new Address(rs.getString("street"),rs.getString("country"),rs.getString("postcode"));
				mh.setAddress(address);
				mh.setTel(rs.getString("tel"));
				mh.setMacthedRoomNum(rs.getInt("room_num"));
				mh.setDescription(rs.getString("description"));				
				mh.setRoomPriceRange(parsePrice(price));
				mh.searchMatchedRoom(mh.hotel_id,parsePrice(price),capacity);
				matchedHotelList.addElement(mh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return matchedHotelList;
	}
	
	public Vector<MatchedHotel> getMatchedHotels()
	{
		return matchedHotelList;
	}

	
	public void addSelectedHotel(int hotel_id)
	{
		for(int i=0;i<matchedHotelList.size();i++)
		{
			if(matchedHotelList.get(i).getHotelId()==hotel_id)
			{
				selectedHotelList.addElement(matchedHotelList.get(i));
				break;
			}
		}
	}
	
	public void removeSelectedHotel(int hotel_id)
	{
		int total_number=matchedHotelList.size();
		for(int i=0;i<total_number;i++)
		{
			if(matchedHotelList.get(i).getHotelId()==hotel_id)
			{
				System.out.println("Selected hotel left before is "+getSelectedHotel().size());
				selectedHotelList.removeElement(matchedHotelList.get(i));
				System.out.println("Selected hotel left after is "+getSelectedHotel().size());
				break;
			}
		}
	}
	
	public Vector<MatchedHotel>	getSelectedHotel()
	{
		return selectedHotelList;
	}
	
	public Object[] getAllHotels()
	{
		Vector<String> names=new Vector<String>();
		ResultSet rs=conn.getResultSet("select distinct name from Hotel order by name asc");
		try {
			while(rs.next())
			{
				names.addElement(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return names.toArray();
	}
	
	public Object[] getAllTypes()
	{
		Vector<String> types=new Vector<String>();
		ResultSet rs=conn.getResultSet("select distinct type from Hotel order by type asc");
		try {
			while(rs.next())
			{
				types.addElement(rs.getString("type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return types.toArray();
	}
	
	public Object[] getAllCountries()
	{
		Vector<String> countries=new Vector<String>();
		ResultSet rs=conn.getResultSet("select distinct country from Hotel order by country asc");
		try {
			while(rs.next())
			{
				countries.addElement(rs.getString("country"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return countries.toArray();
	}
	
	private double[] parsePrice(String p)
	{
		double price[]=new double[2];
		if(!p.equals("All"))
		{
			if(p.equals("<100"))
			{
				price[0]=0;
				price[1]=100;
			}
			else
			{
				if(p.equals(">500"))
				{
					price[0]=500;
					price[1]=Integer.MAX_VALUE;
				}
				else
				{
					String str[]=p.split("-");
					price[0]=Double.parseDouble(str[0]);
					price[1]=Double.parseDouble(str[1]);
				}
			}
		}
		else
		{
			price[0]=0;
			price[1]=Integer.MAX_VALUE;
		}

		return price;
	}
}
