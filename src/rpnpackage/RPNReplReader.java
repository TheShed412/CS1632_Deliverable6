package rpnpackage;

import java.io.*;

public class RPNReplReader implements RPNReader {

  private InputStreamReader stream;
  private BufferedReader reader;

  public RPNReplReader() {

    stream = new InputStreamReader(System.in);
    reader = new BufferedReader(stream);
  }

  public String nextLine() {
    return null;
  }

  public int getLineNumber() {
    return -1;
  }
}
