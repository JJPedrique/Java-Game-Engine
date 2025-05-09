package Engine.Components;
import java.awt.Graphics2D;

public abstract class Instance {
    //Transform
    public int x=0,y=0;
    public int width = 32, height =32;

    //Components
    public Collision collider;
    public Animation animator;
    public Sound sounder;

    public Instance(int x, int y, int w, int h){
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;    
    }

    public void update(){}
    public void draw(Graphics2D g2D){}
}
