package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
	Hashtable<String,Long> book=new Hashtable<>();

	int x;
do {
    System.out.println("\nchoose your choice:");
    System.out.println("1:Add Contact");
    System.out.println("2:Delete Contact");
    System.out.println("3:Delete All Contacts");
    System.out.println("4:Search Contact");
    System.out.println("5:Print All Contacts in the PhoneBook");
    System.out.println("6:Exit");

     x = sc.nextInt();
    sc.nextLine();

    switch (x) {
        case 1: {
            System.out.println("\nenter the name of the person you would like to add to your contacts:");
            String name = sc.nextLine();
            System.out.println("\nenter the phone number:");
            Long number = sc.nextLong();

            if(book.containsKey(name)){

                Long temp=book.get(name);//number of the contact which is already existing in the phone book
                if(number.equals(temp)){//comparing current number with previous number

                    System.out.println("\ncontact already exists");
                    break;

                }else {
                    /*
                    if the contact already exists with the same name and the person has entered the different number
                    then we will ask the user if he want to update the contact with the number which he has entered or not.
                     */
                    System.out.println("\ncontact already exists but the phone number you are trying to save is different to the existing contact");
                    System.out.println("\nDo you want to update the existing contact with new number (yes or no)");

                    String decision=sc.next();

                    if(decision.equals("yes")) {
                        book.put(name, number);
                        System.out.println("\nphone number successfully updated");
                    }
                }
            }else {
                book.put(name, number);

                System.out.println("\ncontact is successfully added to the phonebook");

            }
            break;

        }

        case 2: {
            try{
            if(book.isEmpty()){
                System.out.println("\nphoneBook is empty");
            }else {
                System.out.println("\nEnter the name of the contact that you would like to delete:");
                String name = sc.nextLine();
                book.remove(name);

                System.out.println("\ncontact successfully removed");
            }}catch(Exception e){
                System.out.println(e);
            }
            break;
        }

        case 3: {
            if(book.isEmpty()){

                System.out.println("No contacts found in the phone book to delete.");

            }else {

                System.out.println("Are you sure you want to delete all the contacts?(yes or no)");
                String choice = sc.next();

                if (choice.equals("yes")) {

                    book.clear();
                    System.out.println("\nAll the contacts are deleted! Phone book is empty now.");

                }

            }
            break;
        }

        case 4: {
            if(book.isEmpty()){

                System.out.println("Phone Book is Empty.Can't search for any contacts.");

            }else {

                System.out.println("\nEnter the name of the person:");
                String name = sc.nextLine();

                if (book.containsKey(name)) {

                    System.out.println("\ncontact found with phone number:" + book.get(name));

                } else {

                    System.out.println("\ncontact not found");

                }

            }

            break;
        }

        case 5: {

            System.out.println(book);
            break;
        }

        case 6: {
            return;
        }

        default:{
            break;
        }
    }
}while(x>0 && x<7);
    }

}