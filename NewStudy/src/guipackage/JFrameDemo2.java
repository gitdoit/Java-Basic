package guipackage;
import java.awt.*;
import java.awt.image.ImageObserver;

import javax.swing.*;

public class JFrameDemo2 {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				JFrame frame = new NotWordsFrame();
				frame.setTitle("Hello");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}

class NotWordsFrame extends JFrame{
	public NotWordsFrame(){
		this.add(new NotWordsComponent());
		//this.setSize(300,500);
		pack();//此方法是window类中的，它会调用子组件中的getPreferredSize方法，通过其返回参数确定此组件的大小
		
	}
}

class NotWordsComponent extends JComponent{
	

	@Override
	public void paintComponent(Graphics g){//覆盖这个方法来描绘自己的组件，就相当父类中的构造方法。 
		g.drawString("Hello world!", 75, 100);
		g.drawImage(new ImageIcon("d:\\yy.png").getImage(), 55, 50, new JLabel("ddd"));
	}
	@Override
	public Dimension getPreferredSize(){//为了配合pack()表演
		return new Dimension(300,150);
	}
}