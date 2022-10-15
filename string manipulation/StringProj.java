/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringproj;
import java.util.Scanner;
/**
 *
 * @author lukasbernard
 */
public class StringProj {
    private String theString;
    Scanner userInput;
    Scanner userString;
    String[] splitString;
    StringProj(){
        this.userInput = new Scanner(System.in);
        this.userString = new Scanner(System.in);
    }
    public void printMenu(){
        System.out.println("~~Menu~~");
        System.out.println("Choose and item");
        System.out.println("1. Count the number of occurrences of a single character in the String. ");
        System.out.println("2. Count the words in the String.");
        System.out.println("3. Return the String as a String without spaces.");
        System.out.println("4. Change the original input String.");
        System.out.println("5. Exit.");
    }
    public void setString(){
        System.out.println("What is your string?");
        theString = userString.nextLine();
    }
    public int getInput(){
        int userChoice = 0;
        System.out.print("What is your choice (1-5)?: ");
        userChoice = userInput.nextInt();
        System.out.println("");
        return userChoice;
    }
    public void occurences(){
        System.out.print("What letter would you like to count the number of occurences for?: ");
        char letter;
        String current;
        int total = 0;
        letter = userInput.next().charAt(0);
        letter = Character.toLowerCase(letter);
        for(int i = 0; i<theString.length(); i++){
            current = theString.toLowerCase();
            if(current.charAt(i) == letter){
                total++;
            }
        }
        System.out.println("Your letter "+letter+" occurs " + total + " times in the string.");
    }
    public void wordCount(){
        splitString = theString.split("\\s+");
        int wordcount;
        wordcount = splitString.length;
        System.out.println("The word count of the string is: " + wordcount);
    }
    public void spaceless(){
        String noSpaces = theString.replaceAll("\\s+", "");
        System.out.println(noSpaces);
    }
    public void reset(){
        setString();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StringProj strp = new StringProj();
        int exit = 0;
        int out;
        int userChoice = 0;
        strp.setString();
        while(exit == 0){
            System.out.println("");
            strp.printMenu();
            userChoice = strp.getInput();
            switch(userChoice){
                case 1:
                    strp.occurences();
                    break;
                case 2:
                    strp.wordCount();
                    break;
                case 3:
                    strp.spaceless();
                    break;
                case 4:
                    strp.setString();
                    break;
                case 5:
                    exit = 1;
                    break;
                }
        
        }
    }
    
}
