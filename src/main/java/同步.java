

public class 同步 {
	public static synchronized void prin() {
		System.out.println("进入了sync方法"+System.currentTimeMillis());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
//	public static  synchronized void prin2(){
	public static  void prin2(){
		System.out.println("进入其他方法"+System.currentTimeMillis());
	}
	
	public static void main(String[] args) {
		同步 xx=new 同步();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				xx.prin();
				
			}
		}).start();
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				xx.prin2();
			}
		}).start();
	}
}

 