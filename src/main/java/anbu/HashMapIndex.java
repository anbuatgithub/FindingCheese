package anbu;

import java.util.HashMap;
import java.util.Random;

public class HashMapIndex {
    public static void main(String[] args) {


        Integer empId = 5;
        String empName = "anbu";

        int bucketLocation1 = empId.hashCode() % 3;
        System.out.println(bucketLocation1);

        for(int i=0;i<5;i++){
            Random r = new Random();

            //System.out.println(Math.abs(r.nextInt()) & 3);
        }

        System.out.println( 678 & 3);



    }
}
