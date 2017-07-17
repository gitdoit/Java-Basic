package exception;
/*
 * �쳣��������������ǽ����⵱��������з�װ��
 * ��ϵ��
 * 		Throwable
 * 			|--ERROR
 * 			|--Exception
 * 				|--RuntimeException
 * �쳣���ص㣺�쳣��ϵ�����е����Լ������Ķ��󶼾��п����ԣ�
 * 			Ҳ����˵���Ա�throw��throws�ؼ���������
 * 			ֻ���쳣��ϵ�߱�����ص�
 * throw��throws���÷���
 * throw�����ں����ڣ������׳��쳣����
 * throws�����ں����ϣ������׳��쳣�࣬�����׳�����ö��Ÿ�����
 * 
 * ������������throw�׳��쳣���󣬲�δ����try��������Ҫ�ں������������������ʧ��
 * ע�⣬RuntimeException���⣬��������쳣
 * ��������������쳣����������Ҫ���д���������������throws��try
 * 
 * �쳣�����֣�
 * 	����ʱ������쳣
 * 		���쳣�ڱ���ʱ�����û�д���û���ף�Ҳû��try����ô����ʧ��
 * 		���쳣����ʶ�������ſ��Ա�����
 * 	����ʱ�쳣
 * 		�ڱ���ʱ����Ҫ���������������
 * 		���쳣�ķ������鲻�����ó���ֹͣ����Ҫ�Դ������������
 * 
 * �쳣��������
 * try
 * {
 * 		��Ҫ����Ĵ���
 * }
 * catch
 * {
 *		�����쳣�Ĵ��� 
 * }
 * finally
 * {
 * 		һ����ִ�еĴ��루System.exit(0)���⣩��һ�������ر���Դ
 * }
 * 
 * 
 * �Զ����쳣��
 * 	������̳�Exception����RuntimeException
 * 	Ϊ���ø��Զ�����߱�������
 *  �ø���߱������쳣�Ĺ��Է���
 *  
 *  �������Զ����쳣����Ϣʱ������ʹ�ø����Ѿ�����õĹ���
 *  �쳣��Ϣ���ݸ�����Ĺ��캯��
 * 
 * �쳣�ĺô���
 * 		��������з�װ
 * 		���������̴�������⴦���������룬�����Ķ�
 * 
 * �쳣�Ĵ���ԭ��
 * 		����ʽ�����֣�try����throws
 * 		���õ��׳��쳣�Ĺ���ʱ���׳������ʹ�����
 * 		�����catchҪ�������棬��Ȼ������쳣catch���ò���
 * 		catchҪ��������ԵĴ�����䣬��Ҫ�򵥵Ķ����ӡ���
 * 		�����񵽵��쳣catch�����˵�ʱ���Ǿ��׳�ȥ
 * */
public class ExceptionTest {
	public static void main(String[] args){
			
		Sqare a = new Sqare(2,-3);
		a.getArea();
		
		
	}
}

interface Shape{
	public abstract void getArea();
}

class Sqare implements Shape{
	private double len,wid;
	public Sqare()throws IllegalValueException{//�޲ι��췽���������вΣ������в����쳣���޲β�����Ҫ�׳�ȥ
		this(0, 0);
	}
	public Sqare(double len,double wid) throws IllegalValueException{//����쳣��ɵ�ԭ�����û����벻��ȷ�����Բ����ڹ��췽���н��
		if(len < 0 || wid < 0){
			throw new IllegalValueException(len,wid);//������������newһ���쳣�׳�ȥ
		}
		this.len = len;
		this.wid = wid;
	}
	
	public void getArea(){
		System.out.println(len * wid);
	}
}

class IllegalValueException extends RuntimeException{//�����û���������⣬�ڳ�����֮������޷�ͨ��������������ֻ�ܼ̳�����ʱ�쳣��ֹͣ����
	private double len,wid;
	IllegalValueException(double len,double wid){
		super(String.format("���зǷ���ֵ%f��%f", len,wid));//ֱ�ӵ��ø����еĹ��췽��
	} 
}