import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdIn;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static edu.princeton.cs.introcs.StdDraw.*;

public class Runner {
    private static boolean spaceBarPressed = false;
    private static int canvasWidth = 1400;
    private static int canvasHeight =  800;





    public static void main(String[] args) {
        StdDraw.setCanvasSize(canvasWidth, canvasHeight);
        StdDraw.setXscale(0, 1.0);
        StdDraw.setYscale(0, 1.0);
        eagle eagle = new eagle(0.5, 0.5, true);
        double random = (double) Math.random();
        enemy enemy = new enemy(1, random);
        background background1 = new background(.5, .5);
        background background2 = new background(1.50, .5);
        Font font = new Font("Verdana", Font.BOLD, 70);
        StdDraw.setFont(font);
        StdDraw.text(0.5, 0.5, "Bridgewater Eagle Run");
        Font smallFont = new Font("Arial", Font.PLAIN, 40);
        StdDraw.setFont(smallFont);
        StdDraw.text(0.5, 0.3, "Press Space to start");
        int i = 0;
        StdDraw.enableDoubleBuffering();


        while (true) {
            boolean collided = false;
            if (getSpaceBarPress()) {
                i = 0;
                int p = 15;
                while (!collided) {
                    collided = eagle.collision(enemy.getxPosition(), enemy.getyPosition());

                    background1.moveLeft();
                    background2.moveLeft();
                    if (getSpaceBarPress()) {
                        eagle.moveUp();


                    } else {
                        eagle.moveDown();

                    }

                    i = i + 1;
                    String j = Integer.toString(i);
                    StdDraw.text(.5, .9, j);
                    enemy.moveLeft();
                    StdDraw.show();
                    StdDraw.clear(StdDraw.WHITE);
                    if (i < 15000) {
                        if (i % 1000 == 0) {
                            p = p - 1;
                        }
                    }
                    pause(p);





                }
                eagle.resetEagle();
                enemy.resetEnemy();
                StdDraw.clear(StdDraw.PRINCETON_ORANGE);
                String j = Integer.toString(i);
                StdDraw.text(.5, .6, "Score: " + j);
                StdDraw.text(.5, .5, "Game Over");
                StdDraw.text(.5, .4, "Press Space To Start Over");
                StdDraw.show();
                pause(300);

            }
        }

    }



    /**
     * These methods fired when a key is pressed don't worry about them for now.
     */

    public static boolean getSpaceBarPress(){
        if(Runner.spaceBarPressed  || StdDraw.isKeyPressed(KeyEvent.VK_SPACE)){
            Runner.spaceBarPressed  = false;
            return true;
        }
        return false;
    }

}