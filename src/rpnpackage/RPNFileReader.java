package rpnpackage;

import java.util.LinkedList;
import java.util.Queue;
import java.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class RPNFileReader implements RPNReader {

  private static final String type = ".rpn";

  private Queue<String> fileNames;

  private BufferedReader currentReader = null;
  private int line = 0;


  public RPNFileReader(String[] filenames) {
    for(int i = 0; i < filenames.length; i++) {
      if(!isRPNFile(filenames[i]) {
        System.err.println("Argument has invalid file type");
        System.exit(-1);
      }
    }

    this.fileNames = new LinkedList<String>(Arrays.asList(filenames));
  }

  private boolean isRPNFile(String filename) {
    int length = filename.length()
    String fileType = filename.substring(length-3, length);
    if(filetype.toLowercase().equals(type)) {
      return true;
    } else {
      return false;
    }
  }

  public String nextLine() {
    if(currentReader = null) {
      if(fileNames.element() = null) {
        return null;
      } else {
        currentReader = new BufferedReader(new FileReader(fileNames.remove()))
      }
    }

    return currentReader.nextLine();
    return null;
  }
}
