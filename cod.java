import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
// imports let me use shortened names for stuff
public class TessellationFrame extends JFrame { 
  TesPane pan=new TesPane(); // the panel which shows the tessellation
  TessellationFrame() {
    //setting up the window
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400,400);
    //adding the panel which displays the tessellation to the window
    add(pan);
    setVisible(true);
  }
  public static void main(String[] args) { // called when the program is run
    TessellationFrame f=new TessellationFrame(); //calls line 7, which creates the window
  }
}
class TesPane extends JPanel { // this is the code for rendering the tessellation
  //the array of points in each puzzle piece
  //takes format x1,y1,x2,,y2,x3,y3....
  static public final int[] p={21,60,47,60,48,69,39,68,40,80,63,80,73,78,62,70,61,60,81,60,82,37,74,37,68,45,60,37,63,23,73,30,81,29,81,0,61,0,62,10,73,18,63,20,40,20,39,8,48,9,47,0,21,0,21,29,13,30,10,23,3,23,0,37,8,45,14,37,22,37};
  public void paintComponent(Graphics graf) { // this is called whenever that component needs to be redisplayed
  //Examples: window resize, first time displayed, overlap with other window
    Graphics2D g=(Graphics2D) graf;
    //these find the dimensions of the panel
    int width=this.size().width;
    int height=this.size().height;
    for (int x=-60; x<width+60; x=x+60) { //loops through the panel horizontally to fill in with pieces
      for (int y=-60; y<height+60; y+=60) {// loops through vertically to fill in with pieces
        GeneralPath gen=new GeneralPath();
        if ((((x+120)/60)%2 + ((y+120)/60)%2)==1) { // decides if piece will be red or blue
          g.setColor(Color.RED);
        } else {
          g.setColor(Color.BLUE);
        }
        gen.moveTo(p[0]+x,p[1]+y); // sets starting point of the piece
        for (int i=2; i<p.length; i+=2) { // loops through the cordinate array
          gen.lineTo(p[i]+x,p[i+1]+y); // The line goes to each cordinate pair
        }
        gen.closePath(); // closes the shape
        g.fill(gen); // draws the shape filled in
      }
    }
  }
}
