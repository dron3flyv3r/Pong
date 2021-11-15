import java.awt.*;
import javax.swing.*;

//                     set the code as a normal JFrame
public class GameFrame extends JFrame{
    //diffing what GamePanel is
    GamePanel panel;
// building a frame to run the panel in a frame 
    GameFrame(){
        panel = new GamePanel();
        this.add(panel);
        this.setTitle("Pong Game");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
    
}
