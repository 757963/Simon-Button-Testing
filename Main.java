import javax.swing.*;
import java.awt.*;

class Main {

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
  static void createButtons() {
    JFrame frame = new JFrame();
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
    createButtons();
  }
}