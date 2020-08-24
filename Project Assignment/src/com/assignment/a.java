package com.assignment;

import com.assignment.a.b.c;

public class a {
	public static class b
	{
		 static a a;   
		 public static a c;
		 public static class c
		 {
			 static b b;
		 }
	}
	public static void main(String[] args) {
		a.b.c = c.b.a;
	}

}
