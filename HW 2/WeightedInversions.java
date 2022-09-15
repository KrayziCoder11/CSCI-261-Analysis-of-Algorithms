import java.util.Scanner;
import java.io.*;
import java.math.*;

public class WeightedInversions{


    // Merges the two subarrays of arr[].
    private static int merge(int array[], int l, int m, int r){
        // Find sizes of two subarrays to be merged
        int left_size = m - l + 1;
        int right_size = r - m;
 
        /* Create temp arrays */
        int left_array[] = new int [left_size];
        int right_array[] = new int [right_size];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<left_size; ++i){
            left_array[i] = array[l + i];
        }
        for (int j=0; j<right_size; ++j){
            right_array[j] = array[m + 1+ j];
        }
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0, weight = 0;
 
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
                weight += (j - i);
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

        return weight;
    }
 
    // Main function that sorts the given array using merge()
    private static int merge_Sort(int array[], int start_index, int range_minus_one)
    {
        if (start_index < range_minus_one)
        {
            // Find the middle point
            int middle_point = (start_index+range_minus_one)/2;
 
            // Sort first and second halves
            int r = merge_Sort(array, start_index, middle_point);
            int l = merge_Sort(array, middle_point+1, range_minus_one);
 
            // Merge the sorted halves
            int m = merge(array, start_index, middle_point, range_minus_one);
            return r+l+m;
        }
        else{
            return 0;
        }
    }
 

    private static Pair Sort_And_Count(int array[]){
        //base case
        if (array.length == 1){
            return new Pair(0, array);
        }

        //finds middle point
        //creates left and right arrays
        int middle_point = (array.length)/2;
        int[] left;
        int[] right;
        if(array.length % 2 == 0){
            right = new int[middle_point];
        }else{
            right = new int[middle_point + 1];
        }
        left = new int[middle_point];

        //copys data into left and right arrays
        for(int i = 0; i < middle_point; i++){
            left[i] = array[i];
        }
        int c = 0;
        for(int i = middle_point; i < array.length; i++){
            right[c] = array[i];
            c++;
        }

        Pair L = Sort_And_Count(left);
        Pair R = Sort_And_Count(right);
        Pair M = Merge_And_Count(L.list, R.list);

        // Merge the sorted halves
        //merge(array, start_index, middle_point, range_minus_one);
        
        return new Pair(L.val + R.val + M.val, M.list);

    }
    

    private static Pair Merge_And_Count(int[] left, int[] right) {  
        
        int[] combo = new int[left.length + right.length];
        int i = 0, j =0, k = 0, weight = 0;
        
        // Initial index of merged subarray array
        // 2 5 || 3 1 4
        //weight = 0
        //combo = 1 
        // i = 0
        // j = 0
        // k = 0
        while (i < left.length && j < right.length)
        {
            if (left[i] <= right[j])
            {
                combo[k] = left[i];
                i++;
            }
            else
            {
                combo[k] = right[j];
                weight ++;
                j++;
            }
            k++;
        }

        /* Copy remaining elements of left_array[] if any */
        while (i < left.length)
        {
            combo[k] = left[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of right_array[] if any */
        while (j < right.length)
        {
            combo[k] = right[j];
            j++;
            k++;
        }
        
                

        return new Pair(weight, combo);
    }

    static void get_Input(){
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();

        int[] list = new int[size];
        for(int i = 0; i < size; i++){
            list[i] = scan.nextInt();
        }
        
    }


    public static void main(String[] args) {
        int[] test = new int[5];
        test[0] = 2;
        test[1] = 5;
        test[2] = 3;
        test[3] = 1;
        test[4] = 4;
        Pair result = Sort_And_Count(test);
        System.out.print(result.val);

        
    }
    /*
     * TODO:
     * complete SAC method (see method for notes)
     * ask prof for help ( not with hw solution, with writing counting inversions algorithm)
     */
}