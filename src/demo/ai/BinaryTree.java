package demo.ai;

import java.util.Stack;

public class BinaryTree {
	public static void main(String[] args) {
		BinaryTree left=new BinaryTree("1");
		BinaryTree right=new BinaryTree("5");
		BinaryTree tree=new BinaryTree("/");
		tree.setLeft(left);
		tree.setRight(right);
		tree.midVisit();
		String exp="5 1 5 / - 5 *";
		System.out.println();
		BinaryTree tree2=BinaryTree.createTree(exp.split("\\s+"));
		tree2.midVisit();
	}	
	/**
	 * 根据后缀式还原二叉树
	 * @param exp
	 * @return
	 */
	public static BinaryTree createTree(String[] exp) {
		Stack<BinaryTree> stack=new Stack<BinaryTree>();
		for(String s:exp){
			if(Evaluator.isNumber(s)){
				BinaryTree t=new BinaryTree(s);
				stack.push(t);				
			}else if (Evaluator.isOperator(s)){
				BinaryTree t=new BinaryTree(s);// operator
				BinaryTree right=stack.pop();
				BinaryTree left=stack.pop();
				t.setLeft(left);
				t.setRight(right);
				stack.push(t);
				
			}
		}
		return stack.peek();
	}




	public void midVisit() {
		System.out.print("(");
		if(left!=null)left.midVisit();
		System.out.print(root);
		if(right!=null)right.midVisit();	
		System.out.print(")");
	}
	public BinaryTree(String root) {
		this(root,null,null);//构造方法的重载
	}
	public BinaryTree(String root, BinaryTree left, BinaryTree right) {
		this.root = root;
		this.left = left;
		this.right = right;
	}

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public BinaryTree getLeft() {
		return left;
	}

	public void setLeft(BinaryTree left) {
		this.left = left;
	}

	public BinaryTree getRight() {
		return right;
	}
	
	public void setRight(BinaryTree right) {
		this.right = right;
	}
	
	String root;
	BinaryTree left;
	BinaryTree right;
}
