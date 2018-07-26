package dictionary;
import java.util.Scanner;
public class admin_code {
    Scanner sc = new Scanner(System.in);
    
    void admin_code()
    {
        char c ='n';
        do
        {
            System.out.println("ADMIN MENU");
            System.out.println("1. Add a newly learnt Word");
            System.out.println("2. Search for a value of already added word");
            System.out.println("3.Delete an value");
            System.out.println("Enter your choice:");
            int ch = sc.nextInt();
            Operation op = new Operation();
            boolean a=false;
            String p;
        switch (ch)
        {
            case 1:
                System.out.println("Enter the Word to be inserted");
                p = sc.next();
                op.operation();
                a=op.insertion(p);
                break;
            case 2:
                System.out.println("Enter the Word to be searched");
                p =sc.next();
                op.operation();
                op.searching(p);
                break;
            case 3:
                System.out.println("Enter the Word to be deleted");
                p =sc.next();
                op.operation();
                op.deletion(p);
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }
        System.out.println("Enter y to continue n to exit");
        c = sc.next().charAt(0);
    }
    while (c == 'y');
    }
}
