package code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LeetCode44{
	
    private static ArrayList<ArrayList<Integer>> result;
    private static ArrayList<Integer> l;
    private static int[] tmpset;
    private static int numer; // 在set中还需要的选择的元素个数
	
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
		
		
		Set<Set<Integer>> result = getSubSet(num);	//调用方法
		//输出结果
		for(Set<Integer> subSet: result){
			for(Integer i: subSet)
				System.out.print(i+" ");
			
			System.out.println("");
		}

	}


	//数组表示的数字进行加一操作，数组的最高位表示的是数字的最低位
	public static ArrayList<ArrayList<Integer>> findAllSubset(int set[]) {
		result = new ArrayList<ArrayList<Integer>>();
		
		if(set != null){
			l = new ArrayList<>();
			
            // 对S进行排序处理
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
		Set<Set<Integer>> result = new HashSet<Set<Integer>>();	//用来存放子集的集合，如{{},{1},{2},{1,2}}
		int length = set.length;
		int num = length==0 ? 0 : 1<<(length);	//2的n次方，若集合set为空，num为0；若集合set有4个元素，那么num为16.
		
		//从0到2^n-1（[00...00]到[11...11]）
		for(int i = 0; i < num; i++){		
			Set<Integer> subSet = new HashSet<Integer>();
			
			int index = i;
			for(int j = 0; j < length; j++){
				if((index & 1) == 1){		//每次判断index最低位是否为1，为1则把集合set的第j个元素放到子集中
					subSet.add(set[j]);
				}
				index >>= 1;		//右移一位
			}
			
			result.add(subSet);		//把子集存储起来
		}
		return result;
	}
	
	
	//通过递归的方式来进行
	public static void subset(int start) {
		
        if (numer == 0) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (Integer i : l) {
                tmp.add(i);
            }

            result.add(tmp);
            return;
        }
		
		int endFirst = tmpset.length - numer; // 剩余的要挑选的num个元素中，第一个的最大下标
        for (int i = start; i <= endFirst; i++) {
            l.add(tmpset[i]);
            numer--;
            subset(i + 1);
            numer++;
            l.remove(new Integer(tmpset[i]));
        }
	}


	//快速排序
	public static void quickSort(int num[], int left, int right){
		if(left < right){
			int mid = getMid(num, left, right);
			quickSort(num, left, mid-1);
			quickSort(num, left+1, right);
		}
	}
	
	//通过交换的方式将两边进行排序，并返回中间的位置
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
	