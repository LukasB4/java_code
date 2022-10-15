/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.util.ArrayList;

/**
 *
 * @author lukasbernard
 * This is the same dynamic program as my lab 8
 * I wrote this
 * 
 * I feel this program is inaccurate, that is why the size of the longest
 * sequence varies. The output from my graph is correct.
 */
public class longestSeq
{
    public void getLongest(ArrayList<Integer> numSet, int M)
    {
        int allTimeHigh = 1; //the all time high of my sequence
        int currentHigh; //the longest subsequence so far
        int current; //current number we are on
        int original; //the original term we looked at
        for(int i = 0; i < M; i++) //iterate through the array
        {
            current = numSet.get(i);
            original = numSet.get(i);
            currentHigh = 1; //must always be a subsequence at least one long
            for(int j = i + 1; j < M; j++) //iterate through all the elements after our current element i
            {
                if(numSet.get(j) > current) //if the item is bigger than the current
                {
                    current = numSet.get(j); //set the current to this item
                    currentHigh++; //increase the currentHigh by 1
                }
                else if(numSet.get(j) > original && numSet.get(j) < current) //if the number is greater than the original yet smaller than the current
                    current = numSet.get(j); //our current is set to this number, leapfrogging and possibly allowing for longer subsequences
            }
            if(currentHigh > allTimeHigh) //if the current high value is greater than the all time
                allTimeHigh = currentHigh; //set the all time to the currentHigh
        }
        System.out.println("Longest increasing sequence in the dynamic program is: " + allTimeHigh); //calls the print function
    }
}
