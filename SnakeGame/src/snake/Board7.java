package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Timer;
import javax.swing.event.MouseInputListener;

import com.sun.java.swing.plaf.windows.resources.windows;

import snake.Board.TAdapter;

public class Board7 extends Board3_2 implements MouseInputListener{

	@Override
	public void mouseClicked(MouseEvent e) {
	
    x[0] = e.getX();
    y[0] = e.getY();
    

	}

	@Override
	public void mousePressed(MouseEvent e) {
	
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
    public void initBoard() {

        addKeyListener(new TAdapter());
        addMouseListener(this);
      
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        initGame();
    }


    public void initGame() {

        dots = 3;

        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }

        locateApple();

        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    
}
