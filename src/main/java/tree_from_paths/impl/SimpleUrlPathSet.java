package tree_from_paths.impl;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tree_from_paths.PathIterable;
import tree_from_paths.PathSet;

public class SimpleUrlPathSet implements PathSet<String> {

	private List<PathIterable<String>> pathIterators;

	public SimpleUrlPathSet(URL[] urls) {
		this.pathIterators = new ArrayList<PathIterable<String>>();
		for (URL url : urls) {
			pathIterators.add(new UrlPathIterator(url));
		}

	}

	@Override
	public Iterator<PathIterable<String>> iterator() {
		return pathIterators.iterator();
	}

}
