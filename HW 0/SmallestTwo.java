import java.io.*;
public class SmallestTwo {

    static void findSmallestTwo() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(reader.readLine());
        int first = Integer.parseInt(reader.readLine());
        int count = 1;
        int second;
        while (true){
            second = Integer.parseInt(reader.readLine());
            count++;
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
            
        for (int i = count; i < length; i++){
            int newest = Integer.parseInt(reader.readLine());
            
            if(newest < first){
                second = first;
                first = newest;
            }
            else if (newest > first && newest < second){
                second = newest;
            }
        }
        System.out.println(first);
        System.out.println(second);
    }

    public static void main(String[] args) {
        try {
            findSmallestTwo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
