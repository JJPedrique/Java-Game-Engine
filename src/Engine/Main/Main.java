package Engine.Main;

import javax.swing.*;
import Engine.Components.keyHandler;

public class Main {
    public static int WINDOWS_SIZE_X = 512;
    public static int WINDOWS_SIZE_Y = 280;

    public static void main(String[] args) {
        JFrame frame = new JFrame("GAME_v2");
        frame.setSize(WINDOWS_SIZE_X+15,WINDOWS_SIZE_Y+40);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        frame.add(new Panel2D());
        frame.addKeyListener(new keyHandler());

        frame.setVisible(true);
    }

}
