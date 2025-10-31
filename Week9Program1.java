package week9;

// Claire Francis, Week9Program1, October 30, 2025

//   Write a program that reads in the file and displays the following information about the file:
// 1) the number of letters
// 2) the number of words (i.e. just count the number of spaces)
// 3) the number of sentences (i.e. just count the number of periods, exclamation marks, and questions marks)
// 4) the average number of letters per word (use a double variable type and round to the nearest 0.1)
// 5) the average number of words per sentence (use a double variable type and round to the nearest 0.1

import java.util.Scanner;

import java.io.FileNotFoundException;
import java.io.File;
public class Week9Program1 {

	public static void main(String[] args) throws FileNotFoundException {
		String fileName = "C:\\Users\\clair\\Documents\\FileforWeek9CodeExample.txt";
        int letters = 0;
        int words = 0;
        int sentences = 0;

        try {
            Scanner fileScanner = new Scanner(new File(fileName));

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                for (char ch : line.toCharArray()) {
                    if (Character.isLetter(ch)) {
                        letters++;
                    }
                    if (ch == '.' || ch == '!' || ch == '?') {
                        sentences++;
                    }
                }

                String trimmed = line.trim();
                if (!trimmed.isEmpty()) {
                    String[] word = trimmed.split("\\s+");
                    words += word.length;
                }
            }
            fileScanner.close();

            double avgLettersPerWord = (words > 0) ? (double) letters / words : 0.0;
            double avgWordsPerSentence = (sentences > 0) ? (double) words / sentences : 0.0;

            avgLettersPerWord = Math.round(avgLettersPerWord * 10.0) / 10.0;
            avgWordsPerSentence = Math.round(avgWordsPerSentence * 10.0) / 10.0;

            System.out.println("File: " + fileName);
            System.out.println("Number of letters: " + letters);
            System.out.println("Number of words: " + words);
            System.out.println("Number of sentences: " + sentences);
            System.out.println("Average number of letters per word: " + avgLettersPerWord);
            System.out.println("Average number of words per sentence: " + avgWordsPerSentence);

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + fileName);
        }
    }
}

		
	
	





