package code;

public class LeetCode39{
	
	public static void main(String args[]){
		int num[][] = new int[][]{
			{0, 0, 0, 0},
			{0, 1, 0, 0},
			{0, 0, 0, 0}
		};
		
		System.out.println(uniquePathsWithObstacles(num));
	}


	//一共有多少种不同的路径
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 输入校验
        if (obstacleGrid == null || obstacleGrid.length < 1 || obstacleGrid[0].length < 1
                || obstacleGrid[0][0] == 1
                || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] result = new int[rows][cols];

        // 第一个位置有多少种方法，无障碍就是1种，有障碍就是0种
        result[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;

        for (int i = 1; i < cols; i++) {
            result[0][i] = obstacleGrid[0][i] == 0 ? result[0][i - 1] : 0;
        }

        for (int i = 1; i < rows; i++) {
            result[i][0] = obstacleGrid[i][0] == 0 ? result[i - 1][0] : 0;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                result[i][j] = obstacleGrid[i][j] == 0 ? result[i - 1][j] + result[i][j - 1] : 0;
            }
        }

        return result[rows - 1][cols - 1];
    }

}
	