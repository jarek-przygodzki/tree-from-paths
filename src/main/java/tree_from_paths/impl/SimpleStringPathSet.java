package tree_from_paths.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tree_from_paths.PathIterable;
import tree_from_paths.PathSet;

public class SimpleStringPathSet implements PathSet<String> {

	private List<PathIterable<String>> pathIterators;

	public SimpleStringPathSet(String[] paths, String regexSeparator) {
		this.pathIterators = new ArrayList<PathIterable<String>>();
		for (String path : paths) {
			pathIterators.add(new RegExStringPathIterator(path, regexSeparator));
		}

	}

	@Override
	public Iterator<PathIterable<String>> iterator() {
		return pathIterators.iterator();
	}

}
