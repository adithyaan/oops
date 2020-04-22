import java.util.*;

import javax.imageio.IIOException;

import java.io.*;

public class Main {
    
    public static void main(String args[]) throws IOException {

        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        int noOfPersons = Integer.parseInt(reader.readLine());
        Map <String,Person>personMap = new HashMap<String,Person>();

       
        for(int i=0;i<noOfPersons;i++){
            String personName = ((char)(65+i))+"";
            personMap.put(personName, new Person(personName));
        }

        while(true) {
            String input  = reader.readLine();

            if(input.equals("n")){
                find(personMap);
                break;
            }
            String arr[] = input.split(" ");

            calc(personMap,arr);

        }
    }
    static void calc (Map persons,String arr[]) {
       
        int amount = Integer.parseInt(arr[0]);
        Person person = (Person)persons.get(arr[1]);
        Map<String,Integer> spent = person.getSpent();

        for(int i =2;i<arr.length;i++){
            if(person.getSpent().containsKey(arr[i])) {
                int value = spent.get(arr[i]);
                int total=(amount / (arr.length - 1))+value;
                spent.put(arr[i], total);
            }
            else{
                spent.put(arr[i], amount / (arr.length - 1));
            }
            person.setSpent(spent);
        }
       

    }

    
    static void find(Map persons){
        Iterator personIterator = persons.entrySet().iterator(); 
            while (personIterator.hasNext()) { 
                Map.Entry mapElement = (Map.Entry)personIterator.next(); 
                Person person = (Person)mapElement.getValue();

            String personName = person.getPersonName();
            Map<String,Integer> spent = person.getSpent();
            
            int spentFor=0;
            int receivedFor=0;
            Iterator hmIterator = spent.entrySet().iterator(); 

            while (hmIterator.hasNext()) { 
                Map.Entry mapEl = (Map.Entry)hmIterator.next(); 
                spentFor += ((int)mapEl.getValue()); 
            }
            Iterator pIterator = persons.entrySet().iterator(); 

            while (pIterator.hasNext()) { 
                Map.Entry mapElem = (Map.Entry)pIterator.next(); 
                Person person1 = (Person)mapElem.getValue();
                if(!person1.equals(person)){
                Map<String,Integer> map = person1.getSpent();
                receivedFor+=map.containsKey(personName)?map.get(personName):0;
               }
               
            }
            if(receivedFor == 0){
                System.out.println(personName +"  gets  "+ spentFor);
            }
            else if(spentFor == 0){
                System.out.println(personName +"  gives  "+ receivedFor);
    
            }
        }

    }
}