package anbu;

import org.apache.commons.collections4.functors.PredicateTransformer;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LearnFuctioinalInterface {
    public static void main(String[] args) {
        //Predicate<Student> predicate = st-> st.getAge()>15;
        Student student = new Student("1", "anbu", "anbu@gmail.com",20);
        System.out.println(isStudentMinor(student, st -> st.getAge() > 10));
        System.out.println(returnNoOfLettersInEmail(student, st -> st.length()));
        printStudent(student, st -> System.out.println(st.toString()));

        Supplier<LocalDateTime> lt = () -> LocalDateTime.now();
        System.out.println(printLocal(lt));

        printStudent(student, st -> System.out.println(st.toString()));


        String s1 = "Harry Potter";
        String s2 = "The Lord of the Rings";
        String s3 = "Harry Potter";


        String s4 = new String("Harry Potter");
        s4 = s4.intern();
        String s5 = new String("The Lord of the Rings");

        System.out.println(s1.hashCode());
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());

        System.out.println(s1==s3);
        System.out.println(s1==s4);
        Point p= new Point(6,8);
       // p.x()


    }

    private static LocalDateTime printLocal(Supplier<LocalDateTime> supplier) {
        return supplier.get();
    }

    private static void printStudent(Student student, Consumer<Student> con) {
        con.accept(student);
    }

    public static Boolean isStudentMinor(Student s, Predicate<Student> pr) {
        return pr.test(s);
    }

    public static Integer returnNoOfLettersInEmail(Student s, Function<String,Integer> pr) {
        return pr.apply(s.getEmail());


    }


}

record Point(int x, int y) { }
