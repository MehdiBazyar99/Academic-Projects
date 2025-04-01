
package snake;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.swing.ImageIcon;
import java.nio.file.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Board3 extends Board {
    
public Image wall; 
public int wallCount = 15;
public int[] wall_x = new int[wallCount];
public int[] wall_y = new int[wallCount];

public String[][] coordinates = new String[wallCount][2];

        
 public void loadImages() {

        ImageIcon iid = new ImageIcon("src/resources/dot.png");
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon("src/resources/apple.png");
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon("src/resources/head.png");
        head = iih.getImage();
        
        ImageIcon iis = new ImageIcon("src/resources/wall.png");
        wall = iis.getImage();
    }
 
@Override
  public void paintComponent(Graphics g) {
        super.paintComponent(g);
    try {
        readWalls(g);
    } catch (IOException ex) {
        Logger.getLogger(Board3.class.getName()).log(Level.SEVERE, null, ex);
    }
        doDrawing(g);
    }
    
      
@Override
public void checkCollision() {

        for (int z = dots; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }

        if (y[0] >= B_HEIGHT) {
            inGame = false;
        }

        if (y[0] < 0) {
            inGame = false;
        }

        if (x[0] >= B_WIDTH) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }
        
        if (!inGame) {
            timer.stop();
        }
        for(int i = 0 ; i < wallCount; i++)
        if (x[0] == wall_x[i]  && y[0] == wall_y[i])
            inGame = false;
      
    }

public void drawWall(Graphics g)
{
   for(int i=0; i<wallCount;i++) 
   {
    if(inGame)
    g.drawImage(wall, wall_x[i] , wall_y[i], this);
   }
    
}

 public  void readWalls(Graphics g) throws IOException
{
    String s = "";
    String delimiter = ",";
    Path file = Paths.get("src\\resources\\XY.txt");
    int count = 0;
    
    try 
    {
      InputStream input = new BufferedInputStream(Files.newInputStream(file));
      BufferedReader reader = new BufferedReader(new InputStreamReader(input));
      s = reader.readLine();
      while(s != null && count < wallCount)
      {
        coordinates[count] = s.split(delimiter);
          
          s = reader.readLine();
          
          wall_x[count] = Integer.parseInt(coordinates[count][0]);
          wall_y[count] = Integer.parseInt(coordinates[count][1]);
          count++;
          drawWall(g);
          
      }
    }
    catch(IOException e)
            {
             System.out.println(e);
            }
}

}
 




