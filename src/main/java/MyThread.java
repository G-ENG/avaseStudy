

class Wa1f extends Thread {
	@Override
	public void run() {
		System.out.println("hhahaha");
	}
}



class Wa2f implements Runnable {
	@Override
	public void run() {
		System.out.println("heheheheh");
	}

}


public class MyThread {
	public static void main(String[] args) {
		Wa1f a = new Wa1f();
		
		/*将a设置为守护线程
		a.setDaemon(true);*/
		a.start();
		
		Wa2f b = new Wa2f();
		new Thread(b).start();
		
		//通过runable资源共享
		Thread th1 =new Thread(b);
		Thread th2=new Thread(b);
		th1.start();
		th2.start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {

				
			}
		}).start();
		
	}

}