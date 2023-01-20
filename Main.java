
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.*;

class Main {

  JFrame frame = new JFrame();
  ArrayList<Integer> pattern = new ArrayList<Integer>();
  public boolean mouseDown;
  // public int buttonIDMain;
  String white = "\u001B[37m";
  String red = "\u001B[31m";
  String green = "\u001B[32m";
  String blue = "\u001B[34m";
  String yellow = "\u001B[33m";
  static int inputID;
  button button1 = new button(1);
  button button2 = new button(2);
  button button3 = new button(3);
  button button4 = new button(4);
  String highscore;

  // This method makes it easier to generate a random number, and makes the code
  // more readable.
  public void addDig() {
    Random rand = new Random();
    int num = rand.nextInt(4) + 1;
    pattern.add(num);
  }

  public static void clear() {
    Main translator = new Main();
    System.out.println(translator.white + "\033[H\033[2J");
    ;
  }

  static void wait(int milliseconds) {
    try {
      Thread.sleep(milliseconds);
    } catch (Exception e) {
    }
  }

  public void createButtons() {
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setSize(size);
    frame.setBackground(new Color(25,25,50));
    frame.add(button1);
    frame.setVisible(true);
    frame.add(button2);
    frame.setVisible(true);
    frame.add(button3);
    frame.setVisible(true);
    frame.add(button4);
    frame.setVisible(true);
    // for (int i=1; i<=4; i=i+1) {
    // frame.add(new button(i));
    // frame.setVisible(true);
    // }
    clear();
  }

  public void playPattern() {
    clear();
    for (int i = 0; i < pattern.size(); i += 1) {
      System.out.print(i + 1);
      System.out.print(":  ");
      System.out.println(pattern.get(i));
      switch (pattern.get(i)) {
        case (1):
          frame.getRootPane().setBackground(new Color(0, 200, 0));
          System.out.println(green + "green" + white);
          break;
        case (2):
          frame.getRootPane().setBackground(new Color(200, 0, 0));
          System.out.println(red + "red" + white);
          break;
        case (3):
          frame.getRootPane().setBackground(new Color(200, 200, 0));
          System.out.println(yellow + "yellow" + white);
          break;
        case (4):
          frame.getRootPane().setBackground(new Color(0, 0, 200));
          System.out.println(blue + "blue" + white);
          break;
      }
      wait(500);
      frame.getRootPane().setBackground(new Color(25, 25, 50));
      clear();
      wait(200);
    }
  }

  public boolean awaitPlayback() {
    for (int i = 0; i < pattern.size(); i += 1) {
      inputID = 0;
      System.out.println("Repeat the pattern using the \"L\" shaped buttons");
      while (inputID == 0) {
        wait(10);
      }
      switch (inputID) {
        case (1):
          frame.getRootPane().setBackground(new Color(0, 200, 0));
          break;
        case (2):
          frame.getRootPane().setBackground(new Color(200, 0, 0));
          break;
        case (3):
          frame.getRootPane().setBackground(new Color(200, 200, 0));
          break;
        case (4):
          frame.getRootPane().setBackground(new Color(0, 0, 200));
          break;
      }
      wait(100);
      frame.getRootPane().setBackground(new Color(25, 25, 50));
      if (inputID != pattern.get(i)) {
        return (false);
      }
      System.out.println("Correct!");
      wait(100);
      clear();
    }
    System.out.println("Good Job!");
    wait(100);
    return (true);
  }

  // THIS IS MAIN!!!!!
  public static void main(String[] args) throws IOException {
    Main t = new Main();
    try {
      File myObj = new File("highscore.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        t.highscore = myReader.nextLine();
        System.out.println(t.highscore);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    Scanner hold = new Scanner(System.in);
    t.pattern.removeAll(t.pattern);
    t.createButtons();

    String hsLabelText = """
<html>
  <table>
    <tr>
      <th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th>
      <th>
      <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
      <FONT COLOR=\"YELLOW\">
        Highscore:&nbsp;&nbsp;"""+t.highscore+"""
      </th>
    </tr>
  </table>
<html>
""";
    JLabel hsLabel = new JLabel(hsLabelText, JLabel.CENTER);
    t.button4.add(hsLabel);
    
    String beginLabelText = """
      <html>
        <table>
          <tr>
            <th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th>
            <th>
              <FONT COLOR=\"RED\">
              Press to begin
              <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
            </th>
          </tr>
        </table>
      </html>
      """;
    JLabel beginLabel = new JLabel(beginLabelText);
    t.button1.add(beginLabel);

    System.out.println("Press enter to continue");
    // hold.nextLine();
    while (inputID != 1) {
        wait(10);
      }
    hsLabel.setVisible(false);
    beginLabel.setVisible(false);
    while (true) {
      t.addDig();
      System.out.println("Your pattern is...");
      wait(500);
      t.playPattern();
      boolean result = t.awaitPlayback();
      wait(100);
      if (result) {
        continue;
      } else {
        break;
      }
    }
    System.out.println(t.red + "Game Over");
    System.out.print("Your score was ");
    System.out.println(t.pattern.size() - 1);
    if (t.pattern.size() - 1 > Integer.parseInt(t.highscore)) {
      t.highscore = Integer.toString(t.pattern.size() - 1);
      BufferedWriter writer = new BufferedWriter(new FileWriter("example.txt"));
      writer.write(t.highscore);
      writer.close();
    }
    hold.close();
  }
}