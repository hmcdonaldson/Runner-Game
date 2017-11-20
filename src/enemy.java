import edu.princeton.cs.introcs.StdDraw;

public class enemy {

    private double xPosition;
    private double yPosition;
    private final double rate =0.02;
    private boolean up;
    private static String monster = "monster.png";


    public enemy(double x, double y){

        xPosition = x;
        yPosition =  y;

    }

    public double getxPosition(){
        return xPosition;
    }

    public double getyPosition(){
        return yPosition;
    }

    public void  drawEnemy(){
        StdDraw.picture(getxPosition(), getyPosition(), monster);
    }

    public void resetEnemy(){
        yPosition = Math.random();
        xPosition = 1;
    }

    public void moveLeft(){
        if(xPosition > 0.1 ){
            xPosition -= 0.01;
        }
        else {
            xPosition = 1;
            yPosition = randomNum();
        }
        drawEnemy();
    }

    public static double randomNum(){
        double max = .9;
        double min = .2;
       double a = Math.random()*(max - min) + min;
        return a;
    }

}
