package com.mvc.util;

public class ExtendedEuclidean {
	
	public static byte solve(byte[] i, byte r1)
    {
		
		int a = Integer.parseInt(i.toString());
		String r1_str = String.valueOf(r1);
		int b = Integer.parseInt(r1_str);
		int x = 0,y = 1,u = 1,v = 0, u1; 
	    int e = b,f = a;
	    int c,d,q,r;
	    while(f != 1)
	    {
	        q = e/f;
	        r = e%f;
	        c = x-q*u;
	        d = y-q*v;
	        x = u;
	        y = v;
	        u = c;
	        v = d;
	        e = f;
	        f = r;
	    } 
	    u1 = (u+b)%b;
	    byte hpw = (byte)u;
	    return hpw;
    }
}
