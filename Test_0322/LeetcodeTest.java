package Test_0322;

/*
1023. 子串能表示从 1 到 N 数字的二进制串
给定一个二进制字符串 S（一个仅由若干 '0' 和 '1' 构成的字符串）和一个正整数 N，
如果对于从 1 到 N 的每个整数 X，其二进制表示都是 S 的子串，就返回 true，否则返回 false。

示例 1：
输入：S = "0110", N = 3
输出：true
示例 2：
输入：S = "0110", N = 4
输出：false
提示：
1 <= S.length <= 1000
1 <= N <= 10^9
 */

/*
 * 分析：
 * 表示出从1到N的正整数二进制字符串s，判断二进制字符串 S是否包含s,
 * 不包含，返回false，若包含所有1到N的正整数二进制字符串，返回true。
 * 这里用到的BigInteger的toString方法，
 * BigInteger中的String toString()将当前整数转换成十进制的字符串形式，
 * 转为二进制只需要传参为2。
 */
//import java.math.BigInteger;
//public class LeetcodeTest {
//	public static void main(String[] args) {
//		Solution So = new Solution();
//		String S = "0110";
//		int N = 4;
//		System.out.println(So.queryString(S, N));
//	}
//}
//class Solution {
//    public boolean queryString(String S, int N) {
//        for(int i=1; i<=N; i++){
//            BigInteger b = new BigInteger(String.valueOf(i));
//            String s = b.toString(2);
//            if(!S.contains(s)){
//            	return false;
//            }
//            s = "";
//        }
//        return true;
//    }
//}
	
/*
48. 旋转图像
给定一个 n × n 的二维矩阵表示一个图像。
将图像顺时针旋转 90 度。
说明：
你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
示例 1:
给定 matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
示例 2:
给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 
原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 */
/*
 * 分析：
 * 先从最外层开始交换，逐渐往里缩进，
 * 每一层交换时矩阵四个角的点分别为交换的头，接着交换每一组下面值，
 * 不得不感叹一下这个题是个细心活哪，交换的时候一定要注意对交换点的坐标描述，使得每一组交换都准确。
 */
public class LeetcodeTest {
	public static void main(String[] args) {
		int[][] matrix = {{ 5, 1, 9,11},
				  { 2, 4, 8,10},
				  {13, 3, 6, 7},
				  {15,14,12,16}};
		Solution So = new Solution();
		So.rotate(matrix);
		for(int i=0; i<matrix.length;i++){
			for(int j=0; j<matrix[0].length;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}	
	}
}
class Solution {
    public void rotate(int[][] matrix) {
       if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
    	   return;
       }
       int col = matrix.length-1;
       for(int j=0; j<matrix.length/2; j++,col--){
    	   int r = col;//记录最后
    	   int c = 0;//记录开始
    	   for(int i=j;i<col; i++){  
    		  swap(matrix,i,j,r,i);  
    		  swap(matrix,r,i,r-c,r);  
    		  swap(matrix,r-c,r,j,r-c);
    		  c++;
    	   }
       }
    }
    private void swap(int[][]matrix,int i1,int j1,int i2,int j2){
    	int temp = matrix[i1][j1];
    	matrix[i1][j1] = matrix[i2][j2];
    	matrix[i2][j2] = temp;
    }
}