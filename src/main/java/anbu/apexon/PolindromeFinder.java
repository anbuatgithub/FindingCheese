package anbu.apexon;

public class PolindromeFinder {
    public static void main(String[] args) {
        System.out.println(poly1("liril"));
        System.out.println(poly2("liril"));
        System.out.println(poly3("liil"));

    }

    private static boolean poly3(String str) {
        int left= 0;
        int right=str.length()-1;

        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;

    }

    private static boolean poly2(String str) {
        char[] charArray = str.toCharArray();
        char[] revverseArray = new char[str.length()];

        for(int i=0,j= charArray.length-1;i<charArray.length;i++,j--){
            revverseArray[j]=charArray[i];
        }
        return String.valueOf(charArray).equals(String.valueOf(revverseArray));
    }

    private static boolean poly1(String str) {
        return new StringBuilder(str).reverse().toString().equals(str);
    }









}
