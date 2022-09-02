/**
 * JP Dumont
 * Hw 0
 * 
 * CSCI 261 Analysis of Algorithms 
 * Ting Cao
 * Section 4
 */
import java.io.*;

public class Primes {

    //this function checks if the given number is prime
    static boolean isPrime(int n)
    {
        if (n <= 1){
            return false;
        }

        for (int i = 2; i < n; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }


    static void printPrimes(int n) {
        
        int count = 2;

        //loops through each number <= the given input
        while(count <= n){

            //checks if each # is prime
            if(isPrime(count)){
                System.out.println(count);
            }
            count = count + 1;
        }
        
    }

    public static void main(String[] args) {

        //reads in given input and runs "printPrimes()" function
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            printPrimes(Integer.parseInt(reader.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
