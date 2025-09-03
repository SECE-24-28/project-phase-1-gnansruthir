public class Participant {
    Integer id;
    String name;
    String email;
    Event event;

    public Participant(Integer id, String name, String email, Event event) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.event = event;
    }

    public Integer getId() { 
        return this.id; 
        }
    public String getName() { 
        return this.name;
         }
    public String getEmail() { 
        return this.email; 
        }
    public String getEventName() { 
        return this.event.getName(); 
        }
}
