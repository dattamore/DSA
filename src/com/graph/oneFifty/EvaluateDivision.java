package com.graph.oneFifty;
import java.util.*;

//https://www.youtube.com/watch?v=i0lqeMRuI5k&list=PLQ7ZAf76c0ZOGuMjg3qwNgILb_dKWTxyQ&index=12&t=1785s
public class EvaluateDivision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
	
		HashMap<String,HashMap<String,Double>> map=new HashMap<>();
		for (int i = 0; i < equations.size(); i++) {
			String dividend=equations.get(i).get(0);
			String divisor=equations.get(i).get(1);
			double res =values[i];
			if(!map.containsKey(dividend)) {
				map.put(dividend, new HashMap<String,Double>());				
			}
			if(!map.containsKey(divisor)) {
				map.put(divisor, new HashMap<String,Double>());				
			}
			map.get(dividend).put(divisor,res);
			map.get(dividend).put(dividend,1/res);
		}
		
		double[] res= new double[queries.size()];
		
		for (int i = 0; i < queries.size(); i++) {
			String dividend=queries.get(i).get(0);
			String divisor=queries.get(i).get(1);
			if(!map.containsKey(dividend) || !map.containsKey(divisor) ) {
				res[i] = -1.0;
			}else if(dividend.equals(divisor)) {
				res[i] = -1.0;
			}else {
				HashSet<String> visited= new HashSet<>();
				res[i] = dfs(dividend,divisor,1,visited,map);
			}
		}
		return res;
	}

	private double dfs(String dividend, String divisor, double prod, HashSet<String> visited,
			HashMap<String, HashMap<String, Double>> map) {
		double ret=-1;
		visited.add(dividend);
		if(map.get(dividend).containsKey(divisor)) {
			ret=map.get(dividend).get(divisor) * prod;
		}else {
			for (String neighbour : map.get(dividend).keySet()) {
				if(!visited.contains(neighbour)) {
					ret=dfs(neighbour,divisor,map.get(dividend).get(neighbour) * prod,visited,map);
					if(ret!=-1) {
						break;
					}
				}
			}
		}
		visited.remove(dividend);
		return 0;
	}


}
