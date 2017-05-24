import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Created on 30 April 2010
 */

public class G {
    public static void main(String[] args) throws FileNotFoundException,
            IOException {
        Scanner fin = new Scanner(new FileReader("G.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("G.out"));

        String line;
        int numChars=0;
        while (fin.hasNextLine()) {
            line = fin.nextLine();
            //need to pull out all <img src....> from file
            //add to dic depending on filename. use size attrubute for value.
            numChars+= line.length();
            numChars++; //for CL/LF character
        }
        System.out.print(numChars);
        fin.close();
        fout.close();
    }
    
    // creates a buffered reader object for the standard input stream
    public static BufferedReader open (InputStream in)
    {
      return new BufferedReader(new InputStreamReader(in));
    }
    
    // creates a buffered reader object for the specified file input stream
    public static BufferedReader open (String filename) throws FileNotFoundException
    {
      try
      {
          return new BufferedReader(new FileReader(filename));
      }
      catch (FileNotFoundException e)
      {
          System.err.println();
          System.err.println("File " + filename + " does not exist.");
          System.err.println();
      }
      throw new FileNotFoundException();
    }
    
    // creates a print writer object for the specified file output stream
    public static PrintWriter create (String filename) throws IOException
      {
          return new PrintWriter(new FileWriter(filename));
      }

    public static long getLong(BufferedReader br) throws IOException 
    {
      long localLong = 0;
      try 
      {
        localLong = Long.valueOf(br.readLine().trim()).longValue();
      }
      catch (NullPointerException e)
      {
          System.err.println("End of file detected");
          throw new EOFException();
      }
      catch (NumberFormatException e) 
      {
        System.err.println();
        System.err.println("Error entering long: " + e.getMessage());
        System.err.println();
      }
      return localLong;
    }

    public static int getInt(BufferedReader br) throws IOException
    {
      int localInt = 0;
      try 
      {
        localInt = Integer.valueOf(br.readLine().trim()).intValue();
      }
      catch (NullPointerException e)
      {
          System.err.println("End of file detected");
          throw new EOFException();
      }
      catch (NumberFormatException e) 
      {
        System.err.println();
        System.err.println("Error entering int: " + e.getMessage());
        System.err.println();
      }
      return localInt;
    }

    public static float getFloat(BufferedReader br) throws IOException
    {
      float localFloat = (float)0.0;
      try 
      {
        localFloat = Float.valueOf(br.readLine().trim()).floatValue();
      }
      catch (NullPointerException e)
      {
          System.err.println("End of file detected");
          throw new EOFException();
      }
      catch (NumberFormatException e) 
      {
        System.err.println();
        System.err.println("Error entering float: " + e.getMessage());
        System.err.println();
      }
      return localFloat;
    }

    public static double getDouble(BufferedReader br) throws IOException
    {
      double localDouble = 0.0;
      try 
      {
        localDouble = Double.valueOf(br.readLine().trim()).doubleValue();
      }
      catch (NullPointerException e)
      {
          System.err.println("End of file detected");
          throw new EOFException();
      }
      catch (NumberFormatException e) 
      {
        System.err.println();
        System.err.println("Error entering double: " + e.getMessage());
        System.err.println();
      }
      return localDouble;
    }

    public static char getChar(BufferedReader br) throws IOException
    {
      char localChar = ' ';
      try 
      {
        localChar = br.readLine().trim().charAt(0);
      }
      catch (NullPointerException e)
      {
          System.err.println("End of file detected");
          throw new EOFException();
      }
      catch (NumberFormatException e) 
      {
        System.err.println();
        System.err.println("Error entering char: " + e.getMessage());
        System.err.println();
      }
      return localChar;
    }

    public static String readString(BufferedReader br) throws IOException
    {
      String localString = "";      
      localString = br.readLine();
      if (localString==null)
      {
          System.err.println("End of file detected");
          throw new EOFException();
      }      
      return localString;
    }
}
