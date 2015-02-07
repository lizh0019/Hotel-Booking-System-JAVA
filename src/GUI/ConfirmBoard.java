package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GUI.HotelBookingFrame.SearchThread;


public class ConfirmBoard extends LogoWindow{
	private static final long serialVersionUID = 1L;
	private int WIDTH=400;
	private int HEIGHT=150;
	
	public ConfirmBoard()
	{
		super();
        init();
	}
	
	private void init()
	{
		setSize(WIDTH,HEIGHT);
		setTitle("Confirm window");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());
		
		JPanel panel=new JPanel();
		JLabel lbl=new JLabel("<html>Congratulations.You booking is successful.<br>We have sent an email regarding to the booking detals.Please kindly check it.<br>Thank you.Hope to see you soon again.</html>");
		lbl.setIcon(new ImageIcon("icons/confirm.gif"));
		lbl.setPreferredSize(new Dimension(360,80));
		lbl.setBackground(new Color(255,255,255));
		lbl.setOpaque(true);
		panel.add(lbl);
		panel.setBounds(0,0,400,180);
		getContentPane().add(panel,BorderLayout.CENTER);
		
		panel=new JPanel();
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
