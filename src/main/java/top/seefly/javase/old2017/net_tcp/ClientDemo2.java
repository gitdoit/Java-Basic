package net_tcp;
/*
 * ������ʾ���ڿͻ��˴Ӽ���¼�����ݣ����͵�����ˣ�����˽��յ�֮��д���ļ���
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientDemo2 {

	public static void main(String[] args)throws IOException {
		//ָ��������
		Socket sk = new Socket("192.168.3.4",8888);
		//��װ�����,��ܵ�д����
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));
		//��װ���������Ӽ��̶�����
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		//ѭ���Ӽ��̶����ݣ�����ܵ���д��
		while((str = input.readLine())!= null) {
			if(str.equals("close"))
				break;
			output.write(str);
			//�ǵó�ˢ����Ȼ��������һֱ��.
			output.newLine();
			output.flush();
		}
		output.close();
		sk.close();
	}

}
