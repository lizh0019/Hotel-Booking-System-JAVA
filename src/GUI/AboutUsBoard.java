package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class AboutUsBoard extends LogoWindow{
	private static final long serialVersionUID = 1L;
	private int WIDTH=450;
	private int HEIGHT=400;
	
	public AboutUsBoard()
	{
		super();
        init();
	}
	
	private void init()
	{
		setSize(WIDTH,HEIGHT);
		setResizable(false);
		setTitle("About Hotel Booking System");
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		JLabel lbl=new JLabel("<html><p><h1>About us</h1></p>"
				+"<p>HotelBookingSystem has been first to market with a number of innovations. It was the first hostel-booking website to develop a travel social network which launched in November 2010. It also has the largest number of customer ratings and reviews and has seamlessly integrated video, podcasting and guides into the site. 2010 also marked a first for HotelBookingSystem when Tours Services was launched, an online travel guildance where customers can avail of great offers and exclusive discounts across the globe.</p>" 
				+"<p>&nbsp;</p>"
				+"<p><font font-weight='bold'>Our Mission: To become the fastest-growing online provider of great value accommodation, using innovative technology to inspire independently minded travellers everywhere.</font></p>"
				+"</html>");
		lbl.setIcon(new ImageIcon("icons\\hotelL.jpg"));
		getContentPane().add(lbl,BorderLayout.CENTER);
		
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
