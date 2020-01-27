package com.adnan;

public class QuickFindProblem {
	
	public static void main(String[] args) {	
		QuickFind qf = new QuickFind(10);
		System.out.println("Is Connected: " + qf.isConnected(1, 3));
		qf.union(1, 2);
		qf.union(3, 2);
		qf.union(2, 6);
		System.out.println("Is Connected: " + qf.isConnected(1, 3));
	}
}

class QuickFind {
	private final int n;
	private final int[] data;
	public QuickFind(int n) {
		this.n = n;
		data = new int[n];
		for (int i = 0; i < n; i++) {
			data[i] = i;
		}
	}

	public boolean isConnected(int p, int q) {
		return data[p] == data[q];
	}

	public void union(int p, int q) {
		int a = data[p];
		int b = data[q];
		for (int i = 0; i < n; i++) {
			if (data[i] == a) {
				data[i] = b;
			}
		} 
	}
}
