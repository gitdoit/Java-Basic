package net_udp;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * URL:ͳһ��Դ��λ��
 * ��ɣ�Э����-����-�˿�-��Դ
 * 	   protocol://host:port/resourceName
 * 	   http://www.crazyit.org/index.hph
 * ע��URI���ܶ�λ�κ���Դ����Ψһ�����þ��ǽ���
 * 
 *���߳����أ�
 *ָ�������е�Դ�ļ����������ӡ��������ӡ�
 *�õ�Դ�ļ���С��n���߳����ļ��ֳ�n�ݣ�ÿ�ݴ�С��ͬ��
 *Ϊÿ���̷ֱ߳�ָ��һ�������д�������������д����������ֱ����������������������ʵλ�á�
 */
public class URLConnectionDemo {

	public static void main(String[] args) throws Exception {
		long star = System.currentTimeMillis();
		final DownUtil downUtil = new DownUtil("http://sw.bos.baidu.com/sw-search-sp/software/92f7b2170f9b7/BaiduNetdisk_5.6.1.2.exe",
				"E:\\IOTest\\�ٶ���.exe",4);
		downUtil.download();
		new  Thread() {
			@Override
			public void run() {
				while(downUtil.getCompleteRate() < 1) {
					System.out.println("���ȣ�"+downUtil.getCompleteRate());
					try {
						Thread.sleep(1000);
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

}

class DownUtil{
	//Դ�ļ���ַ
	private String path;
	//�洢λ��
	private String targetFile;
	//�߳���
	private int threadNum;
	//�߳�����
	private DownThread[] threads;
	//ԭ�ļ���С
	private int fileSize;
	//���췽��
	public DownUtil(String path,String targetFile,int threadNum) {
		this.path = path;
		this.targetFile = targetFile;
		this.threadNum = threadNum;
		threads = new DownThread[threadNum];
	}
	//ִ�����ط�����
	public void download() throws Exception{
		//ָ���ļ���ַ
		URL url = new URL(path);
		//��������
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		//�������ӳ�ʱ
		conn.setConnectTimeout(5000);
		//�������󷽷�
//		conn.setRequestMethod("GET");
		//������������
//		conn.setRequestProperty("Accept", "image/gif,image/jpeg,image/pjpeg,image/pjpeg,"+
//		"application/x-shockwave-flash,application/xaml+xml,"
//		+ "application/vpn.ms-xpadocument,application/x-ms-xbap,"
//		+ "application/x0ms-application,applicaation/msword,*/*");
//		conn.setRequestProperty("Accept-Language", "zh-CN");
//		conn.setRequestProperty("Charset", "UTF-8");
//		conn.setRequestProperty("Connection", "Keep-Alive");
		//�õ�Դ�ļ���С
		fileSize = conn.getContentLength();
		//�ر�����
		conn.disconnect();
		//��Դ�ļ��ֳ����߳�����ȵĿ�����ÿ�鳤����ȡ�currentParSizΪÿ���С
		int eachPartSize = fileSize / threadNum +1;
		//�½������ļ�
		RandomAccessFile file = new RandomAccessFile(targetFile,"rw");
		//���ñ����ļ���С��Ҫ��Դ�ļ���Сһ��
		file.setLength(fileSize);
		file.close();
		for(int i = 0; i < threadNum; i++) {
			//����ÿ���߳����صĿ�ʼλ��
			int startPos = i * eachPartSize;
			//Ϊÿ���̴߳��� һ�������
			RandomAccessFile outputRan = new RandomAccessFile(targetFile,"rw");
			//Ϊÿ���߳������ָ����ʼд��λ��
			outputRan.seek(startPos);
			//���������̣߳�������ʼλ�ã����صĳ��ȣ�ָ�������
			threads[i] = new DownThread(startPos,eachPartSize,outputRan);
			threads[i].start();
		}
		
		
	}
	//��ȡ���ؽ���
	public double getCompleteRate() {
		int sumSize = 0;
		for(int i = 0; i < threadNum; i ++) {
			sumSize +=threads[i].length;
		}
		return sumSize * 1.0 / fileSize;
	}

	private class DownThread extends Thread{
		//��ǰ�߳�����λ��
		private int startPos;
		private int currentPartSize;
		private RandomAccessFile currentPart;
		public int length;
		public DownThread(int startPos,int currentPartSize,RandomAccessFile currentPart){
			this.startPos = startPos;
			this.currentPartSize = currentPartSize;
			this.currentPart = currentPart;
		}
		
		@Override
		public void run() {
			try {
				URL url = new URL(path);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				//�������ӳ�ʱ
				conn.setConnectTimeout(5000);
//				conn.setRequestMethod("GET");
				//������������
//				conn.setRequestProperty("Accept", "image/gif,image/jpeg,image/pjpeg,image/pjpeg,"+
//				"application/x-shockwave-flash,application/xaml+xml,"
//				+ "application/vpn.ms-xpadocument,application/x-ms-xbap,"
//				+ "application/x0ms-application,applicaation/msword,*/*");
//				conn.setRequestProperty("Accept-Language", "zh-CN");
//				conn.setRequestProperty("Charset", "UTF-8");
				//������ΪԴ�ļ�
				InputStream inStream = conn.getInputStream();
				//����ÿ���߳̿�ʼ�����λ��
				inStream.skip(this.startPos);
				byte[] buffer = new byte[1024];
				int hasRead = 0;
				while(length < currentPartSize && (hasRead = inStream.read(buffer)) != -1) {//�������س��ȳ���ÿ���߳�ָ�����س��ȣ����ȡ��ϡ����˳�ѭ��
					currentPart.write(buffer,0,hasRead);
					length += hasRead;
				}
				currentPart.close();
				inStream.close();
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
	


