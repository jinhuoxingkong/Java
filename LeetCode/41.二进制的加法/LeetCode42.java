package code;

public class LeetCode42{
	
	public static void main(String args[]){
		String str = addBinary("111", "1");
		System.out.println(str);
	}


	//�����ʾ�����ֽ��м�һ��������������λ��ʾ�������ֵ����λ
	public static String addBinary(String str1, String str2) {
		if(str1 == null || str2 == null){
			return null;
		}else{
			int num1[] = new int[str1.length()];
			int num2[] = new int[str2.length()];
			
			for(int i = 0; i < str1.length(); i++){
				num1[i] = str1.charAt(i) - '0';
			}
			
			for(int j = 0; j < str2.length(); j++){
				num2[j] = str2.charAt(j) - '0';
			}
			
			//ʹnum1����Ƚϳ�������ĳ���
	        if (num1.length < num2.length) {
	            int[] tmp = num1;
	            num1 = num2;
	            num2 = tmp;
	        }
	        
	        int index1 = num1.length - 1; // �ַ�����ca���һ�������±�
	        int index2 = num2.length - 1; // �ַ�����cb���һ�������±�
	        int carry = 0; // ��λ�Ľ�λ��ʶ
	        int result; // ���صĽ��
			
	        //���������������
	        while (index1 >= 0 && index2 >= 0) {
	            result = num1[index1] + num2[index2] + carry;
	            num1[index1] = result % 2;
	            carry = result / 2;

	            index1--;
	            index2--;
	        }
	        
	        //����num1ʣ������֣�Ҳ���ǽϳ������ֵ�ʣ�������
	        while(index1 >= 0){
	        	result = carry + num1[index1];
	        	num1[index1] = result%2;
	        	carry = result/2;
	        	
	        	if(carry == 0){
	        		break;
	        	}
	        	index1--;
	        }
	        
	        // ���ַ������е�ֵת�����ַ���0����1
	        for (int i = 0; i < num1.length; i++) {
	            num1[i] += '0';
	        }
	        
	        // ����Ҫ��չһλ
	        if (carry == 0) {

	            char[] ch = new char[num1.length];
	            for (int i = 0; i < num1.length; i++) {
	                ch[i] = (char) (num1[i]);
	            }

	            return new String(ch);
	        }else{
	            char[] ch = new char[num1.length + 1];
	            ch[0] = '1';
	            for (int i = 0; i < num1.length; i++) {
	                ch[i + 1] = (char) (num1[i]);
	            }
	            return new String(ch);
	        }
	        
		}
		

    }

}
	