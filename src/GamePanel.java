
import java.awt.*;
import java.util.List;
import javax.swing.*;

public class GamePanel extends JPanel{
	int width;
	int height;
	Image background;
	Level level1;
	public GamePanel(int width, int height){
		this.width = width;
		this.height = height;;
		ImageIcon icon = new ImageIcon(this.getClass().getResource("Background.jpg"));
		background = icon.getImage();
		level1 =new Level(width,height,this,1);
		//setBackground(Color.white);
	}



	public void paintComponent(Graphics g){
	    super.paintComponent(g);
	    g.drawImage(background,width,height,null);
	    List<Ball> balls =  level1.getBallinlevel();
		for (int i = 0; i <balls.size() ; i++) {
			balls.get(i).draw(g);
		}
	}

	public static void main(String[] args) {
		JFrame f=new JFrame("Ping Pong Balls by Mario (c)");
		GamePanel bp=new GamePanel(500,620);
		f.add(bp);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500,620);
		f.setResizable(false);
		f.setVisible(true);	
	}

}
