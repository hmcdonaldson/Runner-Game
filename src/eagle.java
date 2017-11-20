import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.Draw;

public class eagle {
    private double xPosition;
    private double yPosition;
    private double topPostion = 0.9;
    private double bottomPostion = 0.1;
    private final double upRate =0.02;
    private boolean up;
    private static String eagleUp = "eagleUp.png";
    private static String eagleDown = "eagleDown.png";

    public eagle(double x, double y, boolean upPosition){

        xPosition = x;
        yPosition =  y;
        up = upPosition;

    }

    public double getxPosition(){
        return xPosition;
    }

    public double getyPosition(){
        return yPosition;
    }

    public String getEagleFile(){
        if(up){
            up =!up;
            return eagleDown;
        }else{
            up = !up;
            return eagleUp;
        }
    }

    public void moveUp(){
        if(yPosition < 0.94 ){
            yPosition += 0.01;
        }
        drawEagle();
    }


    public void  drawEagle(){
        StdDraw.picture(getxPosition(), getyPosition(), getEagleFile());

    }

    public void moveDown(){
        if(yPosition > 0.0 ){
            yPosition -= 0.01;
        }
        drawEagle();
    }

    public void resetEagle(){
        yPosition = .5;
    }

    public boolean collisionX(double enemyX) {
        double r = .09;
        return (Math.abs(xPosition - enemyX) < r);
    }

    public boolean collisionY(double enemyY){
        double a = .2;
        double b = .17;
        return (yPosition > enemyY - a &&  yPosition < enemyY + b);
    }

    public boolean collisionG(){
        double g = .13;
        return (yPosition < g);
    }

    public boolean collisionC(){
        double c = .94;
        return (yPosition > c);
    }

    public boolean collision(double enemyX, double enemyY, double enemy2X, double enemy2Y) {
        boolean collided = false;
        if (collisionX(enemyX) == true && collisionY(enemyY) == true){
            collided = true;
        }
        if(collisionX(enemy2X) == true && collisionY(enemy2Y) == true){
            collided = true;
        }
        if(collisionG() == true){
            collided = true;
        }
        if(collisionC() == true){
            collided = true;
        }
        return collided;
    }

}