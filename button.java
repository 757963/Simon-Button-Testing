import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class button extends JButton {
  public boolean mouseDown;
  public Polygon shape;
  int buttonID;

  static void wait(float seconds) {
    int milliseconds = (int) seconds*100;
    try {
      Thread.sleep(milliseconds);
    } catch (Exception e) {
    }
  }
  
  ArrayList<Point> initPoints = new ArrayList<Point>(5);

  public button(int buttonIDin) {
    buttonID = buttonIDin;
    this.shape = new Polygon();
    this.addMouseListener(new MouseButtonRecogn());
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    // Get the screen size in type Dimension
    // Must convert to ints to center the buttons on the screen
    String dimToInt = String.valueOf(screenSize);
    // For some reason Dimensions start with java.awt.Dimension, so this is removed
    dimToInt = dimToInt.substring(25, dimToInt.length() - 1);
    // It also says width= and height=. This removes that
    dimToInt = dimToInt.replaceFirst("height=", "");
    // Here all that is left is width,height. Remove the comma and put in String[]
    String[] parser = dimToInt.split(",");
    // Since you cannot parseInt a list, we must do it one element at a time
    int width = Integer.parseInt(parser[0]);
    int height = Integer.parseInt(parser[1]);
    System.out.print(width);
    System.out.print(", ");
    System.out.println(height);
    
    if (buttonID == 1) {
      initPoints.removeAll(initPoints);
      initPoints.add(new Point(300, 150));
      initPoints.add(new Point(180, 150));
      initPoints.add(new Point(180, 270));
      initPoints.add(new Point(300, 270));
      initPoints.add(new Point(300, 210));
      initPoints.add(new Point(240, 210));
      initPoints.add(new Point(240, 270));
      initPoints.add(new Point(300, 270));
      this.initialize(initPoints);
    } else if (buttonID == 2) {
      initPoints.removeAll(initPoints);
      initPoints.add(new Point(350, 150));
      initPoints.add(new Point(470, 150));
      initPoints.add(new Point(470, 270));
      initPoints.add(new Point(350, 270));
      initPoints.add(new Point(350, 210));
      initPoints.add(new Point(410, 210));
      initPoints.add(new Point(410, 270));
      initPoints.add(new Point(350, 270));
      this.initialize(initPoints);
    } else if (buttonID == 3) {
      initPoints.removeAll(initPoints);
      initPoints.add(new Point(180, 220));
      initPoints.add(new Point(180, 340));
      initPoints.add(new Point(300, 340));
      initPoints.add(new Point(300, 220));
      initPoints.add(new Point(240, 220));
      initPoints.add(new Point(240, 280));
      initPoints.add(new Point(300, 280));
      initPoints.add(new Point(300, 220));
      this.initialize(initPoints);
    } else if (buttonID == 4) {
      initPoints.removeAll(initPoints);
      initPoints.add(new Point(620, 220));
      initPoints.add(new Point(620, 340));
      initPoints.add(new Point(500, 340));
      initPoints.add(new Point(500, 220));
      initPoints.add(new Point(560, 220));
      initPoints.add(new Point(560, 280));
      initPoints.add(new Point(500, 280));
      initPoints.add(new Point(500, 220));
      this.initialize(initPoints);
    }
  }

  protected void initialize(ArrayList<Point> points) {

    Point p1, p2, p3, p4, p5, p6, p7, p8;

    p1 = new Point(points.get(0));
    p2 = new Point(points.get(1));
    p3 = new Point(points.get(2));
    p4 = new Point(points.get(3));
    p5 = new Point(points.get(4));
    p6 = new Point(points.get(5));
    p7 = new Point(points.get(6));
    p8 = new Point(points.get(7));

    this.shape.addPoint((int) Math.round(p1.getX()),
        (int) Math.round(p1.getY()));
    this.shape.addPoint((int) Math.round(p2.getX()),
        (int) Math.round(p2.getY()));
    this.shape.addPoint((int) Math.round(p3.getX()),
        (int) Math.round(p3.getY()));
    this.shape.addPoint((int) Math.round(p4.getX()),
        (int) Math.round(p4.getY()));
    this.shape.addPoint((int) Math.round(p5.getX()),
        (int) Math.round(p5.getY()));
    this.shape.addPoint((int) Math.round(p6.getX()),
        (int) Math.round(p6.getY()));
    this.shape.addPoint((int) Math.round(p7.getX()),
        (int) Math.round(p7.getY()));
    this.shape.addPoint((int) Math.round(p8.getX()),
        (int) Math.round(p8.getY()));
  }

  public boolean contains(int x, int y) {
    if (this.shape.contains(x, y)) {
      return true;
    } else {
      return false;
    }
  }

  protected void paintComponent(Graphics g) {
    Graphics2D gCopy = (Graphics2D) g.create();
    if (buttonID == 1) {
      gCopy.setColor(Color.green);
    } else if (buttonID == 2) {
      gCopy.setColor(Color.red);
    } else if (buttonID == 3) {
      gCopy.setColor(Color.yellow);
    } else if (buttonID == 4) {
      gCopy.setColor(Color.blue);
    }
    gCopy.fillPolygon(this.shape);
  }
}