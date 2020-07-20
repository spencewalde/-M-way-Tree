package lab5;
/*
 * Spencer Williams-Waldemar 10/20/19
 * node class that has several different functions to navigate and pull values from a 
 * node tree.
 */

public class node {
	// variable declaration
	node[] children;
	int data;
	int m;

	// constructor
	public node(int m) {
		
		this.m = m;
		children = new node[m];
	}

	// sets data to a value
	public void setData(int m) {
		
		this.data = m;

	}

	// asks each node if it has children and once the child node has no children it
	// kicks out
	// the total and it goes up the tree
	public int total() {
		
		int total = 1;
		
		for (int i = 0; i < children.length; i++) {
			
			if (children[i] != null) {
				
				total += children[i].total();

			}
		}

		return total;

	}

	// asks every node if it has a child and adds the child node to the parent
	// when the child doesnt have children.
	public int sum() {
		
		int sum = data;
		
		for (int i = 0; i < children.length; i++) {
			
			if (children[i] != null) {
				
				sum += children[i].sum();

			}
		}

		return sum;

	}

	// uses the total method and the sum method to find average
	public double average() {
		
		return sum() / total();

	}

	// goes through each node and asks each child if it has children and when
	// it returns null for its children and add 1 to the maxheight of that node
	// and recursively adds that child to the parents values for height and compares
	// the heightest height
	public int height() {
		
		int maxheight = 0;

		for (int i = 0; i < children.length; i++) {
			
			if (children[i] != null) {

				int h = children[i].height();

				if (h > maxheight)
					maxheight = h;
			}

		}

		return 1 + maxheight;

	}

	// goes down the list recursively and looks for a node with null for children
	// when a node has no children it leaves the boolean as true and kicks out that
	// it is a leaf and it does that for each child of each node and counts the
	// leaves
	// of the tree
	public int leaves() {

		int leaves = 0;

		boolean isLeaf = true;
		for (int i = 0; i < children.length; i++) {
			
			if (children[i] != null) {
				
				leaves += children[i].leaves();
				isLeaf = false;
			}
		}
		
		if (isLeaf)
			return 1;

		return leaves;
	}

	public String postordertraversal() {

		String result = "";

		for (int i = 0; i < children.length; i++) {
			if (children[i] != null) {
				result += children[i].postordertraversal();
			}

		}

		return result + " " + this.data;
	}

	// asks each node if it has children then add each child to the result string
	// and goes until is null
	public String preordertraversal() {

		String result = "";

		for (int i = 0; i < children.length; i++) {
			
			if (children[i] != null) {
				result += children[i].preordertraversal();
			}

		}

		return this.data + " " + result;
	}

	// asks each node if it has children then add each child to the result string
	// and goes until is null
	public node find(int nodevalue) {

		if (this.data == nodevalue)
			
			return this;
		{

			for (int i = 0; i < children.length; i++) {
				
				if (children[i] != null) {
					
					node found = children[i].find(nodevalue);

					if (found != null)
						return found;
				}

			}

		}
		return null;

	}

}
