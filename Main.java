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

  public static void main(String[] args) {

    JFrame frame = new JFrame();
    frame.setLayout(new GridLayout(2, 2));
    frame.add(new button(1));
    frame.add(new button(2));
    frame.add(new button(3));
    frame.add(new button(4));
    frame.pack();

    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setSize(size);
    
    frame.setVisible(true);
  }
}