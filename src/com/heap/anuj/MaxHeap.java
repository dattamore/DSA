package com.heap.anuj;

import java.util.Arrays;
//insert delete heapify heapsort
public class MaxHeap {

	public static void main(String[] args) {
		int arr[]= {0,50,30,40,10,5,20,30,0};
		
		insert(arr,arr.length,60);
		
		//System.out.println(Arrays.toString(arr));
		insert(arr,arr.length,45);
		//System.out.println(Arrays.toString(arr)); 
		
        int arrDel[]= {0,40,30,10,20,15};
       // System.out.println(Arrays.toString(arrDel));
		delete(arrDel,arrDel.length-1);
		//System.out.println(Arrays.toString(arrDel));
		//int arrHeapify[]= {0,10,30,50,20,35,15};
		int arrHeapify[]= {0,40,10,30,50,60,15}; //check heapsort
		//System.out.println(Arrays.toString(arrHeapify));
		//buildHeap(arrHeapify,arrHeapify.length-1);
		System.out.println(Arrays.toString(arrHeapify));
		
		heapSort(arrHeapify,arrHeapify.length-1);
	}
  
	private static void heapSort(int[] arrHeapify, int n) {
		buildHeap(arrHeapify,n);
		System.out.println(Arrays.toString(arrHeapify));
		for (int i = n; i >1; i--) {
			swap(arrHeapify,1,i);
			heapify(arrHeapify,i-1,1);
		}
		System.out.println(Arrays.toString(arrHeapify));
		
		
		
	}
//to convert array / binary tree into heap
	private static void buildHeap(int[] arrHeapify, int n) {
	
		for (int i = n/2; i >0; i--) {
			heapify(arrHeapify,n,i);
		}
	}

	private static void heapify(int[] arrHeapify, int n, int i) {
		int largest=i;  //root node
		int l=2*i;
		int r=2*i+1;
		//int largest=0;
		if(l<=n && arrHeapify[largest]<arrHeapify[l]) {
			largest=l;
		}
		if(r<=n && arrHeapify[largest]<arrHeapify[r]) {
			largest=r;
		}
		if(largest !=i) {
			swap(arrHeapify,i,largest);
			heapify(arrHeapify,n,largest);
		}		
	}

	private static void delete(int[] arrDel, int length) {
		arrDel[1]=arrDel[length];
		int n=length-1;
		int i=1;
		while(i<n) {
			int left=arrDel[2*i];
			int right=arrDel[2*i+1];
			int larger=left>right?2*i:2*i+1;
			if(arrDel[i]<arrDel[larger]) {
				swap(arrDel,larger,i);
				i=larger;
			}else {
				return;
			}
		}
		
	}

	private static void insert(int[] arr, int length, int value) {
		int n=length-1;
		arr[n]=value;
		int i=n;
		
		while(i>1) {
			int parent=i/2;
			if(arr[parent] < arr[i]) {
				
				swap(arr,parent,i);
				i=parent;
			}else{
				return;
			}
		}
	}

	private static void swap(int[] arr, int parent, int i) {
		// TODO Auto-generated method stub
		int temp=arr[parent];
		arr[parent]=arr[i];
		arr[i]=temp;
		
	}

}

//leaf node= n/2+1 --to-- n
