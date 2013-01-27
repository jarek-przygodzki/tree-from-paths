package tree_from_paths.impl;

import javax.swing.tree.DefaultMutableTreeNode;

import tree_from_paths.TreeNodeAccessor;

public class DefaultMutableTreeNodeAccessor implements
		TreeNodeAccessor<DefaultMutableTreeNode, Object> {

	@Override
	public DefaultMutableTreeNode getOrCreate(
			DefaultMutableTreeNode parentNode, Object childNodeName) {
		int childCount = parentNode.getChildCount();
		for (int childIndex = 0; childIndex < childCount; ++childIndex) {
			DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) parentNode.getChildAt(childIndex);
			Object userObject = childNode.getUserObject();
			if (eq(userObject, childNodeName)) {
				return childNode;
			}

		}
		DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(childNodeName);
		parentNode.add(childNode);
		return childNode;
	}

	private static boolean eq(Object userObject, Object nodeName) {
		return userObject == null ? nodeName == null : userObject.equals(nodeName);
	}
	
	public static DefaultMutableTreeNodeAccessor getNew() {
		return new DefaultMutableTreeNodeAccessor();
	}
	

}
