package guipackage;

import java.awt.*;
import java.awt.geom.*;


import javax.swing.JComponent;
import javax.swing.JFrame;

public class SimpleShape {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				JFrame f = new DrawFrame();
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setTitle("ͼ��");
				f.setVisible(true);
				f.setLocationRelativeTo(null);//���þ���
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
		//��һ�����Σ���200����150�����뻭������100�����100
		Rectangle2D rect = new Rectangle2D.Double(leftx,topy,width,height);
		g2.draw(rect);
		//��һ�����ε��ڽ���Բ
		Ellipse2D ellipse = new Ellipse2D.Double();
		ellipse.setFrame(rect);//��Բ�ڽ������
		g2.draw(ellipse);
		
		//��һ����
		Point2D  p1 = new Point2D.Double(leftx,topy);//��ȷ���ߵ������յ�
		Point2D p2 = new Point2D.Double(leftx+width,topy+height);
		g2.draw(new Line2D.Double(p1,p2));//�½�һ���ߣ���������ȥ
		
		//��һ����Բ
		Ellipse2D cicle = new Ellipse2D.Double();
		cicle.setFrameFromCenter(rect.getCenterX(),rect.getCenterY(),rect.getCenterX()+150,rect.getCenterY()+150);
		g2.draw(cicle);
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
}