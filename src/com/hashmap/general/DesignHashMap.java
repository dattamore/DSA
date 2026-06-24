package com.hashmap.general;

import java.util.LinkedList;

public class DesignHashMap {

	LinkedList<Entry>[] map;
	public static int SIZE=769;
	
	public DesignHashMap() {
		map=new LinkedList[SIZE];
	}
	class Entry{
		public int key;
		public int val;
		public Entry(int key,int val) {
			this.key=key;
			this.val=val;
		}
	}
	public int get(int key) {
		int bucket=key%SIZE;
		LinkedList<Entry> entries=map[bucket];
		if(entries==null) return -1;
		for (Entry entry : entries) {
			if(entry.key==key) return entry.val;
		}
		return -1;
	}
	public void put(int key,int val) {
		int bucket=key%SIZE;
		if(map[bucket]==null) {
			map[bucket]=new LinkedList<Entry>();
			map[bucket].add(new Entry(key,val));
		}else {
			boolean flag=true;
			for(Entry entry:map[bucket]) {
				if(entry.key==key) {
					entry.val=val;
					flag=false;
					//return;
				}
			}
			if(flag==true) {
			map[bucket].add(new Entry(key,val));
			}
		}

		
	}
	public void remove(int key) {
		int bucket=key%SIZE;
		Entry toRemove=null;
		if(map[bucket]==null)return;
		else {
			for(Entry entry:map[bucket]) {
				if(entry.key==key) {
					toRemove=entry;
					
					//return;
				}
			}
			if(toRemove==null)return;
			map[bucket].remove(toRemove);
		}
		
	}
	public static void main(String[] args) {
		DesignHashMap map=new DesignHashMap();
		map.put(1, 101); map.put(2, 102);map.put(3, 103);map.put(3, 153);
		
		int resutl=map.get(3);
		System.out.println("resutl : "+resutl);
		map.remove(3);
		int resutll=map.get(3);
		System.out.println("resutl : "+resutll);

	}

}

//for (Entry entry : entries) {
//	if(entry.key==key) return entry.val;
//}
//return -1;