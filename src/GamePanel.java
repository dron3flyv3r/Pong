import java.awt.*;
import java.awt.event.*;

import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{

    //make a static verbile to use all around the code and classes
    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    static final int BALL_DIMETER = 20;
    static final int PADDEL_WIDTH = 25;
    static final int PADDEL_HEIGHT = 100;

    //Defines what what code mens  
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddel paddel1;
    Paddel paddel2;
    Ball ball;
    Score score;

    //making a simple panel to run the game in and sent the keyPressed to my Key listener
    GamePanel(){
        newPaddles();
        newBall();
        score = new Score(GAME_WIDTH,GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();

    }
    //generate a new ball
    public void newBall() {

        random = new Random();
        ball = new Ball((GAME_WIDTH/2) - (BALL_DIMETER/2), random.nextInt(GAME_HEIGHT-BALL_DIMETER), BALL_DIMETER, BALL_DIMETER);

    }
    //generate the players
    public void newPaddles() {

        paddel1 = new Paddel(0,(GAME_HEIGHT/2)-(PADDEL_HEIGHT/2),PADDEL_WIDTH,PADDEL_HEIGHT,1);
        paddel2 = new Paddel(GAME_WIDTH - PADDEL_WIDTH, (GAME_HEIGHT/2)-(PADDEL_HEIGHT/2),PADDEL_WIDTH,PADDEL_HEIGHT,2);

    }

    public void paint(Graphics g) {

        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
        
    }
    //draw the things that need to show on the frame
    public void draw(Graphics g) {
        
        paddel1.draw(g);
        paddel2.draw(g);
        ball.draw(g);
        score.draw(g);

    }

    //calls the now move positions
    public void move() {
        paddel1.move();
        paddel2.move();
        ball.move();
    }

    //check if the player ball is some specific place 
    public void checkCollision() {

        //limets the ball
         if (ball.y <= 0) {
            ball.setYDirection(-ball.yVelocity);
        }
        if (ball.y>= GAME_HEIGHT-BALL_DIMETER) {
            ball.setYDirection(-ball.yVelocity);
         }

         //bounce ball of paddel
         if (ball.intersects(paddel1)) {
             ball.xVelocity = Math.abs(ball.xVelocity);
             ball.xVelocity++; // for more speed
         
         if (ball.yVelocity>0){
                ball.yVelocity++; // for more speed of wall
         } else{
             ball.yVelocity--;
         }
         ball.setXDirection(ball.xVelocity);
         ball.setYDirection(ball.yVelocity);
        }
         if (ball.intersects(paddel2)) {
             ball.xVelocity = Math.abs(ball.xVelocity);
             ball.xVelocity++; // for more speed
         
         if (ball.yVelocity>0){
                ball.yVelocity++; // for more speed of wall
         } else{
             ball.yVelocity--;
         }
         ball.setXDirection(-ball.xVelocity);
         ball.setYDirection(ball.yVelocity);
        }


        //limets the paddels
        if (paddel1.y<=0) {
            paddel1.y=0;
        }
        if (paddel1.y>=GAME_HEIGHT-PADDEL_HEIGHT) {
            paddel1.y = GAME_HEIGHT-PADDEL_HEIGHT;
        }
        if (paddel2.y<=0) {
            paddel2.y=0;
        }
        if (paddel2.y>=GAME_HEIGHT-PADDEL_HEIGHT) {
            paddel2.y = GAME_HEIGHT-PADDEL_HEIGHT;
        }

        //give a player 1 point and generate new ball

        if (ball.x <=0) {
            score.player2++;
            newPaddles();
            newBall();
            System.out.println("player 2 has "+score.player2);
        }
        if (ball.x >= GAME_WIDTH-BALL_DIMETER) {
            score.player1++;
            newPaddles();
            newBall();
            System.out.println("player 1 has "+score.player1);
        } 
        
    }

    //the engine that call and run the games
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            if (delta >= 1) {
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }        
    }

    //check if i press a button and sendt that to the players
    public class AL  extends KeyAdapter{

        public void keyPressed(KeyEvent e) {
            paddel1.keyPressed(e);
            paddel2.keyPressed(e);
            
        }
        public void keyReleased(KeyEvent e) {

            paddel1.keyReleased(e);
            paddel2.keyReleased(e);

        }
    }
}