package tree_from_paths.impl;

import java.util.Arrays;
import java.util.Iterator;

import tree_from_paths.PathIterable;

public class RegExStringPathIterator implements PathIterable<String> {

	private final String separator;
	private final String path;

	public RegExStringPathIterator(String path, String regexSeparator) {
		this.path = path;
		this.separator = regexSeparator;
	}

	@Override
	public Iterator<String> iterator() {
		String[] paths = path.split(separator);
		return Arrays.asList(paths).iterator();
	}

}
