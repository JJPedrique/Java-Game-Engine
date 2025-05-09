package Engine.Components;
import java.awt.Rectangle;

import Engine.Main.*;
import Game.Entity.Player;

public class Collision {
    public Rectangle HitBox, OldHitBox;

    public boolean isEnabled = true, isTrigger = false, isGrounded = true;
    public double p = 1;
    public int Up, Down, Left, Right;

    public Collision(Instance I, double p){
        this.p = p;
        OldHitBox = new Rectangle();
        HitBox = new Rectangle(I.x + (int)(I.width*(1-p)/2), I.y + (int)(I.height*(1-p)/2), (int)(I.width*p), (int)(I.height*p));
        Up = HitBox.y; 
        Down = Up + HitBox.height;
        Left = HitBox.x;
        Right = Left + HitBox.width;
    }

    public void update(Instance I){
        OldHitBox = HitBox;

        HitBox = new Rectangle(I.x + (int)(I.width*(1-p)/2), I.y + (int)(I.height*(1-p)), (int)(I.width*p), (int)(I.height*p));
        Up = HitBox.y; 
        Down = Up + HitBox.height;
        Left = HitBox.x;
        Right = Left + HitBox.width;

        SetBorder(I);
    }

    public boolean isGrounded(){
        return Down >= Main.WINDOWS_SIZE_Y;
    } 

    public boolean isGrounded(Collision other){
        return Down > other.Up;
    }  

    public boolean OnCollision(Collision other){
        return Left < other.Right && other.Left < Right && Up < other.Down && Down > other.Up;
    }

    public boolean isLeft(){return Left <= 0;}
    public boolean isRight(){return Right >= Main.WINDOWS_SIZE_X;}



    public void SetBorder(Instance I){
        if(!isEnabled){return;}

        if(Right >= Main.WINDOWS_SIZE_X){I.x = Main.WINDOWS_SIZE_X - HitBox.width;}
        if(Left <= 0){I.x = I.x-Left;}
    
        if(Down >= Main.WINDOWS_SIZE_Y){I.y =  Main.WINDOWS_SIZE_Y - HitBox.height;}
        if(Up <= 0){I.y = I.y-Up;}
    }
  
    public void CorrectPos(Instance I, Collision other){
        if(!isEnabled || isTrigger){return;}

        int MidSizeX = HitBox.width/2 + other.HitBox.width/2;
        int MidSizeY = HitBox.height/2 + other.HitBox.height/2;

        int Prevdy = (int)Math.abs(OldHitBox.getCenterY() - other.HitBox.getCenterY());
        int PrevOverlapY = (MidSizeY-Prevdy);

        int dx = (int)Math.abs(HitBox.getCenterX() - other.HitBox.getCenterX());
        int dy = (int)Math.abs(HitBox.getCenterY() - other.HitBox.getCenterY());
        int OverlapX = (MidSizeX-dx);
        int OverlapY = (MidSizeY-dy);

        if(!OnCollision(other)){return;}

        int DisX = HitBox.x - OldHitBox.x;
        int DisY = HitBox.y - OldHitBox.y;

        if(PrevOverlapY > 0){
            if(DisX>0){I.x -= OverlapX;}
            else{I.x += OverlapX;}
        }else{
            if(DisY > 0){
                isGrounded = true;
                I.y -= OverlapY;
            }else{I.y += OverlapY;}
        }
        
        update(I);
    }
}
