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


	//һ���ж����ֲ�ͬ��·��
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // ����У��
        if (obstacleGrid == null || obstacleGrid.length < 1 || obstacleGrid[0].length < 1
                || obstacleGrid[0][0] == 1
                || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] result = new int[rows][cols];

        // ��һ��λ���ж����ַ��������ϰ�����1�֣����ϰ�����0��
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
	