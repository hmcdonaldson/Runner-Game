import edu.princeton.cs.introcs.StdDraw;
import java.awt.Image;

public class background {

    private double xPosition;
    private double yPosition;
    private static String background = "background.png";

    public background(double x, double y){
        xPosition = x;
        yPosition = y;
    }
    public double getxPosition(){
        return xPosition;
    }

    public double getyPosition(){
        return yPosition;
    }

    public void  drawBackground(){
        StdDraw.picture(getxPosition(), getyPosition(), background);
    }

    public void moveLeft(){
        if(xPosition > -.49 ){
            xPosition -= 0.01;
        }
        else {
            xPosition = 1.5;
        }
        drawBackground();
    }




}
