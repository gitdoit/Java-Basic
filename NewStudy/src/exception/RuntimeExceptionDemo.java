package exception;
/*RuntimeException��Error�쳣��������쳣�������Բ�ʹ��try-catch������ר�Ŵ���
 * ��ʹ���ڷ������ֶ��׳�������ͷ��Ҳ����������ʹ�ø÷����ĺ���Ҳ����try
 * 
 * �Զ����쳣������쳣������ʹ�����޷���������������ʱ�쳣
 * */
public class RuntimeExceptionDemo {
	public static void main(String[] args){
		System.out.println();
	}
	

}

class Demo{
	static int div(int a,int b) //throws ArithmeticException �Ƿ��ں���ͷ�����������������ĵط���������try����
	{
		if(b == 0)
			throw new ArithmeticException("���ܳ�0");//��ʹ�ֶ��׳�Ҳ������ͷ�������������õĵط�������Դ���
		return a / b;
	}
}