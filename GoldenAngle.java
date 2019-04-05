import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/*------------------------------------------------------
 * Aryaman Majumdar
 * 25th November, 2017
 * Simulates golden angle blooms
 ----------------------------------------------------*/
public class GoldenAngle extends JPanel implements ActionListener{
	
	double theta = 0;
	double b = Math.PI*(3.0 - Math.sqrt(5.0));
	double xpos;
	double ypos;
	int initialradius = 10;
	double counter=initialradius;
	int othercounter = 0;
	
	public GoldenAngle() {
		this.setBackground(Color.BLACK);
		this.setSize(1000,1000);

	}

	public static void main(String[] args) {
		int size = 1000;
		JFrame jf = new JFrame();
		jf.setTitle("Golden Angle");
		jf.setSize(size,size);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GoldenAngle ga = new GoldenAngle();
		jf.add(ga);
		jf.setVisible(true);
		
		Timer tm = new Timer(1, ga);
		tm.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}
	
	private void increase(double angleIncrease) {
		this.theta = this.theta + angleIncrease;
	}
	private void drawGoldenDot(Graphics g, double radius, double theta, Color cl, int ovalradius) {
		xpos=this.getWidth()/2 - radius*Math.sin(theta);
		ypos=this.getHeight()/2 - radius*Math.cos(theta);
		g.setColor(cl);
		g.drawOval((int)(xpos-ovalradius), (int)(ypos-ovalradius), ovalradius, ovalradius);
	}
	
	double n = 1;
	private void drawGoldenDots(Graphics g, double radius, Color cl) {
		drawGoldenDot(g, radius, this.theta, cl, 5);
		increase(n*b);
	}

	Color bubblecolor = Color.WHITE;
	double increment = 0.1;

	@Override
	public void actionPerformed(ActionEvent e) {
		
			if((counter < this.getWidth()/2) && (counter < this.getHeight()/2)) {
		        
				Graphics g = this.getGraphics();
				
				g.setColor(Color.WHITE);
				g.drawString(Double.toString(n), 10,10);
				drawGoldenDots(g,counter, bubblecolor);

				
				counter+=increment;	
			}
			
			else {
				repaint();
				counter = initialradius;
				n++;
				Random rand = new Random();
				bubblecolor = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
			}
			

	}
	
	
}