package Game;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Engine.Components.Sound;
import Engine.Main.*;
import Game.Entity.Enemy;
import Game.Entity.Player;
import Game.Tile.Tile;

public class GameManager {

    public static ArrayList<Tile> Scene = new ArrayList<>();    
    public static Player myPlayer = new Player(0,100,32,32);
    public static Enemy myEnemy = new Enemy(250,100,32,32);

    public static void init(){
        System.out.println("Hello World");
        Scene.add(new Tile(0,64,Main.WINDOWS_SIZE_X,Main.WINDOWS_SIZE_Y-96,new ImageIcon("res/Texture/villagething.png").getImage()));
        Scene.add(new Tile(0,Main.WINDOWS_SIZE_Y-32, Main.WINDOWS_SIZE_X, Main.WINDOWS_SIZE_Y-32, null));        
        Scene.add(new Tile(100,175, 100, 20, null));
        Scene.add(new Tile(200,125, 100, 20, null));
        Scene.add(new Tile(300,175, 100, 20, null));


        String[] name = {"BG"};
        String[] URL = {"res/Sound/Background.wav"};
        Sound SoundManager = new Sound(name,URL);
        SoundManager.loop("BG");
    }

    public static void update() {
        //Background
        //Enemigos y Bosses
        //Jugador
        myEnemy.update();
        myPlayer.update();
        //UI

    }

    public static void draw(Graphics2D g2d) {
        //Background
        for(Tile S: Scene){S.draw(g2d);}
        //Enemigos y Bosses
        //Jugador
        myEnemy.draw(g2d);
        myPlayer.draw(g2d);
        //UI
    }
    
}
