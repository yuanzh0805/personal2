package cn.sdu.util;

import java.util.UUID;

public class MyTools {

	public static String changeName(String oldname){
		return UUID.randomUUID().toString().replace("-", "").toUpperCase()
				+ oldname.substring(oldname.lastIndexOf(".") , oldname.length());				
	}
	
	public static String newname(String name ,String str){
		
			return name.substring(0, name.lastIndexOf(".")+1)+str;
	}
}
