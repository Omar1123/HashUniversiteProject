/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

/**
 *
 * @author root
 */
public class HashTable {

    private File HASHES = new File("/root/NetBeansProjects/HashTable/src/hashtable/hash.txt");
    private File VALUES = new File("/root/NetBeansProjects/HashTable/src/hashtable/values.txt");
    private int number, index, keyHash;;
    private int summation, total, random;
    private int[] hashIndex = new int[36];  
    private Random rand = new Random();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            HashTable HashTable = new HashTable();
            HashTable.run();
        } catch(Exception ex) {
            
        }
    }
    
    private void run() {
        System.out.println("Hash table");
        getHashes();
    }
    
    private void getHashes() {
        try {                    
                
            BufferedReader buffer = new BufferedReader(new FileReader(HASHES));                
            String lines;

            while((lines = buffer.readLine())!=null) {                   
                index = operateHash(lines);
                //System.out.println("The value is: " + lines + "  index: " + index);
                createContact(lines, Integer.toString(index));
            }

            buffer.close();             
        } catch (IOException ex) {
            /*Captura un posible error y le imprime en pantalla*/ 
             System.out.println(ex.getMessage());
        }
    }
    
    private int operateHash(String hash) {
        number = Integer.parseInt(hash);
        
        total =  summationNumbers(number) + randomNumber();
        
           keyHash = total % hashIndex.length;
           summation = 0;
           
        return keyHash;
    }
    private int randomNumber() {
        
        random = rand.nextInt(50) + 1;
        
        return random;
    }
    
    private int summationNumbers(int hash) {
        while (number > 0) {
            int d = number / 10;
            int k = number - d * 10;
            number = d;
            summation = summation + k;
          }
        return summation;
    }
    
    private void createContact(String index, String value) {        
        try {          
            
            BufferedWriter writter =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(VALUES,true), "utf-8"));
            
            writter.write(index + "," + value + "\r\n");            
          
            writter.close();
        } catch (Exception ex) {
          //Captura un posible error le imprime en pantalla 
            System.out.println(ex.getMessage());
        }      
    }
    
    
}
