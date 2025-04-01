
package snake;


public class Board1 extends Board {
    public void checkCollision() {

        for (int z = dots; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = true;
            }
        }

        if (y[0] >= B_HEIGHT) {
            inGame = true;
            y[0] = 0;
        }

        if (y[0] < 0) {
            inGame = true;
            y[0] = B_HEIGHT;
        }

        if (x[0] >= B_WIDTH) {
            inGame = true;
            x[0] = 0;
        }

        if (x[0] < 0) {
            inGame = true;
            x[0] = B_WIDTH;
        }
        
        if (!inGame) {
            timer.stop();
        }
    }
}
