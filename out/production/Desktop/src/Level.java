import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Level{
    List<Ball> ballinlevel;
    int width;
    int height;
    GamePanel panel;
    public Level(int width, int height,GamePanel p,int balltostart)
    {
        ballinlevel = new ArrayList<>();
        Random rand = new Random();
        this.height = height;
        this.width = width;
        this.panel = p;
        for (int i = 0; i < balltostart; i++) {
              ballinlevel.add(new Ball(i,width/2+(i-1)*100,height/2,50,Color.red ,this));
              ballinlevel.get(i).start();

        }

    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public GamePanel getPanel() {
        return panel;
    }
    public List<Ball> getBallinlevel() {
        return ballinlevel;
    }
}
