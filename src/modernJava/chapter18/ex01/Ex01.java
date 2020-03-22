package modernJava.chapter18.ex01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex01 {
	public static void main(String[] args) {
		List<Integer> temp = Arrays.asList(1, 4, 9);
		List<List<Integer>> list = subsets(temp);
		System.out.println(list);
	}
	
	static List<List<Integer>> subsets(List<Integer> list) {
		if(list.isEmpty()) {
			List<List<Integer>> ans = new ArrayList<List<Integer>>();
			ans.add(Collections.emptyList());
			System.out.println("ans : " + ans);
			return ans;
		}
		Integer first = list.get(0);
		List<Integer> rest = list.subList(1, list.size());
		List<List<Integer>> subans = subsets(rest);
		List<List<Integer>> subans2 = insertAll(first, subans);
		System.out.println("subans : " + subans);
		System.out.println("subans2 : " + subans2);
		return concat(subans, subans2);
	}

	private static List<List<Integer>> concat(List<List<Integer>> subans, List<List<Integer>> subans2) {
		List<List<Integer>> r = new ArrayList<List<Integer>>(subans);
		r.addAll(subans2);
		return r;
	}

	private static List<List<Integer>> insertAll(Integer first, List<List<Integer>> lists) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		System.out.println("lists : " + lists);
		for(List<Integer> list : lists) {
			List<Integer> copyList = new ArrayList<Integer>();
			copyList.add(first);
			System.out.println("first : " + first);
			System.out.println("list : " + list);
			System.out.println("copyList : " + copyList);
			copyList.addAll(list);
			System.out.println("copyList : " + copyList);
			result.add(copyList);
			System.out.println("result : " + result);
		}
		return result;
	}
}
