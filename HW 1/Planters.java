import java.io.*;
import java.math.*;
import java.util.Scanner;

public class Planters{

    // Merges the two subarrays of arr[].
    static void merge(int array[], int l, int m, int r)
    {
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
    static void merge_Sort(int array[], int start_index, int range)
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
 

    static void is_Replantable() throws IOException{
        Scanner scanner = new Scanner(System.in);

        //reads in the number of plants and pots
        int num_plants = Integer.valueOf(scanner.next());
        int num_pots = Integer.valueOf(scanner.next());

        //creates and fills an array to represent the potted plants
        int[] plants = new int[num_plants];
        for (int i = 0; i < num_plants; i++){
            plants[i] = Integer.valueOf(scanner.next());
        }

        //creates and fills an array to represent the leftover pots
        int[] pots = new int[num_pots];
        for (int i = 0; i < num_pots; i++){
            pots[i] = Integer.valueOf(scanner.next());
        }

        //sorts both the plants[] and pots[]
        merge_Sort(plants, 0, num_plants - 1);
        merge_Sort(pots, 0, num_pots - 1);
        
        //starts with largest plant (at the end of the array) and works backward
        boolean unpottable = false;
         for(int i = num_plants - 1; i >= 0; i--){
            
            //checks if the plant can be repotted
            //if yes: the plant is repotted
            //if not: "NO" is printed and loop ends
            if (plants[i] < pots[num_pots - 1]){
                int temp = plants[i];
                plants[i] = pots[num_pots - 1];
                pots[num_pots - 1] = temp;
                merge_Sort(pots, 0, num_pots - 1);

            }
            else{
                System.out.println("NO");
                unpottable = true;
                break;
            }
         }

         //prints "YES" after all plants have been repotted
         if(!unpottable){
            System.out.println("YES");
         }
    }


    public static void main(String[] args) throws IOException {
        is_Replantable();
    }
    /**
     * TODO:
     * test if works 
     *      have method only print the sorted arrays to make sure things sort as hoped for
     * 
     */
}