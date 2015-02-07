package Calendar;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


/**
 * @author  PI KE
 */
public class DateLabel extends JLabel implements MouseListener{
	private String title="";
	private Color bg_color=new Color(255,255,255);
	private Color fg_color=new Color(0,0,0);
	private String tooltip=null;
	/**
	 * @uml.property  name="cp"
	 * @uml.associationEnd  
	 */
	private CalendarPanel cp=null;
	
    public DateLabel()
    {
    	super();
    	init();
    }
    
    public DateLabel(String title)
    {
    	super();
    	this.title=title;
    	init();
    }
    
    public DateLabel(CalendarPanel cp,String title)
    {
    	super();
    	this.cp=cp;
    	this.title=title;
    	init();
    }
    
    public DateLabel(Color bg_color)
    {
    	super();
    	this.bg_color=bg_color;
    	init();
    }
    
    public DateLabel(CalendarPanel cp,Color bg_color)
    {
    	super();
    	this.cp=cp;
    	this.bg_color=bg_color;
    	init();
    }
    
    public DateLabel(String title,Color bg_color)
    {
    	super();
    	this.title=title;
    	this.bg_color=bg_color;
    	init();
    }
    
    public DateLabel(CalendarPanel cp,String title,Color bg_color)
    {
    	super();
    	this.cp=cp;
    	this.title=title;
    	this.bg_color=bg_color;
    	init();
    }
    
    public DateLabel(CalendarPanel cp,String title,Color bg_color,String tooltip)
    {
    	super();
    	this.cp=cp;
    	this.title=title;
    	this.bg_color=bg_color;
    	this.tooltip=tooltip;
    	init();
    }
    
    public DateLabel(String title,Color bg_color,Color fg_color)
    {
    	super();
    	this.title=title;
    	this.bg_color=bg_color;
    	this.fg_color=fg_color;
    	init();
    }
    
    public DateLabel(CalendarPanel cp,String title,Color bg_color,Color fg_color)
    {
    	super();
    	this.cp=cp;
    	this.title=title;
    	this.bg_color=bg_color;
    	this.fg_color=fg_color;
    	init();
    }
    
    //Initialize the date label
    private void init()
    {
    	setText(title);
    	
    	setBackground(bg_color);
    	setOpaque(true);
    	
    	setForeground(fg_color);
    	
    	if(tooltip!=null)
    	{
    		setToolTipText("<html><b><font size='4'>"+tooltip+"</font></b></html>");
    	}
    	setHorizontalTextPosition(JLabel.CENTER);
    	setVerticalTextPosition(JLabel.CENTER);
    	setHorizontalAlignment(SwingConstants.CENTER);
    	
    	addMouseListener(this);
    }
    
	public void mouseClicked(MouseEvent e) {
		if(cp!=null)
		{
			String year=(String)String.valueOf(cp.getSelectYear());
			String month=(String)String.valueOf(cp.getSelectMonth());
			String date=getText();
			if(month.length()<2)
			{
				month="0"+month;
			}
			
			if(date.length()<2)
			{
				date="0"+date;
			}
			String selectedDate=year+month+date;
			//System.out.println("Today date : "+cp.getTodayDate());
			//System.out.println("Select date : "+selectedDate);
			if(selectedDate.compareTo(cp.getTodayDate())>=0)
			{
				cp.setSelectDay(Integer.parseInt(getText()));
				cp.setSelectedDate(year+"-"+month+"-"+date);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Sorry,Cannot select a date before today.","Error on date",JOptionPane.ERROR_MESSAGE);
				CalendarFrame cf=(CalendarFrame)cp.getParent().getParent().getParent().getParent().getParent();
				cf.setVisible(true);
				cf.toFront();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
