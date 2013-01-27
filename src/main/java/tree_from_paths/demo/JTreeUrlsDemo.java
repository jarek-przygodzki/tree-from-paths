package tree_from_paths.demo;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import tree_from_paths.PathSetFactory;
import tree_from_paths.TreeBuilder;
import tree_from_paths.TreeNodeAccessor;
import tree_from_paths.impl.DefaultMutableTreeNodeAccessor;

public class JTreeUrlsDemo {
	
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
		URL[] urls = createUrls();
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode();
		TreeNodeAccessor<DefaultMutableTreeNode, Object> 
			nodeAccessor = DefaultMutableTreeNodeAccessor.getNew();
		rootNode = defaultMutableTreeNodeBuilder.buildTree(
				PathSetFactory.fromUrls(urls), rootNode, nodeAccessor);
		DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
		JTree tree = new JTree(treeModel);
		return tree;

	}

	private static URL[] createUrls() {
		try {
			URL[] urls = {
					new URL("http://resources.autodesk.com/files/med/docs/ubisoft_assassin_s_creed_v3.pdf"),
					new URL("ftp://ftp.vectranet.pl/pub/linux/ubuntu-pl/ubuntu-pl/Przyjazny-Puchacz-12.04PL-DVD-i386.iso"),
					new URL("http://jarekprzygodzki.wordpress.com/"),
					new URL("ftp://ftp.tpnet.pl/pub/linux/ubuntu-pl/Niebianska-Nimfa-11.04PL-DVD-64bit.iso"),
					new URL("http://ubuntu.pl/iso/Niebianska-Nimfa-11.04PL-DVD-32bit.iso"),
					new URL("ftp://ftp.vectranet.pl/pub/linux/ubuntu-pl/ubuntu-pl/Lamparcik_netbook_10.04PL.iso"),
					new URL("ftp://ftp.tpnet.pl/pub/linux/ubuntu-pl/Lamparcik_netbook_10.04PL.iso")
			};
			return urls;
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

}
