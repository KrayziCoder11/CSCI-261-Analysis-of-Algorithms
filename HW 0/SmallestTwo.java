/**
 * JP Dumont
 * Hw 0
 * 
 * CSCI 261 Analysis of Algorithms 
 * Ting Cao
 * Section 4
 */


import java.io.*;
public class SmallestTwo {

    static void findSmallestTwo() throws IOException{
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        //reads in the number of integers in the input
        int length = Integer.parseInt(reader.readLine());

        //reads in the first number
        int first = Integer.parseInt(reader.readLine());
        
        //reads in the second number
        int count = 1;
        int second;
        while (true){
            second = Integer.parseInt(reader.readLine());
            count++;

            //checks if the second number is <,>, or = to the first number
            if (second > first){
                break;
            }
            else if (second < first){
                int temp = first;
                first = second;
                second = temp;
                break;
            }
        }

        //loops through the rest of the input
        for (int i = count; i < length; i++){
            int newest = Integer.parseInt(reader.readLine());
            
            //assigns each input as one of the two smallest numbers 
            //if its less than the current two smallest
            if(newest < first){
                second = first;
                first = newest;
            }
            else if (newest > first && newest < second){
                second = newest;
            }
        }

        //prints the smallest two numbers
        System.out.println(first);
        System.out.println(second);
    }

    public static void main(String[] args) {
        //runs "findSmallestTwo()" function to find the smallest two numebers
        try {
            findSmallestTwo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
