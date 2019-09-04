package guipackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import testpackage.Panel;

/*
 * 该类用来演示鼠标，键盘，以及Graphics的用法。
 * awt.event中定义了鼠标，以及键盘响应方法。
 * 注意，要在JFrame对象中注册相应的监听器
 * 1 	
 * 		public abstract class KeyAdapter extends Object implements KeyListener 
		相应键盘事件的类--监听器：addKeyListener(KeyListener l)
 * 		public void keyPressed(KeyEvent e) 键盘按下
 * 		public void keyReleased(KeyEvent e) 按键松开
 * 		public void keyTyped(KeyEvent e) 键入某键
 * 		重写这些方法来达到自己的目的。因为该类实现了KeyListener接口，所以可以将该类的子类实例
 * 		直接放入到JFrame实例的addKeyListener方法中当作参数
 * 2
 * 		public abstract class MouseMotionAdapterextends Object implements MouseMotionListener
 * 		鼠标移动以及鼠标拖动的相应类--监听器addMouseMotionListener(MouseMotionListener l)
 * 		public void mouseDragged(MouseEvent e) 滚轮拖动
 * 		public void mouseMoved(MouseEvent e)  鼠标移动
 * 		同样记得要向JFrame实例中注册监听器
 * 
 * 3	其他响应类都在java.awt.event包中查看
 * 
 * 4
 * 		JPanel 上通过重写public void paint(Graphics g)画线，圆等，也可以添加组件 
 * 		可将JPnale的实例放入JFrame的实例中
 * 		通过事件监听响应方法以及对Graphics的操作，可以在JPanel上显示各种图形，以及控制图形的移动。
 * 		JPanel上有repaint方法，每次相应事件时通过paint方法对Graphics进行操作，再调用repaint方法可以实现
 * 		各种图形效果。
 * 
 * 5
 * 		public abstract class Graphics extends Object
 * 		其中的各种方法可以实现对图形的操作
 * 		
 * */
public class ATW_EVENT {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		Panel p = new Panel();
		f.setTitle("ceshi");
		f.setSize(300, 300);
		f.setLocation(800, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(p);
		f.addKeyListener(p.new Controller());//注册键盘监听器
		f.addMouseMotionListener(p.new Con());//注册鼠标移动监听器
		f.setVisible(true);
	}

}

class Panel extends JPanel{
	//Panel上Graphics的坐标以及长宽
	private final int w = 20;
	private final int h = 20;
	private int x = 0;
	private int y = 0;
	Panel p;
	
	public Panel() {
		//this.setBackground(Color.red);
		p = this;
	}
	
	@Override
	protected void paintComponent(Graphics g) {//repaint会调用此方法，来重绘图形
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fill3DRect(x, y, w, h, true);
	}
	public class Controller extends KeyAdapter{//内部类，用来响应事件来操做Panel上的图形
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_UP:
				y--;
				break;
			case KeyEvent.VK_DOWN:
				y++;
				break;
			case KeyEvent.VK_LEFT:
				x--;
				break;
			case KeyEvent.VK_RIGHT:
				x++;
				break;
			}
			
			p.repaint();//响应处理之后重绘该Panel
		}
		
	}
	public class Con extends MouseMotionAdapter{//继承鼠标移动响应类，重写其中对鼠标移动处理的方法
		@Override
		public void mouseMoved(MouseEvent e) {//当鼠标发生移动时，调用该方法
			x = e.getX();
			y = e.getY();
			p.repaint();//响应处理之后重绘该Panel
		}
		
	}
}