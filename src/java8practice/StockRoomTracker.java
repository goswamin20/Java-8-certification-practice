package java8practice;

import java.util.concurrent.*;
import java.util.stream.*;

import org.omg.Messaging.SyncScopeHelper;
	public class StockRoomTracker {
	public static void await(CyclicBarrier cb) { // j1
	try { cb.await(); } catch (InterruptedException |
	BrokenBarrierException e) {
		e.printStackTrace();
	}
	}
	public static void main(String[] args) {
	CyclicBarrier cb = new CyclicBarrier(10,
	() -> System.out.println("Stock Room Full!")); // j2
	IntStream.iterate(1, i -> 1).limit(9).peek(System.out::println)
	.parallel().forEach(i -> await(cb)); // j3
	}
	}
	

