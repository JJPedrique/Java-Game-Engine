package Game.Entity;
import java.awt.Graphics2D;
import Engine.Components.*;
import Game.GameManager;
import Game.Tile.Tile;

public class Player extends Instance {
    public boolean LoR = true;
    int speed = 5;
    int Voy = 0,  gravity = 9, jump = 22;

    public String AnimationName[] = {"Left","Right"};
    public String AnimationImgDir[][] ={{"res/Texture/Knight/Left/Left1.png","res/Texture/Knight/Left/Left2.png"},
                                        {"res/Texture/Knight/Right/Right1.png","res/Texture/Knight/Right/Right2.png"}};
    
    public Player(int x, int y, int w, int h){
        super(x, y, w, h);  
        collider = new Collision(this, 0.75);
        animator = new Animation(AnimationName,AnimationImgDir);
    }
    
    public void update(){
        //Physics non physics
        if(keyHandler.right==keyHandler.Phase.Pressed){
            x+=speed; LoR = true;}
        else if(keyHandler.left==keyHandler.Phase.Pressed){
            x-=speed; LoR = false;}
        if(collider.isGrounded && keyHandler.space==keyHandler.Phase.Pressed){Voy=jump; collider.isGrounded = false;}
        
        collider.isGrounded = collider.isGrounded();
        y+=(gravity-Voy);
        Voy--;
        if(Voy<=0){Voy=0;}

        collider.update(this);
        for (Tile S : GameManager.Scene) {
            if(S.collider != null) {collider.CorrectPos(this,S.collider);}} 
    }

    public void draw(Graphics2D g2D){
        if(LoR){animator.PlayAnimation(this, "Right", g2D);}
        else{animator.PlayAnimation(this, "Left", g2D);}
    }
}
