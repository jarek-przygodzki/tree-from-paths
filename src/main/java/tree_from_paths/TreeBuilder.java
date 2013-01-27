package tree_from_paths;

public class TreeBuilder<NodeType, NameType> {
	public <NodeAccessor extends TreeNodeAccessor<NodeType, ? super NameType>> NodeType 
		buildTree(
				PathSet<NameType> paths,
				NodeType root, 
				NodeAccessor nodeAccessor) {
		for (PathIterable<NameType> path : paths) {
			NodeType current = root;
			for (NameType nodeName : path) {
				current = nodeAccessor.getOrCreate(current, nodeName);
			}
		}
		return root;
	}

	public static <NodeType, NameType> TreeBuilder<NodeType, NameType> getNew() {
		return new TreeBuilder<NodeType, NameType>();
	}
}
