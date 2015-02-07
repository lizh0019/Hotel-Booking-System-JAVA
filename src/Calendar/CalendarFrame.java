package Calendar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;


/**
 * @author  PI KE
 */
public class CalendarFrame extends JWindow{
	private static final long serialVersionUID = 1L;
	public static String title="Calendar Frame";
	private int windowWidth=300;
	private int windowHeight=200;
	
	/**
	 * @uml.property  name="cp"
	 * @uml.associationEnd  
	 */
	private CalendarPanel cp;
	/**
	 * @uml.property  name="cc"
	 * @uml.associationEnd  
	 */
	private CalendarController cc;
	private JLabel statusLbl;
	
	public void init()
	{
		this.setSize(windowWidth,windowHeight);
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout());
		
		panel.add("Center",getCalendarPanel());
		panel.add("North",getControllerPanel());
		panel.add("South",getStatusPanel());
		
		//panel.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, new Color(255,0,0)));
		panel.setBorder(BorderFactory.createRaisedBevelBorder());
		//panel.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, new ImageIcon("icons\\close.gif")));
		this.getContentPane().add(panel);
	}
	
	private JPanel getControllerPanel()
	{
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout());
		
		cc=new CalendarController(cp);
		panel.add("Center",cc);
		
		JLabel closeLbl=new JLabel(new ImageIcon("icons\\close.gif"));
		closeLbl.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e)
			{
				setVisible(false);
			}
		});
		panel.add("East",closeLbl);
		panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
		return panel;
	}
	
	private JPanel getCalendarPanel()
	{
		cp=new CalendarPanel();
		return cp;
	}
	
	private JLabel getStatusPanel()
	{
		statusLbl=new JLabel();
		return statusLbl;
	}
	
	public String getSelectedDate()
	{
		return cp.getSelectedDate();
	}
	
	public boolean isSelected()
	{
		if(cp.getSelectDay()==0)
			return false;
		return true;
	}
	
	public void clearSelectDay()
	{
		cp.setSelectDay(0);
	}
}
