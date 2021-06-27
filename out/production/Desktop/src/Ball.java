
import java.awt.*;
import java.util.List;

public class Ball extends Thread{
	private  int x,y,width,oldwidth;
	private int id;
	private Color color;
	private Level level;
	private int touch;
	public Ball(int id, int x,int y,int width,Color color, Level l){
		this.id = id;
		this.x=x;
		this.y=y;
		this.touch = -1;
		this.width=width;
		this.oldwidth = width;
		this.color=color;
		this.level=l;
	}
	
	public void draw(Graphics g){
		g.setColor(color);
		g.fillOval(x-width/2,y-width/2,width,width);
	}
	public void run(){
		int dirx=1,diry=1;
		while (true)
		{
			int h=level.getHeight();
			int w=level.getWidth();
				
			if (x + width/2  > w)
					dirx = -1;
				
			if (x-width/2  < 0)
					dirx = 1;
				
			if (y + width/2  > h)
					diry = -1;
				
			if (y -width/2 < 0)
					diry = 1;
				
			x+=dirx;
			y+=diry;

			List<Ball> balls = level.getBallinlevel();
			for (int i = 0; i < balls.size(); i++) {
				if (balls.get(i) != this)
				if( distance(x-balls.get(i).x,y-balls.get(i).y)<=width/2+balls.get(i).width/2)
				{
					if(this.touch == -1) {
						touch = i;
						balls.get(i).touch = id;
						//balls[i].touch = id;
						dirx *= -1;
						diry *= -1;
						this.width = 1;
						balls.get(i).width =1;
						//balls[i].width =1;
					}
				}
				else if(touch == i)
				{
					this.width = this.oldwidth;
					balls.get(i).width = balls.get(i).oldwidth;
					//balls[i].width = balls[i].oldwidth;
					touch = -1;
					balls.get(i).touch = -1;
					//balls[i].touch = -1;
				}

			}

			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				System.out.println("peog");
				e.printStackTrace();
			}
			 level.getPanel().repaint();
			}
	}
	public  double distance(int a,int b){
		return Math.sqrt(Math.pow(a,2.0)+Math.pow(b,2.0));
	}
	
}
