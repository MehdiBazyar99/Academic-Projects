
package snake;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;


public class Board4 extends Board3_2 {
     
     public Image magicapple;
     public void loadImages() {

        ImageIcon iid = new ImageIcon("src/resources/dot.png");
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon("src/resources/apple.png");
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon("src/resources/head.png");
        head = iih.getImage();
        
        ImageIcon iis = new ImageIcon("src/resources/wall.png");
        wall = iis.getImage();
        
        ImageIcon iip = new ImageIcon("src/resources/magicapple.png");
        magicapple = iip.getImage();
    }
 
    
    
    public void checkApple() {

        if ((x[0] == apple_x) && (y[0] == apple_y)) {

            dots++;
            dots++;
            locateApple();
         for(int i = 0; i < wallCount; i++)
            {
            if(apple_x == wall_x[i] && apple_y == wall_y[i])
            {  
                locateApple();    
            }
            }
        }
    }
    @Override
     public void doDrawing(Graphics g) {
        
        if (inGame) {

            g.drawImage(magicapple, apple_x, apple_y, this);

            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this);
                } else {
                    g.drawImage(ball, x[z], y[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {

            gameOver(g);
        }        
    }
}
