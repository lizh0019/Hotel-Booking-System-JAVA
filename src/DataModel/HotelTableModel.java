package DataModel;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;


public class HotelTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	public String[] columnNames={"Select","Name","Type","Country","Telephone","Available rooms number","Address","Detail"};
	public Vector<Object[]> objects=null;
	
	public HotelTableModel()
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
        if (col==0||col==(getColumnCount()-1)) {
            return true;
        } else {
            return false;
        }
    }
    
    /*
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    */
	public void clear()
	{
		objects.removeAllElements();
	}
}
