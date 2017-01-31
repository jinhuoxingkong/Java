package code;

public class LeetCode38{
	
	public static void main(String args[]){
		System.out.println(uniquePathNum(1, 1));
		System.out.println(uniquePathNum(2, 2));
		System.out.println(uniquePathNum(3, 3));
		System.out.println(uniquePathNum(4, 4));
	}


	//一共有多少种不同的路径
	public static int uniquePathNum(int m, int n) {
		int res[][] = new int[m][n];
		
		for(int i = 0; i < m; i++){
			res[i][0] = 1;
		}
        
		for(int j = 0; j < n; j++){
			res[0][j] = 1;
		}
		
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				res[i][j] = res[i-1][j] + res[i][j-1]; 
			}
		}
		
		return res[m - 1][n - 1];
	}

}
	