package application;
import java.util.*;
import java.io.*;

public class ParserWithFileInput 
{
    private CommandWords commands;  // holds all valid command words
    private Scanner reader;         // OLD source of command input
    private File source; 
    private String inputLine;

    /**
     * Create a parser to read from the terminal window.
     */
    public ParserWithFileInput() 
    {
        commands = new CommandWords();
        //reader = new Scanner(System.in);
        try
        {
            source = new File("GuidedTourCommands.txt");
            reader= new Scanner(source);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }

    }

    /**
     * @return The next command from the user.
     */
    public Command getCommand() 
    {
        String inputLine;   // will hold the full input line
        String word1 = null;
        String word2 = null;

        System.out.print("> ");     // print prompt


        if(!reader.hasNext())
        {
            word1="quit";
            word2=null;
            return new Command(word1, word2);
        }

        inputLine = reader.nextLine();
        System.out.println(inputLine);
        // Find up to two words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();      // get first word
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();      // get second word
                // note: we just ignore the rest of the input line.
            }
        }

        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command).
        if(commands.isCommand(word1)) {
            return new Command(word1, word2);
        }
        else {
            return new Command(null, word2); 
        }
    }

    public void showCommands()
    {
        commands.showAll();
    }
}
