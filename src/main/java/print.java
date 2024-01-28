
import java.util.*;

public class print {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter name- ");
        String str= sc.nextLine();

        for (int i=0;i<=str.length();i++)
        {
            System.out.println(str.substring(0,i));
        }

        for (int i=str.length();i>0;i--)
        {
            System.out.println(str.substring(0,i));
        }


        System.out.println(str);

    }
}

