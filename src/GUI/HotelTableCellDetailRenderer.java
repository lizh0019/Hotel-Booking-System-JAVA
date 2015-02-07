package GUI;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;


public class HotelTableCellDetailRenderer extends JButton implements TableCellRenderer {
	public HotelTableCellDetailRenderer()
	{
		super();
	}
	
	public Component getTableCellRendererComponent(JTable table, Object object,
			boolean isSelected, boolean hasFocus, int row, int col) {
		if(object instanceof JButton)
		{
			JButton comp=(JButton)object;
			comp.setHorizontalAlignment(SwingConstants.CENTER);
			return comp;
		}
		return (Component)object;
	}
}
