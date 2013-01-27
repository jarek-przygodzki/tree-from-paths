package tree_from_paths;

import java.net.URL;

import tree_from_paths.impl.SimpleStringPathSet;
import tree_from_paths.impl.SimpleUrlPathSet;

public class PathSetFactory {
	public static PathSet<String> fromStringPaths(String[] paths, String regexSeparator) {
		return new SimpleStringPathSet(paths, regexSeparator);
	}

	public static PathSet<String> fromUrls(URL[] urls) {
		return new SimpleUrlPathSet(urls);
	}
}
