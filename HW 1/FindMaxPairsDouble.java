import java.io.*;
import java.math.*;
import java.util.Scanner;

public class FindMaxPairsDouble {

    //returns the factorial of a given number
    static long my_factorial(int n){
        long answer = (long) 1;
        for(long i = n; i >0; i--){
            answer = answer * i;
        }

        return answer;
    }

    //calculates how many sums there are based on the size of the input
    static long NumberOfSums(int input_size){
        long first = my_factorial(input_size);
        long second =(2 * my_factorial(input_size-2));
        //System.out.println("First: " + first);
        //System.out.println("Second: " + second);
        return first / second;
    }

    // Merges the two subarrays of arr[].
    static void merge(double array[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int left_size = m - l + 1;
        int right_size = r - m;
 
        /* Create temp arrays */
        double left_array[] = new double [left_size];
        double right_array[] = new double [right_size];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<left_size; ++i){
            left_array[i] = array[l + i];
        }
        for (int j=0; j<right_size; ++j){
            right_array[j] = array[m + 1+ j];
        }
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarray array
        int k = l;
        while (i < left_size && j < right_size)
        {
            if (left_array[i] <= right_array[j])
            {
                array[k] = left_array[i];
                i++;
            }
            else
            {
                array[k] = right_array[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of left_array[] if any */
        while (i < left_size)
        {
            array[k] = left_array[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of right_array[] if any */
        while (j < right_size)
        {
            array[k] = right_array[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts the given array using merge()
    static void merge_Sort(double array[], int start_index, int range)
    {
        if (start_index < range)
        {
            // Find the middle point
            int middle_point = (start_index+range)/2;
 
            // Sort first and second halves
            merge_Sort(array, start_index, middle_point);
            merge_Sort(array, middle_point+1, range);
 
            // Merge the sorted halves
            merge(array, start_index, middle_point, range);
        }
    }
 
    //calculates all the possible sums from the given numbers
    static void calculate_Sums() throws FileNotFoundException{
        Scanner scanner = new Scanner(System.in);

        //creates array for the input
        int length = Integer.valueOf(scanner.next());
        int sum_length = (int) NumberOfSums(length);
        double[] numbers = new double[length];

        //creates an array to hold all of the sums of the input
        double[] sums = new double[sum_length];
        
        //reads in all of the input
        int n = 0;
        while(scanner.hasNext()){
            numbers[n] = Integer.valueOf(scanner.next());
            n++;
        }
        
        //calculates all of the sums
        int c = 0;
        for(int i = 0; i < length; i++){
            for(int k = i + 1; k < length; k++){
                sums[c] = (numbers[i] + numbers[k]);   
                c++;
            }
        } 

        //sorts the sums[] arrays
        merge_Sort(sums, 0, sum_length - 1);

        //variables to keep find the most common sum and the # of times it appears
        int highest_count = 0;
        double highest_sum = sums[0];
        double current_sum = sums[0];
        int count = 1;
        
        //loops through all the sums
        //finds the most common summ and the number of times it appears in the array
        for(int i = 1; i < sum_length; i++){
            if(sums[i] == current_sum){
                count++;
            }
            else if (sums[i] != current_sum){
                if(highest_count < count){
                    highest_count = count;
                    highest_sum = current_sum;
                }
                else if (highest_count == count){
                    if(highest_sum > sums[i]){
                        highest_sum = current_sum;
                    } 
                }
                current_sum = sums[i];
                count = 1;
            }    
        }
        System.out.print(highest_count + " "); 
        System.out.format("%.6f", highest_sum);
        
        
    }

    public static void main(String[] args) throws FileNotFoundException {
        calculate_Sums();
    }
    
}
