public class EventType {
    Integer id;
    String type; // e.g., Technical, Cultural, Sports

    public EventType(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

    public Integer getId() { 
        return this.id; 
        }
    public String getType() { 
        return this.type; 
        }
}
