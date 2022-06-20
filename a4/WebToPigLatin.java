import java.util.Scanner;
import java.io.*;
import java.util.Formatter;



public class WebToPigLatin {

    static boolean noVowels(String s)
    {
        s = s.toLowerCase();
        char c;
        boolean noVs = true;

        for (int i = 1; i <= s.length(); i++)
        {
            c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            {
                noVs = false;
            }
        }
        return noVs;
    }

    static boolean isVowel(char c)
    {
        boolean b = false;
        if (c == 'a' || c =='e' || c == 'i' || c == 'o' || c == 'u')
        {
            b = true;   
        }
        return b;
    }

    static String translateWord(String s)
    {
        String pigWord = "";
        if (isVowel(s.charAt(0)))
        {
            pigWord = s + "way";
        }
        return pigWord;
    }



    public static void main(String[] args) throws IOException
    {
        File in = new File(args[0]);
		File out = new File (args[1]);

		FileReader input = new FileReader(in);
		FileWriter fileToPigLatin = new FileWriter(out);

        int charVal;
        char charToWrite;
        String word = "";

        while ((charVal = input.read()) != -1)
        {
            charToWrite = (char)charVal;        // cast to char value
            if (charToWrite == '<')
            {
                fileToPigLatin.write(charToWrite);
                while (charToWrite != '>')
                {
                    fileToPigLatin.write(charToWrite);
                    charVal = input.read();
                    charToWrite = (char)charVal;
                }
                fileToPigLatin.write(charToWrite);
            }
            else if (charToWrite == ' ')
            {
                fileToPigLatin.write(charToWrite);
                charVal = input.read();
                charToWrite = (char)charVal;
                while ( (charToWrite >= 'a' && charToWrite <= 'z') || (charToWrite >= 'A' && charToWrite <= 'Z') )
                {
                    word += charToWrite;
                    charVal = input.read();
                    charToWrite = (char)charVal;
                }
                if (noVowels(word))
                {
                    fileToPigLatin.write(word);
                }
                else 
                {
                    fileToPigLatin.write(translateWord(word));
                }
            }
            else 
            {
                fileToPigLatin.write(charToWrite);
            }
            word = "";  // reinitialize word
        }
    }
}

