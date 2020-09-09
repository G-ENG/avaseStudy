public class 排序{
	/**
	 * 我们看一看排序算法
	 * @param len
	 * @param a
	 */
	
	//选择排序n2
	void sort1(int len,int a[]) {
		int i=0,j=0,num=0;
		for (i = 0; i <len; i++) {
			for (j = i; j < len; j++) {
				if(a[j]<a[i]) {
					num=a[j];
					a[j]=a[i];
					a[i]=num;
			}
		}
	}
	}
	
	
	//冒泡排序n2
	static void bubleSort(int a[]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length-i-1; j++) {
				if (a[j]>a[j+1]) {
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
	}
	//快速排序 nlogn


	//基数排序
	public static void binSort(int[] number, int d) //d表示最大的数有多少位
	{
		int k = 0;
		int n = 1;
		int m = 1; //控制键值排序依据在哪一位
		int[][]temp = new int[10][number.length]; //数组的第一维表示可能的余数0-9
		int[]order = new int[10]; //数组orderp[i]用来表示该位是i的数的个数
		while(m <= d)
		{
			for(int i = 0; i < number.length; i++)
			{
				int lsd = ((number[i] / n) % 10);
				temp[lsd][order[lsd]] = number[i];
				order[lsd]++;
			}
			for(int i = 0; i < 10; i++)
			{
				if(order[i] != 0)
					for(int j = 0; j < order[i]; j++)
					{
						number[k] = temp[i][j];
						k++;
					}
				order[i] = 0;
			}
			n *= 10;
			k = 0;
			m++;
		}
	}

		public static void main(String args[]) { 
			int a[]= {1,3,2,4};int i=0;
			//new 排序().sort1(a.length,a);
			//bubleSort(a);
			binSort(a,1);
			for (; i < a.length; i++) {
				System.out.printf("%d\n",a[i]);
			}
		}
}