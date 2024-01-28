package anbu.algo;

import java.util.*;

public class FirstDuplicate {
    public static void main(String[] args) {
        int array[]={2,5,4,6,6,2,4};
        System.out.println(negativeIndex(array.clone()));
        System.out.println(throughSet(array));
        System.out.println(bruteforceMethod(array));
        System.out.println(bruteforceMethod3(array));
    }

    private static int bruteforceMethod(int[] array) {
        for(int i=0;i< array.length;i++){
            for(int j=i-1;j>=0;j--){
                if(array[i] == array[j])
                    return array[i];
            }
        }
        return -1;

    }

    private static int throughSet(int[] array) {

        Set<Integer> set = new HashSet<Integer>();
        for(int number:array){
            if(set.contains(number)){
                return number;
            }
            set.add(number);
        }

        return -1;
    }

    private static int negativeIndex(int[] array) {
        for(int number:array){
            int absNo= Math.abs(number);
            if(array[absNo] <0 ) {
                return absNo;
            }
            array[absNo] *= -1;
        }
        return -1;
    }




    private static int bruteforceMethod3(int[] array) {
        for(int i=0;i< array.length-1;i++){
            for(int j=i+1;j< array.length;j++){
                if(array[i] == array[j] && i!=j)
                    return array[i];
            }
        }
        return -1;

    }


}
