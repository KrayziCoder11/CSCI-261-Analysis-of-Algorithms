public class MergeSort {
    
    // Merges two subarrays of arr[].
    void merge(int array[], int l, int m, int r)
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
    void merge_sort(int array[], int start_index, int range)
    {
        if (start_index < range)
        {
            // Find the middle point
            int middle_point = (start_index+range)/2;
 
            // Sort first and second halves
            merge_sort(array, start_index, middle_point);
            merge_sort(array, middle_point+1, range);
 
            // Merge the sorted halves
            merge(array, start_index, middle_point, range);
        }
    }
 
    
    
 
}
