import java.util.Scanner;
public class Main
{
    public static boolean wordContainsLetter(String word, char letter)
    {

        char[] letterCheck = word.toCharArray();
        for(char currentLetter : letterCheck)
        {
            if(currentLetter == letter)
            {
                return true;
            }
        }
        return false;
    }
    public static boolean wordContainsString(String word_1, String word_2)
    {
        return word_1.contains(word_2);
    }
    public static void guessWordWithLetters(English wordList, int length, String letterGuess)
    {
        char[] letters = letterGuess.toCharArray();
        for(String word : wordList.words)
        {
            if(word.length() == length)
            {
                boolean wordMatch = true;
                for(char userLetter : letters)
                {
                    if(!wordContainsLetter(word, userLetter))
                    {
                        wordMatch = false;
                        break;
                    }
                }
                if(wordMatch)
                {
                    System.out.println(word);
                }
            }
        }
    }
    public static void guessWordWithPattern(English wordList2, int length, String pattern)
    {
        for(int i = 0; i < wordList2.words.size(); i++)
        {
            String word = wordList2.words.get(i);
            if(word.length() == length && wordContainsString(word, pattern))
            {
                System.out.println(word);
            }
        }
    }


    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        English wordList = new English();

        System.out.println("How many letters are in the word?");
        int userLength = scan.nextInt();
        System.out.println("Do you want me to look for letters or a pattern?" +
                "\n1. Letters" +
                "\n2. Pattern");
        int choice = scan.nextInt();
        scan.nextLine();

        switch(choice)
        {

            case 1:
                System.out.println("What letters are in the word?");
                String userLetters = scan.next();
                System.out.println("It might be any of these...");
                guessWordWithLetters(wordList, userLength, userLetters);
                break;
            case 2:
                System.out.println("What pattern is in the word?");
                String userPattern = scan.next();
                System.out.println("It might be any of these...");
                guessWordWithPattern(wordList, userLength, userPattern);
                break;

        }

    }
}