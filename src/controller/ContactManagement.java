package controller;

import common.Library;
import java.util.ArrayList;
import model.Contact;

import view.Menu;

public class ContactManagement extends Menu<String>{
    static String[] mc = {"Add a contact", "Display all contacts", "Delete a contact", "Exit"};
    ArrayList<Contact> contacts = new ArrayList<>();
    
    private Library library;
    
    public ContactManagement(Contact contact) {
        super("Contact Management Program", mc);
        library = new Library();
    }

    public void createContact(ArrayList<Contact> contacts) {      
        int i = 1;
      
        
        while (true) {
            int contactId = i++;
            System.out.print("Enter first name: ");
            String firstName = library.inputString();
            System.out.print("Enter last name: ");
            String lastName = library.inputString();
            System.out.print("Enter group: ");
            String group = library.inputString(); 
            System.out.print("Enter address: ");
            String address = library.inputString();
            while(!library.inputAddress(address)) {
                address = library.inputString();
            }          
            System.out.print("Enter phone: ");
            String phone = library.inputPhone();

            Contact c = new Contact(contactId, firstName + lastName, group, address, phone, firstName, lastName);
            if (library.checkIdExist(contacts, contactId)) {
                contacts.add(c);
            System.err.println("Create success!");
            }

                System.out.print("Do you want to create more students (Y/N): ");
            if (!library.inputYesNo()) {
                return;
            }
            
        }
    }
    
    public void printAllContact(ArrayList<Contact> contacts) {
        System.out.println("------------------------------- Display all list ---------------------------------");
        System.out.printf("%-5s%-25s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Name",
                "First name", "Last name", "Group", "Address", "Phone");
        //print infomation of contact from first to last list contact
        for (Contact contact : contacts) {
            System.out.printf("%-5d%-25s%-20s%-20s%-20s%-20s%-20s\n",
                    contact.getContactId(), contact.getFullName(),
                    contact.getFirstName(), contact.getLastName(),
                    contact.getGroup(), contact.getAddress(), contact.getPhone());
        }
    }

    //allow user delete contact
    public void deleteContactd(ArrayList<Contact> contacts) {
        System.out.print("Enter id: ");
        int idDelete = library.inputInt();
        Contact contactDelete = getContactById(contacts, idDelete);
        if (contactDelete == null) {
            System.err.println("Not found contact.");
            return;
        } else {
            contacts.remove(contactDelete);
        }
        System.err.println("Delete successful.");
    }

    //get contact by id
    public Contact getContactById(ArrayList<Contact> contacts, int idDelete) {
        for (Contact contact : contacts) {
            if (contact.getContactId() == idDelete) {
                return contact;
            }
        }
        return null;
    }
    
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                createContact(contacts);
                break;
            case 2:
                printAllContact(contacts);
                break;
            case 3:
                deleteContactd(contacts);
                break;
            case 4:
                System.out.println("Exit the program successfully!");
                System.exit(0);
                break;
        }
    }   
    

}