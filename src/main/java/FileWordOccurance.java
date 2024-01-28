import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileWordOccurance {

	public static void main(String[] args) throws FileNotFoundException {

		String fileName ="sample.txt";
		File fr = new File(fileName);
		Scanner sc = new Scanner(fr);
		Map<String, Integer> hashMap = new HashMap<>();
		while (sc.hasNext()) {
			String[] words = sc.next().split(" ");
			for (String word : words) {
				Integer integer = hashMap.get(word);
				if (integer == null)
					hashMap.put(word, 1);
				else {
					hashMap.put(word, integer + 1);
				}
			}
		}
		System.out.println(hashMap);

		}
}
