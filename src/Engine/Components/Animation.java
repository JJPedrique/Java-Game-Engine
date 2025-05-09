package Engine.Components;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

public class Animation {
    //OnlyDrawIMg
    Image Img;
    
    //Animation
    Dictionary<String,ArrayList<Image>> Animation = new Hashtable<>();
    int i = 0, timer = 0 ; String ActualAnimationName;

    public Animation(String ImgDir){
        Img = new ImageIcon(ImgDir).getImage();
    };

    public Animation(String [] names, String[][] SpritesDir){
        for(int i = 0; i < names.length; i++){
            ArrayList<Image> newSprites = new ArrayList<>();
            for(String Spr : SpritesDir[i]){newSprites.add(new ImageIcon(Spr).getImage());}
            Animation.put(names[i],newSprites);
        }
    }

    public void DrawImage(Instance I, Graphics2D g2D){
        if(Img == null ){
            g2D.setColor(Color.MAGENTA);
            g2D.fillRect(I.x,I.y,I.width,I.height);
        }else{
            g2D.drawImage(Img, I.x, I.y, I.width, I.height, null);
        }
    }

    public void PlayAnimation(Instance I, String name, Graphics2D g2D){
        if(Animation.isEmpty() || Animation.get(name) == null ){
            g2D.setColor(Color.MAGENTA);
            g2D.fillRect(I.x,I.y,I.width,I.height);
        }else{
            if(ActualAnimationName != name){i=0; timer = 0;}

            g2D.drawImage(Animation.get(name).get(i), I.x, I.y, I.width, I.height, null);
            ActualAnimationName = name;

            if(timer > 30){i++; timer = 0;} 
            if(i>=Animation.get(name).size()){i=0;}
            timer++;
        }
    }


}
