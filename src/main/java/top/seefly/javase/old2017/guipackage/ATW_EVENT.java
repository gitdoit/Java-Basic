package top.seefly.javase.old2017.guipackage;

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
 * 璇ョ被鐢ㄦ潵婕旂ず榧犳爣锛岄敭鐩橈紝浠ュ強Graphics鐨勭敤娉曘��
 * awt.event涓畾涔変簡榧犳爣锛屼互鍙婇敭鐩樺搷搴旀柟娉曘��
 * 娉ㄦ剰锛岃鍦↗Frame瀵硅薄涓敞鍐岀浉搴旂殑鐩戝惉鍣�
 * 1 	
 * 		public abstract class KeyAdapter extends Object implements KeyListener 
		鐩稿簲閿洏浜嬩欢鐨勭被--鐩戝惉鍣細addKeyListener(KeyListener l)
 * 		public void keyPressed(KeyEvent e) 閿洏鎸変笅
 * 		public void keyReleased(KeyEvent e) 鎸夐敭鏉惧紑
 * 		public void keyTyped(KeyEvent e) 閿叆鏌愰敭
 * 		閲嶅啓杩欎簺鏂规硶鏉ヨ揪鍒拌嚜宸辩殑鐩殑銆傚洜涓鸿绫诲疄鐜颁簡KeyListener鎺ュ彛锛屾墍浠ュ彲浠ュ皢璇ョ被鐨勫瓙绫诲疄渚�
 * 		鐩存帴鏀惧叆鍒癑Frame瀹炰緥鐨刟ddKeyListener鏂规硶涓綋浣滃弬鏁�
 * 2
 * 		public abstract class MouseMotionAdapterextends Object implements MouseMotionListener
 * 		榧犳爣绉诲姩浠ュ強榧犳爣鎷栧姩鐨勭浉搴旂被--鐩戝惉鍣╝ddMouseMotionListener(MouseMotionListener l)
 * 		public void mouseDragged(MouseEvent e) 婊氳疆鎷栧姩
 * 		public void mouseMoved(MouseEvent e)  榧犳爣绉诲姩
 * 		鍚屾牱璁板緱瑕佸悜JFrame瀹炰緥涓敞鍐岀洃鍚櫒
 * 
 * 3	鍏朵粬鍝嶅簲绫婚兘鍦╦ava.awt.event鍖呬腑鏌ョ湅
 * 
 * 4
 * 		JPanel聽涓婇�氳繃閲嶅啓public聽void聽paint(Graphics聽g)鐢荤嚎锛屽渾绛夛紝涔熷彲浠ユ坊鍔犵粍浠� 
 * 		鍙皢JPnale鐨勫疄渚嬫斁鍏Frame鐨勫疄渚嬩腑
 * 		閫氳繃浜嬩欢鐩戝惉鍝嶅簲鏂规硶浠ュ強瀵笹raphics鐨勬搷浣滐紝鍙互鍦↗Panel涓婃樉绀哄悇绉嶅浘褰紝浠ュ強鎺у埗鍥惧舰鐨勭Щ鍔ㄣ��
 * 		JPanel涓婃湁repaint鏂规硶锛屾瘡娆＄浉搴斾簨浠舵椂閫氳繃paint鏂规硶瀵笹raphics杩涜鎿嶄綔锛屽啀璋冪敤repaint鏂规硶鍙互瀹炵幇
 * 		鍚勭鍥惧舰鏁堟灉銆�
 * 
 * 5
 * 		public abstract class Graphics extends Object
 * 		鍏朵腑鐨勫悇绉嶆柟娉曞彲浠ュ疄鐜板鍥惧舰鐨勬搷浣�
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
        f.addKeyListener(p.new Controller());//娉ㄥ唽閿洏鐩戝惉鍣�
        f.addMouseMotionListener(p.new Con());//娉ㄥ唽榧犳爣绉诲姩鐩戝惉鍣�
        f.setVisible(true);
    }

}

class Panel extends JPanel {
    //Panel涓奊raphics鐨勫潗鏍囦互鍙婇暱瀹�
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
    protected void paintComponent(Graphics g) {//repaint浼氳皟鐢ㄦ鏂规硶锛屾潵閲嶇粯鍥惧舰
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fill3DRect(x, y, w, h, true);
    }

    public class Controller extends KeyAdapter {//鍐呴儴绫伙紝鐢ㄦ潵鍝嶅簲浜嬩欢鏉ユ搷鍋歅anel涓婄殑鍥惧舰

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
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

            p.repaint();//鍝嶅簲澶勭悊涔嬪悗閲嶇粯璇anel
        }

    }

    public class Con extends MouseMotionAdapter {//缁ф壙榧犳爣绉诲姩鍝嶅簲绫伙紝閲嶅啓鍏朵腑瀵归紶鏍囩Щ鍔ㄥ鐞嗙殑鏂规硶

        @Override
        public void mouseMoved(MouseEvent e) {//褰撻紶鏍囧彂鐢熺Щ鍔ㄦ椂锛岃皟鐢ㄨ鏂规硶
            x = e.getX();
            y = e.getY();
            p.repaint();//鍝嶅簲澶勭悊涔嬪悗閲嶇粯璇anel
        }

    }
}