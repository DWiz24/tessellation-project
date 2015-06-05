import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class TessellationFrame extends JFrame {
  TesPane pan=new TesPane();
  TessellationFrame() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400,400);
    add(pan);
    setVisible(true);
  }
  public static void main(String[] args) {
    TessellationFrame f=new TessellationFrame();
  }
}
class TesPane extends JPanel {
  static public final int[] p={21,60,47,60,48,69,39,68,40,80,63,80,73,78,62,70,61,60,81,60,82,37,74,37,68,45,60,37,63,23,73,30,81,29,81,0,61,0,62,10,73,18,63,20,40,20,39,8,48,9,47,0,21,0,21,29,13,30,10,23,3,23,0,37,8,45,14,37,22,37};
  public void paintComponent(Graphics graf) {
    Graphics2D g=(Graphics2D) graf;
    int width=this.size().width;
    int height=this.size().height;
    for (int x=-60; x<width; x=x+60) {
      for (int y=-60; y<height; y+=60) {
        GeneralPath gen=new GeneralPath();
        if ((((x+120)/60)%2 + ((y+120)/60)%2)==1) {
          g.setColor(Color.RED);
        } else {
          g.setColor(Color.BLUE);
        }
        gen.moveTo(p[0]+x,p[1]+y);
        for (int i=2; i<p.length; i+=2) {
          gen.lineTo(p[i]+x,p[i+1]+y);
        }
        gen.closePath();
        g.fill(gen);
      }
    }
  }
}
