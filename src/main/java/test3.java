

class Mtc {

}

class Dc {

}

class Threadss extends Thread {
	Mtc mtc;
	Dc dc;

	public Threadss(Mtc mtc, Dc dc) {
		this.mtc = mtc;
		this.dc = dc;
	}

	@Override
	public void run() {
		synchronized (mtc) {
			try {
				sleep(1000);
				System.out.println("wait dc ....");
			//	wait();
				synchronized (dc) {
					System.out.println("dc .....");
				}
			} catch (Exception e) {
			}
		}
	}
}

class Threadsb extends Thread {
	Mtc mtc;
	Dc dc;

	public Threadsb(Mtc mtc, Dc dc) {
		this.mtc = mtc;
		this.dc = dc;
	}

	@Override
	public void run() {
		synchronized (dc) {
			try {
				sleep(1000);
				System.out.println("wait mtc....");
//				wait();
				synchronized (mtc) {
					System.out.println("mtc .....");
				}
			} catch (Exception e) {
			}

		}
	}
}

public class test3 {
	public static void main(String args[]) {
		Mtc mtc = new Mtc();
		Dc dc = new Dc();
		new Threadss(mtc, dc).start();
		new Threadsb(mtc, dc).start();
	}
}
