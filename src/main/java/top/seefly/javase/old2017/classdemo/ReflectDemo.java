package classdemo;
import java.lang.reflect.*;
import java.util.*;
/*
 *�����еķ��������õ�һ�����ȫ����Ϣ�� 
 *
 * */
public class ReflectDemo {
	public static void getClassInfo(String name){
		
		//Scanner in = new Scanner(System.in);
		//System.out.println("Enter class name (e.g. java.util.Date)");
		//name = in.next();
		try{
			Class c = Class.forName(name);
			Class superc = c.getSuperclass();
			//Class.getModifiers()�õ����η���Ӧ��Intֵ��Ҳ�������ڱ����򷽷��ϣ�Modifier.toString��intֵתΪ��Ӧ�ַ�
			String modifiers = Modifier.toString(superc.getModifiers());
	
			if(modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.print("class " + name);
			if(superc != null && superc != Object.class) System.out.print(" extends" + superc.getName());
			
			System.out.print("\n{\n");
			printFields(c);
			//��ӡ���캯��
			printConstructors(c);
			System.out.println();
			//��ӡ����
			printMethods(c);
			System.out.println();
			System.out.println("}");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public static void printConstructors(Class c1){
		Constructor[] constructors = c1.getDeclaredConstructors();//����һ�� Constructor ���󣬸ö���ӳ�� Class 
		 //Constructor��������Ĺ��췽��	   							          ��������ʾ�����ӿڵ�ָ�����췽����
		for(Constructor c : constructors){
			String name = c.getName();//�õ����췽��������
			System.out.print("   ");
			String modifiers = Modifier.toString(c.getModifiers());//���ش����ӿ������������ Java �������η���
																   //Ȼ��toString�ٽ��룬Ȼ��õ����η���public ����ɶ��
			if(modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.print(name +  "(");
			
			//print parameter types
			Class[] parameTypes = c.getParameterTypes();//��������˳�򷵻�һ�� Class����,��Щ�����ʾ�� Constructor��������ʾ���췽�����β����͡�
			for(int j = 0 ;j < parameTypes.length; j++){
				if(j > 0) System.out.print(", ");
				System.out.print(parameTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	
	public static void printMethods(Class c1){
		Method[] methods = c1.getDeclaredMethods();//�õ���������з�������Method����������ʽ����
		for(Method m : methods){
			Class retType = m.getReturnType();//�õ������ķ���ֵ���ͣ�����ֵ���Ϳ϶���Class�డ
			String name = m.getName();//�õ���������
			
			System.out.print("   ");
			//print modifiers(���η�),return type and method name
			String modifiers = Modifier.toString(m.getModifiers());//�õ����η�
			if(modifiers.length() > 0) System.out.print(modifiers + " ");//��ӡ���η�
			System.out.print(retType.getName() + " " + name + "(");//��ӡ����ֵ����
			
			//print parameter types
			Class[] paramTypes = m.getParameterTypes();//�õ��������ͣ���Class����������ʽ����
			for(int j = 0; j < paramTypes.length; j++){
				if(j > 0) System.out.print(", "); 
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	
	public static void printFields(Class c1){
		Field[] fields = c1.getDeclaredFields();//����һ����������
		for(Field f : fields){
			Class type = f.getType();//�õ����������ͣ���Class���󷵻�
			String name = f.getName();//�õ�����������
			System.out.print("   ");
			String modifiers = Modifier.toString(f.getModifiers());//�õ����η���
			if(modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.println(type.getName() + " " + name + ";");
		}
	}
}
