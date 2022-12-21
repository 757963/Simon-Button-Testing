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

    JFrame frame = new JFrame("Simons");
    EnterButton button = new EnterButton(1);

    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

    System.out.println(size);

    frame.add(button);
    frame.setSize(size);
    frame.setVisible(true);
  }
}