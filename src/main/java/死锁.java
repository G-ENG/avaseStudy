
class TestSysn{
	//有同步意味着先后访问
	synchronized void test() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("test()"+System.currentTimeMillis());
	}
	void test2() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("rest2()"+System.currentTimeMillis());
	}
}
	class ThreadA extends Thread{
		TestSysn test;
		public ThreadA(TestSysn test) {
			this.test=test;
		}
		@Override
		public void run() {
			try {
				test.test2();
			} catch (Exception e) {
			}
		}
	}
	
	
	public class 死锁{
		public static void main(String[] args) {
			TestSysn test=new TestSysn();
			new ThreadA(test).start();
			new ThreadA(test).start();
		}
	}
