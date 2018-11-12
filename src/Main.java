import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[]args) {
        //words for the game
        String[] gameword = {"write", "that", "program", "telephone", "jazz", "apple", "cookies"};
        // picks a word from the list
        int y = (int) (Math.random() * 7);
        //make the game word = word
        String word = gameword[y];
        //                                            System.out.println(word);
        //Replaces the word with *
        String maskWord = word.replaceAll(".", "*");

        //keeps count of all the wrong guesses
        int count = 0;

        //lets the game know how many letters are in the game
        int letterPosition = 0;


        System.out.println(maskWord);
        char guessedLetter = (char) (letterPosition + '0');
        Scanner input = new Scanner(System.in);
        while (maskWord.contains("*")) {
            System.out.print("(Guess) Enter a letter in word " + maskWord + " >");
            String guessWord = input.nextLine();
//          if guessed letter is part of word, replace asterisks in maskWord with guessed letter at correct position
            if (word.contains(guessWord)) {
                letterPosition = word.indexOf(guessWord);
                (maskWord.replace(maskWord.charAt(guessedLetter), "guessWord"));

            }
//          if guessed letter is not part of word, error counter +1
            else {
                System.out.println(guessWord + " is not in the word");
                count += 1;
            }
        }
    }
}
