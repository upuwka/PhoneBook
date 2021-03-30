import contacts.Contacts;
import menu.Menu;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Menu menu = new Menu();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.openBook();

    }
    void openBook(){
        String userInPut ="";
        do {
            System.out.println("Your Phone Book. Please choose activity:");
            System.out.println();
            System.out.println("1. Add person");
            System.out.println("2. View all contacts");
            System.out.println("3. Find contact");
            System.out.println("4. Remove person");
            System.out.println("5. Update person");
            System.out.println("\nEnter Quit to End Programm\n");

            System.out.print("Enter your choice:");

            userInPut = scanner.nextLine();
            switch (userInPut) {
                case "quit":
                    System.out.println("Exiting app");
                    break;
                case "1":
                   addContact();
                    break;
                case "2":
                    viewAllContacts();
                    break;
                case "3":
                    findContact();
                    break;
                case "4":
                    updateContact();
                    break;
                case "5":
                    removeContact();
                    break;
                default:
                    break;
            }
             } while (!userInPut.equalsIgnoreCase("quit"));
        }
    void addContact(){
        System.out.println("\n Add person");

        Contacts contacts = new Contacts();
        System.out.println("Enter Name:");
        contacts.name = scanner.nextLine();

        System.out.println("Enter phone number:");
        contacts.phoneNumber = scanner.nextLine();

        System.out.println("Enter email:");
        contacts.email = scanner.nextLine();

        String message = menu.addContact(contacts);
        System.out.println(message);

        System.out.println("\n Press enter to continue\n");
        scanner.nextLine();

}
    void viewAllContacts(){
        ArrayList<Contacts> allContacts = menu.getAllContacts();
        System.out.println("\nAll contacts\n");
        System.out.println(" Person's name\t  Phone Number\t E-mail");

        int counter = 0;

        for (Contacts contacts : allContacts) {
            System.out.println(counter + ". \t" + contacts.name + " \t" + contacts.phoneNumber + " \t" + contacts.email);
            counter++;
        }
    }
    void findContact(){
        System.out.println("Type name or number to search:");
        String contactName = scanner.nextLine();

        for (Contacts contacts : menu.contacts) {
            if (contacts.name.contains(contactName)) {
                System.out.println(contacts);
            }
        }
   /* void findContact() {
        System.out.println("Type name or number to search:");
              String contactName = " ";
              ArrayList<Contacts> searchFor = menu.getAllContacts();
              contactName = scanner.nextLine();

            if(contactName.contains(searchFor)){
                System.out.println("Found name " + contactName);}
            else{
                System.out.println(searchFor + "not Found");
            }
                System.out.println(contactName.indexOf(String.valueOf(searchFor)));*/
        }
    void updateContact(){
        Contacts contacts = new Contacts();
        this.viewAllContacts();
        System.out.println("Update Contact");
        int contactId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter new name for contact");
        contacts.name = scanner.nextLine();
        System.out.println("Enter number for contact");
        contacts.phoneNumber = scanner.nextLine();
        System.out.println("Enter email");
        contacts.email = scanner.nextLine();

        String response = menu.updateContact(contactId, contacts);
        System.out.println(response);

    }
    void removeContact(){
        System.out.println("Delete contact\n" );
        System.out.println("Enter contact's ID" );

        int contactId = scanner.nextInt();
        String message = menu.removeContact(contactId);

        System.out.print(message);
    }
    }
