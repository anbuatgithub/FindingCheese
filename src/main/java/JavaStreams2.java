import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams2 {
	public static void main(String[] args) throws IOException {

		List<Integer> numbers = Arrays.asList(1,2,3,4,5);

		//simple for each without streams
		numbers.forEach(System.out::print);
		System.out.println();

		//sum of elements
		Optional<Integer> sum = numbers.stream().reduce((a,b) -> a+b);
		System.out.println(sum.get());

		//sum of elements
		System.out.println(numbers.stream().mapToInt(x->x).sum());

		//number of elements
		System.out.println(numbers.stream());

		//average of numbers
		System.out.println(numbers.stream().mapToInt(x->x).average().getAsDouble());
		System.out.println(numbers.stream().mapToInt(x->x).sum()/numbers.size());

		//average of squared numbers
		System.out.println(numbers.stream().map(x->x*x).mapToInt(x->x).average().getAsDouble());

		//print numbers
		numbers.stream().forEach(x-> System.out.print(x+" "));
		System.out.println();
		numbers.stream().forEach(System.out::print);
		System.out.println();

		//print odd number
		numbers.stream().filter(x->x%2!=0).forEach(x-> System.out.print(x+" "));

		//print number starts with 4
		System.out.println(numbers.stream().map(x-> String.valueOf(x)).filter(x->x.startsWith("4")).findAny().get());
		List<Integer> numbersWithDuplicate = Arrays.asList(1,2,3,4,5,1,3);

		//second Highest number
		List<Integer> list = Arrays.asList(1,2,3,4,5,1,3 , 6 , 8 ,13 , 78);
		System.out.println(list.stream().sorted(Collections.reverseOrder()).distinct().skip(1).findFirst().get());

		//second lowest number
		System.out.println(list.stream().sorted().distinct().skip(1).findFirst().get());


		//find duplicate
		List<Integer> duplicateArrays = Arrays.asList(1,3,10,20,30,1,15);
		Set<Integer> dup = duplicateArrays.stream().filter(e->Collections.frequency(duplicateArrays,e)>1).collect(Collectors.toSet());
		System.out.println(dup);

		Set<Integer> dupNum = new HashSet<Integer>();
		//find duplicate
		Set<Integer> dup2 = duplicateArrays.stream().filter(e-> !dupNum.add(e)).collect(Collectors.toSet());
		System.out.println(dup2);
		//without  duplicate
		System.out.println(dupNum);

		//max no
		System.out.println(duplicateArrays.stream().max(Comparator.comparing(Integer::valueOf)).get());
		System.out.println(duplicateArrays.stream().min(Comparator.comparing(Integer::valueOf)).get());
		//sorting
		System.out.println(duplicateArrays.stream().sorted().collect(Collectors.toList()));
		System.out.println(duplicateArrays.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()));

		//limit and skip
		System.out.println(numbers.stream().limit(4).skip(1).collect(Collectors.toSet()));

		//Finding wovels in string
		String str= "anbalagan";
		System.out.println("No of wowels :"+ str.chars().filter(x-> x=='a' || x=='i' || x=='o' || x=='u' || x=='e').count());

		//NO of letters in string
		Map<String, Long> out = str.chars().mapToObj(x -> (char)x).collect(Collectors.groupingBy(Object::toString, Collectors.counting()));
		out.forEach((key,value)-> System.out.println("letter "+key+" : "+value+ " times"));

		int arr[]= {34,5,6,7,34,5,71};
		List<Integer> listnumbers = Arrays.asList(1,2,3,4,5);
		//Map<Integer, Long> collect = Arrays.stream(arr).mapToObj(x -> x).collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
		Map<Integer, Long> collect = Arrays.stream(arr).mapToObj(x -> x).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		collect.forEach((key,value)-> System.out.println("number "+key+" : "+value+ " times"));
		listnumbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));



	}


}