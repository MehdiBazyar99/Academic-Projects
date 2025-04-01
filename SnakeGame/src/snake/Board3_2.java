
package snake;

import java.awt.Graphics;
import java.util.Random;

 


public class Board3_2 extends Board3 {
    public boolean wallsCreated = false;
    public int wallCount = 50;
    public int[] wall_x = new int[wallCount];
    public int[] wall_y = new int[wallCount];
    

    
    public void checkApple() {

        if ((x[0] == apple_x) && (y[0] == apple_y)) {

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

    public void drawWall(Graphics g)
{
   for(int i=0; i<wallCount;i++) 
   {
    if(inGame)
    g.drawImage(wall, wall_x[i] , wall_y[i], this);
   }
    
}
 
     public  void readWalls(Graphics g) 
{
 
  if(wallsCreated == false)
  {
    for(int i=0; i < wallCount; i++)
    {
     Random random = new Random();
    int x = random.nextInt(400);
    int y = random.nextInt(400);
    int xLen = Integer.toString(x).length();
    char xFN = Integer.toString(x).charAt(xLen-1);
    x = x - Character.getNumericValue(xFN);
    
    int yLen = Integer.toString(y).length();
    char yFN = Integer.toString(y).charAt(yLen-1);
    y = y - Character.getNumericValue(yFN);
    
    wall_x[i]=x;
    wall_y[i]=y;  
 
    }
    wallsCreated = true; 
    int j = 0;
    int k = 0;
       Random random2 = new Random();
      while(j<20){
             int doubleWall = random2.nextInt(wallCount-1);
             wall_x[doubleWall] = wall_x[doubleWall+1];
             wall_y[doubleWall] = wall_y[doubleWall+1]+10;
             wall_y[doubleWall] = wall_y[doubleWall+1]+20;
             j++;
      }
     while(k<20){
             int doubleWall = random2.nextInt(wallCount-1);
             wall_y[doubleWall] = wall_y[doubleWall+1];
             wall_x[doubleWall] = wall_x[doubleWall+1]-10;
             k++;
      }
  }
    drawWall(g);
}
     

}
    

