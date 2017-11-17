package java8practice;

import java.util.stream.*;

import org.omg.Messaging.SyncScopeHelper;

import java.util.*;
import java.util.function.Predicate;

public class StreamClass {
public static void main(String[] args) {
	
	
	
	
	
	Stream<String> stream1 = Stream.iterate("", (s) -> s + "1");
	System.out.println(stream1.limit(2).map(x -> x + "2"));
	/*Stream<Integer> stream= Stream.of(1,2,3);
	stream.filter(s1->s1%2==0).map(s1->s1*2).forEach(System.out::println);
	Stream<Double> str=Stream.generate(Math::random);
	str.skip(5).limit(10).forEach(System.out::println);*/
	
	DoubleStream.of(1.0,2.0,3.0).forEach(System.out::println);
	//Double d=DoubleStream.iterate(0.5,x->x+0.5).limit(10).peek(System.out::println).reduce(0.5,(x,y)->x+y);
	//System.out.println(d);
	
	IntStream stream = IntStream.empty();
	OptionalDouble optional = stream.average();
	//optional.ifPresent(System.out::println);
	//System.out.println(optional.getAsDouble());
	//System.out.println(optional.orElseGet(() -> Double.NaN));
	
	Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
	//TreeSet<String> result = ohMy.filter(s -> s.startsWith("t")).collect(Collectors.toCollection(TreeSet::new));
	//System.out.println(result);
	
	Map<Boolean, Map<String,Integer>> map = 
			//ohMy.collect(Collectors.toMap(String::length,s -> s,(s1, s2) -> s1 + "," + s2));
	//ohMy.collect(Collectors.groupingBy(String::length));
			ohMy.collect(Collectors.partitioningBy(s->s.length()==5,Collectors.toMap(s->s,String::length)));
	
	/*Map<Integer, Optional<Character>> map1 = ohMy.collect(
			Collectors.groupingBy(
			String::length,
			Collectors.mapping(s -> s.charAt(0),
			Collectors.minBy(Comparator.naturalOrder()))));*/
	System.out.println(map);
	
	//Stream<String> stream1 = Stream.iterate("", (s) -> s + "1");
	System.out.println(stream1.limit(2).map(x -> x + "2"));
	
	System.out.println(Stream.iterate(1, x -> ++x).limit(5).map(x -> x+"").collect(Collectors.
			joining()));
	
}
}
