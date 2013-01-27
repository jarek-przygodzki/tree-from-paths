package tree_from_paths.demo;

import java.util.Enumeration;

import javax.swing.JTree;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 * {@link java.swing.JTree} utilities
 * 
 * @author Jarek Przygódzki
 * 
 */
public class TreeUtils {

	/**
	 * Expand all paths in {@link java.swing.JTree}
	 * 
	 * @param tree
	 *            tree to expand
	 */
	public static void expandAllNodes(JTree tree) {
		TreeNode root = (TreeNode) tree.getModel().getRoot();
		expandNode(tree, new TreePath(root));
	}

	private static void expandNode(JTree tree, TreePath parentPath) {
		TreeNode node = (TreeNode) parentPath.getLastPathComponent();
		if (node.getChildCount() > 0) {
			for (Enumeration<TreeNode> e = node.children(); e.hasMoreElements();) {
				TreeNode childNode = (TreeNode) e.nextElement();
				TreePath childPath = parentPath.pathByAddingChild(childNode);
				expandNode(tree, childPath);
			}
		}
		tree.expandPath(parentPath);
	}
}
