package net_udp;

import java.net.URLDecoder;
import java.net.URLEncoder;

/*
 * ����������ʾ����ַ�г����˷���ŷ�ַ�ʱ��Ҫ��URLEncoder��֮ת���ɡ����롯
 * ����URLDecoder�������롯����
 * ע�������������ŷ�ַ���ô ������ת����
 * ת�� ������ÿ�������ַ�ռ�����ֽڣ�ÿ���ֽڿ���ת����2��ʮ�����Ƶ����֣�����ÿ�������ַ�
 * ��ת����%XX%XX����ʽ����ʹ�ò�ͬ���ַ���ʱ������ռ�õ��ֽڲ�ͬ���Խ������ʱҪָ���ַ���
 */
public class URLCoder {

	public static void main(String[] args) throws Exception{
		//ʹ��GBK������ַ�ת����URL�ж�Ӧ����ʽ
		String keyword = URLEncoder.encode("����","GBK");
		System.out.println(keyword);
		
		//�������롯ת�����ַ�
		String chr = URLDecoder.decode(keyword);
		System.out.println(chr);
		
	}

}
