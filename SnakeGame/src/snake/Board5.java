package snake;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;


public class Board5 extends Board3_2 {
    public Image portal;
    boolean portalCreated = false;
    boolean portalCrossed = false;
    int portalCount = 2;
    int[] portal_x = new int[portalCount];
    int[] portal_y = new int[portalCount];



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

        for (int i = 0; i < wallCount; i++)
            if (x[0] == wall_x[i] && y[0] == wall_y[i])
                inGame = false;

        for (int i = 0; i < portalCount; i++)
            if (wall_x[i] == portal_x[0] && wall_y[i] == portal_y[0]) {
                portalCrossed = false;
                portalCreated = false;


            }
        else if (wall_x[i] == portal_x[1] && wall_y[i] == portal_y[1]) {

            portalCrossed = false;
            portalCreated = false;

        }

        if (x[0] == portal_x[1] && y[0] == portal_y[1]) {
            x[0] = portal_x[0];
            y[0] = portal_y[0];
            portalCrossed = true;
        } else if (x[0] == portal_x[0] && y[0] == portal_y[0]) {

            x[0] = portal_x[1];
            y[0] = portal_y[1];
            portalCrossed = true;

        }
    }

    public void loadImages() {

        ImageIcon iid = new ImageIcon("src/resources/dot.png");
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon("src/resources/apple.png");
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon("src/resources/head.png");
        head = iih.getImage();

        ImageIcon iis = new ImageIcon("src/resources/wall.png");
        wall = iis.getImage();

        ImageIcon iiq = new ImageIcon("src/resources/portal.png");
        portal = iiq.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        readWalls(g);
        readPortal(g);
        doDrawing(g);
    }

    public void readPortal(Graphics g) {

        if (portalCreated == false) {
            for (int i = 0; i < portalCount; i++) {
                Random random = new Random();
                int x = random.nextInt(400);
                int y = random.nextInt(400);
                int xLen = Integer.toString(x).length();
                char xFN = Integer.toString(x).charAt(xLen - 1);
                x = x - Character.getNumericValue(xFN);

                int yLen = Integer.toString(y).length();
                char yFN = Integer.toString(y).charAt(yLen - 1);
                y = y - Character.getNumericValue(yFN);

                portal_x[i] = x;
                portal_y[i] = y;
                portalCreated = true;
            }

        }
        drawPortal(g);


    }


    public void drawPortal(Graphics g) {
        for (int i = 0; i < portalCount; i++) {
            if (inGame)
                g.drawImage(portal, portal_x[i], portal_y[i], this);
        }

        if (portalCrossed == true) {
            portalCrossed = false;
            portalCreated = false;

            readPortal(g);


        }

    }


}