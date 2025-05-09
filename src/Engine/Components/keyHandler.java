package Engine.Components;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyHandler implements KeyListener {

    public static enum Phase {Typed, Pressed, Released}
    public static Phase up, down, left, right,//ASWD
                 space;//SPACE

    @Override
    public void keyTyped(KeyEvent e){
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W){up=Phase.Typed;}
        if(key == KeyEvent.VK_S){down=Phase.Typed;}
        if(key == KeyEvent.VK_A){left=Phase.Typed;}
        if(key == KeyEvent.VK_D){right=Phase.Typed;}

        if(key == KeyEvent.VK_SPACE){space=Phase.Typed;}
    }

    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W){up=Phase.Pressed;}
        if(key == KeyEvent.VK_S){down=Phase.Pressed;}
        if(key == KeyEvent.VK_A){left=Phase.Pressed;}
        if(key == KeyEvent.VK_D){right=Phase.Pressed;}

        if(key == KeyEvent.VK_SPACE){space=Phase.Pressed;}
    }

    @Override
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W){up=Phase.Released;}
        if(key == KeyEvent.VK_S){down=Phase.Released;}
        if(key == KeyEvent.VK_A){left=Phase.Released;}
        if(key == KeyEvent.VK_D){right=Phase.Released;}

        if(key == KeyEvent.VK_SPACE){space=Phase.Released;}

    }


}