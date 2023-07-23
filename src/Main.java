import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        User[] userArray = new User[4];

        try (BufferedReader dirFile = new BufferedReader(new FileReader("src/data.txt"))) {
            String input;
            int count = 0;
            while((input = dirFile.readLine()) != null) {
                String[] data = input.split(",");

                String uname = data[0];
                String password1 = data[1];
                String name = data[2];

                userArray[count] = new UserService().createUser(uname, password1, name);
                count++;
        }
//
            }

        int count2 = 5;
        String username = "";
        String password = "";
        Boolean loginPass = false;

        while(count2 > 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\u001B[35m" + "\nPlease enter your username : \n Example : test@email.com");
            username = scanner.nextLine().toLowerCase();
            System.out.println("\u001B[35m" + "Please enter your password : \n Example : passwordTest!1");
            password = scanner.nextLine();

            for (User users : userArray) {

                String username2 = users.getUsername();
                String password2 = users.getPassword();


                if (username.equals(username2) || password.equals(password2)) {
                    System.out.println("\u001B[34m" + "Log in Successful. " + "\u001B[33m\" + Username : " + "\u001B[32m" + username + "\u001B[33m" + " and password: " +
                            "\u001B[32m" + password + "\u001B[33m" + " match.");
                    loginPass = true;
                    System.exit(0);
                }



            }
            if(!loginPass){
                System.out.println("\u001B[31m" + "Login Failed");
            }
            count2--;
        }
        System.out.println("\u001B[31m" + "Too many failed login attempts, you are now locked out." );
        }
    }





