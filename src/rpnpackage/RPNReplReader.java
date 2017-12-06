package rpnpackage;

import java.io.*;

public class RPNReplReader implements RPNReader {

  private InputStreamReader stream;
  private BufferedReader reader;
  private int lineNumber;

  public RPNReplReader() {

    stream = new InputStreamReader(System.in);
    reader = new BufferedReader(stream);
    lineNumber = 0;
  }

  public String nextLine() {

    System.out.print("> ");
    String expression = "";

    try{
      expression = reader.readLine();
    } catch (Exception e) {
      return null;
    }

    if (!expression.equals(""))
      lineNumber ++;

    return expression;
  }

  public int getLineNumber() {
    return lineNumber;
  }
}
