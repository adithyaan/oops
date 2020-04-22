import java.util.*;
import java.io.*;

public class Main {

    int n = 3;
    public static void main(String args[]) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Map <String,Integer> give = new HashMap<>();
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        Person A = new Person();
        Person B = new Person();
        Person C = new Person();
        Main main =  new Main();

        while(true) {
            String input  = reader.readLine();

            if(input.equals("n")){
                break;
            }
            String arr[] = input.split(" ");

            if(arr[1].equals("A")){
                main.calcuate(A,arr);
            }
            else if(arr[1].equals("B")){
                main.calculate(B,arr);
            }
            else if(arr[1].equals("C")){
                main.calculate(C,arr);
            }

        }

    }

     public void calculate(Person person,String arr[]){
        int amount = Integer.parseInt(arr[0]);
        for(int i =2;i<arr.length;i++){
            int value = person.spent.get(arr[i]);
            if(person.spent.containsKey(arr[i])) {

                int total=(amount / (arr.length - 1))+value;
                person.spent.put(arr[i], total);
            }
            else{
                person.spent.put(arr[i], amount / (arr.length - 1));

            }
        }
    }
}