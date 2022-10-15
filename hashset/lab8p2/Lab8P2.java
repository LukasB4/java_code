/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8p2;

/**
 *
 * @author lukasbernard
 * I wrote this main function myself
 */
public class Lab8P2 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception 
    {
        SCHashST hash = new SCHashST(); //new instance of the Separately Chaining Hash Symbol Table
        hash.put("E"); //calls the put method in the SCHashST class and inserts char E as the key
        hash.put("A");
        hash.put("S");
        hash.put("Y");
        hash.put("Q");
        hash.put("U");
        hash.put("T");
        hash.put("I");
        hash.put("O");
        hash.put("N");
        hash.print(); //calls the print method in the SCHashST class
        hash.get("N"); //gets the value of N in the hashTable if it exists
        hash.get("P");//gets the value of P in the hashTable if it exists
    }
    
}
