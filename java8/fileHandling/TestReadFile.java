package java8.fileHandling;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class TestReadFile {

	public static void main(String args[]) {

		String fileName = "c://lines.txt";

		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			stream.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			long uniqueWord = stream.flatMap(x-> Arrays.stream(x.split(" "))).distinct().count();
			System.out.println(uniqueWord);

		} catch (IOException e) {
			e.printStackTrace();
		}

		
		try (Scanner scanner = new Scanner(new File(fileName))) {

			while (scanner.hasNext()){
				System.out.println(scanner.nextLine());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
	}

}