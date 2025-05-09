package Engine.Main;

import java.awt.*;
import javax.swing.*;

import Game.GameManager;

public class Panel2D extends JPanel implements Runnable {
    int FPS = 60;
    Thread gameThread;

    double drawInterval = 1000000000/FPS , delta = 0;
    long lastTime = System.nanoTime(), timer = 0, currentTime;
    int drawCount = 0;

    GameManager GM = new GameManager();

    Panel2D(){
        this.setBackground(Color.black);
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {
        GameManager.init();

        while(gameThread != null){
            if(DeltaTime()){
                update();
                repaint();
                delta--; drawCount++;}
            //ShowFPS();
        }
    }
    
    public void update(){
        GameManager.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D)g;
        
        GameManager.draw(g2D);
        g2D.dispose();
    }

    public boolean DeltaTime(){
        currentTime = System.nanoTime();
        delta += (currentTime - lastTime) / drawInterval;
        timer += (currentTime - lastTime);
        lastTime = currentTime;
        return delta >= 1; 
    }

    public void ShowFPS(){
        if(timer >= 1000000000){
            System.out.println("H\033[2J");
            System.out.flush();
            System.out.println("FPS: " + drawCount);
            drawCount = 0; timer = 0;}
    }
}
