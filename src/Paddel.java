import java.awt.*;
import java.awt.event.*;

public class Paddel extends Rectangle{

    int id;
    int yVelocity;
    int speed = 12;

    Paddel(int x, int y, int PADDEL_WIDTH, int PADDEL_HEIGHT, int id){
        super(x,y,PADDEL_WIDTH,PADDEL_HEIGHT);
        this.id = id;
    }
    
    //simple move constructor that move by pixels define on speed
    public void keyPressed(KeyEvent e) {

        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W){
                    setYDirection(-speed);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_S){
                    setYDirection(speed);
                    move();
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    setYDirection(-speed);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    setYDirection(speed);
                    move();
                }
                break;
                }
        
    }

    //check what button that is pressed and the update the position of the players
    public void keyReleased(KeyEvent e) {

        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W){
                    setYDirection(0);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_S){
                    setYDirection(0);
                    move();
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    setYDirection(0);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    setYDirection(0);
                    move();
                }
                break;
                }
        
    }
    public void setYDirection(int YDirection) {
        yVelocity = YDirection;
    }
    public void move() {
        y = y + yVelocity; 
    }

    //just colors the paddels aka players
    public void draw(Graphics g) {
        if (id == 1) {
            g.setColor(Color.white);
        }
        else{
            g.setColor(Color.white);
        }
        g.fillRect(x, y, width, height);
    }
    
}
