package mypraxis;

import java.util.Scanner;
import java.util.TreeSet;

/*
 * 题目描述
宋代史学家司马光在《资治通鉴》中有一段著名的“德才论”：“是故才德全尽谓之圣人，才德兼亡谓之愚人，德胜才谓之君子，才胜德谓之

小人。凡取人之术，苟不得圣人，君子而与之，与其得小人，不若得愚人。”

德才结都过H线，为德才都有，按总分排序    第一类
才不过H，德过，为德胜才 按总分排序	   第二类
德才均不过H，才德都亡，若德高才，又称为德胜才。按总分 第三类
其他过L的为第四类


现给出一批考生的德才分数，请根据司马光的理论给出录取排名。

输入描述:
输入第1行给出3个正整数，分别为：N（<=105），即考生总数；L（>=60），为录取最低分数线，即德分和才分均不低于L的考生才有资格

被考虑录取；H（<100），为优先录取线——德分和才分均不低于此线的被定义为“才德全尽”，此类考生按德才总分从高到低排序；才分不到

但德分到线的一类考生属于“德胜才”，也按总分排序，但排在第一类考生之后；德才分均低于H，但是德分不低于才分的考生属于“才德兼

亡”但尚有“德胜才”者，按总分排序，但排在第二类考生之后；其他达到最低线L的考生也按总分排序，但排在第三类考生之后。


随后N行，每行给出一位考生的信息，包括：准考证号、德分、才分，其中准考证号为8位整数，德才分为区间[0, 100]内的整数。数字间以空格分隔。


输出描述:
输出第1行首先给出达到最低分数线的考生人数M，随后M行，每行按照输入格式输出一位考生的信息，考生按输入中说明的规则从高到低排序。当某类考生中有多人

总分相同时，按其德分降序排列；若德分也并列，则按准考证号的升序输出。

输入例子:
total	de     cai
14     60     80

10000001 64 90

10000002 90 60

10000011 85 80

10000003 85 80

10000004 80 85

10000005 82 77

10000006 83 76

10000007 90 78

10000008 75 79

10000009 59 90

10000010 88 45

10000012 80 100

10000013 90 99

10000014 66 60

输出例子:
12

10000013 90 99

10000012 80 100

10000003 85 80

10000011 85 80

10000004 80 85

10000007 90 78

10000006 83 76

10000005 82 77

10000002 90 60

10000014 66 60

10000008 75 79

10000001 64 90

 */
public class Sort {//该线程使用了1120KB
	public static  byte H;
	public static  byte L;
	public static void main(String[] args)throws Exception {
		Thread.currentThread().setName("gggggggggggggggggg");
		
		byte totle,de,cai;
		int id;
		TreeSet<Stu> list = new TreeSet<>();
		Scanner in = new Scanner(System.in);
		totle = in.nextByte();
		H = in.nextByte();
		L = in.nextByte();
		for(;totle > 0;totle--) {//分组，且排序
			id = in.nextInt();
			de = in.nextByte();
			cai = in.nextByte();
			if(de < L || cai < L)
				continue;
			if(de >= H && cai >= H)//德才都过
				list.add(new Stu(id,de,cai,(byte)1));
			else if(de >= H && cai < H)//德过才不过
				list.add(new Stu(id,de,cai,(byte)2));
			else if(de < H && cai < H && de > cai)
				list.add(new Stu(id,de,cai,(byte)3));
			else
				list.add(new Stu(id,de,cai,(byte)4));
		}
		Thread.currentThread().sleep(10000);
		for(Stu e : list) {
			System.out.println(e);
		}
	}

}

class Stu implements Comparable<Stu>{
	private int id;
	private byte de;
	private byte cai;
	private byte group;
	
	public Stu(int id,byte de,byte cai,byte group) {
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
		if(group > o.getGroup())
			return 1;
		else if(group < o.getGroup())
			return -1;
		//能到这里说明在一个组
		if(cai + de > o.getDe() + o.getCai())
			return -1;
		else if(cai + de < o.getDe() + o.getCai())
			return 1;
		//能到这里说明在同一组，且总分相同
		if(de > o.getDe())//同组，总分相同。按德分
			return -1;
		else if(de < o.getDe())
			return 1;
		//能到这里说明同组，总分相同。德分相同,按ID分
		if(id > o.getId())
			return 1;
		return -1;
		
		
	}
	@Override
	public String toString() {
		return id + " " + de + " " + cai +" " + group;
	}
}