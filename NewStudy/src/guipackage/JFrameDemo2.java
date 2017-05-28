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
		pack();//�˷�����window���еģ��������������е�getPreferredSize������ͨ���䷵�ز���ȷ��������Ĵ�С
		
	}
}

class NotWordsComponent extends JComponent{
	

	@Override
	public void paintComponent(Graphics g){//�����������������Լ�����������൱�����еĹ��췽���� 
		g.drawString("Hello world!", 75, 100);
		g.drawImage(new ImageIcon("d:\\yy.png").getImage(), 55, 50, new JLabel("ddd"));
	}
	@Override
	public Dimension getPreferredSize(){//Ϊ�����pack()����
		return new Dimension(300,150);
	}
}