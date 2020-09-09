public class 倒三角 {

	static void out(int a) {
		int ary[][] = new int[a][2 * a];
		int n = 1;
		for (int i = 0; i < a; i++) {
			for (int j = i; j < a; j++) {
				ary[i][j] = n;
				ary[i][2 * a - j - 1] = a * (a + 1) - n + 1;
				n++;
			}
		}
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < 2 * a; j++) {
				if (ary[i][j] == 0)
					System.out.printf("     ");
				else
					System.out.printf("%5d", ary[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		out(4);
		outTri(4);
		outTri2(4);
		outTri3(4);
	}

//打印三角形
	static void outTri(int n) {
		char arry[][] = new char[n][2 * n ];
		for (int i = 0; i < n; i++) {
			for (int j = i; j < (2 * n - i); j=j+2) {
				arry[i][j] = '*';
				
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2 * n - 1; j++) {
				System.out.print(arry[i][j]);
			}
			System.out.println();

		}
	}

	static void outTri2(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print(' ');
			}
			for (int j = i; j <= n; j++) {
				System.out.print('*');
				System.out.print(' ');
			}
			System.out.println();
		}
	}

	static void outTri3(int n) {
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print(' ');
			}
			for (int j = 1; j <=i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}