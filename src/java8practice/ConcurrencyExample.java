package java8practice;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.*;
public class ConcurrencyExample {
	int apple;
public static void main(String[] args) {
	TreeMap<Integer,String> tree = new TreeMap<>();
	List<?> list=new LinkedList<Object>();
	String s=null;
	
	System.out.println(s);
	tree.put(2, "b");
	tree.put(1, "a");
	tree.put(1, "a");
	for(Number number:tree.keySet()){
		System.out.println(tree.get(number));
	}
	ExecutorService service=null;
	try{
		service= Executors.newSingleThreadExecutor();
		service.execute(()->{for(int i=0;i<50;i++)System.out.println(i);});
		Future<?> future=service.submit(()->{for (int i = 0; i < 100; i++) {
			System.out.println(i);
		}});
		if(!future.isDone()){
			service.awaitTermination(10, TimeUnit.MILLISECONDS);
		}
		Future<Integer> fc=service.submit(()->0);
		System.out.println("from callable future object "+fc.get());
		System.out.println(future.isDone());
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ExecutionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		
		service.shutdown();
	}
}
}
