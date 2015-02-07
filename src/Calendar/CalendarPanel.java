package Calendar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JPanel;

public class CalendarPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private static int CALENDAR_WIDTH=300;
	private static int CALENDAR_HEIGHT=180;
	private static int CALENDAR_COLS=7;
	private static int FIRST_DAY_OF_MONTH_WEEKDAY=1;
	protected static int CURRENT_YEAR=1972;
	protected static int CURRENT_MONTH=1;
	protected static int CURRENT_DAY=1;
	
	protected int SELECTED_YEAR=2010;
	protected int SELECTED_MONTH=1;
	
	private int select_year=0;
	private int select_month=0;
	private int select_day=0;
	private String select_date="";
	private Calendar cal;
	
	public CalendarPanel()
	{
		super();
		init();
		buildCalendar();
	}
	
    //Initialize Calendar Panel
	protected void init()
	{
		setLayout(new GridLayout(0,CALENDAR_COLS));
        cal=Calendar.getInstance();
        CURRENT_YEAR=cal.get(Calendar.YEAR);
        CURRENT_MONTH=cal.get(Calendar.MONTH);
        CURRENT_DAY=cal.get(Calendar.DATE);
        
        SELECTED_YEAR=CURRENT_YEAR;
        SELECTED_MONTH=CURRENT_MONTH;
        
        select_year=CURRENT_YEAR;
        select_month=CURRENT_MONTH+1;
        
        cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),1);
        FIRST_DAY_OF_MONTH_WEEKDAY=cal.get(Calendar.DAY_OF_WEEK);  
	}
	
	//Build the Calendar panel
	protected void buildCalendar()
	{
		add(new DateLabel("SUN",new Color(255,200,160)));
        add(new DateLabel("MON",new Color(200,255,200)));
        add(new DateLabel("TUE",new Color(200,255,200)));
        add(new DateLabel("WED",new Color(200,255,200)));
        add(new DateLabel("THU",new Color(200,255,200)));
        add(new DateLabel("FRI",new Color(200,255,200)));
        add(new DateLabel("SAT",new Color(255,200,160)));
        
        for(int i=1;i<FIRST_DAY_OF_MONTH_WEEKDAY;i++)
        {
        	add(new DateLabel(""));
        }
        
        for(int j=1;j<=cal.getActualMaximum(Calendar.DAY_OF_MONTH);j++)
        {
        	if(CURRENT_DAY==j)
        	{
        		add(new DateLabel(this,Integer.toString(j),new Color(200,255,200)));
        	}
        	else
        	{
        		add(new DateLabel(this,Integer.toString(j)));
        	}
        }
		
		repaint();
		validate();
	}
	
	//Refresh the calendar panel without parameters
	public void refreshCalendar()
	{
        removeAll();
        buildCalendar();
	}
	
	//refresh calendar panel
	public void refreshCalendar(int year,int month)
	{
        cal.set(year,month,1);
        SELECTED_YEAR=year;
        SELECTED_MONTH=month;
        
        FIRST_DAY_OF_MONTH_WEEKDAY=cal.get(Calendar.DAY_OF_WEEK);  
        
        removeAll();
        buildCalendar();
	}
	
	//Get current day date
	public static int getCurrentDay()
	{
		return CURRENT_DAY;
	}
	
	public void setSelectYear(int year)
	{
		select_year=year;
	}

	public int getSelectYear()
	{
		return select_year;
	}
	
	public void setSelectMonth(int month)
	{
		select_month=month;
	}

	public int getSelectMonth()
	{
		return select_month;
	}
	
	public void setSelectDay(int day)
	{
		select_day=day;
	}

	public int getSelectDay()
	{
		return select_day;
	}
	
	public void setSelectedDate(String date)
	{
		select_date=date;
	}
	
	public String getSelectedDate()
	{
		return select_date;
	}
	
	public String getTodayDate()
	{
		String year=(String)String.valueOf(CURRENT_YEAR);
		String month=(String)String.valueOf(CURRENT_MONTH+1);
		String date=(String)String.valueOf(CURRENT_DAY);
		if(month.length()<2)
		{
			month="0"+month;
		}
		
		if(date.length()<2)
		{
			date="0"+date;
		}
		return year+month+date;
	}
}
