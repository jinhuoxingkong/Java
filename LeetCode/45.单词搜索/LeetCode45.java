package code;

public class LeetCode45{
	public static void main(String args[]){
		char num[][] = new char[][]{
			{'A', 'B', 'C', 'E'},
			{'S', 'F', 'C', 'S'},
			{'A', 'D', 'E', 'E'}
		};
		
		boolean e1 = isExist(num, "ABCCED");
		boolean e2 = isExist(num, "ABEE");
		
		System.out.println(e1+" "+e2);
	}


	//验证单词是否能搜索到
	public static boolean isExist(char[][] num, String word){
		//标记矩阵，用来表示该元素是否被访问过，是否被访问的过是表的是在一条对的路径上没有被访问过，这样可以保证不重复遍历元素
		boolean [][] visited = new boolean[num.length][num[0].length];
		
		//每一个位置为起点进行搜索
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[0].length; j++) {
                if (search(num, visited, i, j, word, new int[]{0})) {
                    return true;
                }
            }
        }
        
        return false;
	}
	
	/**
	 * @param num
	 * @param visited
	 * @param row  访问的元素的行号
	 * @param col  访问的元素的列号
	 * @param word 匹配的字符串
	 * @param idx  匹配的位置
	 * @return
	 */
	private static boolean search(char[][] num, boolean[][] visited, int row, int col, String word, int[] index) {
		if(index[0] == word.length()){
			return true;
		}
		
		//从该点开始是否有其他路径
		boolean hasPath = false;
		
		//判断当前位置是否合法，并且该元素是否和字符串中的元素相匹配
		if(check(num, visited, row, col, word, index[0])){
			//标记被访问过了
			visited[row][col] = true;
			
			//移动到单词的下一个元素
			index[0]++;			
			//对上下左右的四个方向进行搜索，也就是上下左右只要有一个方向和目标字符串的下一个单词想匹配，就OK
            hasPath = search(num, visited, row - 1, col, word, index ) // 上
                    || search(num, visited, row, col + 1, word, index) // 右
                    || search(num, visited, row + 1, col, word, index) // 下
                    || search(num, visited, row, col - 1, word, index); // 左
            
            //如果没有找到路径，就标记该点不行了,进行回溯
            if(!hasPath){
            	visited[row][col] = false;
            	index[0]--;
            }
		}
		
		return hasPath;
	}
	
    /**
     * @param num
     * @param visited
     * @param row
     * @param col
     * @param word
     * @param index
     * @return
     */
    public static boolean check(char[][] num, boolean[][] visited, int row, int col, String word, int index) {
        return  row >= 0 && row < num.length 			// 行号合法
                && col >= 0 && col < num[0].length	    // 列号合法
                && !visited[row][col] 					// 没有被访问过
                && num[row][col] == word.charAt(index); // 字符相等
    }
}
	