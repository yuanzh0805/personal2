package cn.sdu.util;

public class ConvertThread extends Thread {
	
	String inputFile;
	String swfFile;
	String pdfFile;
	
	public ConvertThread(String inputFile,String pdfFile, String swfFile) {
		this.inputFile = inputFile;
		this.swfFile = swfFile;
		this.pdfFile = pdfFile;
	}

	@Override
	public void run() {

		if(ConvertToPdf.convert2PDF(inputFile, pdfFile))
			if(ConvertToSwf.convert2SWF(pdfFile, swfFile))
				System.out.print("成功");
		
	}

}
