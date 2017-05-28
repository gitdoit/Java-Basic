package guipackage;

import java.awt.*;

import javax.swing.*;

public class JFrameDemo1 {
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				SimpleFrame frame = new SimpleFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				
				frame.setVisible(true);
				frame.setResizable(false);
				//frame.setAlwaysOnTop(true);
				//frame.setBounds(500, 300, 100, 100);
			}
		});
		
	}
}

class SimpleFrame extends JFrame{
	public SimpleFrame(){
		this.setLocationByPlatform(true);
		Toolkit kit = Toolkit.getDefaultToolkit();//Toolkit是一个抽象类，其中的静态方法会返回一个默认的工具箱实例
		Dimension screenSize = kit.getScreenSize();//通过工具箱返回一个Dimension实例。
		this.setSize(screenSize.width/2,screenSize.height/2);
		Image img = new ImageIcon("d:\\yy.png").getImage();
		setIconImage(img);
		
		
	}
}
