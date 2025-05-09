package Game.Entity;

import java.awt.Graphics2D;

import Engine.Components.Animation;
import Engine.Components.Collision;
import Engine.Components.Instance;
import Game.GameManager;
import Game.Tile.Tile;

public class Enemy extends Instance {
    public boolean LoR = true;
    int speed = 5, Voy = 0,  gravity = 9, jump = 22, timer = 0, jumprate = 60;

    public String AnimationName[] = {"Left","Right"};
    public String AnimationImgDir[][] ={{"res/Texture/Goblin/Left/Left1.png","res/Texture/Goblin/Left/Left2.png"},
                                        {"res/Texture/Goblin/Right/Right1.png","res/Texture/Goblin/Right/Right2.png"}};
    
    public Enemy(int x, int y, int w, int h){
        super(x, y, w, h);  
        collider = new Collision(this, 0.75);
        animator = new Animation(AnimationName,AnimationImgDir);
    }
    
    public void update(){
        if(LoR){x+=speed;}
        else{x-=speed;}
        if(collider.isLeft()){LoR = true;}
        if(collider.isRight()){LoR = false;}

        if(collider.isGrounded && timer > jumprate){Voy = jump; timer = 0;}
   
        collider.isGrounded = collider.isGrounded();
        y+=(gravity-Voy);
        Voy--; timer++;
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
