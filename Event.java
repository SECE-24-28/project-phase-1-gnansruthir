public class Event {
    Integer id;
    String name;
    String date;
    EventType eventType;

    public Event(Integer id, String name, String date, EventType eventType) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.eventType = eventType;
    }

    public Integer getId() { 
        return this.id; 
        }
    public String getName() { 
        return this.name;
         }
    public String getDate() { 
        return this.date;
         }
    public String getEventTypeName() { 
        return this.eventType.getType();
         }
}
