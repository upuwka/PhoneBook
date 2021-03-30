package menu;
import contacts.Contacts;
import java.util.ArrayList;

public class Menu {
    public ArrayList<Contacts> contacts = new ArrayList<Contacts>();
    public String addContact(Contacts contact){
        this.contacts.add(contact);
        return contact.name + " was added";
    }
    public ArrayList<Contacts> getAllContacts(){
        return contacts;
    }
    //public ArrayList<Contacts> findContact(Contacts contact){
        //this.contacts(contact);
            //   return contacts;   }
    public String removeContact(int contactId){
        try {
            contacts.remove(contactId);
        }
        catch (Exception ex){
            return "Unable to remove this contact\n";
        }
        return "contact removed successfully\n";
    }
    public String updateContact(int contactId, Contacts newContacts){
        if(this.contacts.get(contactId) != null){
            Contacts oldContact = this.contacts.get(contactId);
            oldContact.name = newContacts.name;
            oldContact.phoneNumber = newContacts.phoneNumber;
            oldContact.email = newContacts.email;
            return "car updated successfully";
        }
        return "car not found";

    }
}
