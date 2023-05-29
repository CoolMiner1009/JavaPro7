import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // 2. Метод findSymbolOccurance
        String inputString = scanner.nextLine();
        char symbol = scanner.nextLine().charAt(0);
        int occurrenceCount = findSymbolOccurrence(inputString, symbol);
        System.out.println("Occurrences: " + occurrenceCount);

        // 3. Метод findWordPosition
        String source = scanner.nextLine();
        String target = scanner.nextLine();
        int position = findWordPosition(source, target);
        System.out.println("Position: " + position);

        // 4. Метод stringReverse
        String str = scanner.nextLine();
        String reversedString = stringReverse(str);
        System.out.println("Reversed: " + reversedString);

        // 5. Метод isPalindrome
        String palindrome = scanner.nextLine();
        boolean isPalindrome = isPalindrome(palindrome);
        System.out.println("Is palindrome: " + isPalindrome);

        // 6. Гра відгадування слова
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        playWordGuessingGame(words, random, scanner);
    }

    public static int findSymbolOccurrence(String inputString, char symbol) {
        int count = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == symbol) {
                count++;
            }
        }
        return count;
    }

    public static int findWordPosition(String source, String target) {
        int position = source.indexOf(target);
        return position;
    }

    public static String stringReverse(String str) {
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }

        return new String(charArray);
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void playWordGuessingGame(String[] words, Random random, Scanner scanner) {
        int index = random.nextInt(words.length);
        String chosenWord = words[index];
        int wordLength = chosenWord.length();
        char[] guessedLetters = new char[wordLength];

        for (int i = 0; i < wordLength; i++) {
            guessedLetters[i] = '#';
        }

        boolean wordGuessed = false;
        int attempts = 0;

        while (!wordGuessed) {
            System.out.print("Guess the word: ");
            String guess = scanner.nextLine().toLowerCase();

            if (guess.equals(chosenWord)) {
                wordGuessed = true;
            } else {
                for (int i = 0; i < wordLength; i++) {
                    if (chosenWord.charAt(i) == guess.charAt(i)) {
                        guessedLetters[i] = chosenWord.charAt(i);
                    }
                }

                System.out.println(guessedLetters);
                attempts++;
            }
        }

        System.out.println("Congratulations! You guessed the word in " + attempts + " attempts.");
    }
}

