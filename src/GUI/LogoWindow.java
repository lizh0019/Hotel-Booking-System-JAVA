package GUI;
import java.awt.Toolkit;

import javax.swing.*;

public class LogoWindow extends JFrame{
	public LogoWindow()
	{
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage("icons/hotel.jpg"));
		//setLocationRelativeTo(null);
	}
	
	public LogoWindow(String src)
	{
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage(src));
	}
}
