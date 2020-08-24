package com.assignment_2;

//{June = 8}
//June is a month name
// 8 is count of file in month

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Folder_Scan {

	public static void main(String[] args) throws IOException {
		File f = new File("F:\\JQuery");
		String[] fileList = f.list();
		String[] monthName = {"January","feb","march","April","May","June","July","August","September"
				,"oct","Nov","Dec"};
		Map<String, Integer> list = new HashMap<>();
		for( String singleFile : fileList )
		{
			File file = new File( "F:/JQuery/"+singleFile );
			BasicFileAttributes attrs;
			try {
			    attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
			    FileTime time = attrs.creationTime();
			    
			    String pattern = "MM";
			    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				
			    String formatted = simpleDateFormat.format( new Date( time.toMillis() ) );
			    int key = Integer.parseInt(formatted) - 1;
			    if( list.containsKey( monthName[key ]  ) )
			    {
			    	list.put(monthName[key], list.get(monthName[key]) + 1);
			    }
			    else{
			    	list.put(monthName[key], 1 );
			    }
			} catch (IOException e) {
			    e.printStackTrace();
			}
		}	
		System.out.println( list );
	}
}
