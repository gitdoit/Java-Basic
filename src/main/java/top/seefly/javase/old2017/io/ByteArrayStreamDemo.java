package io;
/*
 * ����Ҳ��Ϊ�ڴ����������Ὣ����д���ļ��У��������ڴ��п���һ������أ���д��ʱ������д��û���أ�������������ݶ�ʧ��
	�Ҳ���ʹ��close����
 * 
 * 
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayStreamDemo {

	public static void main(String[] args) throws IOException{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();//����ָ��Ŀ��
		for(int i = 0; i < 10; i++) {
			baos.write(("������").getBytes());//getBytes()ʹ��ƽ̨Ĭ�ϱ��루����GBK�������ַ���ת����byte���顣write()��byte������뻺����
		}
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());//����ԴΪ�ڴ滺������
		byte[] bt = new byte[2];//GBK�������ĸ����ʹ��һ���ֽڣ�����ʹ����������Ϊ�������ȫ��Ϊ���ģ�����ָ��byte���鳤��Ϊ2.����Ӣ�Ķ��У��������
		while(bais.read(bt) != -1) {
			System.out.println(new String(bt));//ʹ��ƽ̨Ĭ�Ͻ��루����GBK������byte������ַ���
		}
	}

}
