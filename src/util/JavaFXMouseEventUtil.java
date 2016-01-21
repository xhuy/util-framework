package util;

import javafx.scene.Node;

/**
 * Class
 * 
 * @author jesus.herrera
 *
 */
public class JavaFXMouseEventUtil {

	/**
	 * Function that returns true/false if the <code>Node</code> to be search is
	 * inside the nodeTree
	 * 
	 * @param nodeTree 
	 * @param nodeToSearch
	 * @return <code>True</code> if the nodeToSearch is found in the nodeTree
	 */
	public static Boolean isMouseEventOnNode(Node nodeTree, Node nodeToSearch) {

		Node firstLeaf = nodeTree;
		if (firstLeaf == null)
			return false;
		else {
			Node parent = firstLeaf.getParent();

			if (firstLeaf.getClass() == nodeToSearch.getClass())
				return true;
			else
				return isMouseEventOnNode(parent, nodeToSearch);
		}
	}

	/**
	 * Function that returns parent object of type <code>Node</code>
	 * 
	 * @param nodeTree
	 *            All tree
	 * @param nodeToSearch
	 *            Class of Node looking for
	 * @return Object in nodeTree
	 */
	public static Node getParentTypeNode(Node nodeTree, Node nodeToSearch) {

		Node firstLeaf = nodeTree;
		if (firstLeaf == null)
			return null;
		{
			Node parent = firstLeaf.getParent();

			if (firstLeaf.getClass() == nodeToSearch.getClass())
				return firstLeaf;
			else
				return getParentTypeNode(parent, nodeToSearch);
		}
	}

}
