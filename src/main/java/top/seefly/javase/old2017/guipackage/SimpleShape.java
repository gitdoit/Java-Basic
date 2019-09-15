package top.seefly.javase.old2017.guipackage;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class SimpleShape {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				JFrame f = new DrawFrame();
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setTitle("图形");
				f.setVisible(true);
				f.setLocationRelativeTo(null);//设置居中
			}
		});

	}

}

class DrawFrame extends JFrame{
	public DrawFrame(){
		add(new DrawComponent());
		pack();
	}
}

class DrawComponent extends JComponent{
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 400;
	
	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		double leftx = 100;
		double topy = 100;
		double width = 200;
		double height = 150;
		//画一个矩形，长200，高150，距离画布顶部100，左边100
		Rectangle2D rect = new Rectangle2D.Double(leftx,topy,width,height);
		g2.draw(rect);
		//画一个矩形的内接椭圆
		Ellipse2D ellipse = new Ellipse2D.Double();
		ellipse.setFrame(rect);//椭圆内接与矩形
		g2.draw(ellipse);
		
		//画一条线
		Point2D  p1 = new Point2D.Double(leftx,topy);//先确定线的起点和终点
		Point2D p2 = new Point2D.Double(leftx+width,topy+height);
		g2.draw(new Line2D.Double(p1,p2));//新建一条线，参数传进去
		
		//画一个椭圆
		Ellipse2D cicle = new Ellipse2D.Double();
		cicle.setFrameFromCenter(rect.getCenterX(),rect.getCenterY(),rect.getCenterX()+150,rect.getCenterY()+150);
		g2.draw(cicle);
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
}