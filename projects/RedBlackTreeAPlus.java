package edu.fcps.ab;

import edu.fcps.ab.RedBlackTreeAPlus.RBTreeNode.Colors;
@SuppressWarnings({"rawtypes","unchecked"})

public class RedBlackTreeAPlus<E extends Comparable<E>> extends BinarySearchTreeAPlus<E> {

	public static class RBTreeNode extends TreeNode{
		public enum Colors {RED, BLACK}
		
		private Colors color;
		
		public RBTreeNode(Comparable<?> data) {
			super(data);
			color = Colors.RED;
		}
	}
	
	public void add(E element) {
		super.add(element);
		RBTreeNode x = (RBTreeNode) getNode(element);
		RBTreeNode px = parent(x);
		while(x != getRoot() && px.color == Colors.RED) {
			RBTreeNode grandpx = parent(px);
			if(px == left(grandpx)) {
				RBTreeNode y = right(grandpx);
				if(y != null && y.color == Colors.RED) {
					px.color = Colors.BLACK;
					y.color = Colors.BLACK;
					x = grandpx;
				} else if(x == right(px)) {
					x = px;
					leftRotate(x);
				} else {
					px.color = Colors.BLACK;
					grandpx.color = Colors.RED;
					rightRotate(grandpx);
				}
			} else {
				RBTreeNode y = left(grandpx);
				if(y != null && y.color == Colors.RED) {
					px.color = Colors.BLACK;
					y.color = Colors.BLACK;
					x = grandpx;
				} else if(x == left(px)){
						x = px;
						rightRotate(x);
				} else {
					px.color = Colors.BLACK;
					grandpx.color = Colors.RED;
					leftRotate(grandpx);
				}
			}	
		} ((RBTreeNode)getRoot()).color = Colors.BLACK;
	}
	
	public E remove(E element) {
		RBTreeNode z = (RBTreeNode) getNode(element);
		if(z == null) return null;
		RBTreeNode y, x;
		super.size--;
		
		if(z != null && (z.getLeft() == null || z.getRight() == null)) {
			y = z;
		} else {
			y = (RBTreeNode) getNode(successor((E)z.getData()));
		}
		
		
		if(y.getLeft() != null) {
			x = left(y);
		} else {
			x = right(y);
		}
		
		RBTreeNode py = parent(y);
		if(py == null)
			setRoot(x);
		else if(y == left(py))
			py.setLeft(x);
		else
			py.setRight(x);;
		
		if(y != z)
			z.setData(y.getData()); //y = z
		
		if(y.color == Colors.BLACK && x != null)
			RBDeleteFixup(x);
		
		return (E) y.getData();
	}
	
	private void RBDeleteFixup(RBTreeNode x) {
		while (x != getRoot() && x.color == Colors.BLACK) {
			RBTreeNode px = parent(x);
			RBTreeNode w;
			if (x == left(px)) {
				w = right(x);
				if (w != null && w.color == Colors.RED) {
					w.color = Colors.BLACK;
					px.color = Colors.RED;
					leftRotate(px);
					w = right(px);
				}
				if (w != null && left(w).color == Colors.BLACK && right(w).color == Colors.BLACK) {
					w.color = Colors.RED;
					x = px;
				} else if (w != null && right(w).color == Colors.BLACK) {
					left(w).color = Colors.BLACK;
					w.color = Colors.RED;
					rightRotate(w);
					w = right(px);
				}
				if (w != null) 
					w.color = px.color;
				px.color = Colors.BLACK;
				
				if (w!= null)
						right(w).color = Colors.BLACK;
				leftRotate(px);
				x = (RBTreeNode) getRoot();
			} else {
				w = left(x);
				if (w != null && w.color == Colors.RED) {
					w.color = Colors.BLACK;
					px.color = Colors.RED;
					rightRotate(px);
					w = left(px);
				}
				if (w != null && right(w).color == Colors.BLACK && left(w).color == Colors.BLACK) {
					w.color = Colors.RED;
					x = px;
				} else if (w != null && left(w).color == Colors.BLACK) {
					right(w).color = Colors.BLACK;
					w.color = Colors.RED;
					leftRotate(w);
					w = left(px);
				}
				
				if (w != null) 
					w.color = px.color;
				px.color = Colors.BLACK;
				if (w != null) 
					left(w).color = Colors.BLACK;
				rightRotate(px);
				x = (RBTreeNode) getRoot();
			}
		}
		x.color = Colors.BLACK;
	}
	
	private void leftRotate(RBTreeNode x) {
		RBTreeNode y = right(x);
		x.setRight(y.getLeft());
		RBTreeNode px = parent(x); 
		if (px == null)
			setRoot(y);
		else if (x == left(px))
			px.setLeft(y);
		else
			px.setRight(y);
		y.setLeft(x);
	}
	
	private void rightRotate(RBTreeNode x) {
		RBTreeNode y = left(x);
		x.setLeft(y.getRight());
		RBTreeNode px = parent(x); 
		if (px == null)
			setRoot(y);
		else if (x == right(px))
			px.setRight(y);
		else 
			px.setLeft(y);
		y.setRight(x);
	}
	
	private RBTreeNode parent(TreeNode x) {
		if(x == null || getParentOfNode((E)x.getData()) == null) return null;
		return (RBTreeNode) getParentOfNode((E) x.getData());
	}
	
	public TreeNode<E> createNode(E element) {
		return new RBTreeNode(element);  
	}
	
	private RBTreeNode right(TreeNode<E> x) {
		return (RBTreeNode) x.getRight();
	}
	
	private RBTreeNode left(TreeNode<E> x) {
		return (RBTreeNode) x.getLeft();
	}
	
}
