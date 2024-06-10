package lms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User extends Library {
    private String name;
    private int memberId;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMemberId() {
        return memberId;
    }
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void Checkuser(String name, int Id) {
        File file = new File("D:\\LMS\\src\\lms\\user.txt");
        boolean userFound = false;
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().trim(); // Trim the data read from the file
                if(data.equalsIgnoreCase(name + " " + Id)) {
                    System.out.println("user name id found");
                    Library l = new Library();
                    Thread t = new Thread(l);
                    t.start();
                    userFound = true;
                    break;
                }
            }
            if (!userFound) {
                System.out.println("user name id not found");
            }
            myReader.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void adduser(int n1) {
        Scanner in = new Scanner(System.in);
        for(int i = 1 ; i<=n1 ; i++) {
            System.out.println("Enter name ");
            String n=in.next();
            setName(n);
            System.out.println("Enter ID ");
            int id=in.nextInt();
            setMemberId(id);
            try {
                String na = getName();
                int x = getMemberId();
                try (FileWriter fw = new FileWriter("D:\\LMS\\src\\lms\\user.txt", true);
                     BufferedWriter bw = new BufferedWriter(fw)) {
                    bw.write("\n"+na+" "+x+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("All registrations are successful");
    }
}
