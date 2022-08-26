import java.math.*;
import java.util.Scanner;
import java.io.*;

public class Primes {

    static boolean isPrime(int n)
    {
        if (n <= 1)
            return false;
  
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
  
        return true;
    }


    static void printPrimes(int n) {
        int count = 2;
        while(count <= n){
            if(isPrime(count)){
                System.out.println(count);
            }
            count = count + 1;
        }
        
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            printPrimes(reader.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
