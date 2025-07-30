
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VowelsAndConsonants {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter a sentence: ");
            String input = sc.nextLine().toLowerCase();
            int vowels = 0, consonants = 0;
            Map<Character, Integer> freq = new HashMap<>();
            for (char ch: input.toCharArray()) {
                if (Character.isLetter(ch)) {
                    freq.put(ch, freq.getOrDefault(ch, 0) + 1);
                    if ("aeiou".indexOf(ch) != -1) {
                        vowels++;
                    } else {
                        consonants++;
                    }
                }
            }   System.out.print("Vowels: " + vowels + "Consonants: " + consonants);
            System.out.println("Letter Frequencies: " + freq);
        }
    }
}
