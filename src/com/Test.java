package com;

import java.io.File;

public class Test {
	
	public static final String IMG_UPLOAD_RELATIVE_PATH = "web" + File.separator + "upload";

	public static void main(String[] args) {
		System.out.println(IMG_UPLOAD_RELATIVE_PATH);
		System.out.println(File.separator.equals("\\"));
		String s = File.separator.equals("\\")? 
				IMG_UPLOAD_RELATIVE_PATH.replaceAll("\\\\", "/"): 
					IMG_UPLOAD_RELATIVE_PATH;
		System.out.println(s);
	}
	
	public static int getPageCount(int recordCount, int pageSize) {
		int c = recordCount / pageSize;
		return recordCount % pageSize == 0 ? c : c+1;
	}
}
