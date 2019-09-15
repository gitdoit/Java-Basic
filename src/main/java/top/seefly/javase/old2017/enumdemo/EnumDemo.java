package top.seefly.javase.old2017.enumdemo;
/* 枚举类型名.values 将枚举对象以枚举数组的形式返回
 * 
 * 枚举对象.ordinal()返回其在该类中的编号（从零开始），枚举对象.name()返回名字
 * 
 * 枚举对象可以用在switch中 以作比较
 * */
public class EnumDemo {

	public static void main(String[] args){
		Color c1 = Color.BLUE;
		System.out.println("c1的颜色："+c1);//括号内的c1 = c1.toString()
		for(Color c:Color.values())//枚举类中的静态values方法是将其中的枚举元素以枚举数组的形式返回
			System.out.println(c);
		//Enum<Color>[] cc = Color.values(); 泛型
		//Color[] bb = Color.values(); 枚举类型数组
		
		for(Color c : Color.values())//验证枚举类在swithc中的应用
			print(c);
		
		for(Color c : Color.values())//ordinal返回其在该类中的编号（从零开始），name返回名字
			System.out.println(c.ordinal()+ "--->"+ c.name());
		
		
	}
	

	
	public static void print(Color c){//枚举元素用switch来判断
		switch(c){//注意要加break;
			case RED:{
				System.out.println(c);
				break;
			}
			case BLUE :{
				System.out.println(c);
				break;
			}
			case GREEN :{
				System.out.println(c);
				break;
			}
		}
	}
	
	public enum Color{//自定义的枚举类型
		RED,
		BLUE,
		GREEN;
	}

}
