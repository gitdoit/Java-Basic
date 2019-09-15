package top.seefly.javase.old2017.exception;
//演示了异常的处理过程，任何使用了会抛出异常的方法要么自己处理，要么抛出到上级
public class Throw {
	public static void main(String[] args){
		try{
			new ThrowException(5);
			new ThrowException(-5);
			new ThrowException(0);
		}
		catch(InvalidRadiusException ex){
			System.out.println(ex);
		}
		System.out.println("The number of Objecet is " + ThrowException.getNumberOfObjecets());
	}
}

class ThrowException{
	private double radius;
	private static int numberOfObjects = 0;
	
	
	public ThrowException() throws InvalidRadiusException{
		this(1.0);
	}
	public ThrowException(double radius)throws InvalidRadiusException{//构造方法没有处理setRadius抛出的异常，它抛出了
		setRadius(radius);
		numberOfObjects++;
	}
	
	
	public double getRadius(){
		return radius;
	}
	
	public void setRadius(double radius)throws InvalidRadiusException{//该方法会抛出一个异常，任何使用它的方法都要做出处理
		if(radius >= 0)
			this.radius = radius;
		else
			throw new InvalidRadiusException(radius);//万恶之源
	}
	public static int getNumberOfObjecets(){
		return numberOfObjects;
	}
}