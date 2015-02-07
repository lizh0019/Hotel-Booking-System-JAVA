package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import Core.HotelBookingSystem;
import Core.MatchedHotel;
import Core.Room;
import DataModel.MatchedHotelRoomModel;


/**
 * @author  PI KE
 */
public class DetailMatchedHotelInfoFrame extends LogoWindow implements ActionListener{
	private static final long serialVersionUID = 1L;
	public String title="Detail matched hotel information";
	private int windowWidth=800;
	private int windowHeight=600;
	private JTable resultTable=null;
	/**
	 * @uml.property  name="mhrm"
	 * @uml.associationEnd  
	 */
	private MatchedHotelRoomModel mhrm;
	/**
	 * @uml.property  name="mh"
	 * @uml.associationEnd  
	 */
	private MatchedHotel mh;
	/**
	 * @uml.property  name="hbs"
	 * @uml.associationEnd  
	 */
	private HotelBookingSystem hbs;
	
	public DetailMatchedHotelInfoFrame(MatchedHotel mh,HotelBookingSystem hbs)
	{
		this.mh=mh;
		this.hbs=hbs;
		
		init();
	}
	
	private void init()
	{
		this.setTitle(title);
		this.setSize(windowWidth,windowHeight);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		this.getContentPane().add("North",getInfoPanel());
		this.getContentPane().add("Center",getResultPanel());
		this.getContentPane().add("South",getControlPanel());
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public JPanel getInfoPanel()
	{
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel infoPanel=new JPanel();
		JLabel nameLbl,nameField,typeLbl,contactLbl,contactField,addressLbl,addressArea,descriptionLbl,descriptionField;
        nameLbl = new JLabel("Name");
        nameField = new JLabel(mh.getName());
        typeLbl = new JLabel("Type");
        JPanel typeField=new JPanel();
        typeField.setLayout(new FlowLayout(FlowLayout.LEFT));
        if(!mh.type.equals("0"))
        {
            int star=Integer.parseInt(mh.getType());
            for(int i=1;i<=star;i++)
            {
            	typeField.add(new JLabel(new ImageIcon("icons\\star.gif")));
            }
        }
        else
        	typeField.add(new JLabel("Budget hotel"));
        contactLbl = new JLabel("Telephone");
        contactField = new JLabel(mh.getTel());
        addressLbl = new JLabel("Address");
        addressArea = new JLabel(mh.getHotelAddressString());
        descriptionLbl = new JLabel("Description");
        descriptionField = new JLabel("<html><p>"+mh.getDescription()+"</p></html>");
        GroupLayout infoLayout=new GroupLayout(infoPanel);
        infoPanel.setLayout(infoLayout);

		infoLayout.setHorizontalGroup(infoLayout.createSequentialGroup()
				.addContainerGap(3, 20)
				.addGroup(
						infoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(nameLbl)
								.addComponent(typeLbl)
								.addComponent(contactLbl)
								.addComponent(addressLbl)
								.addComponent(descriptionLbl)
								.addGap(10))
				.addGap(10)
				.addGroup(
						infoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(nameField)
								.addComponent(typeField)
								.addComponent(contactField)
								.addComponent(addressArea)							
								.addComponent(descriptionField)
								.addGap(10)));
		infoLayout.setVerticalGroup(infoLayout.createSequentialGroup()
				.addContainerGap(3, 20)
				.addGroup(
						infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
								.addComponent(nameLbl)
								.addComponent(nameField))
								.addGap(10)
				.addGroup(
						infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
								.addComponent(typeLbl)
								.addComponent(typeField))
								.addGap(10)
				.addGroup(
						infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
								.addComponent(contactLbl)
								.addComponent(contactField))
								.addGap(10)
				.addGroup(
						infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
								.addComponent(addressLbl)
								.addComponent(addressArea))
								.addGap(10)
				.addGroup(
						infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
								.addComponent(descriptionLbl)
								.addComponent(descriptionField)
								.addGap(10)
								)
				.addContainerGap(3, 20));
		
		
        infoPanel.setSize(windowWidth-20,180);
        infoPanel.setPreferredSize(new Dimension(windowWidth-50,180));
        panel.add("Center",infoPanel);
        
        JPanel photoPanel=new JPanel();
        photoPanel.add(new JLabel(new ImageIcon(create2DImage(new ImageIcon("icons\\hotels\\asian1.jpg").getImage(),140,160))));
        panel.add("East",photoPanel);
		return panel;
	}
	
	public JScrollPane getResultPanel()
	{
		resultTable=new JTable();
		mhrm=new MatchedHotelRoomModel();
		resultTable.setName("MatchedRoomTable");
		resultTable.setModel(mhrm);
		resultTable.setAutoCreateColumnsFromModel(true);
		resultTable.setRowHeight(20);
		
		//mh.searchMatchedRoom(mh.getHotelId(), mh.getRoomPriceRange());
		Vector<Room> mr=mh.getMatchedRooms();
		for(int i=0;i<mr.size();i++)
		{
			Room room=mr.get(i);
			//JCheckBox checkBox=new JCheckBox();
			//checkBox.setName(String.valueOf(room.getRoomId()));
			Object[] object=new Object[]{room.getRoomId(),room.getType(),room.getPrice(),room.getTel(),"Level "+room.getLevel()+" Room "+room.getRoomNo(),room.getDescription()};
			mhrm.addObject(object);
		}
		TableColumn col=resultTable.getColumnModel().getColumn(0);
		//col.setCellRenderer(new HotelTableCellIDRenderer());
		//col.setCellEditor(new HotelTableCellIDEditor(hbs));
		col.setPreferredWidth(4);
		resultTable.revalidate();
		
		JScrollPane jsp=new JScrollPane(resultTable);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jsp.setSize(windowWidth,400);
		return jsp;
	}
	
	public JPanel getControlPanel()
	{
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createEtchedBorder());
		
		JPanel btnPanel=new JPanel();
		btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JButton btn=new JButton("Book");
		btn.setMnemonic(KeyEvent.VK_B);
		btn.setActionCommand("BOOK");
		btn.addActionListener(this);
		//btnPanel.add(btn);
		
		btn=new JButton("Ok");
		btn.setMnemonic(KeyEvent.VK_O);
		btn.setActionCommand("OK");
		btn.addActionListener(this);
		btnPanel.add(btn);
		panel.add(btnPanel);
		return panel;
	}
	
	//Create 2D image
	private Image create2DImage(Image src,int w,int h)
	{
		BufferedImage buf_image=new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d=buf_image.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.drawImage(src,0,0,w,h,null);
		g2d.dispose();
		
		return buf_image;	
	}

	public void actionPerformed(ActionEvent e) {
		String cmd=(String)e.getActionCommand();
		
		if(cmd.equals("OK"))
			dispose();
		
		if(cmd.equals("BOOK"))
		{
			//new CustomerInfoFrame(hbs,SelectedRoomModel.ROOM_MODEL,mh.getHotelId());
		}
	}
}
