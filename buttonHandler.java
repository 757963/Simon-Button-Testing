import javax.swing.*;
import java.awt.*;

public class buttonHandler extends JFrame {
  public void createButtons() {
    setLayout(new GridLayout(2, 2));
    add(new button(1));
    add(new button(2));
    add(new button(3));
    add(new button(4));
  }
}