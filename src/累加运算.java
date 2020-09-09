public class 累加运算 {

	// 此方法求1^2+2^2+...+100^2
	static void pingFangHe() {
		int sum = 0;
		for (int i = 0; i <= 100; i++) {
			sum = sum + i * i;
		}
		System.out.println(sum);
	}

	// 此方法求1^1+2^2+3^3+...+100^100
	static void duoCiFangHe() {
		long sum = 0;
		for (int i = 1; i <= 100; i++) {
			int s = 1;
			for (int j = 1; j <= i; j++) {
				s = s * i;
			}
			sum = sum + s;
		}
		System.out.println(sum);
	}

	public static void main(String args[]) {
		pingFangHe();
		duoCiFangHe();
	}

	// 递归算法求自然数之和
	public static int sum(int i) {
		if (i == 0)
			return i;
		else
			return i + sum(i - 1);

	}

}