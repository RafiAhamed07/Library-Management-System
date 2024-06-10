package lms;

import java.util.Scanner;


public class Library implements Runnable {
        Scanner in = new Scanner(System.in);
        public void add() {
            System.out.println("Enter book name");
            String name= in.next();
            System.out.println("Enter the authors name");
            String author=in.next();
            LibraryDatabaseOperations.insertData(name, author);



        }
        public void remove() {
            System.out.println("Enter book name");
            String name= in.next();
            LibraryDatabaseOperations.delete(name);
        }
        public void getinfo() {
            System.out.println("Enter book name");
            String name = in.next();
            LibraryDatabaseOperations.getData(name);
        }
        public void getAllinfo(){
            LibraryDatabaseOperations.getALLData();

        }
        public void borrow() {
            System.out.println("Enter book name");
            String bname = in.next();
            LibraryDatabaseOperations.borrow(bname);
        }
        public void updatename(){
            System.out.println("Enter book's uid");
            int uid = in.nextInt();
            System.out.println("Enter book's new name");
            String newname = in.next();
            LibraryDatabaseOperations.updateBName(uid, newname);

        }
    public void updateauthor(){
        System.out.println("Enter book uid");
        int uid = in.nextInt();
        System.out.println("Enter book's new author");
        String newauthor = in.next();
        LibraryDatabaseOperations.updateAuthor(uid, newauthor);


    }

        public void run() {
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("1)Add new book in library");
            System.out.println("2)Remove book from library");
            System.out.println("3)Borrow book from the library");
            System.out.println("4)Get any book's info");
            System.out.println("5)Available books & their info");
            System.out.println("6)Update any book's name");
            System.out.println("7)Update any book's author");
            System.out.println("8) Exit. :)");
            System.out.print("Enter your choice : ");
            try{
            int x = in.nextInt();
            
            if(x==1) {
                add();
                run();
            }else if(x==2) {
                remove();
                run();
            }else if(x==3) {
                borrow();
                run();
            }else if(x==4) {
                getinfo();
                run();
            }else if(x==5) {
                getAllinfo();
                run();
            }else if(x==6) {
                updatename();
                run();
            }else if(x==7) {
                updateauthor();
                run();
            }else if(x==8){
                System.out.println("Thank you");
                System.out.println("Exiting...");
                return;
            }else {
                System.out.println("Invalid option try again!");
                run();
            }
            }catch(Exception e){
                System.out.println(e);
        
            }
            
        }
}
