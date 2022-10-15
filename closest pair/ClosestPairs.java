/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package closestpairs;
import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
/**
 *
 * @author lukasbernard
 */

// big O of this program should be O(n log n) because the largest function of n is the array sort method of (n log n)

//I wrote this program from scratch
public class ClosestPairs 
{

    public void closesttwo(double [] arr) //method to find the nearest 2 numbers
    {
        int storeda = 0; //storeda will be used for the lower key in the array 
        int storedb = 1; //storedb will be used for the upper key in the array
        double distance; //distance will be used for the distance between storeda and storedb
        double distanceb; // distanceb will be used for th distance between our two selected values to check
        
        for(int i = 0; i < (arr.length-1); i++) //for loop to iterate through the array O(n)
        {
            distance = arr[storedb] - arr[storeda]; //solve for distance as stated above
            distanceb = arr[i+1] - arr[i]; //find distanceb as stated above
            
            if(distanceb < distance) //check if distanceb is larger than distance
            {
                storedb = i+1; //if it is larger store the two values we compared
                storeda = i;
            }
        }
        System.out.print("The numbers " + arr[storeda] + " and " + arr[storedb] + " are the closests pair with a difference of ");
        System.out.printf("%.6f", (arr[storedb]-arr[storeda])); //print 6 decimal places using printformat
        System.out.println("");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Scanner scan; //create a scanner called scan
        ClosestPairs close = new ClosestPairs(); //create a new iteration of closestpairs
        double[] arr  = new double[8000]; //create the array
        int x = 0; // for iterating
        try //use a try catch incase the file is not found so no error is returned
        {
            File file = new File("/users/lukasbernard/NetBeansProjects/ClosestPairs/src/closestpairs/lab2in.txt"); //file path
            scan = new Scanner(file); //tell scanner what to scan through
            while(scan.hasNextDouble()) //scan through all doubles in the file
            {
                arr[x++] = scan.nextDouble(); //set element of array to next double while also adding 1 to x O(n)
            }
            Arrays.sort(arr); //sort the array time complexity O(n log n)
        }
        catch(Exception e) //print out if no file is found
        {
            System.out.println("No file was found");
        }
        
        close.closesttwo(arr); //send array to the method closest two
        
    }
    
}
