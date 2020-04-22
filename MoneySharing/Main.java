import java.util.*;

import javax.imageio.IIOException;

import java.io.*;

public class Main {

    int n = 3;
    
    public static void main(String args[]) throws IOException {
         BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        Person A =  new Person("A");
        Person B =  new Person("B");
        Person  C =  new Person("C");


        while(true) {
            String input  = reader.readLine();

            if(input.equals("n")){
                findAmountToBeReceived(A,"A",B,C);
                findAmountToBeReceived(B,"B",C,A);
                findAmountToBeReceived(C,"C",B,A);
                break;
            }
            String arr[] = input.split(" ");

            if(arr[1].equals("A")){
                calculate(A, arr);
            }
            else if(arr[1].equals("B")){
                calculate(B,arr);
            }
            else if(arr[1].equals("C")){
                calculate(C,arr);
            }

        }
    }

     static void calculate(Person person,String arr[]){
        int amount = Integer.parseInt(arr[0]);
        for(int i =2;i<arr.length;i++){
            if(person.spent.containsKey(arr[i])) {
                Map<String,Integer> spent = person.getSpent();
                int value = spent.get(arr[i]);
                int total=(amount / (arr.length - 1))+value;
                spent.put(arr[i], total);
                person.setSpent(spent);
            }
            else{
                person.spent.put(arr[i], amount / (arr.length - 1));

            }
        }
    }
    static void findAmountToBeReceived (Person person,String personName,Person one,Person two){
        Map<String,Integer> spent = person.getSpent();
        int spentFor=0;
        int receivedFor=0;
        Iterator hmIterator = spent.entrySet().iterator(); 

        while (hmIterator.hasNext()) { 
            Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
            spentFor += ((int)mapElement.getValue()); 
        }
         
            int s1= one.getSpent().containsKey(personName) ? one.getSpent().get(personName) :0;
            int s2= two.getSpent().containsKey(personName) ?two.getSpent().get(personName):0;
            receivedFor = s1+s2;         

        if(receivedFor == 0){
            System.out.println(personName +"  gets  "+ spentFor);
        }
        else if(spentFor == 0){
            System.out.println(personName +"  gives  "+ receivedFor);

        }

    }

    static void findAmountToBeGiven(Person person,String personName,Person one,Person two){

    }
}