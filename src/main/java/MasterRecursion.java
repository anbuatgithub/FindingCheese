public class MasterRecursion {

    static  int sum = 0;

    public static void main(String[] args) {
        new MasterRecursion().printonetofive(5);
        new MasterRecursion().sumonetofive(6);
        System.out.println(sum);



    }

    void printonetofive(int i) {
        if (i > 0) {
            System.out.println(i);
            printonetofive(i - 1);

        }
    }

    void sumonetofive(int i) {
        if (i > 0) {
            sumonetofive(i - 1);
            sum = sum+i;
        }
    }

}
