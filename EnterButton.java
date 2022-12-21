import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class EnterButton extends JButton {
  public boolean mouseDown;
  public Polygon shape;

  static void wait(int milliseconds) {
    try {
      Thread.sleep(milliseconds);
    } catch (Exception e) {
    }
  }
  
  ArrayList<Point> initPoints = new ArrayList<Point>(5);

  public EnterButton(int buttonID) {
    this.shape = new Polygon();
    this.addMouseListener(new MouseButtonRecogn());
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    System.out.println(size);
    // Get the screen size in type Dimension
    // Must convert to ints to center the buttons on the screen
    String dimToInt = String.valueOf(size);
    System.out.println(dimToInt);
    // For some reason Dimensions start with java.awt.Dimension, so this is removed
    dimToInt = dimToInt.substring(25, dimToInt.length() - 1);
    // It also says width= and height=. This removes that
    dimToInt = dimToInt.replaceFirst("height=", "");
    // Here all that is left is width,height. Remove the comma and put in String[]
    String[] parser = dimToInt.split(",");
    System.out.println(parser);
    // Since you cannot parseInt a list, we must do it one element at a time
    int width = Integer.parseInt(parser[0]);
    int height = Integer.parseInt(parser[1]);
    System.out.print(width);
    System.out.print(", ");
    System.out.println(height);
    
    // initialisiere Form
    initPoints.removeAll(initPoints);
    // initPoints.add(new Point(200, 200));
    // initPoints.add(new Point(200, 260));
    // initPoints.add(new Point(260, 260));
    // initPoints.add(new Point(260, 320));
    // initPoints.add(new Point(320, 320));
    // initPoints.add(new Point(320, 200));
    // this.initialize(initPoints);

    // initPoints.removeAll(initPoints);
    // initPoints.add(new Point(130, 200));
    // initPoints.add(new Point(130, 260));
    // initPoints.add(new Point(70, 260));
    // initPoints.add(new Point(70, 320));
    // initPoints.add(new Point(-50, 320));
    // initPoints.add(new Point(-50, 200));
    // this.initialize(initPoints);
    initPoints.add(new Point(200, 200));
    initPoints.add(new Point(320, 200));
    initPoints.add(new Point(320, 320));
    initPoints.add(new Point(200, 320));
    initPoints.add(new Point(200, 260));
    initPoints.add(new Point(260, 260));
    initPoints.add(new Point(260, 320));
    initPoints.add(new Point(200, 320));
    this.initialize(initPoints);
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
    // this.setMinimumSize(this.getSize());
    // this.setMaximumSize(this.getSize());
    // this.setPreferredSize(this.getSize());
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
    gCopy.setColor(Color.red);
    gCopy.fillPolygon(this.shape);
  }
}