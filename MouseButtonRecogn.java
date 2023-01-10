import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MouseButtonRecogn extends MouseAdapter {

  int x;
  int y;

  @Override
  public void mouseClicked(MouseEvent event) {

    if ((event.getModifiers() & InputEvent.BUTTON1_MASK) != 0) {
      // Get the point in type Point
      // Must convert to ints to call contains(int, int) from EnterButton
      String PointToInt = String.valueOf(event.getPoint());
      // For some reason points start with java.awt.Point, so this is removed
      PointToInt = PointToInt.substring(17, PointToInt.length() - 1);
      // It also says x= and y=. This removes that
      PointToInt = PointToInt.replaceFirst("y=", "");
      // Here all that is left is Point1,Point2. Remove the comma and put in String[]
      String[] parser = PointToInt.split(",");
      // Since you cannot parseInt a list, we must do it one element at a time
      x = Integer.parseInt(parser[0]);
      y = Integer.parseInt(parser[1]);
      System.out.print(x);
      System.out.print(", ");
      System.out.println(y);
      Main.click();
    }
  }
}