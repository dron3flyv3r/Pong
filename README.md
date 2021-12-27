# Welcome to my Pong pages

this code is not made by me, or i have I have written the code, but I follow a tutorial made by [Bro Code](https://www.youtube.com/watch?v=oLirZqJFKPE), so give him a follow and a like for me.

## How to run
1. download the [code](https://github.com/dron3flyv3r/Pong)
2. Click on the **Pong.jar** and have fun


## How the code works

The games code is very simple, the "game engien" if you even can call it that is this
```engien
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
                delta--;
            }
        repaint();
        }        
    }
```
The engine is ran by a threat, with is like a sub program the run side by the main threat. The enginen is very usefull for small game and I have used it a lot for my oder programe.

## Made by
this code is made by [Bro Code](https://www.youtube.com/watch?v=oLirZqJFKPE) and written by [dron3flyv3r](https://github.com/dron3flyv3r)
