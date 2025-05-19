package dyc;

import java.io.FileNotFoundException;

import javax.swing.JFrame;

public class DyCFrame {
  public static void main(String[] args) throws FileNotFoundException {
    int w = 600;
    int h = 500;
    JFrame frame = new JFrame("Design Your Character");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new DyCPanel(w, h));
    frame.pack();
    frame.setVisible(true);
  }
}
