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
 
    //This function determines if all of the plants can be replotted
    static void is_Replantable(int[] pots, int[] plants, int num_plants, int num_pots){
        
        //The following while loop and variables do the following:
        //      - orders plants and pots in a single array
        //      - creates second array (dictionary int[]) to keep track of which index is a pot or plant
        int[] combo = new int[num_plants + num_pots];
        int[] dictionary = new int[num_plants + num_pots];
        
        int plant_index = num_plants - 1;
        int pot_index = num_pots - 1;
        int combo_index = num_plants + num_pots - 1;

        while(true){
            if(plant_index >= 0 && pot_index >= 0){
                if(pots[pot_index] >= plants[plant_index]){
                    combo[combo_index] = pots[pot_index];
                    dictionary[combo_index] = 0;
                    combo_index--;
                    pot_index--;
                }
                else if(pots[pot_index] < plants[plant_index]){
                    combo[combo_index] = plants[plant_index];
                    dictionary[combo_index] = 1;
                    combo_index--;
                    plant_index--;
                }
                
            }
            else{
                if(plant_index < 0 && pot_index >= 0){
                    combo[combo_index] = pots[pot_index];
                    dictionary[combo_index] = 0;
                    combo_index--;
                    pot_index--;
                }
                else if(plant_index >= 0 && pot_index < 0){
                    combo[combo_index] = plants[plant_index];
                    dictionary[combo_index] = 1;
                    combo_index--;
                    plant_index--;
                }
                else if(plant_index < 0 && pot_index < 0){
                    break;
                }            
            }
        }


        //the following while loop does the following
        //      - it finds the largest pot and largest plant
        //      - it determines if the largest plant can be repotted
        //      - loop ends if no more plants can be repotted
        int l = num_plants + num_pots - 1;
        int o = num_plants + num_pots - 1;
        boolean repottable = true;
        while(true){
            
            if(l >= 0 && o >= 0){
                if(dictionary[l] != 1){
                    l--;
                }
                else if(dictionary[o] != 0){
                    o--;
                }
                else{
                    if(combo[o] > combo[l]){
                        dictionary[o] = 1;
                        dictionary[l] = 0;
                    }
                    else{
                        repottable = false;
                        break;
                    }
                }
            }
            else{
                break;    
            }
            
        }
        
        
        if(repottable){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }

    //this function retrieves all of the provided input
    static void get_Input() throws IOException{
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
        
        //determines if all the plants can be repotted
        is_Replantable(pots, plants, num_plants, num_pots);

    }


    public static void main(String[] args) throws IOException {
        get_Input();
    }
    
}