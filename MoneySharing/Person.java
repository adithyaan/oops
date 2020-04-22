import java.util.*;

public class Person {
    public Map <String,Integer> spent = new HashMap<String,Integer>();
    public Map <String,Integer> received = new HashMap<String,Integer>();
    String personName;
    public Person(String personName){
        this.personName = personName;
    }
    
    public String getPersonName() {
        return personName;
    }
    
    public void setPersonName(String personName) {
        this.personName = personName;
    }
    public Map<String, Integer> getSpent() {
        return spent;
    }

    public void setSpent(Map<String, Integer> spent) {
        this.spent = spent;
    }

    public Map<String, Integer> getReceived() {
        return received;
    }

    public void setReceived(Map<String, Integer> received) {
        this.received = received;
    }
}
