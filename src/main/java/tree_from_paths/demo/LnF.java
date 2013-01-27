package tree_from_paths.demo;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LnF {
	public static void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException 
				| InstantiationException 
				| IllegalAccessException 
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}
