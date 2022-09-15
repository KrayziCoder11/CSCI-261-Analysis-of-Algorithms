import java.util.Scanner;
import java.io.*;
import java.math.*;

public class WeightedBySumInversions{

    //is used to keep track of the calculated weight (val) and the sorted list (list)
    //created by the Sort_And_Count function
    static class Pair {
        int val;
        Number[] list;
        public Pair(int val, Number[] list){
            this.val = val;
            this.list = list;
        }   
    }

    //holds the input value (val) as well as the original index of the input (index)
    static class Number {
        int val;
        int index;
        Number(int val, int orig){
            this.val = val;
            this.index = orig;
        }
    }
        
    private static int[] Calculate_Indexes(Number[] left){
        int[] sums = new int[left.length];
        for(int i = left.length - 1; i >= 0; i--){
            if(i == left.length - 1){
                sums[i] = left[i].index;                
            }
            else{
                sums[i] = left[i].index + sums[i + 1];
            }
        }
        return sums;
    }

    private static Pair Sort_And_Count(Number array[]){
        //base case
        if (array.length == 1){
            return new Pair(0, array);
        }

        //finds middle point
        //creates left and right arrays
        int middle_point = (array.length)/2;
        Number[] left;
        Number[] right;
        if(array.length % 2 == 0){
            right = new Number[middle_point];
        }
        else{
            right = new Number[middle_point + 1];
        }
        left = new Number[middle_point];

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
        int total = L.val + R.val + M.val;

        //returns combined weight and the sorted list
        if(total > 1221884026){
            System.out.println(array.length + " - " + total);

        }
        if(array.length == 10000){
            System.out.println(L.val + " - " + R.val + " - " + M.val);
            System.out.println(total);
            

        }
        return new Pair(total, M.list);

    }
    
    private static Pair Merge_And_Count(Number[] left, Number[] right) {  
        
        Number[] combo = new Number[left.length + right.length];
        int[] sums = Calculate_Indexes(left);
        int i = 0, j =0, k = 0, weight = 0;
        
        while (i < left.length && j < right.length)
        {
            if (left[i].val <= right[j].val)
            {
                combo[k] = left[i];
                i++;
            }
            else
            {
                combo[k] = right[j];
                weight += (right[j].index * (sums.length - i)) - sums[i];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of left[] if any */
        while (i < left.length){
            combo[k] = left[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of right[] if any */
        while (j < right.length){
            combo[k] = right[j];
            j++;
            k++;
        }
        return new Pair(weight, combo);
    }

    static void get_Input() throws FileNotFoundException{
        File test = new File("text.txt");
        Scanner scan = new Scanner(test);
        int size = scan.nextInt();

        Number[] list = new Number[size];
        for(int i = 0; i < size; i++){
            list[i] = new Number(scan.nextInt(), i);
        }
        
        System.out.println("Answer: " + Sort_And_Count(list).val);
        
    }


    public static void main(String[] args) throws FileNotFoundException {
        get_Input();        
    }
}