package exception;
/*
 * ������ʾ��һ��catch����Բ������쳣�����Ǵ�ʱ�Ĳ���ex������Ϊfianl���޷�����������¸�ֵ
 * */
public class MultiExceptionDemo {
	public static void main(String[] args) {
		try {
			String[] arrStr = {"32","44","334"};
			int a = Integer.parseInt(arrStr[0]);
			int b = Integer.parseInt(arrStr[1]);
			int c = a / b;
		}
		catch(IndexOutOfBoundsException|NumberFormatException|ArithmeticException ex) {
			//ex = new IndexOutOfBoundsException();
			//���쳣����ʱ��ex��Ĭ������Ϊfinal�������޷�����������¸�ֵ��
		}
		catch(Exception ex) {
			ex = new IndexOutOfBoundsException();
		}
	}

}
