package com.intervals.general;
import java.util.*;
//https://www.youtube.com/watch?v=99l7goR4y0U  re
public class EmployeeFreeTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Interval> employeeFreeTime(List<List<Interval>> schedule){
		List<Interval> result =new ArrayList<>();
		PriorityQueue<Interval> pq = new PriorityQueue<Interval>(((a,b)->a.start-b.start));
		//Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); //same as line no:13
		for (List<Interval> intervals : schedule) {
			pq.addAll(intervals);
		}
	
		Interval prev=pq.poll();
		while (!pq.isEmpty()) {
			Interval curr=pq.poll();
			if (prev.end<curr.start) {//there is gap between prev&curr which is free time
				result.add(new Interval(prev.end,curr.start));
				prev=curr;
			} else {
				prev.end=Math.max(prev.end, curr.end);//overlapping intervals,update endtime if needed
			}
		}
		return result;
	}
}
class Interval{
	public Interval(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	int start;
	int end;
	
}
