package top.seefly.javase.old2017.mypraxis;

import java.util.Scanner;
import java.util.TreeSet;

/*
 * 棰樼洰鎻忚堪
瀹嬩唬鍙插瀹跺徃椹厜鍦ㄣ�婅祫娌婚�氶壌銆嬩腑鏈変竴娈佃憲鍚嶇殑鈥滃痉鎵嶈鈥濓細鈥滄槸鏁呮墠寰峰叏灏借皳涔嬪湥浜猴紝鎵嶅痉鍏间骸璋撲箣鎰氫汉锛屽痉鑳滄墠璋撲箣鍚涘瓙锛屾墠鑳滃痉璋撲箣

灏忎汉銆傚嚒鍙栦汉涔嬫湳锛岃嫙涓嶅緱鍦ｄ汉锛屽悰瀛愯�屼笌涔嬶紝涓庡叾寰楀皬浜猴紝涓嶈嫢寰楁剼浜恒�傗��

寰锋墠缁撻兘杩嘓绾匡紝涓哄痉鎵嶉兘鏈夛紝鎸夋�诲垎鎺掑簭    绗竴绫�
鎵嶄笉杩嘓锛屽痉杩囷紝涓哄痉鑳滄墠 鎸夋�诲垎鎺掑簭	   绗簩绫�
寰锋墠鍧囦笉杩嘓锛屾墠寰烽兘浜★紝鑻ュ痉楂樻墠锛屽張绉颁负寰疯儨鎵嶃�傛寜鎬诲垎 绗笁绫�
鍏朵粬杩嘗鐨勪负绗洓绫�


鐜扮粰鍑轰竴鎵硅�冪敓鐨勫痉鎵嶅垎鏁帮紝璇锋牴鎹徃椹厜鐨勭悊璁虹粰鍑哄綍鍙栨帓鍚嶃��

杈撳叆鎻忚堪:
杈撳叆绗�1琛岀粰鍑�3涓鏁存暟锛屽垎鍒负锛歂锛�<=105锛夛紝鍗宠�冪敓鎬绘暟锛汱锛�>=60锛夛紝涓哄綍鍙栨渶浣庡垎鏁扮嚎锛屽嵆寰峰垎鍜屾墠鍒嗗潎涓嶄綆浜嶭鐨勮�冪敓鎵嶆湁璧勬牸

琚�冭檻褰曞彇锛汬锛�<100锛夛紝涓轰紭鍏堝綍鍙栫嚎鈥斺�斿痉鍒嗗拰鎵嶅垎鍧囦笉浣庝簬姝ょ嚎鐨勮瀹氫箟涓衡�滄墠寰峰叏灏解�濓紝姝ょ被鑰冪敓鎸夊痉鎵嶆�诲垎浠庨珮鍒颁綆鎺掑簭锛涙墠鍒嗕笉鍒�

浣嗗痉鍒嗗埌绾跨殑涓�绫昏�冪敓灞炰簬鈥滃痉鑳滄墠鈥濓紝涔熸寜鎬诲垎鎺掑簭锛屼絾鎺掑湪绗竴绫昏�冪敓涔嬪悗锛涘痉鎵嶅垎鍧囦綆浜嶩锛屼絾鏄痉鍒嗕笉浣庝簬鎵嶅垎鐨勮�冪敓灞炰簬鈥滄墠寰峰吋

浜♀�濅絾灏氭湁鈥滃痉鑳滄墠鈥濊�咃紝鎸夋�诲垎鎺掑簭锛屼絾鎺掑湪绗簩绫昏�冪敓涔嬪悗锛涘叾浠栬揪鍒版渶浣庣嚎L鐨勮�冪敓涔熸寜鎬诲垎鎺掑簭锛屼絾鎺掑湪绗笁绫昏�冪敓涔嬪悗銆�


闅忓悗N琛岋紝姣忚缁欏嚭涓�浣嶈�冪敓鐨勪俊鎭紝鍖呮嫭锛氬噯鑰冭瘉鍙枫�佸痉鍒嗐�佹墠鍒嗭紝鍏朵腑鍑嗚�冭瘉鍙蜂负8浣嶆暣鏁帮紝寰锋墠鍒嗕负鍖洪棿[0,聽100]鍐呯殑鏁存暟銆傛暟瀛楅棿浠ョ┖鏍煎垎闅斻��


杈撳嚭鎻忚堪:
杈撳嚭绗�1琛岄鍏堢粰鍑鸿揪鍒版渶浣庡垎鏁扮嚎鐨勮�冪敓浜烘暟M锛岄殢鍚嶮琛岋紝姣忚鎸夌収杈撳叆鏍煎紡杈撳嚭涓�浣嶈�冪敓鐨勪俊鎭紝鑰冪敓鎸夎緭鍏ヤ腑璇存槑鐨勮鍒欎粠楂樺埌浣庢帓搴忋�傚綋鏌愮被鑰冪敓涓湁澶氫汉

鎬诲垎鐩稿悓鏃讹紝鎸夊叾寰峰垎闄嶅簭鎺掑垪锛涜嫢寰峰垎涔熷苟鍒楋紝鍒欐寜鍑嗚�冭瘉鍙风殑鍗囧簭杈撳嚭銆�

杈撳叆渚嬪瓙:
total	de     cai
14聽    60聽    80

10000001聽64聽90

10000002聽90聽60

10000011聽85聽80

10000003聽85聽80

10000004聽80聽85

10000005聽82聽77

10000006聽83聽76

10000007聽90聽78

10000008聽75聽79

10000009聽59聽90

10000010聽88聽45

10000012聽80聽100

10000013聽90聽99

10000014聽66聽60

杈撳嚭渚嬪瓙:
12

10000013聽90聽99

10000012聽80聽100

10000003聽85聽80

10000011聽85聽80

10000004聽80聽85

10000007聽90聽78

10000006聽83聽76

10000005聽82聽77

10000002聽90聽60

10000014聽66聽60

10000008聽75聽79

10000001聽64聽90

 */
public class Sort {//璇ョ嚎绋嬩娇鐢ㄤ簡1120KB
    
    public static byte H;
    
    public static byte L;
    
    public static void main(String[] args) throws Exception {
        Thread.currentThread().setName("gggggggggggggggggg");
        
        byte totle, de, cai;
        int id;
        TreeSet<Stu> list = new TreeSet<>();
        Scanner in = new Scanner(System.in);
        totle = in.nextByte();
        H = in.nextByte();
        L = in.nextByte();
        for (; totle > 0; totle--) {//鍒嗙粍锛屼笖鎺掑簭
            id = in.nextInt();
            de = in.nextByte();
            cai = in.nextByte();
            if (de < L || cai < L) {
                continue;
            }
            if (de >= H && cai >= H)//寰锋墠閮借繃
            {
                list.add(new Stu(id, de, cai, (byte) 1));
            } else if (de >= H && cai < H)//寰疯繃鎵嶄笉杩�
            {
                list.add(new Stu(id, de, cai, (byte) 2));
            } else if (de < H && cai < H && de > cai) {
                list.add(new Stu(id, de, cai, (byte) 3));
            } else {
                list.add(new Stu(id, de, cai, (byte) 4));
            }
        }
        Thread.currentThread().sleep(10000);
        for (Stu e : list) {
            System.out.println(e);
        }
    }
    
}

class Stu implements Comparable<Stu> {
    
    private int id;
    
    private byte de;
    
    private byte cai;
    
    private byte group;
    
    public Stu(int id, byte de, byte cai, byte group) {
        this.id = id;
        this.de = de;
        this.cai = cai;
        this.group = group;
    }
    
    public int getId() {
        return this.id;
    }
    
    public byte getDe() {
        return this.de;
    }
    
    public byte getCai() {
        return this.cai;
    }
    
    public byte getGroup() {
        return this.group;
    }
    
    @Override
    public int compareTo(Stu o) {
        if (group > o.getGroup()) {
            return 1;
        } else if (group < o.getGroup()) {
            return -1;
        }
        //鑳藉埌杩欓噷璇存槑鍦ㄤ竴涓粍
        if (cai + de > o.getDe() + o.getCai()) {
            return -1;
        } else if (cai + de < o.getDe() + o.getCai()) {
            return 1;
        }
        //鑳藉埌杩欓噷璇存槑鍦ㄥ悓涓�缁勶紝涓旀�诲垎鐩稿悓
        if (de > o.getDe())//鍚岀粍锛屾�诲垎鐩稿悓銆傛寜寰峰垎
        {
            return -1;
        } else if (de < o.getDe()) {
            return 1;
        }
        //鑳藉埌杩欓噷璇存槑鍚岀粍锛屾�诲垎鐩稿悓銆傚痉鍒嗙浉鍚�,鎸塈D鍒�
        if (id > o.getId()) {
            return 1;
        }
        return -1;
        
        
    }
    
    @Override
    public String toString() {
        return id + " " + de + " " + cai + " " + group;
    }
}
