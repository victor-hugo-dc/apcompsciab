package edu.fcps.ab;

import java.util.Iterator;
import java.util.List;

@SuppressWarnings({"unchecked", "rawtypes"})
public class BinarySearchTreeAPlus<E extends Comparable<E>> extends BinaryTreeAPlus<E> {

	protected int size = 0;

	public int size() {
		return size;
	}

	public void add(E element) {
		if (getRoot() == null) {
			setRoot(createNode(element));
			size++;
			return;
		}
		addElement(getRoot(), element, createNode(element));
		size++;
	}

	private void addElement(TreeNode tn, E element, TreeNode nn) {
		if(tn == null || element == null || nn == null)
			return;
		if(element.compareTo((E)tn.getData()) == 0) {
			tn.setData(element);
			size--;
			return;
		}
		if (element.compareTo((E) tn.getData()) > 0) {
			if (tn != null && tn.getRight() == null) {
				tn.setRight(nn);
				return;
			}
			addElement(tn.getRight(), element, nn);
		} else if (tn != null && element.compareTo((E) tn.getData()) < 0) {
			if (tn.getLeft() == null) {
				tn.setLeft(nn);
				return;
			}
			addElement(tn.getLeft(), element, nn);
		}
	}

	public void addAll(List<E> toBeAdded) {
		for (E e : toBeAdded)
			add(e);
	}

	public void addAll(BinaryTreeAPlus<E> bt) {
		addAll(bt.inOrder());
	}

	protected TreeNode<E> getParentOfNode(E element) {
		return getParent(getRoot(), element);
	}

	private TreeNode<E> getParent(TreeNode tn, E element) {
		if (tn == null)
			return null;
		if (tn != null && tn.getData().compareTo(element) > 0) {
			if (tn.getLeft() != null) {
				if (tn.getLeft().getData().equals(element))
					return tn;
				else
					return getParent(tn.getLeft(), element);
			}
		}
		else if (tn != null && tn.getData().compareTo(element) < 0) {
			if (tn.getRight() != null) {
				if (tn.getRight().getData().equals(element))
					return tn;
				else 
					return getParent(tn.getRight(), element);
			}
		}
		return null;
	}

	protected TreeNode<E> getNode(E element) {
		if (getRoot() == null)
			return null;
		TreeNode n = getParentOfNode(element);
		if (n == null) {
			if (getRoot().getData().equals(element))
				return getRoot();
			else
				return null;
		}
		if (n.getData().compareTo(element) > 0)
			return n.getLeft();
		if (n.getData().compareTo(element) < 0)
			return n.getRight();
		else
			return n;
	}

	public E get(E key) {
		TreeNode tn = getNode(key);
		if (tn == null)
			return null;
		return (E) tn.getData();
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contains(E key) {
		return inOrder().contains(key);
	}

	public E remove(E element){
		if (!contains(element))
			return null;
		TreeNode parentOfNode = getParentOfNode(element);
		boolean isRoot = (parentOfNode == null);
		TreeNode tn = null;
		if (isRoot)
			tn = getRoot();
		else {
			E e = (E)parentOfNode.getData();
			if (element.compareTo(e) > 0)
				tn = parentOfNode.getRight();
			else tn = parentOfNode.getLeft();
		}
		E pred = predessor(element);
		if (pred != null && tn.getLeft() != null && !tn.getLeft().getData().equals(pred)) {
			TreeNode node = getNode(pred);
	        if (node.getLeft() != null)
	            getParentOfNode(pred).setRight(node.getLeft());
	        else
	          	getParentOfNode(pred).setRight(null);
		if (isRoot) {
	        node.setRight(getRoot().getRight());
	        node.setLeft(tn.getLeft());
	        setRoot(node);
	    } else {
	      	if (tn == parentOfNode.getLeft())
	      		parentOfNode.setLeft(node);
	        else {
	        	parentOfNode.setRight(node);
				node.setRight(tn.getRight());
				node.setLeft(tn.getLeft());
	        }
	    }
	    } else if (tn.getLeft() != null && tn.getLeft().getData().equals(pred)) {
			TreeNode node = getNode(pred);
	        if (isRoot) {
	            node.setRight(getRoot().getRight());
	            setRoot(node);
	        } else {
	          	tn.getLeft().setRight(tn.getRight());
				if (tn == parentOfNode.getLeft())
					parentOfNode.setLeft(tn.getLeft());
				else
					parentOfNode.setRight(tn.getLeft());
	        }
	    } else if (pred == null) {
		    E post = successor(element);
	        if (post != null && tn.getRight() != null && !tn.getRight().getData().equals(post)) {
	           	TreeNode postnode = getNode(post);
	           	if (postnode.getRight() != null)
	           		getParentOfNode(post).setLeft(postnode.getRight());
				else
					getParentOfNode(post).setLeft(null);
				if (isRoot) {
					postnode.setRight(tn.getRight());
					postnode.setLeft(null);
					setRoot(postnode);
				} else {
					if (tn == parentOfNode.getLeft())
						parentOfNode.setLeft(postnode);
					else {
						parentOfNode.setRight(postnode);
						postnode.setRight(tn.getRight());
						postnode.setLeft(tn.getLeft());
					}
				}
	    } else if (tn.getRight() != null && tn.getRight().getData().equals(post)) {
			if (isRoot)
				setRoot(getRoot().getRight());
			else {
				if (tn == parentOfNode.getLeft()) parentOfNode.setLeft(tn.getLeft());
				else parentOfNode.setRight(tn.getRight());
				}
		} else if (post == null) {
	        if (isRoot)
	          	setRoot(null);
	        else if (tn == parentOfNode.getLeft())
	            parentOfNode.setLeft(null);
	        else
	            parentOfNode.setRight(null);
		}
	    }
	    size--;
		return element;
	}

	public void removeAll(List<E> toBe) {
		for (E e : toBe)
			remove(e);
	}

	public Iterator<E> iterator() {
		return null;
	}

	public E predessor(E string) {
		// TODO Auto-generated method stub
		TreeNode tn = getNode(string);
		if(tn.getLeft() == null)
			return null;
		tn = tn.getLeft();
		return (E) max((E)tn.getData());
	}

	public E successor(E string) {
		// TODO Auto-generated method stub
		TreeNode tn = getNode(string);
		if(tn.getRight() == null)
			return null;
		tn = tn.getRight();
		return (E) min((E)tn.getData());
	}

	public E min(E string) {
		// TODO Auto-generated method stub
		TreeNode tn = getNode(string);
		while (tn.getLeft() != null)
			tn = tn.getLeft();
		return (E) tn.getData();
	}

	public E max(E string) {
		// TODO Auto-generated method stub
		TreeNode tn = getNode(string);
		while (tn.getRight() != null)
			tn = tn.getRight();
		return (E) tn.getData();
	}
	
	public TreeNode createNode(E element) {
		return new TreeNode(element);
	}
}
