/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author lukasbernard
 */
public class Lab5 {

    /**
     * @param args the command line arguments
     * 
     * basic function of this main is to make the word easyquestion into an array of chars
     * then add each letter in the order of easyquestion to my binary search tree in the for loop
     */
    public static void main(String[] args) {
        char[] test; //declaring my test char array
        BST bst = new BST(); // new instance of my binary search tree
        test = "easyquestion".toCharArray(); //converting easy question into a char array
        
        for(int i = 0; i < test.length; i++) //for loop to iterate through all the letters of test
        {
            bst.add(test[i]); //add all the letters from test to my binary search tree
        }
        bst.print(); //print out all parts of my binary search tree
    }
    
}
