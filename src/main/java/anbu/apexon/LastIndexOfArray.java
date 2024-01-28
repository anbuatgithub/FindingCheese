package anbu.apexon;

public class LastIndexOfArray {
    public static void main(String[] args) {
        Integer[] arr = {3,2,4,5,4,7,67,3,5,1,4,5};
        System.out.println(findLastIndex(arr,4));

    }

    private static int findLastIndex(Integer[] arr, int num) {
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]==num)
                return i;
        }

        return 0;

    }
}
