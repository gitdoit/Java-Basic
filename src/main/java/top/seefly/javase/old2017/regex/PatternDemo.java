package regex;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * ��ָ����������ʽ��װ��ģʽ��ʹ�ô�ģʽ���ַ������бȽ�
 */
public class PatternDemo {

	public static void main(String[] args) {
		//��ģʽ����ɶ���
		Pattern p = Pattern.compile("a*b");//*����һ�λ���
		//ͨ��ģʽ���󣬵õ�ƥ��������
		Matcher m = p.matcher("aaab");
		//ͨ��ƥ�����еĸ��ַ�������ɸ��ֲ���
		System.out.println(m.matches());//�������ͬ�����������
		//System.out.println(p.matcher("aaaab").matches());
		
		//���ַ���������Ҫ��������г�ȡ���������һ���ַ�������
		String str = "lao zi jin tian hen kai xin,wo jiu yao qu gan liang bei";
		ArrayList<String> list = new ArrayList<>();
		Pattern p1 = Pattern.compile("\\b\\w{3}\\b");//��װ���򣺵�����������ĸ��ɵ�,ע��\\w{3}�ǰ��������ַ��������޶��߽�
		Matcher m1 = p1.matcher(str);//����Ŀ���ַ���
		while(m1.find()) {//�ҵ������ƥ���������
			list.add(m1.group());//��֮ȡ����ע�⣡���ڵ���group֮ǰһ��Ҫ�ȵ���find����Ȼ�ᱨ��
		}
		System.out.println(list);
	}

}
