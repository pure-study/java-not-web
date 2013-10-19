package net.will.javatest.java.algorithms;

/**
 * 编写一个java应用程序，求分数序列1/2，2/3，3/5，5/8，8/13，13/21，… 的前10项之和。
 *
 * @author Will
 *
 */
public class FractionQueue1Test {
	public static void main(String[] args) {
		long num1 = 1;     // 第一个分数的分子
		long den1 = 2;     // 第一个分数的分母
		long num2 = 2;     // 第一个分数的分子
		long den2 = 3;     // 第一个分数的分母

		// 先求得前两项之和
		System.out.print(num1 + "/" + den1 + " + " + num2 + "/" + den2);
		long[] rets = getSub(num1 * den2 + num2 * den1, den1 * den2);
		long numOfSum = rets[0];   // 最后求得的和的分子
		long denOfSum = rets[1];   // 最后求得的和的分母

		int interCount = 10; // 求前几项之和

		// 从第三项开始循环，求和
		for (int i = 2; i < interCount; i++) {
			long num3 = num1 + num2;
			long den3 = den1 + den2;
			System.out.print(" + " + num3 + "/" + den3);
			rets = getSub(num3 * denOfSum + numOfSum * den3, den3 * denOfSum);

			num1 = num2;
			den1 = den2;
			num2 = num3;
			den2 = den3;
		}

		System.out.println(" = " + numOfSum + "/" + denOfSum);
	}

	/**
	 * 将两个数同时除以它们的最大公约数，将得到的商以数组形式返回。
	 *
	 * @param num
	 * @param den
	 * @return
	 */
	public static long[] getSub(long num, long den) {
		long maxCommonDivisor = getMaxCommonDivisor(num, den);
		long numret = num / maxCommonDivisor;
		long denret = den / maxCommonDivisor;

		return new long[]{numret, denret};
	}

	/**
	 * 获取两个数的最大公约数。
	 *
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static long getMaxCommonDivisor(long n1, long n2) {
		long result = 1;
		long maxer = Math.min(n1, n2);

		for (int i = 1; i < maxer; i++) {
			if (0==n1%i && 0==n2%i) {
				result = i;
			}
		}

		return result;
	}
}
