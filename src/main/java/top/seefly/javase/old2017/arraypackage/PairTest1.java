package top.seefly.javase.old2017.arraypackage;

public class PairTest1 {
	
	public static void main(String[] args){
		String[] words = {"Mary","had","a","little","lamb"};
		Pair<String> mm = ArrayAlg.minmax(words);
		//Pair<String> nn = new Pair<>();
		System.out.println("min = "+mm.getFirst());
		System.out.println("max = "+ mm.getSecond());
		
	}

}

class ArrayAlg{
	public static Pair<String> minmax(String[] a){//返回类型为Pair<String>
		if(a == null || a.length == 0) return null;
		String min = a[0];
		String max = a[0];
		for(int i = 0 ; i < a.length; i++){
			if(min.compareTo(a[i]) > 0) min = a[i];
			if(max.compareTo(a[i]) < 0) max = a[i];
		}
		return new Pair<String>(min,max);//返回自定义Pair泛型对象。
	}
}