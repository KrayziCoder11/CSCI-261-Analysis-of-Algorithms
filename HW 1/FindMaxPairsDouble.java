import java.io.*;
import java.math.*;
import java.util.Scanner;

public class FindMaxPairsDouble {

    //returns the factorial of a given number
    static int factorial(int n){
        if (n == 0)
            return 1;

        return n*factorial(n-1);
    }

    //calculates how many sums there are based on the size of the input
    static int NumberOfSums(int input_size){
        return factorial(input_size) / (2 * factorial(input_size-2));
    }

    //finds the smallest sum with the highest number of pairs coeesponding to it
    static void find_T(double[] sums, int length){
        int highest_count = 0;
        double highest_num = 0;
        
        /*this nested for loop and the if statments inside count the number of pairs for each sum
        *and keep track of the sum those pairs correspond to
        */
        int count = 1;
        for(int i = 0; i < length; i++){
            for(int k = 1; k < length; k++){
                if(sums[i] == sums[k]){
                    count++;
                }
            }
            count = 1;
            if(count > highest_count){
                highest_count = count;
                highest_num = sums[i];
            }
            else if (highest_count == count){
                if(highest_num > sums[i]){
                    highest_num = sums[i];
                }
            }
        } 

        //prints the hightest number of pairs and the corresponding sum
        System.out.println(highest_count + " " + highest_num);
    }
    
    //calculates all the possible sums from the given numbers
    static void calculate_Sums(){
        Scanner scanner = new Scanner(System.in);

        //creates array for the input
        int length = Integer.valueOf(scanner.next());
        double[] numbers = new double[length];

        //creates an array to hold all of the sums of the input
        double[] sums = new double[NumberOfSums(length)];
        
        //reads in all of the input
        int n = 0;
        while(scanner.hasNext()){
            numbers[n] = Integer.valueOf(scanner.next());
            n++;
        }
        
        //calculates all of the sums
        int c = 0;
        for(int i = 0; i < length; i++){
            for(int k = 1; k < length; k++){
                sums[c] = (numbers[i] + numbers[k]);   
                c++;
            }
        } 

        //finds the highest pair and the smallest sum that goes with it
        find_T(sums, NumberOfSums(length));

    }

    public static void main(String[] args) {
        calculate_Sums();
    }
}
