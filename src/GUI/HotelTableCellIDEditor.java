package GUI;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellEditor;

import Core.Customer;
import Core.HotelBookingSystem;
import Core.MatchedHotel;


/**
 * @author  PI KE
 */
public class HotelTableCellIDEditor extends AbstractCellEditor implements TableCellEditor{
	private static final long serialVersionUID = 1L;
	public Component comp;
	/**
	 * @uml.property  name="hbs"
	 * @uml.associationEnd  
	 */
	private HotelBookingSystem hbs;
	/**
	 * @uml.property  name="customer"
	 * @uml.associationEnd  
	 */
	private Customer customer;
	/**
	 * @uml.property  name="dmhif"
	 * @uml.associationEnd  
	 */
	private DetailMatchedHotelInfoFrame dmhif=null;
	private JButton btn;
	private long click_time=0;
	
	public HotelTableCellIDEditor()
	{
		super();
	}
	
	public HotelTableCellIDEditor(HotelBookingSystem hbs)
	{
		super();
		this.hbs=hbs;
		customer=hbs.getCustomer();
	}
	
	public Component getTableCellEditorComponent(final JTable table, Object object,
			boolean isSelected, int row, int col) {	
		comp=(Component)object;
		if(object instanceof JCheckBox)
		{
			final JCheckBox checkBox=(JCheckBox)object;  	
			checkBox.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent e) 
				{
	    			String id=checkBox.getName();
	    			System.out.println("Room id "+id);
	    			boolean isSelected=false;
	    			if(checkBox.isSelected())
	    			{
	    				if(table.getName().equals("MatchedRoomTable"))
	    				{
							Vector<MatchedHotel> mhv=hbs.getSelectedHotel();
							//Loop through the matched hotels
							for(int i=0;i<mhv.size();i++)
							{
								System.out.println("Matched room number "+mhv.get(i).getMacthedRoomNum());
								//Loop through the matched rooms in the matched hotel
								for(int j=0;j<mhv.get(i).getMacthedRoomNum();j++)
								{
									if(mhv.get(i).getMatchedRooms().get(j).getRoomId()==Integer.parseInt(id))
									{
										int z;
										for(z=0;z<customer.getSelectedRoom().size();z++)
										{
											//Check whether the selected room is in the selected room list or not
											if(customer.getSelectedRoom().get(z).getRoomId()==Integer.parseInt(id))
												break;
										}
										if(z==customer.getSelectedRoom().size())
										{
											System.out.println("Room "+id+" is added for Customer "+customer.getCustID());
											customer.addSelecteddRoom(mhv.get(i).getMatchedRooms().get(j));
										}
										isSelected=true;
										break;
									}
								}
								if(isSelected)
									break;
							}
	    					/*
							Vector<MatchedHotel> mhv=hbs.getMatchedHotels();
							//Loop through the matched hotels
							for(int i=0;i<mhv.size();i++)
							{
								System.out.println("Matched room number "+mhv.get(i).getMacthedRoomNum());
								//Loop through the matched rooms in the matched hotel
								for(int j=0;j<mhv.get(i).getMacthedRoomNum();j++)
								{
									if(mhv.get(i).getMatchedRooms().get(j).getRoomId()==Integer.parseInt(id))
									{
										int z;
										for(z=0;z<mhv.get(i).getSelectedRoom().size();z++)
										{
											//Check whether the selected room is in the selected room list or not
											if(mhv.get(i).getSelectedRoom().get(z).getRoomId()==Integer.parseInt(id))
												break;
										}
										if(z==mhv.get(i).getSelectedRoom().size())
										  mhv.get(i).addSelecteddRoom(Integer.parseInt(id));
										isSelected=true;
										break;
									}
								}
								if(isSelected)
									break;
							}
							*/
	    				}
	    				else
	    				{
	    					if(table.getName().equals("MatchedHotelTable"))
	    					{
	    						int i;
	    						for(i=0;i<hbs.getSelectedHotel().size();i++)
	    						{
	    							if(hbs.getSelectedHotel().get(i).getHotelId()==Integer.parseInt(id))
	    								break;
	    						}
	    						System.out.println("i is "+i+" hotel size "+hbs.getSelectedHotel().size());
	    						if(i==hbs.getSelectedHotel().size())
	    							hbs.addSelectedHotel(Integer.parseInt(id));
	    					}	
	    				}
	    			}
	    			else
	    			{
	    				if(table.getName().equals("MatchedRoomTable"))
	    				{
							Vector<MatchedHotel> mhv=hbs.getSelectedHotel();
							//Loop through the matched hotels
							for(int i=0;i<mhv.size();i++)
							{
								System.out.println("Matched room number "+mhv.get(i).getMacthedRoomNum());
								//Loop through the matched rooms in the matched hotel
								for(int j=0;j<mhv.get(i).getMacthedRoomNum();j++)
								{
									if(mhv.get(i).getMatchedRooms().get(j).getRoomId()==Integer.parseInt(id))
									{
										int z;
										for(z=0;z<customer.getSelectedRoom().size();z++)
										{
											//Check whether the selected room is in the selected room list or not
											if(customer.getSelectedRoom().get(z).getRoomId()==Integer.parseInt(id))
												break;
										}
										if(z!=customer.getSelectedRoom().size())
										{
											System.out.println("Room "+id+" is removed for Customer "+customer.getCustID());
											customer.removeSelectedRoom(mhv.get(i).getMatchedRooms().get(j));
										}
										isSelected=true;
										break;
									}
								}
								if(isSelected)
									break;
							}
	    				}
	    				else
	    				{
	    					if(table.getName().equals("MatchedHotelTable"))
	    					{
	    						int i;
	    						for(i=0;i<hbs.getSelectedHotel().size();i++)
	    						{
	    							if(hbs.getSelectedHotel().get(i).getHotelId()==Integer.parseInt(id))
	    								break;
	    						}
	    						System.out.println("i is "+i+" hotel size "+hbs.getSelectedHotel().size());
	    						if(i!=hbs.getSelectedHotel().size())
	    							hbs.removeSelectedHotel(Integer.parseInt(id));
	    					}
	    				}
	    			}
				}
	    	});
			checkBox.setHorizontalAlignment(SwingConstants.CENTER);
			return checkBox;
		}
		else
		{
			if(object instanceof JButton)
			{
				btn=(JButton)object;		
				btn.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{	
						String cmd=(String)e.getActionCommand();
						if(click_time!=e.getWhen())
						{
						System.out.println("Click count "+e.getWhen());
						Vector<MatchedHotel> mhv=hbs.getMatchedHotels();
						int size=mhv.size();
						for(int i=0;i<size;i++)
						{
							if(mhv.get(i).getHotelId()==Integer.parseInt(cmd))
							{
								System.out.println("Button is clicked "+i);
								dmhif=new DetailMatchedHotelInfoFrame(mhv.get(i),hbs);
								break;
							}
						}
						click_time=e.getWhen();
						}
					}
				});
				btn.setHorizontalAlignment(SwingConstants.CENTER);
				return btn;
			}
		}
		return (Component)object;
	}

	public Object getCellEditorValue() {
		return comp;
	}
}
