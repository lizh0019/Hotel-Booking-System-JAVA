package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Core.Customer;


/**
 * @author  PI KE
 */
public class PayBoard extends LogoWindow implements ActionListener{
	private static final long serialVersionUID = 1L;
	private int windowWidth=500;
	private int windowHeight=400;
	
	/**
	 * @uml.property  name="infoPanel"
	 */
	private JPanel infoPanel;
	private JTextField nameField;
	private JTextField emailField;
	private JTextField cardNoField;
	private JComboBox cardTypeBox;
	
	/**
	 * @uml.property  name="customer"
	 * @uml.associationEnd  
	 */
	private Customer customer;
	
	public PayBoard(Customer customer)
	{
		super();
		this.customer=customer;
        init();
	}
	
	private void init()
	{
		this.setTitle("Payment information");
		this.setSize(windowWidth,windowHeight);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());

		this.getContentPane().add("North",getTitlePanel());
		this.getContentPane().add("Center",getInfoPanel());
        this.getContentPane().add("South",getControlPanel());
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
    private JPanel getTitlePanel()
    {
    	JPanel panel=new JPanel();
    	panel.setLayout(new BorderLayout());
    	panel.setBounds(5,5,windowWidth-10,40);
    	JLabel titleLbl=new JLabel("<html><font font-weight='bold'><h1>Payment information</h1></font></html>",JLabel.CENTER);
    	JLabel notificationLbl=new JLabel("<html><font color='#ff0000'>*Please enter your payment information to book the hotel selected</font></html>",JLabel.CENTER);
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
        
    	JLabel nameLbl,emailLbl,cardTypeLbl,cardNoLbl;
        nameLbl = new JLabel("Name");
        nameField = new JTextField(customer.getName());
        emailLbl=new JLabel("Email");
        emailField=new JTextField(customer.getEmail());
        cardTypeLbl=new JLabel("Card type");
        cardTypeBox=new JComboBox();
        cardTypeBox.addItem("Visa");
        cardTypeBox.addItem("Master card");
        cardTypeBox.addItem("Nets");    
        cardNoLbl=new JLabel("Card no.");
        cardNoField=new JTextField();
        
        GroupLayout infoLayout=new GroupLayout(infoPanel);
        infoPanel.setLayout(infoLayout);
        
		infoLayout.setHorizontalGroup(infoLayout.createSequentialGroup()
				.addContainerGap(3, 20)
				.addGroup(
						infoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(nameLbl)
								.addComponent(emailLbl)
								.addComponent(cardTypeLbl)
								.addComponent(cardNoLbl)
								.addGap(10))
				.addGroup(
						infoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(nameField)
								.addComponent(emailField)
								.addComponent(cardTypeBox)
								.addComponent(cardNoField)
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
								.addComponent(emailLbl)
								.addComponent(emailField))
								.addGap(10)
				.addGroup(
						infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
								.addComponent(cardTypeLbl)
								.addComponent(cardTypeBox))
								.addGap(10)
				.addGroup(
						infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
								.addComponent(cardNoLbl)
								.addComponent(cardNoField)
								.addGap(10)
								)
				.addContainerGap(3, 20));
		
        infoPanel.setSize(windowWidth-20,windowHeight-50);
        infoPanel.setPreferredSize(new Dimension(windowWidth-50,windowHeight-50));
        
        return infoPanel;
    }
    
	public JPanel getControlPanel()
	{
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel btnPanel=new JPanel();
		btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JButton btn=new JButton("Pay");
		btn.setMnemonic(KeyEvent.VK_P);
		btn.setActionCommand("PAY");
		btn.addActionListener(this);
		btnPanel.add(btn);
		
		btn=new JButton("Cancel");
		btn.setMnemonic(KeyEvent.VK_C);
		btn.setActionCommand("CANCEL");
		btn.addActionListener(this);
		btnPanel.add(btn);
		panel.add("Center",btnPanel);
		
		return panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd=(String)e.getActionCommand();
		
		if(cmd.equals("PAY"))
		{
			if(customer.pay())
			{
				new ConfirmBoard();
				dispose();
			}
			else
				JOptionPane.showMessageDialog(null,"Cannot book specified room","Booking error",JOptionPane.ERROR_MESSAGE);
		}
		
		if(cmd.equals("CANCEL"))
		{
			dispose();
		}
	}
}
