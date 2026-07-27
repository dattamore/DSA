package com.graph.miscellaneous;
import java.util.*;

import com.graph.anuj.DisJointUnionSets;
//https://www.youtube.com/watch?v=FMwpt_aQOGw&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=53
public class AccountsMerge {

	public static void main(String[] args) {
		AccountsMerge sol = new AccountsMerge();
        List<List<String>> accounts = Arrays.asList(
            Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
            Arrays.asList("John", "johnnybravo@mail.com"),
            Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
            Arrays.asList("Mary", "mary@mail.com")
        );
        System.out.println(sol.accountsMerge(accounts));
	}
 static List<List<String>> accountsMerge(List<List<String>> details){
	 int n = details.size();  
	 DisJointUnionSets dsu =new DisJointUnionSets(n);
	 
	 //Map individual mails to index
	 HashMap<String,Integer> mapMailNode=new HashMap<String,Integer>();	 
	 for(int i=0;i<n;i++) {
		 for(int j=1;j<details.get(i).size();j++) {
			String mail= details.get(i).get(j);
			if(mapMailNode.containsKey(mail) == false) {
				mapMailNode.put(mail, i);
			}else {
				dsu.unionBySize(i, mapMailNode.get(mail));
			}
		 } 
	 }
	 //Merge mails
	 ArrayList<String>[] mergedMail =new ArrayList[n];
	 for (int i = 0; i < n; i++) {
		 mergedMail[i] = new ArrayList<String>();
	 }
	 for (Map.Entry<String, Integer> it : mapMailNode.entrySet()) {
		String mail = it.getKey();
		int node =dsu.find(it.getValue());
		mergedMail[node].add(mail);
	}
	 
	 //sort and get final result
	 List<List<String>> ans = new ArrayList<>();
	 for(int i=0;i<n;i++) {
		 if(mergedMail[i].size()==0)continue;
		 Collections.sort(mergedMail[i]);
		 List<String> temp = new ArrayList<>();
		 temp.add(details.get(i).get(0));           //add first element i.e name
		 for (String it : mergedMail[i]) {
			temp.add(it);                           //add all sorted mails
		}
		 ans.add(temp);
	 }  
	 return ans;
 }
}
