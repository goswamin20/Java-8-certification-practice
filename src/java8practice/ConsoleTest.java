package java8practice;

import java.io.Console;
import java.io.IOException;
import java.util.Locale;

public class ConsoleTest {
	public static void main(String[] args) {
		Console c=System.console();
		if(c==null)
			System.out.println("not found");
		else return;
		char[] pwd = c.readPassword("Enter password");
		System.out.println(pwd);
		System.out.println(c.format("My name is Nandini"));
		
		try {
			
			while(c.reader().ready())
			c.writer().append(c.reader().read()+"");
			c.flush();
			c.writer().format(new Locale("hi"), "finished");
			
				} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
