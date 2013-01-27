package tree_from_paths;

public interface TreeNodeAccessor<NodeType, NameType> {
	NodeType getOrCreate(NodeType parentNode, NameType childNodeName);
}
