import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   This program implements an animation that moves
   a car shape.
*/
public class AnimationTester extends Thread
{
   public static void main(String[] args) throws InterruptedException
   {
	   Thread t1= new Thread("car1");
	   Thread t3=new Thread("car2");
	   t1.start();
	   t3.start();
      JFrame frame = new JFrame();

      final MoveableShape shape
            = new CarShape(0, 0, CAR_WIDTH);
      Thread.sleep(100);
      final MoveableShape shape2
      = new CarShape(0, 0, CAR_WIDTH);
      Thread.sleep(100);
      ShapeIcon icon = new ShapeIcon(shape,
            ICON_WIDTH, ICON_HEIGHT);
      ShapeIcon icon2 = new ShapeIcon(shape2,
              ICON_WIDTH, ICON_HEIGHT);


      final JLabel label = new JLabel(icon);
      final JLabel label2 = new JLabel(icon2);
      frame.setLayout(new FlowLayout());
      frame.setSize(400,400);
      frame.add(label);
      frame.add(label2);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);

      final int DELAY = 100;
      final int DELAY2 = 50;
      // Milliseconds between timer ticks
      Timer t = new Timer(DELAY, event ->
         {
            shape.move();
           
            label.repaint();
           
         });
      Timer t2= new Timer(DELAY2,event -> {
    	  shape2.move();
    	  label2.repaint();
      });
      t.start();
      t2.start();
   }

   private static final int ICON_WIDTH = 400;
   private static final int ICON_HEIGHT = 100;
   private static final int CAR_WIDTH = 100;
}
