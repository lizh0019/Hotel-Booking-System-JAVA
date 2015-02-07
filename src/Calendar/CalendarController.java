package Calendar;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * @author  PI KE
 */
public class CalendarController extends JPanel{
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="cp"
	 * @uml.associationEnd  
	 */
	protected CalendarPanel cp;
	protected JComboBox year_box;
	protected JComboBox month_box;

	public CalendarController()
	{
		super();
		init();
	}
	
	public CalendarController(CalendarPanel cp)
	{
		super();
		this.cp=cp;
		init();
	}
	
	//Initialize the controller
	private void init()
	{
		add(new JLabel("Please choose :"));
		
		year_box=new JComboBox();
		fillBox(year_box,1972,2020);
		year_box.setSelectedItem(Integer.toString(CalendarPanel.CURRENT_YEAR));
		
		month_box=new JComboBox();
		fillBox(month_box,1,12);
		month_box.setSelectedItem(Integer.toString(CalendarPanel.CURRENT_MONTH+1));
        
		year_box.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				int year=Integer.parseInt((String)year_box.getSelectedItem());
                int month=Integer.parseInt((String)month_box.getSelectedItem());
                cp.setSelectYear(year);
                cp.setSelectMonth(month);
                cp.refreshCalendar(year, month-1);
			}
		});
		
		month_box.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				int year=Integer.parseInt((String)year_box.getSelectedItem());
                int month=Integer.parseInt((String)month_box.getSelectedItem());
                cp.setSelectYear(year);
                cp.setSelectMonth(month);
                cp.refreshCalendar(year, month-1);
			}
		});
		
		add(year_box);
		add(month_box);
	}
	
	//Fill the combo box
	private void fillBox(JComboBox com,int start,int end)
	{
		for(int i=start;i<=end;i++)
		{
			com.addItem(Integer.toString(i));
		}
	}
	
	//Get year combo box
	public JComboBox getYearBox()
	{
		return year_box;
	}
	
	//Get month combo box
	public JComboBox getMonthBox()
	{
		return month_box;
	}
}
