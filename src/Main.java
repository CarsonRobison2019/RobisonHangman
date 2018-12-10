import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //all the words in the game.
        String[] words = {"nail","silk","numberless","sloppy","military","necessary","injure","field","boorish","inject"
                ,"suspend","curtain","alert","skin","acrid","wild","powder","cough","open","work","waste","ducks",
                "aboard","dance","tranquil","truculent","cow","point","basket","calculator","drum","lip","flawless",
                "spade","sisters","cover","possess","slimy","adventurous","quilt","beam","lean","desk","mine",
                "imaginary","grumpy","silent","stop","cut","malicious","delicate","smoke","clear","store","eggs","fear",
                "long","pathetic","overrated","adamant","toothbrush","hour","crazy","flowery","dust","arm","mean",
                "demonic","ambitious","kiss","redundant","jump","turn","produce","follow","slippery","rough","wholesale"
                ,"eatable","strange","trouble","dream","cute","tomatoes","gentle","fish","cloudy","concentrate",
                "wretched","pie","office","wire","receipt","jobless","cannon","watch","thaw","hand","punish","cast",
                "fact","understood","thankful","poke","public","copy","helpful","vigorous","knit","shave","endurable",
                "challenge","can","strap","girl","wrap","toys","limping","disapprove","crow","servant","pear","ahead",
                "inconclusive","help","driving","dispensable","hammer","oval","star","vessel","calm","nine","agonizing",
                "meat","grate","unequaled","bag","zoo","simple","dust","resonant","finger","save","right","bitter",
                "shiny","whispering","wacky","bang","charge","spicy","bleach","changeable","soothe","acoustics",
                "nutritious","tense","stamp","giraffe","thunder","four","holiday","support","yawn","school","resolute",
                "push","past","cent","ball","nose","head","husky","island","color","whip","protect","steer","mate",
                "used","blink","man","surprise","incredible","invincible","crown","rabid","craven","whisper","tart",
                "automatic","wise","realise","prepare","birds","decide","ten","explode","passenger","porter","trees",
                "adaptable","fabulous","theory","wistful","glistening","ground","cover","wood","melodic","stingy",
                "bathe","eye","murder","brother","knotty","eyes","cruel","return","nauseating","believe","bawdy","land",
                "untidy","free","plausible","remove","weigh","naive","tired","wealth","fry","oranges","sleep","like",
                "locket","stupid","pass","premium","disgusting","beautiful","fallacious","meek","appliance","labored",
                "smelly","tremble","halting","hope","moon","plastic","cars","verdant","flap","river","colorful","badge",
                "clear", "stove", "jagged", "efficacious", "accept", "nerve", "historical","mixed",
                "discovery", "feigned", "parcel", "abaft", "morning", "blushing", "terrible", "adjustment", "pine",
                "start", "taste", "idiotic", "soap", "writing", "turn", "omniscient", "letters", "home", "busy",
                "rabbits", "sound", "tie", "satisfying", "serve", "dolls", "anger", "foot", "judge", "ghost", "creepy",
                "irate", "distribution", "superficial", "true", "scarf", "wandering", "wrong", "pest", "abhorrent",
                "electric", "appear", "silky", "handsomely", "expect", "peace", "sheet", "deadpan", "curly", "cap",
                "ignorant", "various", "boring", "wipe", "detailed", "wash", "mine", "dramatic", "complete", "person",
                "loud", "big", "guess", "aunt", "raspy", "weary", "scrub", "coherent", "unnatural", "pickle", "bells",
                "absorbing", "seemly", "hop", "flashy", "offbeat", "box", "loss", "care", "bird", "coach", "measure",
                "tub", "plane", "pocket", "nice", "uppity", "neat", "damaged", "sassy", "garrulous", "wall", "plough",
                "recondite", "flood", "peel", "religion", "influence", "crib", "label", "even", "actor", "snatch",
                "industrious", "honey", "sack", "elated", "bear", "empty", "range", "spare", "multiply", "rescue",
                "thirsty", "writer", "lively", "silly", "action", "itchy", "drop", "comfortable", "destroy", "loving",
                "funny", "grouchy", "brown", "stir", "abiding", "internal", "prefer", "excuse", "tray", "tasteless",
                "interest", "petite", "guide", "alert", "tangible", "record", "flesh", "certain", "psychedelic", "bomb",
                "adhesive", "downtown", "cautious", "glossy", "wicked", "bounce", "onerous", "evasive", "wound", "soda",
                "sick", "quiet", "festive", "pump", "summer", "remarkable", "snail", "exciting", "mother", "plastic",
                "black", "bit", "giants", "harmonious", "questionable", "roomy", "abrasive", "interfere", "scream",
                "end", "lyrical", "frogs", "violet", "woozy", "apparel", "hydrant", "reign", "unkempt", "legs", "shelf",
                "dear", "sneeze", "insidious", "strip", "ruddy", "snails", "absurd", "ill", "same", "knife", "slim",
                "embarrass", "mice", "shame", "normal", "useful", "complete", "waggish", "gaudy", "number", "fancy",
                "flaky", "robust", "massive", "existence", "charming", "disillusioned", "encourage", "behave", "chess",
                "mourn", "grandfather", "zany", "crayon", "time", "overwrought", "eager", "rude", "yeet", "jazz",
                "pneumonoultramicroscopicsilicovolcanoconiosis"};
        // Picks a word for the game
        int WordNumber = (int) (Math.random() * words.length);
        // stores the letter in a array
        char[] enteredLetters = new char[words[WordNumber].length()];
        int triesCount = 0;
        int badguess = 0;
        boolean wordIsGuessed = false;
        //System.out.println(words[WordNumber]);
        do {

            switch (enterLetter(words[WordNumber], enteredLetters)) {
                case 0:
                    triesCount++;
                    badguess++;
                    break;
                case 1:
                    triesCount++;
                    break;
                case 2:
                    triesCount++;
                    badguess++;
                    break;
                case 3:
                    wordIsGuessed = true;
                    break;
            }

            System.out.println(displayHangman(badguess) + "\n" + "\nyou have missed " + badguess + " letters");
        } while (!wordIsGuessed && badguess < 6);

        System.out.println("\n\nYou guessed " + badguess + " incorrect times" + "\nThe Word was " + words[WordNumber] + "\n" +
                "you guessed a total of " + triesCount + " times" + "\nWould you like to play the game again?" +
                "(Y/N)");
    }

    private static int enterLetter(String word, char[] enteredLetters) {
        System.out.print("Take a chance to save the man what is you letter of choice ");
        if (!printWord(word, enteredLetters))
            return 3;
        System.out.print(" > ");
        Scanner input = new Scanner(System.in);
        int emptyPosition = findEmptyPosition(enteredLetters);
        char userInput = input.nextLine().charAt(0);
        if (inEnteredLetters(userInput, enteredLetters)) {
            System.out.println(userInput + " is already in the word");
            return 2;
        } else if (word.contains(String.valueOf(userInput))) {
            enteredLetters[emptyPosition] = userInput;
            return 1;
        } else {
            System.out.println(userInput + " is not in the word");
            return 0;
        }
    }


    private static boolean printWord(String word, char[] enteredLetters) {
        // Iterate through all letters in word
        boolean asteriskPrinted = false;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            // Check if letter already have been entered bu user before
            if (inEnteredLetters(letter, enteredLetters))
                System.out.print(letter); // If yes - print it
            else {
                System.out.print('*');
                asteriskPrinted = true;
            }
        }
        return asteriskPrinted;
    }


    private static boolean inEnteredLetters(char letter, char[] enteredLetters) {
        return new String(enteredLetters).contains(String.valueOf(letter));
    }


    private static int findEmptyPosition(char[] enteredLetters) {
        int i = 0;
        while (enteredLetters[i] != '\u0000') i++;
        return i;
    }

    private static String displayHangman(int badguess) {
        String display = "";
        switch (badguess) {
            case 0:
                display = " ";
                break;
            case 1:
                display = "\n______________\n" +
                        "       |      \n" +
                        "       O      \n" +
                        "              \n" +
                        "              \n" +
                        "              \n" +
                        "              \n";
                break;
            case 2:
                display = "\n______________\n" +
                        "       |      \n" +
                        "       O      \n" +
                        "       |      \n" +
                        "       |      \n" +
                        "              \n" +
                        "              \n";
                break;
            case 3:
                display = "\n______________\n" +
                        "       |      \n" +
                        "       O      \n" +
                        "       |--    \n" +
                        "       |      \n" +
                        "              \n" +
                        "              \n";
                break;
            case 4:
                display = "\n______________\n" +
                        "       |      \n" +
                        "       O      \n" +
                        "     --|--    \n" +
                        "       |      \n" +
                        "              \n" +
                        "              \n";
                break;
            case 5:
                display = "\n______________\n" +
                        "       |      \n" +
                        "       O      \n" +
                        "     --|--    \n" +
                        "       |      \n" +
                        "      /       \n" +
                        "     /          ";
                break;
            case 6:
                display = "\n______________\n" +
                        "       |      \n" +
                        "       O      \n" +
                        "     --|--    \n" +
                        "       |      \n" +
                        "      / \\    \n" +
                        "     /   \\     ";
                break;
        }
        return display;
    }

    private boolean playAgain;{
        boolean Y = true;
        boolean N = false;
        boolean y = true;
        boolean n = false;

    }

}