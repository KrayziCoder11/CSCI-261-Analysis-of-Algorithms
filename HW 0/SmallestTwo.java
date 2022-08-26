import java.io.*;
public class SmallestTwo {

    static void findSmallestTwo() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(reader.readLine());
        int first = Integer.parseInt(reader.readLine());
        int second = Integer.parseInt(reader.readLine());

        for (int i = 2; i < length; i++){
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
