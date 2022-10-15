/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

/**
 *
 * @author lukasbernard
 * pseudocode from G4G, but written by myself.
 */
public class Heap
{
   
    //the sort class takes in the string array and iterates through the array to swap placement of strings
	public void sort(String tale[])
	{
		for (int root = tale.length / 2 - 1; root >= 0; root--) //start in the middle and iterate through the lower half of the array
                {
			swap(tale, root, tale.length); //call the swap function, send the array, root, and length
                }
		for (int end = tale.length - 1; end > 0; end--) //start at the end and iterate backwards through
                {
			String temp = tale[0]; //set the temp to the first string in the array
			tale[0] = tale[end]; //set the first string in the array to the current place in the array
			tale[end] = temp; //set the current place's string to the temp string
			swap(tale, 0, end); //swap function using the array, zero placeholder, and the placement
		}
                print(tale); //call the print function, send the string array
	}
        //swap function takes the array, root, and length to relocate in a subtree if heap rules are violated
	private void swap(String tale[], int root, int length)
	{
		int maxValue = root; //set the max value to the root of the subtree
                if (2 * root + 2 < length) //if the right value fits in the entire tree
                    if(tale[2 * root + 2].compareTo(tale[maxValue])<0) //if the right child is larger than the parent
			maxValue = 2 * root + 2; //set the max value to the right child
		if (2 * root + 1 < length)//if the left value fits in the entire tree
                    if(tale[2 * root + 1].compareTo(tale[maxValue])<0) //if the left child is larger than the parent
			maxValue = 2 * root + 1; //set the max to the left child
		if (maxValue != root) //if the max value is no longer equal to the root
                {
			String temp = tale[root]; //set the temp string to the root
			tale[root] = tale[maxValue]; //set the new root to the new max value
			tale[maxValue] = temp; //set the max value to the temp, if it is left or right
			swap(tale, maxValue, length); //recursively send back the array, left or right child, and length
		}
	}
        //print function takes the string array
	public void print(String[] tale)
        {
            FileOut fo = new FileOut();
		for (int root = tale.length-1; root >= 0; root--) //reads through the array from the top to the bottom in order
			fo.writer(tale[root]);
                fo.writer("Unique words " + tale.length);
	}
}


