package cn.sdu.util;

import java.io.File;
import java.io.IOException;

public class ConvertToSwf {

	public ConvertToSwf() {
		// TODO Auto-generated constructor stub
	}

	private static String PDF2SWF_PATH = "E:\\pdf2swf.exe";

	public static boolean convert2SWF(String inputFile, String swfFile) {
		long start = System.currentTimeMillis(); 
		File pdfFile = new File(inputFile);
		File outFile = new File(swfFile);
		if (!inputFile.endsWith(".pdf")) {
			System.out.println("文件格式非PDF！");
			return false;
		}
		if (!pdfFile.exists()) {
			System.out.println("PDF文件不存在！");
			return false;
		}
		if (outFile.exists()) {
			System.out.println("SWF文件已存在！");
			return false;
		}
		String command = PDF2SWF_PATH + " \"" + inputFile + "\" -o " + swfFile
				+ " -T 9 -f";
		try {
			System.out.println("开始转换文档: " + inputFile +">>>" +swfFile);
			Runtime.getRuntime().exec(command);
			System.out.println("成功转换为SWF文件！");
			long end = System.currentTimeMillis();    
            System.out.println("用时：" + (end - start) + "ms.");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("转换文档为swf文件失败！");
			return false;
		}
		

	}

	public static void convert2SWF(String inputFile) {
		int splitIndex = inputFile.lastIndexOf(".");
		String swfFile = inputFile.substring(0, splitIndex)+".swf";
		convert2SWF(inputFile, swfFile);
	}

}
