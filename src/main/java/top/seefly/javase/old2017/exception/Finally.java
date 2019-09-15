package top.seefly.javase.old2017.exception;
/*
 * finally中的语句无论如何都会执行
 * 里面一般放关闭资源的语句；
 * 
 * 分层思想：
 * 某人调用了method方法，但是由于某种原因该方法执行期间出现了异常
 * 但是该方法不能将此异常抛出，因为他只是使用这个方法，由于该方法的封装性，他并不知道此方法是如何实现的。
 * 也就是说你把出现的异常抛出是没有意义的。
 * 所以该方法内需要做相关处理，抛出的异常应该是对调用者有用的信息，是调用者能够处理的。
 * 
 * */
public class Finally {
/*	public static void main(String[] args){
 * 		
 * 	}
 * 
 * public void method() throws UpNeedDoException{
 * 		try{
 * 			数据库连接；
 * 			数据库操作；
 * 		}
 * 		catch(SQLException ex){
 * 			相关异常操作；
 * 			throw new UpNeedDoException();
 * 		}
 * 		finally{
 * 			关闭数据库连接；
 * 		}
 * }
 * 
 * 
 * */


}
