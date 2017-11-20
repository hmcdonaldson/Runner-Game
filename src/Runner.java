import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.Out;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdIn;

import java.io.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static edu.princeton.cs.introcs.StdDraw.*;

public class Runner {
    private static boolean spaceBarPressed = false;
    private static int canvasWidth = 1400;
    private static int canvasHeight =  800;






    public static void main(String[] args) throws IOException {
        StdDraw.setCanvasSize(canvasWidth, canvasHeight);
        StdDraw.setXscale(0, 1.0);
        StdDraw.setYscale(0, 1.0);
        eagle eagle = new eagle(0.5, 0.5, true);
        double random = enemy.randomNum();
        enemy enemy = new enemy(1, random);
        enemy enemy2 = new enemy(1,random);
        background background1 = new background(.5, .5);
        background background2 = new background(1.50, .5);
        Font smallFont = new Font("Arial", Font.PLAIN, 40);
        Font font = new Font("Verdana", Font.BOLD, 70);
        Font tinyFont = new Font("Verdana", Font.PLAIN, 25 );
        int i = 0;
        boolean menu = getSpaceBarPress();

        int highscore =0;
        StdDraw.enableDoubleBuffering();

        while (true) {



                while (!menu) {


                    background1.moveLeft();
                    background2.moveLeft();
                    eagle.drawEagle();
                    StdDraw.setFont(font);
                    StdDraw.text(0.5, 0.6, "Bridgewater Eagle Run");
                    StdDraw.setFont(smallFont);
                    StdDraw.text(0.5, 0.3, "Press Space to Start");
                    StdDraw.setFont(tinyFont);
                    StdDraw.text(.87,.05, "Hunter Mcdonaldson");
                    StdDraw.setFont(smallFont);
                    StdDraw.show();
                    StdDraw.clear(WHITE);
                    pause(50);
                    if (getSpaceBarPress() == true){
                        menu = true;
                    }

                }

                    boolean collided = false;
                    In reader = new In("Highscore.txt");
                    highscore = reader.readInt();
                    if (getSpaceBarPress()) {
                        i = 0;
                        int p = 10;
                        while (!collided) {
                            collided = eagle.collision(enemy.getxPosition(), enemy.getyPosition(), enemy2.getxPosition(), enemy2.getyPosition());

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
                            if (i > 5000){
                                enemy2.moveLeft();
                            }
                            StdDraw.show();
                            StdDraw.clear(StdDraw.WHITE);
                            if (i < 10000) {
                                if (i % 1000 == 0) {
                                    p = p - 1;
                                }
                            }
                            pause(p);

                        }

                            eagle.resetEagle();
                            enemy.resetEnemy();
                            enemy2.resetEnemy();
                            StdDraw.clear();
                        background1.drawBackground();
                        background2.drawBackground();
                            String j = Integer.toString(i);
                            StdDraw.text(.5, .6, "Score: " + j);
                            StdDraw.text(.5, .5, "Game Over");
                            StdDraw.text(.5, .4, "Press Space To Play Again");
                        if(i > highscore) {
                            Out writer = new Out("Highscore.txt");
                            writer.println(i);
                            writer.close();
                            StdDraw.setFont(font);
                            StdDraw.text(.5, .7, "New High Score: " + j);
                            StdDraw.setFont(smallFont);
                        }
                        if(i <= highscore){
                            StdDraw.text(.5, .7, "High Score: " + Integer.toString(highscore));
                        }
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