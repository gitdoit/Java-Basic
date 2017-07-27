package exception;
//�Զ����쳣
public class InvalidRadiusException extends Exception{
	private double radius;
	public InvalidRadiusException(){
		this(-1);
	}
	public InvalidRadiusException(double radius){
		super("Invalid radius" + radius);
		this.radius = radius;
	}
	public double getRadius(){
		return this.radius;
	}
}
