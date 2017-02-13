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


	//��֤�����Ƿ���������
	public static boolean isExist(char[][] num, String word){
		//��Ǿ���������ʾ��Ԫ���Ƿ񱻷��ʹ����Ƿ񱻷��ʵĹ��Ǳ������һ���Ե�·����û�б����ʹ����������Ա�֤���ظ�����Ԫ��
		boolean [][] visited = new boolean[num.length][num[0].length];
		
		//ÿһ��λ��Ϊ����������
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
	 * @param row  ���ʵ�Ԫ�ص��к�
	 * @param col  ���ʵ�Ԫ�ص��к�
	 * @param word ƥ����ַ���
	 * @param idx  ƥ���λ��
	 * @return
	 */
	private static boolean search(char[][] num, boolean[][] visited, int row, int col, String word, int[] index) {
		if(index[0] == word.length()){
			return true;
		}
		
		//�Ӹõ㿪ʼ�Ƿ�������·��
		boolean hasPath = false;
		
		//�жϵ�ǰλ���Ƿ�Ϸ������Ҹ�Ԫ���Ƿ���ַ����е�Ԫ����ƥ��
		if(check(num, visited, row, col, word, index[0])){
			//��Ǳ����ʹ���
			visited[row][col] = true;
			
			//�ƶ������ʵ���һ��Ԫ��
			index[0]++;			
			//���������ҵ��ĸ��������������Ҳ������������ֻҪ��һ�������Ŀ���ַ�������һ��������ƥ�䣬��OK
            hasPath = search(num, visited, row - 1, col, word, index ) // ��
                    || search(num, visited, row, col + 1, word, index) // ��
                    || search(num, visited, row + 1, col, word, index) // ��
                    || search(num, visited, row, col - 1, word, index); // ��
            
            //���û���ҵ�·�����ͱ�Ǹõ㲻����,���л���
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
        return  row >= 0 && row < num.length 			// �кźϷ�
                && col >= 0 && col < num[0].length	    // �кźϷ�
                && !visited[row][col] 					// û�б����ʹ�
                && num[row][col] == word.charAt(index); // �ַ����
    }
}
	