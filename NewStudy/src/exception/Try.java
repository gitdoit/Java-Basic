package exception;

import java.util.*;

//�������쳣��ʾ
public class Try {
	public static int BaseException(int i,int j) throws Exception{//�������׳�һ��Exception��Ҫ��try��ִ��
		if(j == 0)
			throw new ArithmeticException("��ĸ����Ϊ��");//���쳣������쳣���ɲ�����try����ִ�С�������Exception��
		return i / j;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter two inteters:");
		int i = 0,j = 0;
		
		try{//�����õ��ķ������׳�һ���ؼ��쳣������Ҫ��try��ִ��
			i = input.nextInt();
			j = input.nextInt();
			int result = BaseException(i,j);//����÷����׳��쳣���򲻻�ִ����һ����䣬ת������catch
			System.out.println(result);
		}
		catch(ArithmeticException ex){//���쳣�׳��ᱻcatchץס
			System.out.println(ex);
		}
		catch(InputMismatchException ex){
			
			System.out.println("���벻�Ϸ�");
			throw ex;//��main�����׳��쳣�������ϼ�����
		}
		catch(Exception ex){//ע���InputMismatchException�׳����쳣�����ܵ����������ͬ������ӵ������ĺ������׳�
			System.out.println(ex);
		}
		finally{
			System.out.println("����finally��");//������û���쳣�׳�������û�б����񶼻�ִ��finally
		}
		System.out.println("����finally֮������");
	}

}
