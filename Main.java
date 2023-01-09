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
    frame.setVisible(true);
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setSize(size);
    Container invisGrid = frame.getContentPane();
    // frame.setLayout(null);
    button button1 = new button(1);
    invisGrid.add(button1);
    wait(1000);
    // button1.setBounds(20,20, 100,100);
    // frame.add(button1);
    button button2 = new button(2);
    invisGrid.add(button2);
    wait(1000);
    // button1.setBounds(200,20, 100,100);
    // frame.add(button2);
    button button3 = new button(3);
    invisGrid.add(button3);
    wait(1000);
    // button1.setBounds(20,-200, 100,100);
    // frame.add(button3);
    button button4 = new button(4);
    // button1.setBounds(-200,200, 100,100);
    // frame.add(button4);
    // frame.setBackground(new Color(0,0,0));
    // frame.pack();
    invisGrid.add(button4);
    frame.pack();
    // Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    // frame.setSize(size);
    frame.setSize(size);
    frame.setVisible(true);
  }
}