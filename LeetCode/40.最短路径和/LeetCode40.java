package code;

public class LeetCode40{
	
	public static void main(String args[]){
		int num[][] = new int[][]{
			{1, 1, 2, 0},
			{1, 2, 3, 4},
			{4, 1, 1, 0}
		};
		
		System.out.println(minPathsNum(num));
	}


	//最短路径的问题
	public static int minPathsNum(int[][] num) {
        // 输入校验
        if (num == null || num.length < 1 || num[0].length < 1){
            return 0;
        }

        int rows = num.length;
        int cols = num[0].length;
        int[][] result = new int[rows][cols];

        // 第一个数
        result[0][0] = num[0][0];
        
        //第一行
        for(int i = 1; i < cols; i++){
        	result[0][i] = result[0][i - 1] + num[0][i];
        }
        
        //第一列
        for(int i = 1; i < rows; i++){
        	result[i][0] = result[i - 1][0] + num[i][0];
        }
        
        //其他的情况
        for(int i = 1; i < rows; i++){
        	for( int j = 1; j < cols; j++){
        		result[i][j] = Math.min(result[i-1][j], result[i][j-1]) + num[i][j];
        	}
        }

        return result[rows - 1][cols - 1];
    }

}
	