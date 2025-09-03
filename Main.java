import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        File eventTypeFile = new File("eventTypeFile.txt");
        File eventFile = new File("eventFile.txt");
        File participantFile = new File("participantFile.txt");

        eventTypeFile.createNewFile();
        eventFile.createNewFile();
        participantFile.createNewFile();

        while (true) {
            System.out.println("\n=== Welcome to Event Management System ===");
            System.out.println("1. Add Event Type");
            System.out.println("2. Add Event");
            System.out.println("3. Add Participant");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                
                System.out.print("Enter EventType ID: ");
                int typeId = Integer.parseInt(sc.nextLine());
                System.out.print("Enter EventType Name (Technical/Cultural/Sports): ");
                String typeName = sc.nextLine();

                EventType eventType = new EventType(typeId, typeName);

                FileWriter fw = new FileWriter(eventTypeFile, true);
                fw.write(eventType.getId() + "," + eventType.getType() + "\n");
                fw.close();

                System.out.println("EventType saved in eventTypeFile.txt");

            } else if (choice == 2) {
                // Add Event
                System.out.print("Enter Event ID: ");
                int eventId = Integer.parseInt(sc.nextLine());
                System.out.print("Enter Event Name: ");
                String eventName = sc.nextLine();
                System.out.print("Enter Event Date (YYYY-MM-DD): ");
                String eventDate = sc.nextLine();
                System.out.print("Enter EventType ID for this Event: ");
                int typeId = Integer.parseInt(sc.nextLine());

                // Load EventType from file
                BufferedReader br = new BufferedReader(new FileReader(eventTypeFile));
                EventType eventType = null;
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (Integer.parseInt(parts[0]) == typeId) {
                        eventType = new EventType(Integer.parseInt(parts[0]), parts[1]);
                        break;
                    }
                }
                br.close();

                if (eventType == null) {
                    System.out.println("EventType not found! Add EventType first.");
                    continue;
                }

                Event event = new Event(eventId, eventName, eventDate, eventType);

                FileWriter fw = new FileWriter(eventFile, true);
                fw.write(event.getId() + "," + event.getName() + "," + event.getDate() + "," + event.getEventTypeName() + "\n");
                fw.close();

                System.out.println("Event saved in eventFile.txt");

            } else if (choice == 3) {
                // Add Participant
                System.out.print("Enter Participant ID: ");
                int pId = Integer.parseInt(sc.nextLine());
                System.out.print("Enter Participant Name: ");
                String pName = sc.nextLine();
                System.out.print("Enter Participant Email: ");
                String pEmail = sc.nextLine();
                System.out.print("Enter Event ID for this Participant: ");
                int eventId = Integer.parseInt(sc.nextLine());

                // Load Event from file
                BufferedReader br = new BufferedReader(new FileReader(eventFile));
                Event event = null;
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (Integer.parseInt(parts[0]) == eventId) {
                        EventType et = new EventType(0, parts[3]); // only type name
                        event = new Event(Integer.parseInt(parts[0]), parts[1], parts[2], et);
                        break;
                    }
                }
                br.close();

                if (event == null) {
                    System.out.println("Event not found! Add Event first.");
                    continue;
                }

                Participant participant = new Participant(pId, pName, pEmail, event);

                FileWriter fw = new FileWriter(participantFile, true);
                fw.write(participant.getId() + "," + participant.getName() + "," + participant.getEmail() + "," + participant.getEventName() + "\n");
                fw.close();

                System.out.println("Participant saved in participantFile.txt");

            } else if (choice == 4) {
                System.out.println("Exiting Event Management System...");
                break;
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }

        sc.close();
    }
}

