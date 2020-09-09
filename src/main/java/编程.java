import java.util.Arrays;

public class 编程 {
	static int getMaxMul(int[] skill, int k, int d) {
		int ans = 1;
		int off = 0;
		String str=new String(skill,0,skill.length);
		for (int i = 0; i < k; i++) {
			int end = off + d-1;
			if (off + d >= skill.length)
				end = skill.length-1;
			Arrays.sort(skill, off, end);
			off = str.indexOf(skill[end],off);
			ans=ans*skill[end];
		}
		return ans;

	}

	public static void main(String[] args) {
		int[] skill = { 7, 4, 7,8 };
		System.out.println(getMaxMul(skill, 2, 50));
	}

}
