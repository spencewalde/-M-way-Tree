package lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * Spencer Williams-Waldemar 10/20/19
 * Driver class that uses the node class to create a (m)way tree
 * by reading a text file and assigning nodes with children that 
 * have children .etc. 
 */

public class driver {

	public static void main(String arg[]) throws FileNotFoundException {

		// scanner scans txt file "tree"
		Scanner infile = new Scanner(new File("tree.txt"));

		// sets the mway list size to the first int in the text file (4)
		int mwaysize = infile.nextInt();
		// sets the next int in the file to be the node value
		int nodevalue = infile.nextInt();

		// creates a new node and gives it a size to set the max number of children each
		// node can have in their array
		node root = new node(mwaysize);
		// sets the data of the created node root to be the node value found as the
		// second int on the file
		root.setData(nodevalue);

		// used to skip to the next line to read relevant data
		infile.nextLine();

		while (infile.hasNextLine()) {
			// creates a string to assign the value from reading the line
			String children = infile.nextLine();

			// prints out to prove we got the data
			System.out.println("the next line read has " + children);

			// scanner created to scan the line we just took and grab each number seperately
			Scanner parseline = new Scanner(children);

			// assigns node value to the next int grabbed (45)
			nodevalue = parseline.nextInt();

			node nodetoupdate = root.find(nodevalue);

			// prints out to test
			System.out.println("value looked up was " + nodevalue + " and the value at the node to update is "
					+ nodetoupdate.data + "\n");

			// ADD THE NODES WITH THE REST OF THE VALUES IN THE LINE AS CHILDREN TO
			// NODTOUPDATE
			int count = 0;
			//// while the line of data taken still has values then add the values as
			//// children
			while (parseline.hasNextInt()) {
				// value is equal to the next number in parseline
				int value = parseline.nextInt();

				// node n's array size is set to mwaysize(4)
				node n = new node(mwaysize);
				// the node n's data is set to 38 which is one of 45s children
				n.setData(value);
				// node to update at children (depending on round of while loop) is set to node
				// n
				nodetoupdate.children[count] = n;
				// adds to count to add the next value to the next spot of the array
				count++;
			}
		}
		// prints post order
		System.out.println("this is the post order traversal\n" + root.postordertraversal());

		// prints pre order
		System.out.println("\nthis is the pre order traversal\n" + root.preordertraversal());

		// prints total number of values
		System.out.println("\nthis is the total number of values in the tree\n" + root.total());

		// prints the sum
		System.out.println("\nthis is the sum of the values in the tree\n" + root.sum());

		// prints the average of values
		System.out.println("\nthis is the average of the values in the tree\n" + root.average());

		// prints the hieght of the tree
		System.out.println("\nthis is the height of the tree\n" + root.height());

		// prints the leaves
		System.out.println("\nthis is the number of leaves in the tree\n" + root.leaves());

	}

}
