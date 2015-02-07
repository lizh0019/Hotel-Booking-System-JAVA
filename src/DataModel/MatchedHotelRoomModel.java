package DataModel;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;


public class MatchedHotelRoomModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	public String[] columnNames={"Room ID","Capacity","Price(SGD$)","Telephone","Address","Detail"};
	public Vector<Object[]> objects=null;
	
	public MatchedHotelRoomModel()
	{
		super();
		objects=new Vector<Object[]>();
	}
	
	public void addObject(Object[] strs)
	{
		objects.add(strs);
	}
	
	public String getColumnName(int col)
	{
		return columnNames[col];
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return objects.size();
	}

	public Object getValueAt(int row, int col) {
		return (Object)(objects.get(row))[col];
	}
	
	public void setValueAt(Object object,int row,int col)
	{
		(objects.get(row))[col]=object;
		fireTableCellUpdated(row, col);
	}
	
    public boolean isCellEditable(int row, int col) {
    	if(col==0)
    		return true;
        return false;
    }
    
    /*
    public Class getColumnClass(int c) {
    	System.out.println("Class "+getValueAt(0, c).getClass()+" at col "+c);
        return getValueAt(0, c).getClass();
    }
    */
    
	public void clear()
	{
		objects.removeAllElements();
	}
}
