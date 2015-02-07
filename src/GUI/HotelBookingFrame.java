package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumn;

import Calendar.CalendarFrame;
import Core.Hotel;
import Core.HotelBookingSystem;
import Core.MatchedHotel;
import Core.Room;
import DataModel.HotelTableModel;
import DataModel.MatchedHotelRoomModel;
import DataModel.SelectedRoomModel;



public class HotelBookingFrame extends LogoWindow implements ActionListener{
	private static final long serialVersionUID = 1L;
	public static String title="Hotel Booking System";
	private int windowWidth=800;
	private int windowHeight=600;
	private JTable resultTable=null;
	/**
	 * @uml.property  name="htm"
	 * @uml.associationEnd  
	 */
	public HotelTableModel htm=null;
	public static JLabel statusLbl=null;	
	public JComboBox countryBox;
	public JComboBox typeBox;
	public JComboBox priceBox;
	public JComboBox capacityBox;
	public JTextField dateField;
	private DefaultListModel dlm;
	/**
	 * @uml.property  name="hbs"
	 * @uml.associationEnd  
	 */
	private HotelBookingSystem hbs=null; 
	
	public HotelBookingFrame(HotelBookingSystem hbs)
	{
		this.hbs=hbs;
	}
	
	private void init()
	{
		this.setTitle(title);
		this.setSize(windowWidth,windowHeight);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		this.getContentPane().add("North",getSearchPanel());
		this.getContentPane().add("Center",getResultPanel());
		this.getContentPane().add("South",getControlPanel());
		
		this.setJMenuBar(getSystemMenuBar());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}
	
	private JMenuBar getSystemMenuBar()
	{
		JMenuBar menuBar=new JMenuBar();
		JMenu menu=new JMenu("Window");
		JMenuItem menuItem=new JMenuItem("Close");
		menuItem.setActionCommand("CANCEL");
		menuItem.setMnemonic(KeyEvent.VK_C);
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menuBar.add(menu);
		
		menu=new JMenu("Control");
		menuItem=new JMenuItem("View customer information");
		menuItem.setActionCommand("VIEWCINFO");
		menuItem.setMnemonic(KeyEvent.VK_V);
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuItem=new JMenuItem("View booking information");
		menuItem.setActionCommand("VIEWBINFO");
		menuItem.setMnemonic(KeyEvent.VK_V);
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuItem=new JMenuItem("Cancel booking");
		menuItem.setActionCommand("CANCELBOOKING");
		menuItem.setMnemonic(KeyEvent.VK_C);
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menuBar.add(menu);
		
		menu=new JMenu("About");
		menuItem=new JMenuItem("About us");
		menuItem.setActionCommand("ABOUT");
		menuItem.setMnemonic(KeyEvent.VK_A);
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menuBar.add(menu);
		return menuBar;
	}
	
	public JPanel getSearchPanel()
	{
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout(20,0));
		panel.setBorder(BorderFactory.createTitledBorder("Search"));
        
		JPanel gridPanel=new JPanel();
		gridPanel.setLayout(new GridLayout(0,3));
		gridPanel.add(new JLabel("Hotel Type (Star)"));
		gridPanel.add(new JLabel("Price (SGD$ per day) "));
		gridPanel.add(new JLabel("Country "));
		typeBox=new JComboBox();
		gridPanel.add(typeBox);
		priceBox=new JComboBox();
		gridPanel.add(priceBox);
		countryBox=new JComboBox();
		gridPanel.add(countryBox);
		
		gridPanel.add(new JLabel("Room Capacity (Person per room)"));
		gridPanel.add(new JLabel("Date"));
		gridPanel.add(new JLabel(" "));
		capacityBox=new JComboBox();
		dateField=new JTextField(15);
		//dateField.setBounds(0,0,100,40);
		dateField.setBorder(null);
		dateField.setEditable(false);
		dateField.setText("2010-11-24");
		gridPanel.add(capacityBox);
		
		JPanel datePanel=new JPanel();
		datePanel.add(dateField);
		ImageIcon dateIcon=new ImageIcon("icons\\calendar.jpg");
		JLabel calendarLbl=new JLabel(dateIcon);
		calendarLbl.setToolTipText("Click here to choose date to search");
		final CalendarFrame cf=new CalendarFrame();
		cf.init();
		
		calendarLbl.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e)
			{
				cf.setLocation(e.getXOnScreen(),e.getYOnScreen());
				cf.clearSelectDay();
				cf.setVisible(true);
				cf.validate();
				Thread thread=new Thread(new Runnable(){
						public void run()
						{
							boolean isSelected=false;
							while(!isSelected)
							{
								if(cf.isSelected())
								{
									dateField.setText(cf.getSelectedDate());
									cf.setVisible(false);
									isSelected=true;
								}
								try
								{
									Thread.sleep(1000);
								}
								catch(Exception ex)
								{
									System.err.println("Thread error");
								}
							}
						}
					});
				thread.start();
			}
		});
		datePanel.add(calendarLbl);
		gridPanel.add(datePanel);
		panel.add("Center",gridPanel);
		
		JPanel searchPanel=new JPanel();
		//searchPanel.setBackground(new Color(255,255,255));
		//searchPanel.setOpaque(true);
        GridBagConstraints gbc=new GridBagConstraints();
		searchPanel.setLayout(new GridBagLayout());
		JButton btn=new JButton("Search");
		btn.setPreferredSize(new Dimension(120,40));
		btn.setIcon(new ImageIcon("icons\\search.gif"));
		btn.setMnemonic(KeyEvent.VK_S);
		btn.setActionCommand("SEARCH");
		
		btn.addActionListener(this);
		searchPanel.add(btn,gbc);
		/*
		btn=new JButton("Advanced Search");
		btn.setMnemonic(KeyEvent.VK_S);
		btn.setActionCommand("ADSEARCH");
		btn.addActionListener(this);
		searchPanel.add(btn);
		*/
		panel.add("East",searchPanel);
		return panel;
	}
	
	
	public JSplitPane getResultPanel()
	{
		JSplitPane splitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(0.7);
		splitPane.setResizeWeight(1.0);

		resultTable=new JTable();
		htm=new HotelTableModel();
		resultTable.setName("MatchedHotelTable");
		resultTable.setAutoCreateColumnsFromModel(true);
		resultTable.setRowHeight(20);
		resultTable.setSelectionBackground(new Color(100,255,100));
		
		JScrollPane jsp=new JScrollPane(resultTable);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jsp.setSize((int)(windowWidth*0.7),400);
		//jsp.setBackground(new Color(255,255,255));
		//jsp.setOpaque(true);
		splitPane.setLeftComponent(jsp);
		
		final JList hotelList=new JList();
		dlm=new DefaultListModel();
		hotelList.setModel(dlm);
		hotelList.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()==2)
				{
					MatchedHotelRoomModel mhrm=new MatchedHotelRoomModel();
					Vector<Room> vr=hbs.search(hotelList.getSelectedValue().toString());
					for(int i=0;i<vr.size();i++)
					{
						Room room=vr.get(i);
						Object[] object=new Object[]{room.getRoomId(),room.getType(),room.getPrice(),room.getTel(),"Level "+room.getLevel()+" Room "+room.getRoomNo(),room.getDescription()};
						mhrm.addObject(object);
					}
					resultTable.setModel(mhrm);
					resultTable.revalidate();
					statusLbl.setText("Totol rooms : "+vr.size());
				}
			}
		});
		jsp=new JScrollPane(hotelList);
		jsp.setBorder(BorderFactory.createTitledBorder("All hotels"));
		jsp.setSize((int)(windowWidth*0.3),400);
		jsp.setPreferredSize(new Dimension((int)(windowWidth*0.3),400));
		splitPane.setRightComponent(jsp);
		
		return splitPane;
	}
	
	
	public JPanel getControlPanel()
	{
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createEtchedBorder());
		
		JPanel btnPanel=new JPanel();
		btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JButton btn=new JButton("Book");
		btn.setIcon(new ImageIcon("icons\\booking.gif"));
		btn.setMnemonic(KeyEvent.VK_B);
		btn.setActionCommand("BOOK");
		btn.addActionListener(this);
		btnPanel.add(btn);
		
		btn=new JButton("Cancel");
		btn.setIcon(new ImageIcon("icons\\close.gif"));
		btn.setMnemonic(KeyEvent.VK_C);
		btn.setActionCommand("CANCEL");
		btn.addActionListener(this);
		btnPanel.add(btn);
		panel.add("Center",btnPanel);
		
		statusLbl=new JLabel("<html>&nbsp;</html>");
		panel.add("South",statusLbl);
		return panel;
	}
	
	private void fillSearchCriteria()
	{		
		//Fill up type box
		typeBox.addItem("All");
		typeBox.addItem("Budget hotel");
		for(int i=3;i<=7;i++)
		{
			typeBox.addItem(i);
		}
		
		//Fill up price
		priceBox.addItem("All");
		priceBox.addItem("<100");
		priceBox.addItem("100-200");
		priceBox.addItem("200-300");
		priceBox.addItem("300-400");
		priceBox.addItem("400-500");
		priceBox.addItem(">500");
		
		//Fill up capacity box
		capacityBox.addItem("All");
		capacityBox.addItem("1");
		capacityBox.addItem("2");
		capacityBox.addItem("4");
		capacityBox.addItem(">4");
		
		//Fill up country box
		countryBox.addItem("All");
		Object[] countries=hbs.getAllCountries();
		for(int i=0;i<countries.length;i++)
		{
			countryBox.addItem((String)countries[i]);
		}
		
		//Fill hotel List 
		Object[] names=hbs.getAllHotels();
		for(int i=0;i<names.length;i++)
		{
			dlm.addElement(names[i]);
		}
	}
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable(){
			public void run()
			{
				HotelBookingSystem hbs=new HotelBookingSystem();
				HotelBookingFrame hbf=new HotelBookingFrame(hbs);
				hbf.init();
				hbf.fillSearchCriteria();
			}
		});	
	}

	public void actionPerformed(ActionEvent e) {
		String cmd=(String)e.getActionCommand();
		
		if(cmd.equals("ABOUT"))
		{
			new AboutUsBoard();
		}
		
		if(cmd.equals("SEARCH"))
		{
			new Thread(new SearchThread()).start();
		}
		
		if(cmd.equals("BOOK"))
		{
			if(hbs.getSelectedHotel().size()!=0)
				new CustomerInfoFrame(hbs,SelectedRoomModel.HOTEL_MODEL);
			else
				JOptionPane.showMessageDialog(null,"Sorry,You don't choose any hotel to book!","No hotel selected",JOptionPane.WARNING_MESSAGE);
		}
		
		if(cmd.equals("CANCELBOOKING"))
		{
			if(hbs.getCustomer().isBookingCanceled)
				JOptionPane.showMessageDialog(null,"Sorry,No booked room is available to cancel!","No hotel booked",JOptionPane.WARNING_MESSAGE);
			else
				hbs.getCustomer().cancelBooking();
		}
		
		if(cmd.equals("VIEWCINFO"))
		{
			new CustomerInfoViewer(hbs.getCustomer());
		}
		
		if(cmd.equals("VIEWBINFO"))
		{
			new BookingInfoViewer(hbs.getCustomer());
		}
		
		if(cmd.equals("CANCEL"))
		{
			System.exit(0);
		}
	}
	
	//When search button is clicked,this thread will be created and the search
	//Process will start and the result table will be refreshed
	class SearchThread implements Runnable
	{
		public void run() {
			//htm=new HotelTableModel();
			htm.clear();
			resultTable.invalidate();
			resultTable.setModel(htm);
			Vector<MatchedHotel> matchedHotels=hbs.search((String)countryBox.getSelectedItem(),typeBox.getSelectedItem().toString(),(String)priceBox.getSelectedItem(),(String)capacityBox.getSelectedItem());
			if(matchedHotels!=null)
			{
				int num=matchedHotels.size();
				for(int i=0;i<num;i++)
				{
					MatchedHotel mh=matchedHotels.get(i);
					JCheckBox box=new JCheckBox();
					box.setName(String.valueOf(mh.getHotelId()));
					JButton btn=new JButton("Detail");
					btn.setActionCommand(String.valueOf(mh.getHotelId()));
					Object[] object=new Object[]{box,mh.getName(),Hotel.typeHash.get(mh.getType()),mh.getAddress().getCountry(),mh.getTel(),mh.getMacthedRoomNum(),mh.getHotelAddressString(),btn};
					htm.addObject(object);
				}
				TableColumn col=resultTable.getColumnModel().getColumn(0);
				col.setCellRenderer(new HotelTableCellIDRenderer());
				col.setCellEditor(new HotelTableCellIDEditor(hbs));
				col.setPreferredWidth(6);
				
				col=resultTable.getColumnModel().getColumn(resultTable.getColumnModel().getColumnCount()-2);
				col.setPreferredWidth(300);
				
				col=resultTable.getColumnModel().getColumn(resultTable.getColumnModel().getColumnCount()-1);
				col.setCellRenderer(new HotelTableCellDetailRenderer());
				col.setCellEditor(new HotelTableCellIDEditor(hbs));
				col.setPreferredWidth(50);
				
				resultTable.revalidate();
				statusLbl.setText("Totol matched hotels : "+num);
			}
		}
	}
}
