package tree_from_paths.demo;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class JTreeDemo {
	
	public static void showTree(JTree tree) {
		createAndShowGui(tree);
	}

	private static void createAndShowGui(JTree tree) {
		tree.setRootVisible(false);
		TreeUtils.expandAllNodes(tree);
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new JScrollPane(tree));
		f.setLocationByPlatform(true);
		f.pack();
		f.setVisible(true);
	}

}
