/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestsequence;

import java.util.Arrays;

/**
 *
 * @author lukasbernard
 * I wrote the longSet class from scratch myself
 */
public class longSet
{
    /**
     * getLongest gets the longest subsequence in the array of numbers dynamically
     */
    public void getLongest(int[] numSet, int M)
    {
        int allTimeHigh = 1;
        int currentHigh; //the longest subsequence so far
        int current; //current number we are on
        int original; //the original term we looked at
        for(int i = 0; i < M; i++) //iterate through the array
        {
            current = numSet[i];
            original = numSet[i];
            currentHigh = 1; //must always be a subsequence at least one long
            for(int j = i + 1; j < M; j++) //iterate through all the elements after our current element i
            {
                if(numSet[j] > current) //if the item is bigger than the current
                {
                    current = numSet[j]; //set the current to this item
                    currentHigh++; //increase the currentHigh by 1
                }
                else if(numSet[j] > original && numSet[j] < current) //if the number is greater than the original yet smaller than the current
                    current = numSet[j]; //our current is set to this number, leapfrogging and possibly allowing for longer subsequences
            }
            if(currentHigh > allTimeHigh) //if the current high value is greater than the all time
                allTimeHigh = currentHigh; //set the all time to the currentHigh
        }
        print(numSet, allTimeHigh); //calls the print function
    }
    /**
     * @param numSet
     * @param allTimeHigh 
     * 
     * print() prints the number set and the all time high value
     */
    public void print(int[] numSet, int allTimeHigh)
    {
        System.out.println("For Sequence: " + Arrays.toString(numSet) + ", length of longest subsequence is " + allTimeHigh);
    }
}
