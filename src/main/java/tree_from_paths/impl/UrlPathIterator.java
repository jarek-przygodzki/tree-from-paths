package tree_from_paths.impl;

import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;

import tree_from_paths.PathIterable;

public class UrlPathIterator implements PathIterable<String> {

	private final URL url;

	public UrlPathIterator(URL url) {
		this.url = url;
	}

	@Override
	public Iterator<String> iterator() {
		String[] paths = { url.getProtocol(), url.getHost(), url.getPath() };
		return Arrays.asList(paths).iterator();
	}

}
