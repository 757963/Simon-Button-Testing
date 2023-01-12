import javax.swing.*;
import java.awt.*;

class Main {
  JFrame frame = new JFrame();

  public boolean mouseDown;

  public static void clear() {
    System.out.println("\033[H\033[2J");
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
    for (int i=1; i<=4; i=i+1) {
      frame.add(new button(i));
      frame.setVisible(true);
    }
  }
  

  static void click() {
    System.out.println("Now Main knows!");
  }

  public static void main(String[] args) {
    Main translator = new Main();
    translator.createButtons();
    wait(1000);
    translator.frame.getRootPane().setBackground(new Color(200,0,0));
    translator.frame.setVisible(true);
    System.out.println("Done.");
  }
}