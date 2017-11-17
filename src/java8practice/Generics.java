package java8practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Stream;

import org.omg.Messaging.SyncScopeHelper;
interface A {}
class B implements A { }
class C extends B { }
public class Generics {
public static void main(String[] args) throws IOException {
	
	
	Set<Number> numbers=new HashSet<>();
	numbers.add(new Integer(86));
	numbers.add(75);
	numbers.add(null);
	System.out.println(numbers);
	
	TreeSet<String> tree = new TreeSet<String>();
	tree.add("one");
	tree.add("One");
	tree.add("ONE");
	System.out.println(tree.higher("On"));
	
	Stream ints=Stream.of(3,0,6,4);
	long i=ints.skip(1).limit(1).count();
	System.out.println(i);
	//ints.sorted().peek(System.out::println).findFirst();
	Map map=new HashMap<>();
	map.put("One", 1);
	map.put("Two", 2);
	map.put("three", 3);
	map.put("four", 4);
	TreeMap tree1= new TreeMap<>(map);
	System.out.println("key"+tree1.ceilingKey("O"));
	
	Integer[] arrays={2,5,9,1,4,6,7};
	List<Integer> l = Arrays.asList(arrays);
	Collections.sort(l);
	l.forEach(System.out::println);
	InputStream in=new FileInputStream("F:\\test\\java8practice\\src\\java8practice\\New.txt");
	System.out.println(in.markSupported());
	if(in.markSupported()) {
		System.out.println(true);
		in.mark(-1);
		System.out.print((char)in.read());
		System.out.print((char)in.read());
		System.out.print((char)in.read());
		System.out.print((char)in.read());
		System.out.print((char)in.read());
		in.reset();
		in.mark(2);
		System.out.print((char)in.read());
		System.out.print((char)in.read());
		System.out.print((char)in.read());
		System.out.print((char)in.read());
		in.reset();
		}
		System.out.print((char)in.read());
	in.close();
	String[] str=new String[3];
	//String l=Optional.of(str[2]).orElse("empty");
	//System.out.println(l);
	Comparator c = Comparator.nullsLast(Integer::compare);
	System.out.println(c.compare(null, 10));
}
}

	

