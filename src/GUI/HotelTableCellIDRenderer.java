package GUI;
import java.awt.Component;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;


public class HotelTableCellIDRenderer extends JCheckBox implements TableCellRenderer {
	private static final long serialVersionUID = 1L;
	Component comp;
	
	public HotelTableCellIDRenderer()
	{
		super();	
	}
	
	public Component getTableCellRendererComponent(JTable table, Object object,
			boolean isSelected, boolean hasFocus, int row, int col) {	
		if(object instanceof JCheckBox)
		{
			JCheckBox comp=(JCheckBox)object;
			comp.setHorizontalAlignment(SwingConstants.CENTER);
			return comp;
		}
		return (Component)object;
	}
}
