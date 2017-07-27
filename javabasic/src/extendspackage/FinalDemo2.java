package extendspackage;
/*
 * final�������ʱ��(String��)�������޷����̳У������������޷����޸ġ�
 * �����ڶ������ʱ����Ҫ����һ�¼���
 * ʹ��private final���θ���������򣬼���һ��ʵ����֮��Ͳ��ɸı���������
 * �ṩ�вι��췽������������г�ʼ��
 * ��Ҫ�ṩ�޸���
 * ��Ҫ��ʱ����Ҫ��дtoString(),equals(),hashCode()
 * 
 * */
public class FinalDemo2 {
	private final String detail;
	private final String PostCode;
	
	public FinalDemo2() {
		detail = "";
		PostCode = "";
	}
	public FinalDemo2(String detail,String PostCode) {
		this.detail = detail;
		this.PostCode = PostCode;
	}
	public String getDetail() {
		return detail;
	}
	public String getPostCode() {
		return PostCode;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj != null && getClass() == obj.getClass()) {
			FinalDemo2 Fd = (FinalDemo2)obj;
			if(this.getDetail().equals(Fd.getDetail())&&
			   this.getPostCode().equals(Fd.getPostCode()))
				return true;
		}
		return false;
	}
	@Override
	public int hashCode() {
		return detail.hashCode() + PostCode.hashCode();
	}
	@Override
	public String toString() {
		return String.format("The detail is %s and PostCode is %s", detail,PostCode);
	}
	public static void main(String[] args) {

	}

}
