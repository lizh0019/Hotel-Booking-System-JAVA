package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import Core.Customer;


/**
 * @author  PI KE
 */
public class BookingInfoViewer extends LogoWindow{
	private static final long serialVersionUID = 1L;
	private int WIDTH=450;
	private int HEIGHT=400;
	
	/**
	 * @uml.property  name="customer"
	 * @uml.associationEnd  
	 */
	private Customer customer;
	public BookingInfoViewer(Customer customer)
	{
		super();
		this.customer=customer;
        init();
	}
	
	private void init()
	{
		setSize(WIDTH,HEIGHT);
		setResizable(false);
		setTitle("Booking Information--"+customer.getName());
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		JLabel lbl=new JLabel(customer.displayBookingInfo());
		Border paddingBorder = BorderFactory.createEmptyBorder(10,10,10,10);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		lbl.setBorder(BorderFactory.createCompoundBorder(border,paddingBorder));
		lbl.setSize(WIDTH,HEIGHT-40);
		lbl.setBackground(new Color(255,255,255));
		lbl.setOpaque(true);
		JScrollPane jsp=new JScrollPane(lbl);
		getContentPane().add(jsp,BorderLayout.CENTER);
		
		JPanel panel=new JPanel();
		JButton btn=new JButton(" OK ");
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		panel.add(btn);
		getContentPane().add(panel,BorderLayout.SOUTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
