package DataModel;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;


public class SelectedRoomModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	public String[] columnNames={" ","Room ID","Type","Price","Telephone","Address","Detail"};
	public Vector<Object[]> objects=null;
	public static final int HOTEL_MODEL=0;
	public static final int ROOM_MODEL=1;
	private int model;
	
	public SelectedRoomModel(int model)
	{
		super();
		objects=new Vector<Object[]>();
		this.model=model;
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
    	if(col==0&&model==HOTEL_MODEL)
    		return true;
        return false;
    }
    
	public void clear()
	{
		objects.removeAllElements();
	}
}
