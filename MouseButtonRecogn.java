import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MouseButtonRecogn extends MouseAdapter {

  int x;
  int y;
  int buttonID;

  @Override
  public void mouseClicked(MouseEvent event) {
    // Tell main which button was clicked
    Main.inputID = buttonID;
  }
  
  public MouseButtonRecogn(int buttonIDin) {
    // When the mouseListener is added to at button, the button shares it's buttonID so that when this class detects it's click, it can give main the correct button ID
    buttonID = buttonIDin;
  }
}