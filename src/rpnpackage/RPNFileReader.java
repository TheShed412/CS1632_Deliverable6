package rpnpackage;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RPNFileReader implements RPNReader {

  private static final String type = ".rpn";

  private Queue<String> fileNames;

  private BufferedReader currentReader = null;
  private int lineNumber = 0;


  public RPNFileReader(String[] filenames) {
    for(int i = 0; i < filenames.length; i++) {
      if(!isRPNFile(filenames[i])) {
        System.err.println("Argument has invalid file type");
        System.exit(-1);
      }
    }

    this.fileNames = new LinkedList<String>(Arrays.asList(filenames));
  }

  private boolean isRPNFile(String filename) {
    int length = filename.length();
    if(length < 5) return false;
    String fileType = filename.substring(length-4, length);
    if(fileType.toLowerCase().equals(type)) {
      return true;
    } else {
      return false;
    }
  }

  public String nextLine() {
    // At the beginning and no files open yet
    if(lineNumber == 0 && hasFile()) {
      try {
        currentReader = new BufferedReader(new FileReader(fileNames.remove()));
      } catch(FileNotFoundException fnfe) {}
    }

    // Initialize line to token value
    String line = "";
    boolean reading = true;
    while(reading) {
      try {
        line = currentReader.readLine();
      } catch(IOException ioe) {}

      if(line == null && hasFile()) {
        try {
          currentReader = new BufferedReader(new FileReader(fileNames.remove()));
          continue;
        } catch(FileNotFoundException fnfe) {}
      }

      if(line == null) return null;

      if(!line.equals("")) reading = false;
    }

    lineNumber++;
    return line;
  }

  private boolean hasFile() {
    if(fileNames.peek() == null) return false;
    else return true;
  }

  public int getLineNumber() {
    return lineNumber;
  }
}
