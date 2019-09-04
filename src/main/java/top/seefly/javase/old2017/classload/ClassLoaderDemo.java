package classload;

/*
 * һ����һ�����������ڴ棨�������ڴ����ڻ�ȡҲ���Դ������ϣ����Ͳ��ټ����ˡ�
 * ����ж�һ�����Ƿ��Ѿ��������ˣ�����ҪΨһ��ID�����ID���Ǽ�����+����+����
 * �����ͬ�ļ���������ͬһ���࣬��ô���������ǲ�ͬ��
 * 
 * JVM����ʱ���γ����������������ɵĳ�ʼ���������
 * 
 * 1.BootStarp ClassLoader:���������
 * 	���������java��jdk�еĺ����ࣨ����String�������˴˼������������м���������Java.lang.ClassLoader������
 * 	�˼���������JVM����ʵ�ֵģ�ʹ��ƽ̨��ص�����ʵ�ֵġ�����C���Ի��߻��C++...
 * 
 * 2.Extension ClassLoader:��չ������������������չ�࣬����jre.lib.ext�е���
 * 
 * 3.System ClassLoader:ϵͳ�������
 * 
 * 4.Appliction CalssLoader ���������Լ��������
 * 
 * ������BootstrapClassLoader������ClassLoader���ؽ�����������ЩClassLoader�ټ�����������
 * 
 * �����������Class�Ĳ��裺
 * 	1.�������Ƿ񱻼��ع������ع�ֱ�ӷ��ض�Ӧ��java.lang.Class����û����ʹ�ø������������
 *  2.�����������û�ҵ����ٵ����ĸ���..ѭ������������ʹ�õ�ǰ�������Ѱ��Class�ļ����ҵ������룬����Class����û�����쳣
 *  3.��û�и������������ʹ�ø�����������ɹ�����Class���󣬲��ɹ����쳣
 *  
 */
public class ClassLoaderDemo {

	public static void main(String[] args) {
		//String�Ǻ�����������BootStarp ClassLoader���صģ��˼�����û�����֣�������javaд�ģ��޷���ȡʵ��
		System.out.println(String.class.getClassLoader());
		//����jre�е��࣬��ʹ�� ExtensionClassLoader������������������Ҳ��һ���࣬����������ļ��������ص�
		//System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader());
		//�����Լ��������
		System.out.println(ClassLoaderDemo.class.getClassLoader().getClass().getName());
		//ϵͳ��classLoader
		System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());
		
		ClassLoader c = ClassLoaderDemo.class.getClassLoader();
		while(c != null) {
			System.out.println("ClassLoader:"+c.getClass().getName());
			c = c.getParent();//ע�⣬getParent���ǵõ����ࡣ����֮��û�м̳й�ϵ�������ù�ϵ��A���������и��������ֽ���parentָ��B��
		}
	}

}
