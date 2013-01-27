package tree_from_paths.demo;

import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import tree_from_paths.PathSetFactory;
import tree_from_paths.TreeBuilder;
import tree_from_paths.TreeNodeAccessor;
import tree_from_paths.impl.DefaultMutableTreeNodeAccessor;

public class JTreePathsDemo {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				LnF.setLookAndFeel();
				JTreeDemo.showTree(buildTree());
			}

		});
	}
	
	private static JTree buildTree() {
		TreeBuilder<DefaultMutableTreeNode, String> 
			defaultMutableTreeNodeBuilder = TreeBuilder.getNew();
		String[] paths = { "A;B;C", "X;A", "A;X", "Q", "X;Y;Z;R;Q;Q" };
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode();
		TreeNodeAccessor<DefaultMutableTreeNode, Object> 
			nodeAccessor = DefaultMutableTreeNodeAccessor.getNew();
		rootNode = defaultMutableTreeNodeBuilder.buildTree(
				PathSetFactory.fromStringPaths(paths, ";"), rootNode, 
				nodeAccessor);
		DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
		JTree tree = new JTree(treeModel);
		return tree;


	}

}
