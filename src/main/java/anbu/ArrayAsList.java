package anbu;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ArrayAsList {

    public static void main(String[] args) {

        Integer a[]={1,4,5,6};
        List<Integer> list = Arrays.asList(a);

        Collections.synchronizedList(list);
        list.lastIndexOf(4);

        list.stream().forEach(System.out::println);

        list.stream().forEach(System.out::println);
        List<Integer> list2 = new ArrayList<>(Arrays.asList(a));


        a[2]=0;

        list2.add(100);

        list2.stream().forEach(System.out::println);
        Queue<String> st= new LinkedList<>() ;

        Set<String> s = new HashSet();
        s.add("anbu");
        s.add("amanthika");
        s.add("amarishika");

        Set<String> s2 = new LinkedHashSet<>();

        s2.add("anbu");
        s2.add("amanthika");
        s2.add("amarishika");

        s.stream().forEach(System.out::println);
        s2.stream().forEach(System.out::println);


       Vector v= new Vector();

        ArrayAsList tester = new ArrayAsList();
        tester.testVector();
        tester.testArrayList();
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put(null, 1);


    }

    public void testVector() {
        long startTime = System.currentTimeMillis();

        Vector<Integer> vector = new Vector<>();

        for (int i = 0; i < 10_000_000; i++) {
            vector.addElement(i);
        }

        long endTime = System.currentTimeMillis();

        long totalTime = endTime - startTime;

        System.out.println("Test Vector: " + totalTime + " ms");

    }

    public void testArrayList() {
        long startTime = System.currentTimeMillis();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10_000_000; i++) {
            list.add(i);
        }

        long endTime = System.currentTimeMillis();

        long totalTime = endTime - startTime;

        System.out.println("Test ArrayList: " + totalTime + " ms");

    }

}
