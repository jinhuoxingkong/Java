package code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LeetCode44{
	
    private static ArrayList<ArrayList<Integer>> result;
    private static ArrayList<Integer> l;
    private static int[] tmpset;
    private static int numer; // ��set�л���Ҫ��ѡ���Ԫ�ظ���
	
	public static void main(String args[]){
		int num[] = new int[]{1, 3, 2, 4};
		
//		ArrayList<ArrayList<Integer>> allSubset = findAllSubset(num);
//		Iterator<ArrayList<Integer>> it1 = allSubset.iterator();
		
//		while(it1.hasNext()){
//			Iterator<Integer> it2 = it1.next().iterator();
//			while(it2.hasNext()){
//				System.out.print(it2.next()+" ");
//			}
//			System.out.println();
//		}
		
		
		Set<Set<Integer>> result = getSubSet(num);	//���÷���
		//������
		for(Set<Integer> subSet: result){
			for(Integer i: subSet)
				System.out.print(i+" ");
			
			System.out.println("");
		}

	}


	//�����ʾ�����ֽ��м�һ��������������λ��ʾ�������ֵ����λ
	public static ArrayList<ArrayList<Integer>> findAllSubset(int set[]) {
		result = new ArrayList<ArrayList<Integer>>();
		
		if(set != null){
			l = new ArrayList<>();
			
            // ��S����������
            quickSort(set, 0, set.length - 1);
            
            tmpset = set;
            for (int i = 0; i <= set.length; i++) {
                numer = i;
                subset(0);
            }
		}
		
		return result;
    }


	public static Set<Set<Integer>> getSubSet(int[] set){
		Set<Set<Integer>> result = new HashSet<Set<Integer>>();	//��������Ӽ��ļ��ϣ���{{},{1},{2},{1,2}}
		int length = set.length;
		int num = length==0 ? 0 : 1<<(length);	//2��n�η���������setΪ�գ�numΪ0��������set��4��Ԫ�أ���ônumΪ16.
		
		//��0��2^n-1��[00...00]��[11...11]��
		for(int i = 0; i < num; i++){		
			Set<Integer> subSet = new HashSet<Integer>();
			
			int index = i;
			for(int j = 0; j < length; j++){
				if((index & 1) == 1){		//ÿ���ж�index���λ�Ƿ�Ϊ1��Ϊ1��Ѽ���set�ĵ�j��Ԫ�طŵ��Ӽ���
					subSet.add(set[j]);
				}
				index >>= 1;		//����һλ
			}
			
			result.add(subSet);		//���Ӽ��洢����
		}
		return result;
	}
	
	
	//ͨ���ݹ�ķ�ʽ������
	public static void subset(int start) {
		
        if (numer == 0) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (Integer i : l) {
                tmp.add(i);
            }

            result.add(tmp);
            return;
        }
		
		int endFirst = tmpset.length - numer; // ʣ���Ҫ��ѡ��num��Ԫ���У���һ��������±�
        for (int i = start; i <= endFirst; i++) {
            l.add(tmpset[i]);
            numer--;
            subset(i + 1);
            numer++;
            l.remove(new Integer(tmpset[i]));
        }
	}


	//��������
	public static void quickSort(int num[], int left, int right){
		if(left < right){
			int mid = getMid(num, left, right);
			quickSort(num, left, mid-1);
			quickSort(num, left+1, right);
		}
	}
	
	//ͨ�������ķ�ʽ�����߽������򣬲������м��λ��
	public static int getMid(int num[], int left, int right){
		int tmp = num[left];
		while(left < right){
			while(left < right && num[right] > tmp){
				right--;
			}
			num[left] = num[right];
			
			while(left < right && num[left] < tmp){
				left++;
			}
			num[right] = num[left];
		}
		
		num[left] = tmp;
		
		return left;
	}

}
	