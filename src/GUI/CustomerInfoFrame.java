package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

import Core.Customer;
import Core.HotelBookingSystem;
import Core.MatchedHotel;
import Core.Room;
import Core.SpecRoom;
import DataModel.SelectedRoomModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CustomerInfoFrame.java
 *
 * Created on Nov 21, 2010, 2:34:17 PM
 */
/**
 * @author  PI KE
 */
public class CustomerInfoFrame extends LogoWindow implements ActionListener{
	private static final long serialVersionUID = 1L;
	public String title="Customer Information Entry";
	private int windowWidth=500;
	private int windowHeight=600;
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
	/**
	 * @uml.property  name="infoPanel"
	 */
	private JPanel infoPanel;
    private JLabel nameLbl;
	private JLabel emailLbl;
	private JLabel contactLbl;
	private JLabel streetLbl;
	private JLabel addressLbl;
	private JLabel postalLbl;
    private JTextField nameField;
	private JTextField emailField;
	private JTextField contactField;
	private JTextField streetField;
	private JTextField postalField;
    private JTextArea addressArea;
    private JComboBox countryBox;
	private JComboBox genderBox;
    private JTable selectedHotelTable;
    /**
	 * @uml.property  name="srm"
	 * @uml.associationEnd  
	 */
    private SelectedRoomModel srm;
    private int model;
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
    private int hotel_id;
    
    /** Creates new form CustomerInfoFrame */
    public CustomerInfoFrame(HotelBookingSystem hbs,int model) {
    	this.hbs=hbs;
    	this.model=model;
        initComponents();
    }
    
    public CustomerInfoFrame(HotelBookingSystem hbs,int model,int hotel_id) {
    	this.hbs=hbs;
    	this.model=model;
    	this.hotel_id=hotel_id;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
		this.setTitle(title);
		this.setSize(windowWidth,windowHeight);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		this.getContentPane().add("North",getTitlePanel());
		this.getContentPane().add("Center",getInfoPanel());
		this.getContentPane().add("South",getControlPanel());
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		customer=hbs.getCustomer();
    }
    
    private JPanel getControlPanel()
    {
        JPanel ctrlPanel=new JPanel();
        ctrlPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
		JButton btn=new JButton("Book");
		btn.setIcon(new ImageIcon("icons\\booking.gif"));
		btn.setMnemonic(KeyEvent.VK_B);
		btn.setActionCommand("PAY");
		btn.addActionListener(this);
		ctrlPanel.add(btn);
		
		btn=new JButton("Cancel");
		btn.setIcon(new ImageIcon("icons\\close.gif"));
		btn.setMnemonic(KeyEvent.VK_C);
		btn.setActionCommand("CANCEL");
		btn.addActionListener(this);
		ctrlPanel.add(btn);
		return ctrlPanel;
    }
    
    private JPanel getTitlePanel()
    {
    	JPanel panel=new JPanel();
    	panel.setLayout(new BorderLayout());
    	panel.setBounds(5,5,windowWidth-10,40);
    	JLabel titleLbl=new JLabel("<html><font font-weight='bold'><h1>Customer information</h1></font></html>",JLabel.CENTER);
    	JLabel notificationLbl=new JLabel("<html><font color='#ff0000'>*Please enter your personal information to book the hotel selected</font></html>",JLabel.CENTER);
    	panel.add("North",titleLbl);
    	panel.add("Center",notificationLbl);
    	
    	return panel;
    }

    /**
	 * @return
	 * @uml.property  name="infoPanel"
	 */
    private JPanel getInfoPanel()
    {
    	infoPanel = new JPanel();
        
        nameLbl = new JLabel("Name");
        nameField = new JTextField();
        emailLbl = new JLabel("Email");
        emailField = new JTextField();
        contactLbl = new JLabel("Contact");
        contactField = new JTextField();
        streetLbl=new JLabel("Street");
        streetField=new JTextField();
        addressLbl = new JLabel("Address");
        addressArea = new JTextArea(4,80);
        postalLbl = new JLabel("Postal code");
        postalField = new JTextField();
        
        JLabel genderLbl=new JLabel("Gender");
        genderBox=new JComboBox();
        genderBox.addItem("Male");
        genderBox.addItem("Female");
        
        JLabel countryLbl=new JLabel("Country");
        countryBox=new JComboBox();
        countryBox.addItem("Singapore");
        countryBox.addItem("China");
        countryBox.addItem("India");
        countryBox.addItem("Malaysia");
        countryBox.addItem("Indonesia");
        
        JLabel selectedHotelLbl=new JLabel("Selected hotel");
        srm=new SelectedRoomModel(model);
        selectedHotelTable=new JTable(srm);
        selectedHotelTable.setName("MatchedRoomTable");
        switch(model)
        {
        case SelectedRoomModel.HOTEL_MODEL:fillSelectedHotelModel();break;
        //case SelectedRoomModel.ROOM_MODEL:fillSelectedRoomModel();break;
        }
		TableColumn col=selectedHotelTable.getColumnModel().getColumn(0);
		col.setCellRenderer(new HotelTableCellIDRenderer());
		col.setCellEditor(new HotelTableCellIDEditor(hbs));
		col.setPreferredWidth(4);
		selectedHotelTable.revalidate();
        
        JScrollPane jsp=new JScrollPane(selectedHotelTable);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jsp.setSize(400,120);
        jsp.setPreferredSize(new Dimension(400,120));
        
        JLabel tmpLbl=new JLabel("");
        
        GroupLayout infoLayout=new GroupLayout(infoPanel);
        infoPanel.setLayout(infoLayout);
        
		infoLayout.setHorizontalGroup(infoLayout.createSequentialGroup()
				.addContainerGap(3, 20)
				.addGroup(
						infoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(nameLbl)
								.addComponent(genderLbl)
								.addComponent(emailLbl)
								.addComponent(contactLbl)
								.addComponent(countryLbl)
								.addComponent(streetLbl)
								.addComponent(postalLbl)
								.addComponent(selectedHotelLbl)
								.addComponent(tmpLbl)
								.addGap(10))
				.addGroup(
						infoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(nameField)
								.addComponent(genderBox)
								.addComponent(emailField)
								.addComponent(contactField)
								.addComponent(countryBox)
								.addComponent(streetField)							
								.addComponent(postalField)
								.addComponent(jsp)
								.addComponent(tmpLbl)
								.addGap(10))
				.addContainerGap(3, 20));
		infoLayout.setVerticalGroup(infoLayout.createSequentialGroup()
				.addContainerGap(3, 20)
				.addGroup(
						infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
								.addComponent(nameLbl)
								.addComponent(nameField))
								.addGap(10)
				.addGroup(
						infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
								.addComponent(genderLbl)
								.addComponent(genderBox))
								.addGap(10)
				.addGroup(
						infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
								.addComponent(emailLbl)
								.addComponent(emailField))
								.addGap(10)
				.addGroup(
						infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
								.addComponent(contactLbl)
								.addComponent(contactField))
								.addGap(10)
				.addGroup(
						infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
								.addComponent(countryLbl)
								.addComponent(countryBox))
								.addGap(10)
				.addGroup(
						infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
								.addComponent(streetLbl)
								.addComponent(streetField))
								.addGap(10)
				.addGroup(
						infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
								.addComponent(postalLbl)
								.addComponent(postalField))
								.addGap(10)
				.addGroup(
						infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
								.addComponent(selectedHotelLbl)
								.addComponent(jsp))
								.addGap(10)
				.addGroup(
						infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
								.addComponent(tmpLbl)
								.addComponent(tmpLbl)
								.addGap(10)
								)
				.addContainerGap(3, 20));
		
        infoPanel.setSize(windowWidth-20,windowHeight-50);
        infoPanel.setPreferredSize(new Dimension(windowWidth-50,windowHeight-50));
        
        return infoPanel;
    }
    
    private void fillSelectedHotelModel()
    {
    	Vector<MatchedHotel> mhv=hbs.getSelectedHotel();
    	
    	srm=new SelectedRoomModel(model);
    	selectedHotelTable.setModel(srm);
    	for(int i=0;i<mhv.size();i++)
    	{
    		MatchedHotel mh=mhv.get(i);
    		//mh.searchMatchedRoom(mh.getHotelId(), mh.getRoomPriceRange());
    		
    		Vector<Room> mr=mh.getMatchedRooms();
    		fillRoomModel(mr);
    	}
    }
    
    /*
    private void fillSelectedRoomModel()
    {
    	Vector<Room> rooms=null;
    	/*
    	for(int i=0;i<hbs.getMatchedHotels().size();i++)
    	{
    		if(hbs.getMatchedHotels().get(i).getHotelId()==hotel_id)
    		{
    			//rooms=hbs.getMatchedHotels().get(i).getSelectedRoom();
    			break;
    		}
    	}
    	
    	rooms=customer.getSelectedRoom();
    	srm=new SelectedRoomModel(model);
    	selectedHotelTable.setModel(srm);
    	fillRoomModel(rooms);
    }
    */
    private void fillRoomModel(Vector<Room> rooms)
    {	
		for(int i=0;i<rooms.size();i++)
		{
			Room room=rooms.get(i);
			JCheckBox checkBox=new JCheckBox();
			if(model==SelectedRoomModel.ROOM_MODEL)
				checkBox.setSelected(true);
			else
				checkBox.setSelected(false);
			checkBox.setName(String.valueOf(room.getRoomId()));
			Object[] object=new Object[]{checkBox,room.getRoomId(),room.getType(),room.getPrice(),room.getTel(),room.getLevel(),room.getDescription()};
			srm.addObject(object);
		}
    }
    
    public SpecRoom createSprecRoom(Room room)
    {
    	SpecRoom sr=new SpecRoom();
    	sr.setHotelId(room.getHotelId());
    	sr.setHotel(room.getHotel());
    	sr.setRoomId(room.getRoomId());
    	sr.setLevel(room.getLevel());
    	sr.setRoomNo(room.getRoomNo());
    	sr.setPrice(room.getPrice());
    	sr.setTel(room.getTel());
    	sr.setType(room.getType());
    	sr.setDescription(room.getDescription());
		Date date=new Date();
		sr.setBookedDate(date);
    	return sr;
    }
    
	public void actionPerformed(ActionEvent e) {
		String cmd=(String)e.getActionCommand();
		
		if(cmd.equals("PAY"))
		{
			int room_count=0;
			room_count=customer.getSelectedRoom().size();
			System.out.println("Selected room size "+room_count+" Customer ID "+customer.getCustID());
			if(room_count>0)
			{
				customer.setName(nameField.getText());
				customer.setGender(genderBox.getSelectedItem().toString());
				customer.setContactNo(contactField.getText());
				customer.setCountry(countryBox.getSelectedItem().toString());
				customer.setEmail(emailField.getText());
				customer.setStreet(streetField.getText());
				customer.setPostCode(postalField.getText());
				
				Vector<Room> rooms=customer.getSelectedRoom();
				for(int j=0;j<rooms.size();j++)
				{
					SpecRoom sr=createSprecRoom(rooms.get(j));
					customer.addSpecRoom(sr);
				}
				new PayBoard(customer);
				dispose();                                                   //After the pay board is shown,the customer information panel will dispose
			}
			else
				JOptionPane.showMessageDialog(null,"Sorry,You don't choose any room to book!","No room selected",JOptionPane.WARNING_MESSAGE);
		}
		
		if(cmd.equals("CANCEL"))
		{
			dispose();
		}
	}
}