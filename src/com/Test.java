package com;

public class Test {

	public static void main(String[] args) {
		int recordCount = 0, pageSize = 4;
		System.out.println(getPageCount(recordCount, pageSize));
	}
	
	public static int getPageCount(int recordCount, int pageSize) {
		int c = recordCount / pageSize;
		return recordCount % pageSize == 0 ? c : c+1;
	}
}
