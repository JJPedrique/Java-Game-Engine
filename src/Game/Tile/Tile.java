package Game.Tile;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import Engine.Components.*;

public class Tile extends Instance{
    Image img;

    public Tile(int x, int y, int w, int h, Image img){
        super(x, y, w, h);  
        if(img != null){this.img = img;}
        if(img == null){collider = new Collision(this, 1);}
    }

    public void update(){
    }

    public void draw(Graphics2D g2D){
        if(img != null){
            g2D.drawImage(img, x, y, width, height, null);
        }else{
            g2D.setPaint(Color.BLACK);
            g2D.fillRect(x, y, width, height);
        }
    }
}
