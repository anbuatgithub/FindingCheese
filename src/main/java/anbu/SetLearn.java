package anbu;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SetLearn {

    public static void main(String[] args) {
        Student student1 = new Student("123", "Tom", "tom@gmail.com", 30);
        Student student2 = new Student("123", "Tom", "tom@gmail.com", 30);
        Student student3 = new Student("456", "Tom", "peter@gmail.com", 23);

        Set<Student> setStudents = new HashSet<Student>();
        setStudents.add(student1);
        setStudents.add(student2);
        setStudents.add(student3);
        setStudents.forEach(System.out::println);
        System.out.println(118 & 16);
        teststatoc.myMethod();
        SimpleStaticExample.myMethod();
   }





}


class SimpleStaticExample
{
    // This is a static method

    static int i=10;
    static void myMethod()
    {
        System.out.println("myMethod");
    }

    public static void main(String[] args)
    {
        /* You can see that we are calling this
         * method without creating any object.
         */
        myMethod();
    }
}


class teststatoc extends SimpleStaticExample
{

    static int i =30;

    static void myMethod(){
        System.out.println("hai");
    }


}

 class Student {
    private String id;
    private String name;
    private String email;
    private int age;


     public String getId() {
         return id;
     }

     public void setId(String id) {
         this.id = id;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getEmail() {
         return email;
     }

     public void setEmail(String email) {
         this.email = email;
     }

     public int getAge() {
         return age;
     }

     public void setAge(int age) {
         this.age = age;
     }

     public Student(String id) {
        this.id = id;
    }

    public Student(String id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String toString() {
        String studentInfo = "Student " + id;
        studentInfo += ": " + name;
        studentInfo += " - " + email;
        studentInfo += " - " + age;

        return studentInfo;
    }

    public boolean equals2(Object obj) {
        if (obj instanceof Student) {
            Student another = (Student) obj;
            if (this.id.equals(another.id)) {
                return true;
            }
        }
        return false;
    }

     public int hashCode2() {
         //return Objects.hash(id, name, email, age);
         return 31 * this.id.hashCode();
     }

     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         Student student = (Student) o;
         return age == student.age && id.equals(student.id) && name.equals(student.name) && email.equals(student.email);
     }

     @Override
     public int hashCode() {
         return Objects.hash(id, name, email, age);
     }
 }