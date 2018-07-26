package dictionary;
import java.util.Scanner;
public class Dictionary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        access_checker ac= new access_checker();
        System.out.println("Welcome to the course Dictionary.you may Enter new Words,Delete or edit any entry according to your permissions -----------");
            System.out.println("Enter your User id(int) followed by your passkey(int)");
            int user_id = sc.nextInt();
            int passkey = sc.nextInt();
            int access_p = ac.access_checking(user_id, passkey);
            if(access_p == 1)
            {
                System.out.println("Welcome "+user_id+" You are admin");
                admin_code a_c = new admin_code();
                a_c.admin_code();
            }
            else if(access_p == 0)
            {
                System.out.println("Welcome "+user_id+" You are student");
                user_code u_c = new user_code();
                u_c.user_code();
            }
            else
            {
                System.out.println("Welcome "+user_id+" You are can't access anything");
            }
    }
}
