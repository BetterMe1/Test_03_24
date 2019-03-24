package Test_0322;

/*
1023. �Ӵ��ܱ�ʾ�� 1 �� N ���ֵĶ����ƴ�
����һ���������ַ��� S��һ���������� '0' �� '1' ���ɵ��ַ�������һ�������� N��
������ڴ� 1 �� N ��ÿ������ X��������Ʊ�ʾ���� S ���Ӵ����ͷ��� true�����򷵻� false��

ʾ�� 1��
���룺S = "0110", N = 3
�����true
ʾ�� 2��
���룺S = "0110", N = 4
�����false
��ʾ��
1 <= S.length <= 1000
1 <= N <= 10^9
 */

/*
 * ������
 * ��ʾ����1��N���������������ַ���s���ж϶������ַ��� S�Ƿ����s,
 * ������������false������������1��N���������������ַ���������true��
 * �����õ���BigInteger��toString������
 * BigInteger�е�String toString()����ǰ����ת����ʮ���Ƶ��ַ�����ʽ��
 * תΪ������ֻ��Ҫ����Ϊ2��
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
48. ��תͼ��
����һ�� n �� n �Ķ�ά�����ʾһ��ͼ��
��ͼ��˳ʱ����ת 90 �ȡ�
˵����
�������ԭ����תͼ������ζ������Ҫֱ���޸�����Ķ�ά�����벻Ҫʹ����һ����������תͼ��
ʾ�� 1:
���� matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
ԭ����ת�������ʹ���Ϊ:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
ʾ�� 2:
���� matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 
ԭ����ת�������ʹ���Ϊ:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 */
/*
 * ������
 * �ȴ�����㿪ʼ������������������
 * ÿһ�㽻��ʱ�����ĸ��ǵĵ�ֱ�Ϊ������ͷ�����Ž���ÿһ������ֵ��
 * ���ò���̾һ��������Ǹ�ϸ�Ļ��ģ�������ʱ��һ��Ҫע��Խ����������������ʹ��ÿһ�齻����׼ȷ��
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
    	   int r = col;//��¼���
    	   int c = 0;//��¼��ʼ
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