package exception;
//��ʾ���쳣�Ĵ�����̣��κ�ʹ���˻��׳��쳣�ķ���Ҫô�Լ�����Ҫô�׳����ϼ�
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
	public ThrowException(double radius)throws InvalidRadiusException{//���췽��û�д���setRadius�׳����쳣�����׳���
		setRadius(radius);
		numberOfObjects++;
	}
	
	
	public double getRadius(){
		return radius;
	}
	
	public void setRadius(double radius)throws InvalidRadiusException{//�÷������׳�һ���쳣���κ�ʹ�����ķ�����Ҫ��������
		if(radius >= 0)
			this.radius = radius;
		else
			throw new InvalidRadiusException(radius);//���֮Դ
	}
	public static int getNumberOfObjecets(){
		return numberOfObjects;
	}
}